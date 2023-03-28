package com.yyy.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyy.demo.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper extends BaseMapper<User> {

//    @Select("select * from order1 where uid=#{uid}")
//    List<Order> selectById(int uid);
//    //查询用户以及其对应的订单
//    @Select("select * from order1")
//    @Results(
//            {
//                    @Result(column="id",property="id"),
//                    @Result(column="order_time",property="time"),
//                    @Result(column="total",property="total"),
//                    @Result(column="uid",property="uid",javaType = List.class,
//                    one=@One(select="com.yyy.demo.mapper.UserMapper.selectById")
//                    )
//
//            }
//    )
//    List<User> selectAllUserAndOrders();
}
