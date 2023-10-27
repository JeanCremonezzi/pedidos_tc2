package ifsp.scl.ads.demo.domain.dish;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="dishes")
@Table(name="dishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private Double price;
}
