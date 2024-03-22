package com.bsoft.simpledrive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bsoft.simpledrive.services.ApplicationService;

@SpringBootApplication
public class SimpleDriveApplication {
	private static final Logger log = LoggerFactory.getLogger(SimpleDriveApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(SimpleDriveApplication.class, args);
		ApplicationService app = ctx.getBean(ApplicationService.class);

		log.info(app.getVersion());
		log.info(app.getName());
		log.info(app.getAuthor());
		log.info(app.getOS());
		log.info(app.getJavaVersion());
	}
}
