package dev.latanassov.customers;


import dev.latanassov.animals.Animal;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Animal> pets;
}
