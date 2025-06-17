package rgt.moonsh.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;


@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {
        log.info("AuthorizationInterceptor preHandle", request.getRequestURI()) ;


        //web, chrome 의경우 get, post options = pass
        //크롬 처리
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        //javascript, html, img 같은 resource 요청 처리 = pass
        if (handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        // TODO header 검증
        // 인증관련 코드 삽입 현재는 인증 처리 하지 않음 일단 통과 처리

        return true;

    }
}
