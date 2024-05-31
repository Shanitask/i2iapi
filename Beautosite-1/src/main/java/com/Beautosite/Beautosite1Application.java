package com.Beautosite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@ComponentScan("com")
@EntityScan("com")
@EnableJpaRepositories("com")
@SpringBootApplication
public class Beautosite1Application {

	public static void main(String[] args) {
		SpringApplication.run(Beautosite1Application.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Beautosite1Application.class);
	}
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.Beautosite")).build();
	   }

}
