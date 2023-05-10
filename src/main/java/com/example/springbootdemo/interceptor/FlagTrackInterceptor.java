package com.example.springbootdemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

/**
 * @author guocang.shi
 *在Spring框架中，可以通过实现HandlerInterceptor接口来自定义拦截器。HandlerInterceptor接口定义了三个方法，分别在请求被处理前、请求被处理后、视图渲染之后执行，具体如下：
 *
 * preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)：在请求被处理之前调用，返回值为布尔类型，如果返回false，则请求将被终止。
 *
 * postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)：在请求被处理之后、视图渲染之前调用，可以对请求进行一些后置处理，如添加模型数据等。
 *
 * afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)：在视图渲染之后调用，用于清理资源等工作。
 *
 * 通过实现HandlerInterceptor接口并实现上述三个方法，就可以自定义拦截器了。在自定义拦截器之后，需要将拦截器注册到Spring的拦截器链中，可以通过实现WebMvcConfigurer接口，在addInterceptors方法中添加自定义拦截器。
 *
 *
 */

@Component
public class FlagTrackInterceptor implements HandlerInterceptor {
    /**
     * 存储 flag
     */
    private static final ThreadLocal<String> FLAG_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 获取请求头 header 中传递的 flag，若没有，则 UUID 代替
         */
        String flag = Optional.ofNullable(request.getHeader("flag")).orElse(UUID.randomUUID().toString().replaceAll("-",""));
        // 请求前设置
        FLAG_THREAD_LOCAL.set(flag);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除，防止内存泄漏
        FLAG_THREAD_LOCAL.remove();
    }

    public static String getFlag() {
        return FLAG_THREAD_LOCAL.get();
    }

    public static void setFlag(String flag){
        FLAG_THREAD_LOCAL.set(flag);
    }

}
