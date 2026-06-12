package imnider.learning.springboot.billing;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import imnider.learning.springboot.billing.models.Item;
import imnider.learning.springboot.billing.models.Product;

@Configuration
@PropertySources({
    @PropertySource("classpath:properties/data.properties")
})

public class AppConfig {

    @Bean
    List<Item> itemsInvoice() {
        return List.of(
            new Item(new Product("TV", 1000.00), 1),
            new Item(new Product("PS5", 500.00), 2),
            new Item(new Product("XBOX", 500.00), 1)
        );
    }
}
