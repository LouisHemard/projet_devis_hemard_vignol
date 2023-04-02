
package com.hemardvignol.webapp1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Data
@SpringBootApplication
public class Webapp1Application implements CommandLineRunner {

	@Autowired
	private CustomProperties props;

	public static void main(String[] args) {
		SpringApplication.run(Webapp1Application.class, args);
	}

	@Override
	public void run (String...args) throws Exception {
		System.out.println(props.getApiUrl());
	}
}
