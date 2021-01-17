package de.fsujena.inf.swt.spaethe.arcbyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication( scanBasePackages = { "de.fsujena.inf.swt.spaethe.arcbyexample" })
public class ArcByExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcByExampleApplication.class, args);
	}

}
