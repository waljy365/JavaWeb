package com.example.controller.jsonparam;

import com.example.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class JsonParamController {
    /**
     * RequestBody接受json数据
     * @param user
     * @return
     */
    @RequestMapping("jsonParam")
    public String jsonParam(@RequestBody User user) {
        log.info(user.toString());
        return "ok";
    }
}
