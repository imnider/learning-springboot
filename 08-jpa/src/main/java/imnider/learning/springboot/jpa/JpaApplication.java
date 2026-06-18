package imnider.learning.springboot.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import imnider.learning.springboot.jpa.dto.PersonDto;
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
		subQueries();
	}

	@Transactional
	private void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Write the name: ");
		String name = scanner.next();
		System.out.print("Write the lastname: ");
		String lastname = scanner.next();
		System.out.print("Write the programming language: ");
		String programmingLanguage = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);
		Person newPerson = personRepository.save(person);

		personRepository.findById(newPerson.getId()).ifPresent(System.out::println);;
	}

	@Transactional
	private void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Write the id of the person: ");
		Long id = scanner.nextLong();
		Optional<Person> optionalPerson = personRepository.findById(id);

		optionalPerson.ifPresent(p -> {
			System.out.println("Person selected: ".concat(p.toString()));
			System.out.print("Write new programming language: ");
			String programmingLanguage = scanner.next();
			p.setProgrammingLanguage(programmingLanguage);
			Person personDb = personRepository.save(p);
			System.out.println("New person data: ".concat(personDb.toString()));
		});

		scanner.close();
	}

	@Transactional
	private void delete(){
		System.out.println("All persons: ");
		personRepository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Write the id of the person: ");
		Long id = scanner.nextLong();

		personRepository.deleteById(id);

		System.out.println("New all persons: ");
		personRepository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional(readOnly = true)
	private void customQueries(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Write the id of the person: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = personRepository.findById(id);
		optionalPerson.ifPresentOrElse(p -> {
			Optional<Object> optionalObject = personRepository.getDataById(id);
			if(optionalObject.isPresent()){
				Object[] ob = (Object[]) optionalObject.orElseThrow();
				System.out.println("id: ".concat(ob[0].toString())
											.concat(", name: ")
											.concat(ob[1].toString())
											.concat(", lastname: ")
											.concat(ob[2].toString())
											.concat(", programmingLanguage: ")
											.concat(ob[3].toString())
				);
			}
		}, () -> {
			System.out.println("Person doesn't exits.");
		});

		scanner.close();
	}

	@Transactional(readOnly = true)
	private void listDto(){
		List<PersonDto> personsDto = personRepository.getAllPersonDto();
		personsDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	private void listBetween(){
		List<Person> persons = personRepository.findByIdBetween(2L, 5L);
		persons.forEach(System.out::println);

		persons = personRepository.findByNameBetween("A", "J");
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	private void subQueries(){
		List<Object[]> regs = personRepository.getShorterName();
		regs.forEach(p -> {
			System.out.println("name: ".concat(p[0].toString()).concat(" length: ".concat(p[1].toString())));
		});

		Optional<Person> lastPerson = personRepository.getLastPerson();
		lastPerson.ifPresentOrElse(System.out::println, () -> System.out.println("An error has ocurred."));
	}

	@Transactional(readOnly = true)
	private void listProgrammingLanguageDistinct(){
		List<String> programmingLanguages = personRepository.getAllProgrammingLanguagesDistinct();
		programmingLanguages.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	private void findOne(){
		personRepository.findById(1L).ifPresent(p -> System.out.println(p));
		personRepository.findLikeName("ia").ifPresent(p -> System.out.println(p));
		personRepository.findByNameContaining("pe").ifPresent(p -> System.out.println(p));
	}

	@Transactional(readOnly = true)
	private void list(){
		// List<Person> persons = (List<Person>) personRepository.findAll();
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguageAndName("Java", "Andres");
		persons.stream().forEach(p -> System.out.println(p));

		List<Object[]> personValues = personRepository.getNameAndProgrammingLanguage();
		personValues.stream().forEach(p -> System.out.println(p[0].toString().concat(" programming in ").concat(p[1].toString())));
	}
}
