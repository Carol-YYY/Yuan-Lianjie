package com.yyy.demo.controller;

import com.yyy.demo.entity.Deal_application;
import com.yyy.demo.entity.Property;
import com.yyy.demo.mapper.Deal_applicationMapper;
import com.yyy.demo.mapper.PropertyMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deal_aplication")
public class Deal_applicationController {
    @Autowired
    private Deal_applicationMapper deal_applicationMapper;

    @GetMapping("/requery")
    @ApiOperation("查询交易")
    public List<Deal_application> query() {
        return deal_applicationMapper.selectList(null);
    }

    @PostMapping("/insert")
    @ApiOperation("增加交易")
    public String save(Deal_application deal_application) {
        int i = deal_applicationMapper.insert(deal_application);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

}
