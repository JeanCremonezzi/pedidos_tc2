package ifsp.scl.ads.demo.domain.order;

import ifsp.scl.ads.demo.domain.dish.Dish;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name="orders")
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Dish> dishes;

    private Date requested;

    private Date delivered;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
}
