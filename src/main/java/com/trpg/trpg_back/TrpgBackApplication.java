package com.trpg.trpg_back;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Default Server URL")
})
@EnableRedisRepositories(basePackages = "com.trpg.trpg_back.domain.user.dao.redis")
@EnableJpaRepositories(basePackages = "com.trpg.trpg_back.domain.**.dao.jpa")
@EnableCaching
public class TrpgBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrpgBackApplication.class, args);
    }

    //cors 처리
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
