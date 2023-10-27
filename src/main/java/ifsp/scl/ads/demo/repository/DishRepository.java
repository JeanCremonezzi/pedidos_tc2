package ifsp.scl.ads.demo.repository;

import ifsp.scl.ads.demo.domain.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findDishById(Long id);
    Optional<Dish> findDishByName(String name);
}
