package com.pss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pss.parser.Parse_Method;
import com.pss.repository.BasicinfoRepository;
import com.pss.repository.CallinfoRepository;
import com.pss.repository.WarningRepository;

@SpringBootApplication
public class WarninginfoWebProjectApplication {

	//	private static final Logger log = LoggerFactory.getLogger(WarninginfoWebProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WarninginfoWebProjectApplication.class, args);
	}

/*
	@Bean
	public CommandLineRunner demo(WarningRepository warn_repository,
			BasicinfoRepository basic_repository,
			CallinfoRepository call_repository) {
		Parse_Method parseobj = new Parse_Method();
		parseobj.ParseStart(warn_repository, basic_repository, call_repository);
		return (args) -> {
			

			//			// save a couple of customers
			//			repository.save(new Warning("123", "123", "123", "123", "123", "123", "123"));
			//			repository.save(new Warning("234", "234", "234", "234", "234", "234", "234"));
			//			
			//			// fetch all customers
			//			log.info("Customers found with findAll():");
			//			log.info("-------------------------------");
			//			for (Warning warn : repository.findAll()) {
			//				log.info(warn.toString());
			//			}
			//			log.info("");
			//
			//			// fetch an individual customer by ID
			//			Warning warn = repository.findOne(1L);
			//			log.info("Customer found with findOne(1L):");
			//			log.info("--------------------------------");
			//			log.info(warn.toString());
			//			log.info("");
			//
			//			// fetch customers by last name
			//			log.info("Customer found with findByLastName('Bauer'):");
			//			log.info("--------------------------------------------");
			//			for (Warning bauer : repository.findByIsocode("123")) {
			//				log.info(bauer.toString());
			//			}
			//			log.info("");

		};
	}
*/

}
