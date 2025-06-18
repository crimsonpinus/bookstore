package rgt.moonsh.api.config.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rgt.moonsh.api.interceptor.AuthorizationInterceptor;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AuthorizationInterceptor authorizationInterceptor;

    //검증 하지 않을  Api 현재는 전부 열어둠
    private List<String> OPEN_API = List.of(
            "/**"
    );

    //기본 url
    private List<String> DEFAULT_EXCLUSIONS = List.of(
            "/",
            "favicon.ico",
            "/error"
    );

    //swagger
    private List<String> SWAGGER_EXCLUSIONS = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .excludePathPatterns(OPEN_API)
                .excludePathPatterns(DEFAULT_EXCLUSIONS)
                .excludePathPatterns(SWAGGER_EXCLUSIONS)
        ;
    }

    //cors
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowCredentials(true)
                .maxAge(500);
    }
}
