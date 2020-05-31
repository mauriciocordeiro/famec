package br.org.mcord.famec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.org.mcord.famec.controller"))
          .paths(PathSelectors.any())
          .build()
          .useDefaultResponseMessages(false)
          .apiInfo(apiInfo());
    }
    

    private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("API REST da FAMEC")
	            .description("API REST para manutenção de registros dos educando da FAMEC")
	            .version("v1")
	            .license("GNU General Public License v3.0")
	            .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html")
	            .contact(new Contact("Maurício Cordeiro", "https://github.com/mauriciocordeiro/famec", "mauriciocordeiro@live.com"))
	            .build();
}

}

