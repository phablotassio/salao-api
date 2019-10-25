package com.phablo.tassio.salao.api;

import com.phablo.tassio.salao.api.property.PessoaMicroServiceApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PessoaMicroServiceApiProperty.class)
public class SalaoSpiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaoSpiApplication.class, args);
    }

}

