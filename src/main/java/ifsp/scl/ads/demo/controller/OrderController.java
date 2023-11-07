package ifsp.scl.ads.demo.controller;

import ifsp.scl.ads.demo.domain.order.Order;
import ifsp.scl.ads.demo.domain.order.Status;
import ifsp.scl.ads.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders Endpoints")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Operation(summary = "Create a new Order")
    public ResponseEntity<Order> createOrder(@RequestBody @NotNull Order order) {
        order.setRequested(new Date());
        Order newOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all Orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get a Order by ID")
    public ResponseEntity<Order> findById(@PathVariable Long id) throws Exception {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get Orders by Status")
    public ResponseEntity<List<Order>> findByStatus(@PathVariable Status status) throws Exception {
        List<Order> orders = orderService.findOrderByStatus(status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Order")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) throws Exception {
        orderService.deleteOrderById(id);
        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary = "Update a Order")
    public ResponseEntity<Order> updateOrder(@RequestBody @NotNull Order order) throws Exception {
        Order foundOrder = orderService.findOrderById(order.getId());

        if (order.getStatus().equals(Status.DELIVERED)) {
            foundOrder.setDelivered(new Date());
        }

        Order updatedOrder = orderService.saveOrder(foundOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
