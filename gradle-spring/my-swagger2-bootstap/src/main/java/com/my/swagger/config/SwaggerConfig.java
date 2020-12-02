package com.my.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
//@Profile({"dev"}) //@Profile({"dev","{pro}"}) 这样写就是两个环境都显示-----设置要显示的工作环境（控制那个环境显示接口文档）
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 设置swagger-ui.html页面上的一些元素信息。
                .apiInfo(metaData())
                .select()
                // 扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.my.swagger.controller"))
                // 定义要生成文档的Api的url路径规则
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                //接口标题
                .title("swagger-bootstrap ui test")
                //副标题
                .description("测试是swagger")
                //接口路径
                .termsOfServiceUrl("http://192.18.27.3:9999/")
                //创建人
                .contact("KevinLee")
                //版本
                .version("1.0")
                .build();
    }
    //配置放行资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
