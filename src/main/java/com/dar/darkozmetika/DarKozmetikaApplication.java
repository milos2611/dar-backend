package com.dar.darkozmetika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.dar.darkozmetika.property.FileStorageProperties;




@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})

public class DarKozmetikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarKozmetikaApplication.class, args);
	}

}

