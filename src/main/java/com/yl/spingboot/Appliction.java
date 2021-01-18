package com.yl.spingboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.yl.*")
@EnableSwagger2
public class Appliction {

    /**
     * https://blog.csdn.net/qq_35387940/article/details/100514134
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Appliction.class,args);
    }
}
