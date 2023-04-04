package ronn.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
    private static final String FRAUD_ID_SEQUENCE = "fraud_id_sequence";

    @Id
    @SequenceGenerator(name = FRAUD_ID_SEQUENCE, sequenceName = FRAUD_ID_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = FRAUD_ID_SEQUENCE)
    private Integer id;

    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
