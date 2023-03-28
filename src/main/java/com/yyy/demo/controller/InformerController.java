package com.yyy.demo.controller;

import com.yyy.demo.entity.Informer;
import com.yyy.demo.entity.Property;
import com.yyy.demo.mapper.InformerMapper;
import com.yyy.demo.mapper.PropertyMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informer")
public class InformerController {
    @Autowired
    private InformerMapper informerMapper;

    @ApiOperation("举报查询")
    @GetMapping("/requery")
    public List<Informer> query() {
        return informerMapper.selectList(null);
    }

    @ApiOperation("增加举报")
    @PostMapping("/insert")
    public String save(Informer informer) {
        int i = informerMapper.insert(informer);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }


}
