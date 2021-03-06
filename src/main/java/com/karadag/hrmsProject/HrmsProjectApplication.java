package com.karadag.hrmsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = { "com.karadag.hrmsProject.core.utilities.HandleValidationException" })
public class HrmsProjectApplication {

	public static void main(String[] args) {
		// org.apache.commons.logging.LogFactory Hatası alınırsa bu eklenmeli.
		System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
		SpringApplication.run(HrmsProjectApplication.class, args);
	}

	@Bean // Uygulamadaki tüm apilerimizi buluyor ve test edebileceğimiz bir ortam sağlıyor. Postman yerine vs
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}
