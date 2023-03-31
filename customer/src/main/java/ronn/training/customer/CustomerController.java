package ronn.training.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
public record CustomerController(CustomerService service) {

    public void registerCustomer(@RequestBody CustomerRegistrationRequest cr){
      log.info("New customer registration {}", cr);
      service.register(cr);
    }
}
