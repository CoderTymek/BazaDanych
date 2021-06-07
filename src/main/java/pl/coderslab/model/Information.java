package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "information")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
