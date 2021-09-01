package info.hitech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication //(exclude = WebMvcAutoConfiguration.class)
public class MainRun {
    public static void main(String[] args) {
        SpringApplication.run(MainRun.class, args);
    }
}