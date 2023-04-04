package ronn.training;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService service) {

    @PostMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId){
        boolean isFraudulentCustomer = service.isFraudulent(customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
