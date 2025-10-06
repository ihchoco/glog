package com.ihchoco.glog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.ihchoco.glog")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class GlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlogApplication.class, args);
	}


}
