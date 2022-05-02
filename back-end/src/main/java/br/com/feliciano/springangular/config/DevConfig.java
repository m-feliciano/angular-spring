package br.com.feliciano.springangular.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.feliciano.springangular.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String profile;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(profile)) {
			return false;
		}
		dbService.instantiateTestDatabase();

		return true;
	}

}