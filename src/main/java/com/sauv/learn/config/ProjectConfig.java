package com.sauv.learn.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public ModelMapper model(){
        return new ModelMapper();
    }

}
