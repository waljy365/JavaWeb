package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest // springboot整合单元测试注解
        // 加载启动类，生成ioc容器
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        // userList.stream().forEach(user -> {
        //     System.out.println(user);
        // });
        userList.forEach(System.out::println);
    }

    @Test
    public void testListUser1() throws IOException {
        //加载mybatis配置文件
        // InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //会话工厂
        // SqlSessionFactory factory = builder.build(is);
        //会话（连接）
        // SqlSession sqlSession = factory.openSession();
        //通过会话获取DAO对象
        // UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // List<User> userList = userMapper.list1();
        // userList.stream().forEach(user -> {
        //     System.out.println(user);
        // });
        // userList.forEach(System.out::println);
    }

    @Test
    public void testJdbc() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接对象
        String url = "jdbc:mysql://172.18.211.89:3306/mybatis";
        String username = "root";
        String password = "123";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 获取执行SQL的对象Statement,执行SQL,返回结果
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // 4. 封装结果数据
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            short age = resultSet.getShort("age");
            short gender = resultSet.getShort("gender");
            String phone = resultSet.getString("phone");

            User user = new User(id, name, age, gender, phone);
            userList.add(user);
        }

        // 5. 释放资源
        statement.close();
        connection.close();
    }

}
