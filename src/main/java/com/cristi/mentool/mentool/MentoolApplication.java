package com.cristi.mentool.mentool;

import com.cristi.mentool.mentool.infra.configurations.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfiguration.class)
public class MentoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(MentoolApplication.class, args);
	}

}

