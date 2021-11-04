package com.hbrs.SrpingBootIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.hbrs")
@EnableMongoRepositories("com.hbrs.Repository")
@EntityScan("com.hbrs.Data")
public class SrpingBootIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrpingBootIntegrationApplication.class, args);
	}
	/*@Bean
	CommandLineRunner runner(SalesManRepo repo){
		return args -> {
			SalesMan salesMan=new SalesMan(1,"Taha","cs");
			repo.insert(salesMan);
		};
	}*/

}
