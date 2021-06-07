package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;

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
    private Long pesel;
    private String name;
    private String surname;
    private String phoneNumber;


    @OneToOne
    private Information information;

    @ManyToOne
    private Offer offer;
}
