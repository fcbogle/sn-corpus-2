package org.fcbogle.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
//@EnableJpaRepositories(basePackages="org.fcbogle.spring.jpa.repository")
@EnableMongoRepositories(basePackages="org.fcbogle.spring.mongo.repository")
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
