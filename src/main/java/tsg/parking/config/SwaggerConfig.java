package tsg.parking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Parking System API")
                        .version("1.0")
                        .description("This is a sample API documentation")
                        .contact(new Contact()
                                .name("Freth Piraban")
                                .email("frethph@gmail.com")
                        ));
    }
}