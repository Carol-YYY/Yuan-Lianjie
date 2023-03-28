package com.yyy.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

@RestController
public class FileController {
    private static final String UPLOADED_FOLDER=System.getProperty("user.dir")+"/upload";

    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        System.out.println(photo.getOriginalFilename());//获取文件名称
        System.out.println(photo.getContentType());//获取文件类型

        String path=request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo,path);
        return "上传成功";
    }

    public void saveFile(MultipartFile photo,String path) throws IOException{
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        File file=new File(path+photo.getOriginalFilename());
        photo.transferTo((file));
    }
}
