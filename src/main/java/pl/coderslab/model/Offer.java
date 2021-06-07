package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "offer")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberOfOffer;
    private String detailsOffer;





}
