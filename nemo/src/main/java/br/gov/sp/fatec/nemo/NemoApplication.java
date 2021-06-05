package br.gov.sp.fatec.nemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NemoApplication.class, args);
	}

}
