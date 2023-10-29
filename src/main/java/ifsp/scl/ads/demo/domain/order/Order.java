package ifsp.scl.ads.demo.domain.order;

import ifsp.scl.ads.demo.domain.dish.Dish;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private Set<Dish> dishes;

    private Date requested;

    private Date delivered;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public Double totalValue() {
        return dishes.stream().mapToDouble(Dish::getPrice).sum();
    }
}
