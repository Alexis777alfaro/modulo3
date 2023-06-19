package com.moduloIII;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProyectoDomingoModulo3Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDomingoModulo3Application.class, args);
	}
	
	@GetMapping("/")
    public String index() {
        return "index";
    }

}
