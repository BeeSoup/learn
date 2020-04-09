package practice.test.newsettle.even;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/24 18:22
 */
//@Configuration
public class MyEvenConfig {

    @Bean(name = "springMyEven", initMethod = "initEven")
    public MyEven myEven() {
        MyEven even = new MyEven();
        even.setName("ggggEven");
        return even;
    }

    public void initEven() {
        System.out.println("initEven");
    }
}
