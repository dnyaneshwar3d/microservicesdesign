package com.dnyanesh.userservice.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	
	@Autowired
	public Environment env;
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)
	      .host("localhost:"+env.getProperty("server.port")+"/swagger-ui.html")
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.dnyanesh.userservice"))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "User Service", 
	      "This microservice is for the user related operations.", 
	      "1.0", 
	      "http://termsofserviceurl.com", 
	      new Contact("Dnyanesh Dake", "www.dnyanesh.com", "dd@dnyanesh.com"), 
	      "License of API", "http://licenseurl.com", Collections.emptyList());
	}
}