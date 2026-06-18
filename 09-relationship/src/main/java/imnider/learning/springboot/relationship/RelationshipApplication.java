package imnider.learning.springboot.relationship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import imnider.learning.springboot.relationship.services.ManyToOneService;
import imnider.learning.springboot.relationship.services.OneToManyService;

@SpringBootApplication
public class RelationshipApplication implements CommandLineRunner{

	private final OneToManyService oneToManyService;
	private final ManyToOneService manyToOneService;

	public RelationshipApplication(OneToManyService oneToManyService, ManyToOneService manyToOneService){
		this.oneToManyService = oneToManyService;
		this.manyToOneService = manyToOneService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToManyService.addAddressesByClientId(2L);
	}

}
