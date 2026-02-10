package com.MoralexCorpSolare_Company_SAS.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI solareCompanyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Solere Company API")
                        .description("Documentación de la API para gestión de gafas y pagos")
                        .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación adicional")
                        .url("https://swagger.io"));
    }
}
