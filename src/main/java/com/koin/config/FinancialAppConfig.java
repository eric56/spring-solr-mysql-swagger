package com.koin.config;

import com.koin.utils.RequestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinancialAppConfig {

    @Bean
    public RequestUtil requestUtil(){
        return new RequestUtil();
    }

}
