package com.coderhouse.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("App Coderhouse")
                .description("Aplicación para Coder")
                .version("v1.0.0")
                .contact(new Contact()
                    .name("Pablo Percara")
                    .email("ppercara@ryaco.com")
                    .url("https://github.com/PerPab"))
                .license(new License()
                    .name("Licencia Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(new Server()
						.url("http://localhost:8080")
						.description("Servidor Local")));
    }
}
