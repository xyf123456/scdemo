package com.bdqn.feign.service;

import com.bdqn.feign.FeignApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FeignApplication.class)
public class ApiServiceTest {

    @Resource
    private ApiService apiService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void index() throws Exception {
        System.out.println(apiService.index());
    }

    @Test
    public void getData() throws Exception {
    }

}