package practice.io;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadIOTest {
    public static void main(String[] args) throws IOException {
        //生成一个默认的资源文件读取流
        ResourceLoader loader = new DefaultResourceLoader();
        //根据目标位置读取文件 classpath:/template/thymeleaf/read.html
        Resource resource = loader.getResource("classpath:/template/thymeleaf/read.html");
        //获取文件
        File file = resource.getFile();

        // 读取文件形成输入流
        FileInputStream inputStream = new FileInputStream(file);
        //创建一个输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //讲文件从输入流，传到输出流
        IOUtils.copyLarge(inputStream, outputStream);
        String fileContext = outputStream.toString("UTF-8");

        System.out.println(fileContext);

        inputStream.close();

    }
}
