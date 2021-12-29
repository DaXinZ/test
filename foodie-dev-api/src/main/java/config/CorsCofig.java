package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Date: 2021/12/29 4:55 下午
 * CorsCofing
 * Describe：
 */
@Configuration
public class CorsCofig {
    public CorsCofig(){

    }
    @Bean
    public CorsFilter corsFilter(){
        //添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");

        // 设置是否发送cookie信息
        config.setAllowCredentials(true);
        // 设置运行请求的方式
        config.addAllowedMethod("*");
        // 设置运行的Header
        config.addAllowedHeader("*");

        //为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",config);

        //返回从新定义的好的corsSource
        return  new CorsFilter(corsSource);
    }
}
