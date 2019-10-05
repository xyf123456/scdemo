package com.bdqn.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * ClassName: EurekaApplication
 * create by:  xyf
 * description: TODO
 * create time: 2019/10/2 0002 上午 11:18
 */
@SpringCloudApplication
@ServletComponentScan(basePackages = "com.bdqn.client.config.filter")
public class EurekaClientApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaClientApplication.class);
    }
}
