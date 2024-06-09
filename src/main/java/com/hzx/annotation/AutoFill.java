package com.hzx.annotation;

import com.hzx.common.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于表示某个方法需要进行功能字段自动填充处理
 */
@Target(ElementType.METHOD) //指定当前注解要加在哪里（这里指定加载方法上）
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    //数据库操作类型
    OperationType value();





}
