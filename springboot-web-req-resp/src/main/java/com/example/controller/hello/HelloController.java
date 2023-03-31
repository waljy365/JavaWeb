package com.example.controller.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 王希辰
 * @date : 2023/3/23 16:02
 */
@RestController
@Slf4j
public class HelloController {
    /**
     * RequestMapping get和post都能访问
     * @return
     */
    @RequestMapping("hello0")
    public String hello() {
        log.info("hello");
        return "a";
    }

    /**
     * GetMapping 只能get访问
     * @return
     */
    @GetMapping ("hello1")
    public String hello1() {
        log.info("hello");
        return "a";
    }

    /**
     * PostMapping 只能post访问
     * @return
     */
    @PostMapping("hello2")
    public String hello2() {
        log.info("hello");
        return "a";
    }
}
