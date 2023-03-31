package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * ClassName: WebTest
 * date: 2022/10/19 20:29
 *
 * @author DingJiaxiong
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//1. 开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {

        //创建一个虚拟请求，访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/testAll/test");
        //执行请求
        ResultActions action = mvc.perform(builder);

        //定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();

        ResultMatcher string = header.string("Content-Type", "application/json;charset=UTF-8");

        //添加预计值到本地调用过程中进行匹配
        action.andExpect(string);
    }
}
