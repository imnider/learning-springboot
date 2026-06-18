package imnider.learning.springboot.relationship.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imnider.learning.springboot.relationship.entities.Client;
import imnider.learning.springboot.relationship.entities.Invoice;
import imnider.learning.springboot.relationship.repositories.IClientRepository;
import imnider.learning.springboot.relationship.repositories.IInvoiceRepository;

@Service
public class ManyToOneService {

    IClientRepository clientRepository;
	IInvoiceRepository invoiceRepository;

	public ManyToOneService(IClientRepository clientRepository, IInvoiceRepository invoiceRepository){
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
	}

    @Transactional
	public void addInvoiceByClientId(Long id){
		Optional<Client> optionalClient = clientRepository.findById(id);
		optionalClient.ifPresentOrElse(c -> {
			Invoice newInvoice = new Invoice("Invoice to: ".concat(c.getName()), 240D);
			newInvoice.setClient(c);
			Invoice invoiceDB= invoiceRepository.save(newInvoice);
			System.out.println(invoiceDB);
		}, () -> System.out.println("The client doesn't exist."));
	}

}
