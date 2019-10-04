package com.bdqn.feign.service.error;

import com.bdqn.feign.service.ApiService;
import org.springframework.stereotype.Component;

/**
 * ClassName: ApiServiceError
 * create by:  xyf
 * description: TODO API业务异常类
 * create time: 2019/10/2 0002 下午 4:05
 */
@Component
public class ApiServiceError implements ApiService {

    @Override
    public String index() {
        return "服务发生故障！";
    }

    @Override
    public Object getData() {
        return "服务发生故障！";
    }
}
