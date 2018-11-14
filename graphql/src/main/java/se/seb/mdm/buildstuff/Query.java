package se.seb.mdm.buildstuff;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private CustomerService customerService;

    @Autowired
    public Query(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer customer(String customerId) {
        return customerService.getCustomer(customerId);
    }

}
