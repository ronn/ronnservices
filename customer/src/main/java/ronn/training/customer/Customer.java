package ronn.training.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Customer {

    private static final String CUSTOMER_ID_SEQUENCE = "customer_id_sequence";

    @Id
    @SequenceGenerator(name = CUSTOMER_ID_SEQUENCE, sequenceName = CUSTOMER_ID_SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMER_ID_SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
