package me.silvernine.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Mi API", version = "v1"))
@SpringBootApplication
@EnableJpaRepositories(basePackages= {"me.silvernine.tutorial.repository"})
@EntityScan({"me.silvernine.tutorial.entity"})
@ComponentScan(basePackages = {"me.silvernine.tutorial.controller", "me.silvernine.tutorial.service", "me.silvernine.tutorial.repository", "me.silvernine.tutorial.entity", "me.silvernine.tutorial.config", "me.silvernine.tutorial.jwt"})
public class JwtTutorialApplication {
	public static void main(String[] args) {
		SpringApplication.run(JwtTutorialApplication.class, args);
	}
}
