package info.hitech;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class MainRun {
    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
    }
}