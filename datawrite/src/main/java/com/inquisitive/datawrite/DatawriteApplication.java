package com.inquisitive.datawrite;

import com.inquisitive.datawrite.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.inquisitive.datawrite.controller",
		"com.inquisitive.datawrite.repository",
		"com.inquisitive.datawrite.service"})
@EnableJpaAuditing
@EnableEurekaClient
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class DatawriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatawriteApplication.class, args);
	}

}
