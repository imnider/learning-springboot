package imnider.learning.springboot.relationship.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imnider.learning.springboot.relationship.entities.Address;
import imnider.learning.springboot.relationship.entities.Client;
import imnider.learning.springboot.relationship.repositories.IClientRepository;
import imnider.learning.springboot.relationship.repositories.IInvoiceRepository;

@Service
public class OneToManyService {

    IClientRepository clientRepository;
	IInvoiceRepository invoiceRepository;

	public OneToManyService(IClientRepository clientRepository, IInvoiceRepository invoiceRepository){
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
	}

    @Transactional
	public void addAddressesByClientId(Long id){
		Optional<Client> optionalClient = clientRepository.findById(id);
		optionalClient.ifPresentOrElse(c -> {
			c.getAddresses().addAll(List.of(
				new Address("My home", 432),
				new Address("My job", 245)));
			clientRepository.save(c);
			System.out.println(c);
		}, () -> System.out.println("The client doesn't exist."));
	}

}
