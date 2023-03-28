package com.yyy.demo.controller;

import com.yyy.demo.entity.Deal;
import com.yyy.demo.entity.Property;
import com.yyy.demo.mapper.DealMapper;
import com.yyy.demo.mapper.PropertyMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {
    @Autowired
    private DealMapper dealMapper;

    @ApiOperation("查询交易")
    @GetMapping("/requery")
    public List<Deal> query() {
        return dealMapper.selectList(null);
    }

    @ApiOperation("增加交易")
    @PostMapping("/insert")
    public String save(Deal deal) {
        int i = dealMapper.insert(deal);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

}
