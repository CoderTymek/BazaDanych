package pl.coderslab.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String city;
    private String phoneNumber;
    private String information;
    private Boolean offer;
}
