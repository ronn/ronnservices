package ronn.training.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
        CustomerRepository repo,
        RestTemplate restTemplate
) {
    public void register(CustomerRegistrationRequest cr) {
        Customer c = Customer.builder()
                .firstName(cr.firstName())
                .lastName(cr.lastName())
                .email(cr.email())
                .build();

        //TODO check CR validity
       repo.saveAndFlush(c);
        //TODO check if fraudster
        FraudCheckResponse fcResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                c.getId()
        );

        if (fcResponse.isFraudster()){
            throw new IllegalStateException("FRAUDSTER!");
        }

        //TODO send notification

        repo.save(c);
    }
}
