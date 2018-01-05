package com.asura.spring.javaconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.asura.spring.javaconfiguration")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public SwimCoach swimCoach() {
		return new SwimCoach();
	}
	
}
