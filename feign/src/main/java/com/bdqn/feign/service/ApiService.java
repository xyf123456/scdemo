package com.bdqn.feign.service;

import com.bdqn.feign.service.error.ApiServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: {@link ApiService}
 * create by:  xyf
 * description: TODO  API业务接口
 * create time: 2019/10/2 0002 下午 3:15
 */
@FeignClient(value = "eurekaclient",fallback = ApiServiceError.class)
public interface ApiService {

    @GetMapping(value = "/index")
    String index();
    @GetMapping(value = "/getData")
    Object getData();
}
