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
		findOne();
	}

	private void findOne(){
		personRepository.findById(1L).ifPresent(p -> System.out.println(p));
		personRepository.findLikeName("ia").ifPresent(p -> System.out.println(p));
		personRepository.findByNameContaining("pe").ifPresent(p -> System.out.println(p));
	}

	private void list(){
		// List<Person> persons = (List<Person>) personRepository.findAll();
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguageAndName("Java", "Andres");
		persons.stream().forEach(p -> System.out.println(p));

		List<Object[]> personValues = personRepository.getNameAndProgrammingLanguage();
		personValues.stream().forEach(p -> System.out.println(p[0].toString().concat(" programming in ").concat(p[1].toString())));
	}
}
