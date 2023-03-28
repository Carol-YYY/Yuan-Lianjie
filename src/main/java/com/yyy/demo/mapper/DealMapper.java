package com.yyy.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyy.demo.entity.Deal;
import com.yyy.demo.entity.Property;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DealMapper extends BaseMapper<Deal> {
}
