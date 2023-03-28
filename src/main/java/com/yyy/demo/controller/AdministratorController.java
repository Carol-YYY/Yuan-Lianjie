package com.yyy.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.yyy.demo.entity.*;
import com.yyy.demo.mapper.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Value("${server.port}")
    private String port;
    private static final String ip = "http://localhost";

    @Autowired
    private AdministratorMapper administratorMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private InformerMapper informerMapper;
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private Deal_applicationMapper deal_applicationMapper;

    @GetMapping("/requery_adm")
    @ApiOperation("查询管理员")
    public List<Administrator> query1() {

        return administratorMapper.selectList(null);
    }

    @PostMapping("/insert_adm")
    @ApiOperation("增加管理员")
    public String save1(Administrator administrator) {
        int i = administratorMapper.insert(administrator);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

    @DeleteMapping("/delete_adm/{id}")
    @ApiOperation("删除管理员")
    public int deleteById1(@PathVariable String id) {
        return administratorMapper.deleteById(id);
    }

    @ApiOperation("查询用户")
    @GetMapping("query_user")
    public List<User> query2() {
        return userMapper.selectList(null);
    }

    @DeleteMapping("/delete_user/{id}")
    @ApiOperation("删除用户")
    public int deleteById2(@PathVariable String id) {
        return userMapper.deleteById(id);
    }

    @ApiOperation("查询资产")
    @GetMapping("query_property")
    public List<Property> query3() {
        return propertyMapper.selectList(null);
    }

    @ApiOperation("删除资产")
    @DeleteMapping("/delete_property/{id}")
    public int deleteById3(@PathVariable String id) {
        return propertyMapper.deleteById(id);
    }

    @ApiOperation("查询举报")
    @GetMapping("query_informer")
    public List<Informer> query4() {
        return informerMapper.selectList(null);
    }

    @ApiOperation("删除举报")
    @DeleteMapping("/delete_informer/{id}")
    public int deleteById4(@PathVariable String id) {
        return informerMapper.deleteById(id);
    }

    @ApiOperation("查询交易D_a")
    @GetMapping("query_deal_application")
    public List<Deal_application> query5() {
        return deal_applicationMapper.selectList(null);
    }

    @ApiOperation("删除交易D_a")
    @DeleteMapping("/delete_deal_application/{id}")
    public int deleteById5(@PathVariable String id) {
        return deal_applicationMapper.deleteById(id);
    }

    @ApiOperation("查询交易D")
    @GetMapping("query_deal")
    public List<Deal> query6() {
        return dealMapper.selectList(null);
    }

    @ApiOperation("删除交易D")
    @DeleteMapping("/delete_deal/{id}")
    public int deleteById6(@PathVariable String id) {
        return dealMapper.deleteById(id);
    }

    @ApiOperation("管理员上传文件")
    @PostMapping("/upload_adm")
    public Result<?> upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();//获取源文件的名称
//        定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();

        String rootFilePath = System.getProperty("user.dir")+"/springboot/src/main/resources/files/"+flag+"_"+originalFilename;//获取文件上传的路径
        try {
            FileUtil.writeBytes(file.getBytes(),rootFilePath);//把文件写入该路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = ip+":"+port+"/files/"+flag;
        return Result.success(url);//返回结果url
    }

    /**
     * 下载接口
     * @param flag
     * @param response
     */
    @ApiOperation("管理员下载文件")
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response){
        OutputStream os;//新建一个输出对象
        String basePath = System.getProperty("user.dir")+"/springboot/src/main/resources/files/";//文件路径
        List<String> fileNames = FileUtil.listFileNames((basePath));//获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");//找到根参数一致的文件

        try {
            if (StrUtil.isNotEmpty(fileName)){
                response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);//通过文件路径读取文字节流
                os = response.getOutputStream();//通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
    }
}
