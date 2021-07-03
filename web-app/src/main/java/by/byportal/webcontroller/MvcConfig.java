package by.byportal.webcontroller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/StartPage").setViewName("StartPage");
        registry.addViewController("/Rules").setViewName("Rules");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("StartPage");
        registry.addViewController("/Bye").setViewName("Bye");
        //registry.addViewController("/HomePage").setViewName("HomePage");
        registry.addViewController("/simple").setViewName("simple");
    }


}
