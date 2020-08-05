package com.kimgao.bootlauch.config;

import com.kimgao.bootlauch.config.accesslog.AccessLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//废弃：public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter{
public class MyWebMvcConfigurer implements WebMvcConfigurer {
 //设置排除路径，spring boot 2.*，注意排除掉静态资源的路径，不然静态资源无法访问
 private final String[] excludePath = {"/static"};


 @Override
  public void addInterceptors(InterceptorRegistry registry) {
   //注册拦截器 拦截规则
  //多个拦截器时 依次添加 执行顺序按添加顺序
  registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
  registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
  }
	
 @Bean
 public static HandlerInterceptor getHandlerInterceptor() {
  return new CustomHandlerInterceptor();
 }
}
