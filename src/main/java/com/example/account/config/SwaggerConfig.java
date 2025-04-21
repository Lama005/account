package com.example.account.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(

        info = @Info(
                contact = @Contact(
                        name = "Min Raj Lama",
                        email = "minraj.lama05@gmail.com"

                ),
                title = "Book Borrow Information of Students.",
                version = "v1"

        ),
        servers = {
                @Server(
                        url = "http://192.168.1.143:8000"
//                        description = "Use this url to hit course."

                )

        }

)


public class SwaggerConfig {
}
