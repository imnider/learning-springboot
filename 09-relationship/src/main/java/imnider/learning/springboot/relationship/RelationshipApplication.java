package imnider.learning.springboot.relationship;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import imnider.learning.springboot.relationship.entities.Client;
import imnider.learning.springboot.relationship.entities.Invoice;
import imnider.learning.springboot.relationship.repositories.IClientRepository;
import imnider.learning.springboot.relationship.repositories.IInvoiceRepository;

@SpringBootApplication
public class RelationshipApplication implements CommandLineRunner{

	IClientRepository clientRepository;
	IInvoiceRepository invoiceRepository;

	public RelationshipApplication(IClientRepository clientRepository, IInvoiceRepository invoiceRepository){
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne();
	}

	public void manyToOne(){
		Optional<Client> optionalClient = clientRepository.findById(1L);
		optionalClient.ifPresentOrElse(c -> {
			Invoice newInvoice = new Invoice("Invoice to: ".concat(c.getName()), 200D);
			newInvoice.setClient(c);
			Invoice invoiceDB= invoiceRepository.save(newInvoice);
			System.out.println(invoiceDB);
		}, () -> System.out.println("The client doesn't exist."));
	}

}
