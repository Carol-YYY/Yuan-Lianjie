package com.yyy.demo.controller;

//import ch.qos.logback.core.util.FileUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyy.demo.entity.*;
import com.yyy.demo.mapper.*;
import com.yyy.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingType;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${server.port}")
    private String port;

    private static final String ip = "http://localhost";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private InformerMapper informerMapper;
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private Deal_applicationMapper deal_applicationMapper;

    // 登录
    @RequestMapping("/login")
    public String login(User user) {
        return userService.login(user);
    }

    // 注册
    @PostMapping("/register")
    public String register(User user) {
        return userService.register(user);
    }


    @GetMapping("/requery")
    @ApiOperation("用户查询")
    public List<User> query1() {

        return userMapper.selectList(null);
    }

    @ApiOperation("用户分页查询")
    @GetMapping("user/queryByPage")
    public IPage findByPage() {
        Page<User> page = new Page<>(0, 10);
        IPage iPage = userMapper.selectPage(page, null);
        return iPage;
    }

    @PostMapping("/insert")
    @ApiOperation("用户注册")
    public String save1(User user) {
        int i = userMapper.insert(user);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

    @ApiOperation("用户上传文件")
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();//获取源文件的名称
//        定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();

        String rootFilePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/" + flag + "_" + originalFilename;//获取文件上传的路径
        try {
            FileUtil.writeBytes(file.getBytes(), rootFilePath);//把文件写入该路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = ip + ":" + port + "/files/" + flag;
        return Result.success(url);//返回结果url
    }

    /**
     * 下载接口
     *
     * @param flag
     * @param response
     */
    @ApiOperation("用户下载文件")
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response) {
        OutputStream os;//新建一个输出对象
        String basePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/";//文件路径
        List<String> fileNames = FileUtil.listFileNames((basePath));//获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");//找到根参数一致的文件

        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);//通过文件路径读取文字节流
                os = response.getOutputStream();//通过输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

    /**
     * 富文本上传接口
     *
     * @param file
     * @return
     */

    @ApiOperation("用户上传富文本文件")
    @PostMapping("editor/upload")
    public JSON editorUpload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();//获取源文件的名称
//        定义文件的唯一标识（前缀）
        String flag = IdUtil.fastSimpleUUID();

        String rootFilePath = System.getProperty("user.dir") + "/springboot/src/main/resources/files/" + flag + "_" + originalFilename;//获取文件上传的路径
        try {
            FileUtil.writeBytes(file.getBytes(), rootFilePath);//把文件写入该路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = ip + ":" + port + "/files/" + flag;
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("errno", 0);
        JSONArray arr = new JSONArray();
        JSONObject data = new JSONObject();
        arr.add(data);
        data.set("url", url);
        jsonObject.set("data", arr);
        return jsonObject;//返回结果url
    }

    @ApiOperation("用户创建资产")
    @PostMapping("insert_property")
    public String save2(Property property) {
        int i = propertyMapper.insert(property);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

    @ApiOperation("用户删除资产")
    @DeleteMapping("/delete_property/{id}")
    public int deleteById2(@PathVariable String id) {
        return propertyMapper.deleteById(id);
    }

    @ApiOperation("用户查询资产")
    @GetMapping("query_property")
    public List<Property> query2() {
        return propertyMapper.selectList(null);
    }

    @ApiOperation("用户分页查询资产")
    @GetMapping("query_property/queryByPage")
    public IPage findByPage2() {
        Page<Property> page = new Page<>(0, 10);
        IPage iPage = propertyMapper.selectPage(page, null);
        return iPage;
    }

    @ApiOperation("用户插入举报")
    @PostMapping("insert_informer")
    public String save3(Informer informer) {
        int i = informerMapper.insert(informer);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

    @ApiOperation("用户删除举报")
    @DeleteMapping("/delete_informer/{id}")
    public int deleteById3(@PathVariable String id) {
        return informerMapper.deleteById(id);
    }


    @ApiOperation("用户查询举报")
    @GetMapping("query_informer")
    public List<Informer> query3() {
        return informerMapper.selectList(null);
    }


    @ApiOperation("用户插入交易")
    @PostMapping("insert_deal")
    public String save4(Deal deal) {
        int i = dealMapper.insert(deal);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }

    @ApiOperation("用户删除交易")
    @DeleteMapping("/delete_deal/{id}")
    public int deleteById4(@PathVariable String id) {
        return dealMapper.deleteById(id);
    }

    @ApiOperation("用户查询交易")
    @GetMapping("query_deal")
    public List<Deal> query4() {
        return dealMapper.selectList(null);
    }


    @ApiOperation("用户插入交易appli")
    @PostMapping("insert_deal_appli")
    public String save5(Deal_application deal_application) {
        int i = deal_applicationMapper.insert(deal_application);
        if (i == 0) {
            return "插入失败";
        } else {
            return "插入成功";
        }
    }


    @ApiOperation("用户删除交易appli")
    @DeleteMapping("/delete_deal_appli/{id}")
    public int deleteById5(@PathVariable String id) {
        return deal_applicationMapper.deleteById(id);
    }

    @ApiOperation("用户查询交易appli")
    @GetMapping("query_deal_applic")
    public List<Deal_application> query5() {
        return deal_applicationMapper.selectList(null);
    }


//    public String upload(MultipartFile touxiang, HttpServletRequest request) throws IOException {//touxiang参数名称一定要和表单名字一致
//        System.out.println(touxiang.getOriginalFilename());//获取文件名称
//        System.out.println(touxiang.getContentType());//获取文件类型
//
//        String path=request.getServletContext().getRealPath("/upload/");
//        System.out.println(path);
//        saveFile(touxiang,path);
//        return "上传成功";
//    }
//
//    public void saveFile(MultipartFile photo,String path) throws IOException{
//        File dir=new File(path);
//        if(!dir.exists()){
//            dir.mkdir();
//        }
//
//        File file=new File(path+photo.getOriginalFilename());
//        photo.transferTo((file));
//    }


}
