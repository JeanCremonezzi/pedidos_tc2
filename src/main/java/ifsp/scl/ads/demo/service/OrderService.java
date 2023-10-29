package ifsp.scl.ads.demo.service;

import ifsp.scl.ads.demo.domain.order.Order;
import ifsp.scl.ads.demo.domain.order.Status;
import ifsp.scl.ads.demo.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order findOrderById (Long id) throws Exception {
        return repository.findOrderById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public List<Order> findOrderByStatus (Status status) throws Exception {
        return repository.findOrderByStatus(status);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order saveOrder (Order order) {
        return repository.save(order);
    }

    public void deleteOrderById (Long id) throws Exception {
        repository.findOrderById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        repository.deleteById(id);
    }
}
