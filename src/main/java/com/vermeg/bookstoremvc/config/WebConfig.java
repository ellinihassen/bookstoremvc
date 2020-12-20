package com.vermeg.bookstoremvc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@EnableSwagger2
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.vermeg.bookstoremvc")
public class WebConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
