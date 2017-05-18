package br.com.sulamerica.ats.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
     public Docket atsApi() {
        Parameter parameter = new ParameterBuilder()
							    .name("Authorization")
							    .description("Header Autorization (Basic para obter e Bearer para utilizar)")
							    .modelRef(new ModelRef("string"))
							    .parameterType("header")
							    .required(false).build();
    	List<Parameter> parameters = new ArrayList<Parameter>();
    	parameters.add(parameter);
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalOperationParameters(parameters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sulamerica.ats.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //    public ApiInfo(String title, String description, String version, String termsOfServiceUrl, Contact contact, String license, String licenseUrl) {


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Ats-Api", "Ats-Api responsavel por disponibilizar servicos de integraçoes", "v1",
                "", new Contact("Sustentaçao Saude", "", "sustentacaosaude@sulamerica.com.br"), "", ""

        );
        return apiInfo;
    }

}