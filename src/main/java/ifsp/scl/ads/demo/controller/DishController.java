package ifsp.scl.ads.demo.controller;

import ifsp.scl.ads.demo.domain.dish.Dish;
import ifsp.scl.ads.demo.service.DishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@Tag(name = "Dishes Endpoints")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    @Operation(summary = "Create a new Dish")
    public ResponseEntity<Dish> createDish(@RequestBody @NotNull Dish dish) throws Exception {
        Dish newDish = dishService.saveDish(dish);

        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all Dishes available")
    public ResponseEntity<List<Dish>> getAllDishes() {
        List<Dish> dishes = dishService.findAll();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Dish")
    public ResponseEntity<String> deleteDish(@PathVariable Long id) throws Exception {
        dishService.deleteDishById(id);
        return new ResponseEntity<>("Dish deleted", HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Find a Dish by ID")
    public ResponseEntity<Dish> findById(@PathVariable Long id) throws Exception {
        Dish dish = dishService.findDishById(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Find a Dish by name")
    public ResponseEntity<Dish> findByName(@RequestParam String name) throws Exception {
        Dish dish = dishService.findDishByName(name);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PutMapping
    @Operation(summary = "Update a Dish")
    public ResponseEntity<Dish> updateDish(@RequestBody @NotNull Dish dish) throws Exception {
        Dish updatedDish = dishService.saveDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
}
