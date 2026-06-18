package imnider.learning.springboot.relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import imnider.learning.springboot.relationship.entities.Invoice;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long>{

}
