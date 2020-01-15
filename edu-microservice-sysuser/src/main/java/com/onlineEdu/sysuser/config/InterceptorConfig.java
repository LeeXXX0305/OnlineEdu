package com.onlineEdu.sysuser.config;

import com.onlineEdu.sysuser.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    @Bean
    OptionsInterceptor optionsInterceptor() {
        return new OptionsInterceptor();
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry ){
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/fileUpdataApi/upload","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(optionsInterceptor());
    }

    /**
     * 改变默认的http消息转换器
     * json消息转换器使用fastjson而不是默认的jackson
     */
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        //设置编码和时间类型格式
//        FastJsonConfig config = new FastJsonConfig();
//        config.setCharset(StandardCharsets.UTF_8);
//        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConverter.setFastJsonConfig(config);
//        //设置为null时也返回
//        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
//        //设置消息类型
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastJsonConverter.setSupportedMediaTypes(mediaTypes);
//        //进行替换
//        for (int i = 0; i < converters.size(); i++) {
//            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
//                converters.set(i, fastJsonConverter);
//            }
//        }
//    }
}
