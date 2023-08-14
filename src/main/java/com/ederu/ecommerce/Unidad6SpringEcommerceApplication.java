package com.ederu.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(/*exclude=DataSourceAutoConfiguration.class*/)
public class Unidad6SpringEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Unidad6SpringEcommerceApplication.class, args);
	}

}
