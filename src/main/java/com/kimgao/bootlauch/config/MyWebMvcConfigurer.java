package com.kimgao.bootlauch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//废弃：public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter{
public class MyWebMvcConfigurer implements WebMvcConfigurer {
 @Override
  public void addInterceptors(InterceptorRegistry registry) {
   //注册拦截器 拦截规则
  //多个拦截器时 以此添加 执行顺序按添加顺序
  registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
  }
	
 @Bean
 public static HandlerInterceptor getHandlerInterceptor() {
  return new CustomHandlerInterceptor();
 }
}
