package br.gov.sp.fatec.nemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NemoApplication.class, args);
	}

}
