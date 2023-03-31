package com.example.controller.arrayparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class ArrayParamController {
    /**
     * 数组参数请求参数和形参名相同
     * @param hobby
     * @return
     */
    @RequestMapping("arrayParam")
    public String arrayParam(String[] hobby) {
        log.info(Arrays.toString(hobby));
        return "ok";
    }
}
