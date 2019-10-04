package com.bdqn.client.controller;

import com.bdqn.client.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * create by:  xyf
 * description: TODO 为习 Spring Cloud 的另一个组件：gateway 测试控制器
 * <p>
 * 我们注意到，每次修改配置都需要重新启动服务，配置才会生效，这种做法也比较
 * 麻烦，因此我们需要一个机制，每次修改了配置文件，各个服务配置自动生效，
 * 、Spring Cloud 给我们提供了解决方案。
 * 手动配置刷新：
 * 1、在 eurekaclient 工程的 pom.xml 添加依赖：
 * 2、修改远程 Git 仓库的配置文件 eurekaclient.yml
 * 3、在 HelloController 类加入 @RefeshScope 依赖
 * <p>
 * 实现手动刷新步骤：
 * 1、依次启动注册中心，配置中心，客户端；
 * 2、访问地址：http://localhost:8763/index；
 * 3、修改 Git 仓库远程配置文件 eurekaclient.yml 的端口为8764；
 * 4、重新访问2的地址，我们发现端口未发生改变；
 * 5、POST 方式请求地址：http://localhost:8763/actuator/refresh；
 * 6.再次访问2的地址，
 * <p>
 * <p>
 * 前面我们讲了通过 /refresh 端点手动刷新配置，如果每个微服务的配置都需要我们手动刷新，
 * 代价无疑是巨大的。不仅如此，随着系统的不断扩张，维护也越来越麻烦。因此，我们有必要
 * 实现自动刷新配置。
 * 自动刷新原理：
 * 1、利用 Git 仓库的 WebHook，可以设置当有内容 Push 上去后，则通过 HTTP 的 POST 远程请求指定地址；
 * 2、利用消息队列如 RabbitMQ、Kafka 等自动通知到每个微服务（本文以 RabbitMQ 为例讲解）；
 * create time: 2019/10/2 0002 上午 11:51
 */
//手动配置刷新：实现不同的服务提供者之间的切换
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    /**
     * description: TODO  获取端口
     * create time: 2019/10/2 0002上午 11:54
     *
     * @ param []
     * @ return java.lang.String
     */
    @RequestMapping("/index")
    public String index() {
        return "Hello World!,端口：" + port;
    }

    @GetMapping("/getData")
    public Object getData() {
        User user = new User(1001, "张三");
        return user;
    }
}
