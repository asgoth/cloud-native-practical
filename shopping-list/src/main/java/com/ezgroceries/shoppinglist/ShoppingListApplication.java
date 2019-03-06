package com.ezgroceries.shoppinglist;

import com.ezgroceries.shoppinglist.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.ezgroceries.shoppinglist.web")
@Import(ApplicationConfig.class)
@EnableSwagger2
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}

}
