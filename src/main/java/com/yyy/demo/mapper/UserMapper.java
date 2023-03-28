package com.yyy.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyy.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where nickname=#{nickname}")
    User findByName(String username);
    @Select("select password from user where nickname = #{nickname}")
    String findPswByName(String userName);
    @Insert("insert into user(nickname,password) value (#{nickname},#{password})")
    void save(User user);
    @Select("select * from user")
    List<User> findAll();
}
