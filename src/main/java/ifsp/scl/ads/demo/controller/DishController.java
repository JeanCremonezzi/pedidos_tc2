package ifsp.scl.ads.demo.controller;

import ifsp.scl.ads.demo.domain.dish.Dish;
import ifsp.scl.ads.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish newDish = dishService.saveDish(dish);

        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = this.dishService.findAll();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
}
