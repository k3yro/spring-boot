package de.k3yro.mavenDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenDemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MavenDemoApplication.class);
		app.setAdditionalProfiles("dev");
		//app.setAdditionalProfiles("prod");
		app.run(args);
	}
}
