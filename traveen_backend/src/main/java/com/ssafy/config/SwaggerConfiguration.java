package com.ssafy.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//	Swagger-UI 2.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui.html
//	Swagger-UI 3.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui/index.html

	private String version = "V1";
	private String title = "Traveen API " + version;
	
	// Notice Swagger
	@Bean
	public Docket api1() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("notice " + version).select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.notice.controller"))
					.paths(regex("/notice/.*")).build()
					.useDefaultResponseMessages(false);
	}
	
	// User Swagger
	@Bean
	public Docket api2() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("user " + version).select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.user.controller"))
					.paths(regex("/user/.*")).build()
					.useDefaultResponseMessages(false);
	}
	
	// Trininfo Swagger
	@Bean
	public Docket api3() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(getConsumeContentTypes()).produces(getProduceContentTypes())
					.apiInfo(apiInfo()).groupName("tripinfo " + version).select()
					.apis(RequestHandlerSelectors.basePackage("com.ssafy.tripinfo.controller"))
					.paths(regex("/tripinfo/.*")).build()
					.useDefaultResponseMessages(false);
	}
	
	private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title)
				.description("<h3>Traveen API Reference for Developers</h3>Swagger를 이용한 API<br>")
				.version("1.0").build();
	}
	
}
