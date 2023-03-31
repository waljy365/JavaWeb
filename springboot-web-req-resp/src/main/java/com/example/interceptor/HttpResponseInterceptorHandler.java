package com.example.interceptor;

// public class HttpResponseInterceptorHandler implements HandlerInterceptor {
//     // 实现HandlerInterceptor  或者 继承HandlerInterceptorAdapter都可以,如果想看着简洁就使用后者
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         response.addHeader("Content-Type", "application/json;charset=UTF-8");
//         response.addHeader("Content-test", "123");
//         return true;
//     }
//
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//     }
//
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//     }
// }