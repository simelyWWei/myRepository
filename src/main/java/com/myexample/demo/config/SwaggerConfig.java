package com.myexample.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //加载此类配置
@EnableSwagger2 //启动swagger
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) //创建API基本信息
                .groupName("swaggerdemo") //指定分组
                .pathMapping("") //base地址，最终会拼接controllor中的地址
                .genericModelSubstitutes(DeferredResult.class)
                .select() //控制需要暴露的接口
                .apis(RequestHandlerSelectors.basePackage("com.myexample.demo.controllor")) //扫描暴露api的包路径
                .paths(PathSelectors.any()) //设置过滤规则暴露接口
                // .paths(or(regex("/api/.*")))// 过滤的接口
                .build();
    }

    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("MySpringbootDemo")
                // 创建人
                .contact(new Contact("WEIWEI", "https://www.mydemo-weiwei.cn/",
                        "bjtuwweiei@163.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}
