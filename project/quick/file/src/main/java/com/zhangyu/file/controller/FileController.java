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

/**
 * 大数据的文件，采用分片传输，然后再合并，输出对应的格式，
 *      比如100M 分着100个1M的
 *      本地保存文件的形式
 *
 *      阿里云OSS
 */
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
        String name = file.getName();
        String fileName = file.getOriginalFilename();
        log.info(String.format("-----name: %s", name));
        log.info(String.format("-----fileName: %s", fileName));
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.info(String.format("-----suffix: %s", suffix));
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
        String fullPath = projectPath + pathChar + uuid + "." + suffix;
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


//    public void merge(FileDto fileDto) throws Exception {
//        LOG.info("合并分片开始");
//        String path = fileDto.getPath(); //http://127.0.0.1:9000/file/f/course\6sfSqfOwzmik4A4icMYuUe.mp4
//        path = path.replace(FILE_DOMAIN, ""); //course\6sfSqfOwzmik4A4icMYuUe.mp4
//        Integer shardTotal = fileDto.getShardTotal();
//        File newFile = new File(FILE_PATH + path);
//        FileOutputStream outputStream = new FileOutputStream(newFile, true);//文件追加写入
//        FileInputStream fileInputStream = null;//分片文件
//        byte[] byt = new byte[10 * 1024 * 1024];
//        int len;
//
//        try {
//            for (int i = 0; i < shardTotal; i++) {
//                // 读取第i个分片
//                fileInputStream = new FileInputStream(new File(FILE_PATH + path + "." + (i + 1))); //  course\6sfSqfOwzmik4A4icMYuUe.mp4.1
//                while ((len = fileInputStream.read(byt)) != -1) {
//                    outputStream.write(byt, 0, len);
//                }
//            }
//        } catch (IOException e) {
//            LOG.error("分片合并异常", e);
//        } finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//                outputStream.close();
//                LOG.info("IO流关闭");
//            } catch (Exception e) {
//                LOG.error("IO流关闭", e);
//            }
//        }
//        LOG.info("合并分片结束");
//
//        System.gc();
//        Thread.sleep(100);
//
//        // 删除分片
//        LOG.info("删除分片开始");
//        for (int i = 0; i < shardTotal; i++) {
//            String filePath = FILE_PATH + path + "." + (i + 1);
//            File file = new File(filePath);
//            boolean result = file.delete();
//            LOG.info("删除{}，{}", filePath, result ? "成功" : "失败");
//        }
//        LOG.info("删除分片结束");
//    }
}
