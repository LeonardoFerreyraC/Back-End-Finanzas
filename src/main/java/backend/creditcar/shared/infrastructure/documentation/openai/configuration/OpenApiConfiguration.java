package backend.creditcar.shared.infrastructure.documentation.openai.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI creditCarPlatformOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Credit Car API")
                        .description(
                                "Credit Car Application REST API Documentation")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Credit Car Platform Wiki Documentation")
                        .url("https://credit-car-platform.wiki.github.org/docs"));
    }
}
