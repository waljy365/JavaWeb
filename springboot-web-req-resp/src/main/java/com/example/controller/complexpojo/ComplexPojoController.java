package com.example.controller.complexpojo;

import com.example.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class ComplexPojoController {
    /**
     * 请求参数和实体成员变量名相同
     * @param user
     * @return
     */
    @RequestMapping("complexPojo")
    public String simpleParam(User user) {
        log.info(user.toString());
        return "ok";
    }
}
