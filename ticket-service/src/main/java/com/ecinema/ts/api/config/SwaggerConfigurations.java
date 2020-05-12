package com.ecinema.ts.api.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger configuration
 * @author j.a.vasconcelos
 *
 */
@Configuration
public class SwaggerConfigurations {
	
	public Docket ticketServiceApi() {

	return new Docket(DocumentationType.SWAGGER_2).
			select()
			.apis(RequestHandlerSelectors.basePackage("com.ecinema.ts.api"))
			.paths(PathSelectors.ant("/**"))
			.build().apiInfo(getApiInfo());
	}
	
	/**
	 * Method responsible to general document api
	 * @return
	 */
	private ApiInfo getApiInfo() {
		
		ApiInfo apiInfo = new ApiInfo("e-cinema",
				"API Remote responsible to seller tickets",
				"1.0.0",
				"",
				new Contact("juliherms","https://github.com/juliherms","j.a.vasconcelos321@gmail.com"),
				"",
				"",
				new ArrayList<>());
		
		return apiInfo;
	}
}
