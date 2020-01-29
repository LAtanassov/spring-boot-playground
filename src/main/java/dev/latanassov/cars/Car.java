package dev.latanassov.cars;

import dev.latanassov.animals.Gender;
import dev.latanassov.customers.Customer;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;

    @OneToOne
    private Customer owner;
}
