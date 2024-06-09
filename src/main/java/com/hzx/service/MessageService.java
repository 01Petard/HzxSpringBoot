package com.hzx.service;

import com.hzx.pojo.dto.UserLoginDTO;
import com.hzx.pojo.vo.UserLoginVO;

public interface MessageService {


    void sendRegisterMessage(String phone);


    void sendKeyMessage(String phone, String key);

    void deleteKeyMessage(String phone, String key);
}
