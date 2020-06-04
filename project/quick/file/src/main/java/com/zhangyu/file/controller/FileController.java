package com.zhangyu.file.controller;


import com.zhangyu.server.dto.ResponseDto;
import com.zhangyu.server.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class FileController {


    @GetMapping(value = "/Test")
    public String getTest() {
        return "File: " + "OK";
    }

    /**
     * Controller层， 不应该写逻辑代码，应该移到Service层 这个，可以后续操作File的Service
     */
    @PostMapping(value = "/postFile")
    public ResponseDto postFile(@RequestParam MultipartFile file) {

        ResponseDto result = new ResponseDto();
        String fileName = file.getOriginalFilename();
        log.info(String.format("-----fileName: %s", fileName));
        String uuid = UuidUtil.getUuid();
        log.info(String.format("-----uuid: %s", uuid));

        //设置上传路径，放项目的相对路径了
        // 启动参数里，可以配置，用配置比较好，动态配置，放properties也可以
        String projectPath = System.getProperty("user.dir"); //项目地址
        //判断系统吧，感觉要，windows 和unix /linux
        //
        String osName = System.getProperty("os.name");

        log.info(String.format("-----osName: %s", osName));
        //大小写，win不区分，所有可以写大写
        String pathChar = "/SaveFile/";
        //win
        if (osName != null && osName.toLowerCase().startsWith("win")) {
            pathChar = "\\SaveFile\\";
        }
        //保存uuid可以存数据库，获取解析找。
        String fullPath = projectPath + pathChar + uuid + "-" + fileName;
        log.info(String.format("------fullPath: %s", fullPath));

        File saveFile = new File(fullPath);

        //可以抛出异常，全局处理 如果是 模块间调用的话
        try {
            file.transferTo(saveFile);
        } catch (IOException ioException) {
            result.setSuccess(false);
        }
        return result;
    }
}
