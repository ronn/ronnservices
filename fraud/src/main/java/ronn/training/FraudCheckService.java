package ronn.training;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(
        FraudCheckRepository repo
) {

    public boolean isFraudulent(Integer customerId) {
        repo.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
