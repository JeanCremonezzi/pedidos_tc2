package ifsp.scl.ads.demo.service;

import ifsp.scl.ads.demo.domain.dish.Dish;
import ifsp.scl.ads.demo.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository repository;

    public Dish findDishById (Long id) throws Exception {
        return this.repository.findDishById(id).orElseThrow(() -> new Exception("Dish not found"));
    }

    public List<Dish> findAll() {
        return repository.findAll();
    }

    public Dish saveDish (Dish dish) {
        return this.repository.save(dish);
    }
}
