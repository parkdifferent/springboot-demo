
package com.phoenix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tianFeng
 * @version $Id: SwaggerConfig.java, v0.1 2017/10/24 17:52 tianFeng Exp $
 */

@EnableSwagger2
@Configuration
//@EnableWebMvc
public class SwaggerConfig {

/*    http://localhost:8080/swagger-ui.html*/

  /* http://127.0.0.1:8080/v2/api-docs */

    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "blogArticleBeen", value = "文档对象", required = true, paramType = "body", dataType = "BlogArticleBeen"),
            @ApiImplicitParam(name = "path", value = "url上的数据", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "query", value = "query类型参数", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "apiKey", value = "header中的数据", required = true, paramType = "header", dataType = "String")
    })*/

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.phoenix.controller")) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("tianf","http://parkdifferent.com","parkdifferent@163.com");
        return new ApiInfoBuilder()
                .title("接口列表 v1.1.0") // 任意，请稍微规范点
                .description("接口测试") // 任意，请稍微规范点
                .termsOfServiceUrl("http://localhost:8090/") // 将“url”换成自己的ip:port
                .contact(contact) // 无所谓（这里是作者的别称）
                .version("1.1.0")
                .build();
    }

}
