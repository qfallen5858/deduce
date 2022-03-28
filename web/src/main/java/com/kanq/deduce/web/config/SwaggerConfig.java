package com.kanq.deduce.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:false}")
public class SwaggerConfig {

    @Value("${custom.api-title}")
    private String title;
    
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.kanq.deduce"))
        .paths(PathSelectors.any())
        .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(title + "API").description(title + "API文档").build();
    }
}
