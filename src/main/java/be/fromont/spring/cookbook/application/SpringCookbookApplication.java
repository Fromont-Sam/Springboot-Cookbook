package be.fromont.spring.cookbook.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class SpringCookbookApplication {

	public static void main(String[] args) throws UnknownHostException {
		Environment environment = SpringApplication.run(SpringCookbookApplication.class, args).getEnvironment();
		log.info(
			"\n----------------------------------------------------------\n\t" +
			"Local: \t\thttp://localhost:{}\n\t" +
			"External: \thttp://{}:{}" +
			"\n----------------------------------------------------------",
			environment.getProperty("spring.application.name"),
			environment.getProperty("server.port"),
			InetAddress.getLocalHost().getHostAddress(),
			environment.getProperty("server.port"));
		SpringApplication.run(SpringCookbookApplication.class, args);
	}

}
