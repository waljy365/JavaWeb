package com.example.controller.simplepojo;

import com.example.domain.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class SimplePojoController {
    /**
     * 请求参数名和实体成员变量名相同
     * 可以直接封装
     * @param people
     * @return
     */
    @RequestMapping("simplePojo")
    public String simpleParam(People people) {
        log.info(people.toString());
        return "ok";
    }
}
