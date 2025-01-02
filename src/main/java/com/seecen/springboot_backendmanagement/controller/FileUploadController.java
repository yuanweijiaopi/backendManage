package com.seecen.springboot_backendmanagement.controller;

import com.seecen.springboot_backendmanagement.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author aql
 * @Date 2025/1/2 10:48
 * @Version 1.0
 **/
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        if (file == null || !StringUtils.hasText(file.getOriginalFilename())) {
            return Result.success("文件为空");
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println("上传的文件名: " + originalFilename);
        //使用uuid保证名字唯一，以防文件被覆盖
        String uuid = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //把文件的内容存储到本地磁盘上
        file.transferTo(new File("/Users/aql/Desktop/backendManage/img/"+uuid));
        return Result.success("url的访问地址是:" + originalFilename);
    }
}
