package com.adobe.numberservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adobe.numberservice.utils.Constants;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* The OpenAPI Specification (OAS) defines a standard,
* language-agnostic interface to RESTful APIs which allows both
* humans and computers to discover and understand the
* capabilities of the service without access to source code,
* documentation, or through network traffic inspection. When
* properly defined, a consumer can understand and interact with
* the remote service with a minimal amount of implementation
* logic.
*<p>
*An OpenAPI definition can then be used by documentation
*generation tools to display the API, code generation tools to
*generate servers and clients in various programming languages,
*testing tools, and many other use cases.
*<p>
*When the application is running the link to access would be
*http://host:port/swagger-ui.html
*
* @author Madhav Pandey
*/
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.adobe.numberservice"))
				.paths(PathSelectors.regex("/v1/.*")).build().apiInfo(metaInfo());
	}
	
	private static ApiInfo metaInfo() {
		return new ApiInfo(Constants.SWAGGER_SPEC_TITLE, Constants.SWAGGER_SPEC_DESCRIPTION, Constants.SWAGGER_SPEC_VERSION, null, new Contact(
				Constants.SWAGGER_SPEC_CONTACT_NAME, null, Constants.SWAGGER_SPEC_CONTACT_EMAIL), null, null);
	}
}
