package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class);
	    }
	    @Bean
	    
	    public CommandLineRunner demo(final MessageRepository reposit){
	    	return new CommandLineRunner() {
				
				@Override
				public void run(String... arg0) throws Exception {
					// save all Massages 
					User user = new User("titi" , "tata");
					
					
					reposit.save(new Message(user, "Amiri"));
					//reposit.save(new Message(new Customer("toti" , "tato"), "Ami"));
					//reposit.save(new Message(new Customer("ttt" , "tgtta"), "Ari"));
					//reposit.save(new Message(new Customer("ti" , "taa"), "Amfi"));
					
					// fetch ................
					
					log.info("Messages found with findAll():");
					log.info("-------------------------------");
					for (Message message : reposit.findAll()) {
						log.info(message.toString());
					}
				    log.info("");
				    
				    // fetch ..................................
				    
				     Message message = reposit.findOne(1L);
					log.info("Message found with findOne(1L):");
					log.info("--------------------------------");
					log.info(message.toString());
				    log.info("");
				    
				    // fetch ................................
				    
				    log.info("Customers found with findByLastName('Bauer'):");
					log.info("--------------------------------------------");
					for (Message message1 : reposit.findAllByUser(user)) {
						log.info(message1.toString());
					}
				    log.info("");
				}
			};
	    }
	    
	    @Bean
		public CommandLineRunner demo2(final UserRepository repository) {
			return new CommandLineRunner() {
				@Override
				public void run(String... args) throws Exception {
					
					// save a couple of customers
					repository.save(new User("Jack", "Bauer"));
					repository.save(new User("Chloe", "O'Brian"));
					repository.save(new User("Kim", "Bauer"));
					repository.save(new User("David", "Palmer"));
					repository.save(new User("Michelle", "Dessler"));
					
					// save the messages 
					
					
					// fetch all customers
					log.info("Customers found with findAll():");
					log.info("-------------------------------");
					for (User user : repository.findAll()) {
						log.info(user.toString());
					}
				    log.info("");

					// fetch an individual customer by ID
					User user = repository.findOne(1L);
					log.info("Customers found with findOne(1L):");
					log.info("--------------------------------");
					log.info(user.toString());
				    log.info("");

					// fetch customers by last name
					log.info("Customers found with findByLastName('Bauer'):");
					log.info("--------------------------------------------");
					for (User bauer : repository.findByLastName("Bauer")) {
						log.info(bauer.toString());
					}
				    log.info("");
				}
			};
		}
}