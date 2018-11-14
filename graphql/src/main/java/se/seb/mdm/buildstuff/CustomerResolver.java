package se.seb.mdm.buildstuff;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    private ArrangementService arrangementService;
    private ProductService productService;


    @Autowired
    public CustomerResolver(ArrangementService arrangementService, ProductService productService) {
        this.arrangementService = arrangementService;
        this.productService = productService;
    }

    public List<Arrangement> arrangements(Customer customer) {
        return arrangementService.getArrangements(customer.getCustomerId());
    }

}
