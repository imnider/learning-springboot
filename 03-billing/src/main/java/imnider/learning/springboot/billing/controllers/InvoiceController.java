package imnider.learning.springboot.billing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imnider.learning.springboot.billing.models.Client;
import imnider.learning.springboot.billing.models.Invoice;

@RestController
@RequestMapping("api/invoices")
public class InvoiceController {

    private Invoice invoice;
    public InvoiceController(@Autowired Invoice invoice) {
        this.invoice = invoice;

    }

    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice();
        Client c = new Client();

        c.setName(invoice.getClient().getName());
        c.setLastName(invoice.getClient().getLastName());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    } 

}
