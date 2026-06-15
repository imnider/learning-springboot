package imnider.learning.springboot.billing.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {
    
    @Autowired
    private Client client;
    
    @Value("${data.invoice.description}")
    private String description;
    
    @Autowired
    @Qualifier("office")
    private List<Item> items;

    public Invoice() {
    }

    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }

    @PostConstruct
    public void init() {
        client.setName(client.getName().concat(" ").concat("Ariel"));
        client.setLastName(client.getLastName().concat(" ").concat("Zambrano"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Invoice destroyed: ".concat(description));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return items.stream().
        mapToDouble(Item::getImport).
        sum();
    }
}
