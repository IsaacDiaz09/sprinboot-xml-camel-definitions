package dev.isaac.tests.xmlcamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SprinbootXmlCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootXmlCamelApplication.class, args);
    }

}
