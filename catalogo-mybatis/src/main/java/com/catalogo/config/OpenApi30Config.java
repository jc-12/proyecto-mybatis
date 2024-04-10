package com.catalogo.config;


import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.List;

@Configuration
public class OpenApi30Config {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("jeancarlo torres");
        myContact.setEmail("jean-12-t@hotmail.com");

        Info information = new Info()
                .title("CATALOGO MYBATIS")
                .version("1.0")
                .description("LISTA DE PRODUCTOS MYBATIS.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}


