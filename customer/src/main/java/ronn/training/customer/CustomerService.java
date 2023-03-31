package ronn.training.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void register(CustomerRegistrationRequest cr) {
        Customer c = Customer.builder()
                .firstName(cr.firstName())
                .lastName(cr.lastName())
                .email(cr.email())
                .build();

        //TODO check CR validity
    }
}
