package com.yyy.demo.controller;

import com.yyy.demo.entity.Property;
import com.yyy.demo.mapper.PropertyMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyMapper propertyMapper;

    @ApiOperation("产权查询")
    @GetMapping("/requery")
    public List<Property> query() {
        return propertyMapper.selectList(null);
    }

    @ApiOperation("增加产权")
    @PostMapping("/insert")
    public String save(Property property) {
        int i = propertyMapper.insert(property);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }


}
