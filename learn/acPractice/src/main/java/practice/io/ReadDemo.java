package practice.io;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;

/**
 * /template/thymeleaf/read.html
 */
public class ReadDemo {

    public static void main(String[] args) throws IOException {

        ResourceLoader loader = new DefaultResourceLoader();

        Resource resource = loader.getResource("classpath:/template/thymeleaf/read.html");

        File file = resource.getFile();

        FileInputStream inputStream = new FileInputStream(file);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        IOUtils.copyLarge(inputStream,outputStream);

        String s = outputStream.toString("UTF-8");


        System.out.println(s);



    }
}
