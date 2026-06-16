package imnider.learning.springboot.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import imnider.learning.springboot.jpa.entities.Person;

public interface IPersonRepository extends CrudRepository<Person, Long>{

}
