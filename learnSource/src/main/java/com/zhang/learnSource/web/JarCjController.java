/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/9/26  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zhang.learnSource.web;

import com.alibaba.fastjson.JSON;
import com.zhang.learnSource.util.FileContentUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import support.components.Section;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 功能说明: http://{envIp}/gateway/file-service/api/external_systems/files/upload_as_stream
 *
 * @author zhangyu30939
 * @since 2021-09-26
 */
//@RequestMapping("/gateway/file-service/api/external_systems/files/")
@RequestMapping("/cj")
@RestController
public class JarCjController {

    private static String filePath = null;

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);
        uuid = uuid.replace("-", "");
        System.out.println(uuid);
    }

    @Value("${local.filePath}")
    private String localPath;

    @PostMapping("/upload_as_stream")
    public String uploadAsStream(@RequestParam MultipartFile file, @RequestParam(required = false) String fileName) throws IOException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate now = LocalDate.now();
        String nowDate = formatter.format(now);
        if (StringUtils.isBlank(filePath)) {
            // 判断是不是最后一位有分隔符
            if (!localPath.endsWith(File.separator)) {
                filePath = localPath + File.separator + nowDate + File.separator + "local" + File.separator;
            } else {
                filePath = localPath + nowDate + File.separator + "local" + File.separator;
            }
        }
        File tempFile = new File(filePath + uuid + ".docx");

        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        return uuid;
    }

    @PostMapping("/getText")
    public String getText(@RequestParam MultipartFile file) throws Exception {


        File tempFile = this.transFile(file);

        // 文件绝对路径
        String filePathName = tempFile.getAbsolutePath();
        // 文件内容
        String fileContent = FileContentUtil.getFileContent(filePathName);
        return fileContent;
    }

    @PostMapping("/getJson")
    public String getJson(@RequestParam MultipartFile file) throws Exception {

        File tempFile = this.transFile(file);

        // 文件绝对路径
        String fileAbsolutePath = tempFile.getAbsolutePath();
        // 文件名
        String fileName = tempFile.getName();
        // 3.2获取文件section 实际JSON对象

        Section fileSection = FileContentUtil.getFileSection(fileAbsolutePath, fileName);
        String sectionJson = JSON.toJSONString(fileSection);
//        log.info("sectionJson:{}", sectionJson);
        return sectionJson;
    }

    private File transFile(MultipartFile file) throws IOException {
        // 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate now = LocalDate.now();
        String nowDate = formatter.format(now);
        String fileLocalPath = "";
        // 判断是不是最后一位有分隔符
        if (!localPath.endsWith(File.separator)) {
            fileLocalPath = localPath + File.separator + nowDate + File.separator + "local" + File.separator;
        } else {
            fileLocalPath = localPath + nowDate + File.separator + "local" + File.separator;
        }
        File tempFile = new File(fileLocalPath + file.getOriginalFilename());

        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        return tempFile;
    }

}
