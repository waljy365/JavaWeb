package com.example.controller;

import com.example.domain.Emp;
import com.example.domain.Result;
import com.example.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 王希辰
 * @date : 2023/3/24 15:06
 */
@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result empList() {
        // List<Emp> emps = XmlParserUtils.parse("E:\\demo\\src\\main\\resources\\emp.xml", Emp.class);
        String file = EmpController.class.getClassLoader().getResource("static/emp.xml").getFile();
        List<Emp> emps = XmlParserUtils.parse(file, Emp.class);

        emps.stream().forEach(emp -> {
            if ("1".equals(emp.getGender())) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }
            if ("1".equals(emp.getJob())) {
                emp.setJob("讲师");
            } else if ("2".equals(emp.getJob())) {
                emp.setJob("班主任");
            } else {
                emp.setJob("就业指导");
            }
        });

        return Result.success(emps);
    }
}
