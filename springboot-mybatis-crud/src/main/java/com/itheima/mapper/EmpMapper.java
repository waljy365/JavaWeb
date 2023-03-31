package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //@Delete("delete from emp where id = 17")
    // public void delete();
    // 以上delete操作的SQL语句中的id值写成固定的17，就表示只能删除id=17的用户数据
    // SQL语句中的id值不能写成固定数值，需要变为动态的数值
    // 解决方案：在delete方法中添加一个参数(用户id)，将方法中的参数，传给SQL语句

    /**
     * 根据id删除数据
     *
     * @param id 用户id
     */
    @Delete("delete from emp where id=#{id}")

    public Integer deleteByID(Integer id);

    // 会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public Integer insert(Emp emp);

    /**
     * 根据id修改员工信息
     *
     * @param emp
     */
    // @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    public Emp getById(Integer id);
    // 解决名字不同
    // 方法1
    // @Select("select id, username, password, name, gender, image, job, entrydate, " +
    //         "dept_id AS deptId, create_time AS createTime, update_time AS updateTime " +
    //         "from emp " +
    //         "where id=#{id}")
    // public Emp getById(Integer id);

    // 方法2
    // @Results({@Result(column = "dept_id", property = "deptId"),
    //         @Result(column = "create_time", property = "createTime"),
    //         @Result(column = "update_time", property = "updateTime")})
    // @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    //

    // @Select("select * from emp " +
    //         "where name like '%${name}%' " +
    //         "and gender = #{gender} " +
    //         "and entrydate between #{begin} and #{end} " +
    //         "order by update_time desc")
    // public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    // @Select("select * from emp " +
    //         "where name like concat('%',#{name},'%') " +
    //         "and gender = #{gender} " +
    //         "and entrydate between #{begin} and #{end} " +
    //         "order by update_time desc")
    // public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    public Integer deleteByIds(List<Integer> ids);
}
