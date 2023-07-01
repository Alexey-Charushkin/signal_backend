package com.example.backend.api;

import com.example.backend.model.dto.DishDTO;
import com.example.backend.model.Dish;
import com.example.backend.service.DishService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    /**
     * Получить все блюда.
     *
     * @return список DTO всех блюд.
     */
    @GetMapping
    public List<DishDTO> getAllDishes() {
        return dishService.getAllDishes();
    }
    /**
     * Создать блюдо.
     *
     * @param dish информация о создаваемом блюде.
     * @return созданное блюдо.
     */
    @PostMapping
    @Operation(summary = "Create dish")
    public Dish createDish(@Valid @RequestBody DishDTO dish) {
        return dishService.createDish(dish);
    }
    /**
     * Получить блюдо по идентификатору.
     *
     * @param id идентификатор блюда.
     * @return найденное блюдо.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get dish by id")
    public Dish getDishById(@PathVariable("id") Long id) {
        return dishService.getDishById(id);
    }
    /**
     * Обновить информацию о блюде.
     *
     * @param id   идентификатор обновляемого блюда.
     * @param dish новая информация о блюде.
     * @return обновленное блюдо.
     */
    @PutMapping("/{id}")
    @Operation(summary = "update dish")
    public Dish updateDish(@PathVariable("id") Long id,@Valid @RequestBody DishDTO dish) {
        return dishService.updateDish(id, dish);
    }
    /**
     * Удалить блюдо по идентификатору.
     *
     * @param id идентификатор удаляемого блюда.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete dish by id")
    public void deleteDish(@PathVariable("id") Long id) {
        dishService.deleteDish(id);
    }
}
