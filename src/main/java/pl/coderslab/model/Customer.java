package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @NotNull
    private Long pesel;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Size(min = 9, max = 9)
    private String phoneNumber;


    @OneToOne
    private Information information;

    @ManyToOne
    private Offer offer;
}
