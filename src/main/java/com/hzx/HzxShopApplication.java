package com.hzx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
@EnableCaching  //开启缓存注解Spring Cache
//@EnableScheduling  //开启任务调度Srping Task
public class HzxShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzxShopApplication.class, args);
        log.info("服务端运行中...");
    }

}
