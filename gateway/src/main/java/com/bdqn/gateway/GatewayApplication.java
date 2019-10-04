package com.bdqn.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * ClassName: EurekaApplication
 * create by:  xyf
 * description: TODO
 * 前面我们提到，服务网关还有个作用就是接口的安全性校验，这个时候就需要通过 gateway
 * 进行统一拦截。Gateway 提供了多种 Filter 可供选择，如 GatewayFilter、GlobalFilter
 * 等，不同的 Filter 的作用是不一样的，GatewayFilter 处理单个路由的请求，而 GlobalFilter
 * 根据名字大致就能知道其作用，它是一个全局 Filter，可以过滤所有路由请求
 * create time: 2019/10/2 0002 上午 11:18
 */
@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
