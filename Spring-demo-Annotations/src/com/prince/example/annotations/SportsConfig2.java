package com.prince.example.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
public class SportsConfig2 {

	
	//Define Bean for our fortune Service
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	//Define Bean for SwimCoach and inject dependency  
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach=new SwimCoach(happyFortuneService());
		return mySwimCoach;
	}
}
