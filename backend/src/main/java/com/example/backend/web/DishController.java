package com.example.backend.web;

import com.example.backend.dto.DishDTO;
import com.example.backend.model.Dish;
import com.example.backend.services.DishService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @PostMapping
    @Operation(summary = "Create dish")
    public Dish createDish(@RequestBody DishDTO dish) {
        return dishService.createDish(dish);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get dish by id")
    public Dish getDishById(@PathVariable("id") Long id) {
        return dishService.getDishById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update dish")
    public Dish updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
        return dishService.updateDish(id, dish);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete dish by id")
    public void deleteDish(@PathVariable("id") Long id) {
        dishService.deleteDish(id);
    }
}
