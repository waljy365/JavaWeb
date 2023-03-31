package com.example.controller.collectionparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class CollectionParamController {
    /**
     * 集合参数使用RequestParam接受
     * 请求参数和形参名相同
     * @param hobby
     * @return
     */
    @RequestMapping("collectionParam")
    public String arrayParam(@RequestParam List<String> hobby) {
        log.info(hobby.toString());
        return "ok";
    }
}
