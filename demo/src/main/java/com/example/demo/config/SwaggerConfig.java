//package com.example.demo.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.Info;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .components(new Components())
//                .info(apiInfo());
//    }
//
//    private Info apiInfo() {
//        return new Info()
//                .title("게시판 기능 만들기")
//                .description("Springdoc을 사용한 게시판 만들어보기!")
//                .version("0.0.1");
//    }
//}