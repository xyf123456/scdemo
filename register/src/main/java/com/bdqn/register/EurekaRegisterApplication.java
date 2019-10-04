package com.bdqn.register;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: EurekaApplication
 * create by:  xyf
 * description: TODO
 * create time: 2019/10/2 0002 上午 11:18
 */
@SpringCloudApplication
//此注解的作用:EnableEurekaServer，这个注解的作用就是标注该应用程序是一个注册中心，只是添加这个注解还不够，还需要增加配置。
@EnableEurekaServer
public class EurekaRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegisterApplication.class);
    }
}
