package mq;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyMqBootStrap {


    public static void main(String[] args) {


        ApplicationContext context =new SpringApplicationBuilder(MyMqBootStrap.class)
                .build()
                .run(args);

    }
}
