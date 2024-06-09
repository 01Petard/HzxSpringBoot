package com.hzx.controller.v1;


import com.hzx.common.result.Result;
import com.hzx.pojo.dto.SendCodeDTO;
import com.hzx.pojo.dto.UserLoginDTO;
import com.hzx.pojo.vo.UserLoginVO;
import com.hzx.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageService messageService;


    @GetMapping("/send/{phone}")
    public Result sendRegisterMessage(@PathVariable String phone) {
        messageService.sendRegisterMessage(phone);
        return Result.success();
    }



}
