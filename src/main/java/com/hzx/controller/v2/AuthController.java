package com.hzx.controller.v2;


import com.hzx.common.result.Result;
import com.hzx.common.utils.AliSmsUtil;
import com.hzx.common.utils.JwtUtil;
import com.hzx.pojo.entity.User;
import com.hzx.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AliSmsUtil aliSmsUtil;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/sendCode/{phone}")
    public Result sendCode(@PathVariable(value = "phone") String phone) {
        String code = aliSmsUtil.generateCode();
        redisTemplate.opsForValue().set(phone + ":" + "code", code, 5, TimeUnit.MINUTES); // 验证码有效期5分钟
        Boolean isMessageSendOK = aliSmsUtil.sendSms(phone, code);
        if (isMessageSendOK){
            return Result.success("验证码已发送！");
        }else {
            return Result.error("验证码发送失败！");
        }

    }

    @PostMapping("/verifyCode/{phone}/{code}")
    public Result verifyCode(@PathVariable(value = "phone") String phone, @PathVariable(value = "code") String code) {
        Map<String, String> response = new HashMap<>();

        //去redis中，查询手机号的验证码
        String correctCode = (String) redisTemplate.opsForValue().get(phone + ":" + "code");

        if (correctCode != null && correctCode.equals(code)) {
            // 验证码通过，删除验证码
            redisTemplate.delete(phone + ":" + "code");

            // 根据手机号查询用户，用户存在返回token，用户不存在创建用户并返回用token
            User user = userService.findByPhone(phone);
            if (user == null) {
                user = userService.createUser(phone);
            }
            String token = jwtUtil.createJWT_user(user.getId());
            response.put("token", token);
            response.put("message", "登录成功");

            // 把token缓存到redis
            redisTemplate.opsForValue().set(phone + ":" + "token", token, 2, TimeUnit.HOURS);
        } else {
            response.put("message", "验证码错误");
        }
        return Result.success(response);
    }
}