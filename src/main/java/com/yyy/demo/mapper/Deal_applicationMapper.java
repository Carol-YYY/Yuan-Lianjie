package com.yyy.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyy.demo.entity.Deal_application;
import com.yyy.demo.entity.Property;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Deal_applicationMapper extends BaseMapper<Deal_application> {
}
