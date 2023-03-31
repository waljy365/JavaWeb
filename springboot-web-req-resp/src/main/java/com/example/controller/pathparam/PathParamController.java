package com.example.controller.pathparam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 王希辰
 * @date : 2023/3/23 18:03
 */
@RestController
@Slf4j
public class PathParamController {
    /**
     * 一个路径参数
     * 占位符 PathVariable
     * @param id
     * @return
     */
    @RequestMapping("pathParam/{id}")
    public String jsonParam(@PathVariable Integer id) {
        log.info("id="+id);
        return "ok";
    }
    /**
     * 二个路径参数，最多两个
     * 占位符 PathVariable
     * @param id
     * @return
     */
    @RequestMapping("pathParam/{id}/{name}")
    public String jsonParam1(@PathVariable Integer id,@PathVariable String name) {
        log.info("id="+id+",name="+name);
        return "ok";
    }
}
