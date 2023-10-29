package ifsp.scl.ads.demo.repository;

import ifsp.scl.ads.demo.domain.order.Order;
import ifsp.scl.ads.demo.domain.order.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderById(Long id);

    List<Order> findOrderByStatus(Status status);
}
