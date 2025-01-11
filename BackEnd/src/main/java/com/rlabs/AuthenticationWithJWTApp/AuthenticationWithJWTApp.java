package com.rlabs.AuthenticationWithJWTApp;
import com.rlabs.AuthenticationWithJWTApp.bl.DataBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@SpringBootApplication
public class AuthenticationWithJWTApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationWithJWTApp.class, args);
	}




	@Override
	public void run(String... args) throws Exception {

	}




}
