package com.hzx.controller.v1;

import com.hzx.common.context.BaseContext;
import com.hzx.common.result.Result;
import com.hzx.model.entity.User;
import com.hzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloController {

    @Autowired
    private UserService userService;

    @PostMapping("/hello")
    public Result<String> hello() {
        User user = userService.getById(BaseContext.getCurrentId());
        return Result.success("Hello, " + user);
    }



}
