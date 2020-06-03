package com.dnyanesh.zuulservice.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableZuulProxy
@EnableEurekaClient
public class Config {
	
}
