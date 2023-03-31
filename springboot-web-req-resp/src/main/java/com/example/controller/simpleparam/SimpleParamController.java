package com.example.controller.simpleparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class SimpleParamController {
    @RequestMapping("simpleParam")
    public String simpleParam(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");//设置request的编码方式
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int i = Integer.parseInt(age);
        log.info(name + ':' + i);
        return "ok";
    }

    /**
     * 请求参数名和形参名相同
     * 可以直接封装
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("simpleParam1")
    public String simpleParam1(String name, Integer age) {
        log.info(name + ':' + age);
        return "ok";
    }

    /**
     * 请求参数名和形参名不同
     * 用RequestParam注解指定
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("simpleParam2")
    public String simpleParam2(@RequestParam(name = "name") String username, Integer age) {
        log.info(username + ':' + age);
        return "ok";
    }
}
