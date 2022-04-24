package mirea.Sportsinventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Physique Week")
                        .description("API documentation for our wonderful app. Stay strong - stay home!")
                        .version("v0.0.1")
                        .license(new License().name("RTU MIREA").url("http://mirea.ru")));
    }
}
