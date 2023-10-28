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
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) throws Exception {
        Dish newDish = dishService.saveDish(dish);

        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = this.dishService.findAll();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable Long id) throws Exception {
        this.dishService.deleteDishById(id);
        return new ResponseEntity<>("Dish deleted", HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Dish> findById(@PathVariable Long id) throws Exception {
        Dish dish = this.dishService.findDishById(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Dish> findByName(@RequestParam String name) throws Exception {
        Dish dish = this.dishService.findDishByName(name);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish) throws Exception {
        Dish updatedDish = this.dishService.saveDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
}
