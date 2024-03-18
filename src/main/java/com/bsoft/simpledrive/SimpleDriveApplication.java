package com.bsoft.simpledrive;

import com.bsoft.simpledrive.models.users.User;
import com.bsoft.simpledrive.models.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bsoft.simpledrive.services.ApplicationService;
import com.bsoft.simpledrive.services.FilesService;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleDriveApplication {

	private static final Logger log = LoggerFactory.getLogger(SimpleDriveApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(SimpleDriveApplication.class, args);
		FilesService service = ctx.getBean(FilesService.class);

		ApplicationService app = ctx.getBean(ApplicationService.class);
		
		System.out.println(service);
		System.out.println(app.getVersion());
		System.out.println(app.getName());
		System.out.println(app.getAuthor());
		System.out.println(app.getOS());
		System.out.println(app.getJavaVersion());
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User("Jack", "Bauer", "okelekelenobel@gmail.com", ""));
			repository.save(new User("Nobel", "Okelekele", "okelekelenobel@gmail.com", ""));

			// fetch all customers
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			User user = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Nobel").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}
}
