package imnider.learning.springboot.jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import imnider.learning.springboot.jpa.entities.Person;
import imnider.learning.springboot.jpa.repositories.IPersonRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private IPersonRepository personRepository;

	public JpaApplication(IPersonRepository personRepository){
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(p -> System.out.println(p));
	}

}
