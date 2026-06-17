package imnider.learning.springboot.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import imnider.learning.springboot.jpa.entities.Person;
import java.util.List;
import java.util.Optional;


public interface IPersonRepository extends CrudRepository<Person, Long>{

    @Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
    Optional<Person> findLikeName(String name);

    @Query("SELECT p.id, p.name, p.lastname, p.programmingLanguage FROM Person p WHERE p.id=?1")
    Optional<Object> getDataById(Long id);

    Optional<Person> findByNameContaining(String name);
    
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> getNameAndProgrammingLanguage();

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.name=?1")
    List<Object[]> getNameAndProgrammingLanguageByName();

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.programmingLanguage=?1")
    List<Object[]> getNameAndProgrammingLanguageByProgrammingLanguage();
}
