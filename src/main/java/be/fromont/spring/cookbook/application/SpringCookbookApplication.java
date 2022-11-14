package be.fromont.spring.cookbook.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class SpringCookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCookbookApplication.class, args);
	}

}
