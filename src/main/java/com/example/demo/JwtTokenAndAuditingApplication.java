package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JwtTokenAndAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenAndAuditingApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		System.out.println("called this method");
		 return new UsernameAuditorAware();
	}
	
	public class UsernameAuditorAware implements AuditorAware<String> {
		 
	    @Override
	    public Optional<String> getCurrentAuditor() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 
	        if (authentication == null || !authentication.isAuthenticated()) {
	            return null;
	        }
	 
	        return Optional.ofNullable(((User) authentication.getPrincipal()).getUsername());
	    }
	}
}
