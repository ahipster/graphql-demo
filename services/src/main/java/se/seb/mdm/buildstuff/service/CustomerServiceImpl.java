package se.seb.mdm.buildstuff.service;

import com.github.javafaker.Faker;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.stereotype.Service;
import se.seb.mdm.buildstuff.Customer;
import se.seb.mdm.buildstuff.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomer(String customerId) {
        Faker faker = new Faker();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPersonalIdNumber(faker.idNumber().validSvSeSsn());
        return customer;
    }
}
