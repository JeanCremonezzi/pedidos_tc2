package ifsp.scl.ads.demo.service;

import ifsp.scl.ads.demo.domain.dish.Dish;
import ifsp.scl.ads.demo.repository.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository repository;

    public Dish findDishById (Long id) throws Exception {
        return this.repository.findDishById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
    }

    public Dish findDishByName (String name) throws Exception {
        return this.repository.findDishByName(name).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
    }

    public List<Dish> findAll() {
        return repository.findAll();
    }

    public Dish saveDish (Dish dish) throws Exception {
        repository.findDishByName(dish.getName()).ifPresent((e) -> {
            throw new DuplicateKeyException("Name already in use");
        });

        return this.repository.save(dish);
    }

    public void deleteDishById (Long id) throws Exception {
        repository.findDishById(id).orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        this.repository.deleteById(id);
    }
}
