package com.bdqn.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: EurekaApplication
 * create by:  xyf
 * description: TODO
 *
 * @EnableFeignClients，如果我们要使用 OpenFeign 声明式 HTTP 客户端，
 * 必须要在启动类加入这个注解，以开启 OpenFeign。
 * Hystrix 给我们提供了一个强大的功能，那就是 Dashboard。Dashboard 是一个
 * Web 界面，它可以让我们监控 Hystrix Command 的响应时间、请求成功率等数据。
 * create time: 2019/10/2 0002 上午 11:18
 */
@SpringCloudApplication
@EnableFeignClients
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class);
    }

}
