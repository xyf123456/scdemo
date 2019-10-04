package com.bdqn.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ClassName: ConfigApplication
 * create by:  xyf
 * description: TODO 配置中心启动项
 * 要加入 @EnableConfigServer 注解，否则配置中心是无法开启的。
 *
 *
 * 我们创建配置中心的目的就是为了方便其他服务进行统一的配置管
 * 理，因此，还需要修改各个服务。
 * create time: 2019/10/2 0002 下午 5:45
 */
@SpringCloudApplication
@EnableConfigServer
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
