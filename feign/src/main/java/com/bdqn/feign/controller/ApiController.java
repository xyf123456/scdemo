package com.bdqn.feign.controller;

import com.bdqn.feign.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ApiController
 * create by:  xyf
 * description: TODO
 * create time: 2019/10/2 0002 下午 4:20
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/index")
    public String index() {
        return apiService.index();
    }

    @GetMapping("/getData")
    public Object getData() {
        return apiService.getData();
    }


}
