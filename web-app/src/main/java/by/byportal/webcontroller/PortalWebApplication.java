package by.byportal.webcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableAutoConfiguration
//@Configuration
//@ComponentScan
@EntityScan("by.byportal.model")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PortalWebApplication {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(PortalWebApplication.class, args);
    }

}