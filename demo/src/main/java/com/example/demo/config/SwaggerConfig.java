package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springdoc.core.models.GroupedOpenApi.*;

@OpenAPIDefinition(
        info = @Info(title = "게시판 명세서",
                description = "게시판 명세서입니다",
                version = "v1"))
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenAPi() {
        // /test 로 시작하는 API 들을 테스트 관련 API 로 그룹핑
        // member 로 시작하는 API 를 그룹핑 하고 싶다 라고 하면 메소드 이름을 변경하고 하나 더 만들어서 설정하면 됨

        String[] paths = {"/api/**"};

        return builder()
                .group("게시판 API")
                .pathsToMatch(paths)
                .build();
    }

}