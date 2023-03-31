package com.example.controller;

import com.example.domain.Address;
import com.example.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : 王希辰
 * @date : 2023/3/20 19:55
 */
@Controller
@Slf4j
@RequestMapping(value = "testAll",produces = "application/json;charset=UTF-8")
public class UserController {
    // @RequestMapping(value = "test",method = RequestMethod.GET)
    @RequestMapping(value = "test",method = RequestMethod.POST)
    @ResponseBody
    public User test(@RequestBody User user) throws JsonProcessingException {
        log.info(user.getName()+"--"+user.getAge());
        User user1 = new User("张三",18,new Address("黑龙江","齐齐哈尔"));
        // ObjectMapper objectMapper = new ObjectMapper();
        // String s = objectMapper.writeValueAsString(user1);
        return user1;
    }
}
