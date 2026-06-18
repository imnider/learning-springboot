package imnider.learning.springboot.relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import imnider.learning.springboot.relationship.entities.Client;

public interface IClientRepository extends CrudRepository<Client, Long>{
    
}
