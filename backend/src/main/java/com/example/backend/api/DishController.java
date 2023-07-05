package com.example.backend.api;

import com.example.backend.model.dto.DishDTO;
import com.example.backend.model.Dish;
import com.example.backend.model.mapper.DishMapper;
import com.example.backend.service.DishService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper;
    /**
     * Получить все блюда.
     *
     * @return список DTO всех блюд.
     */
    @GetMapping
    public ResponseEntity<List<DishDTO>> getAllDishes() {
        List<DishDTO> dishes = dishService.getAllDishes();
        return ResponseEntity.ok(dishes);
    }
    /**
     * Создать блюдо.
     *
     * @param dish информация о создаваемом блюде.
     * @return созданное блюдо.
     */
    @PostMapping
    @Operation(summary = "Create dish")
    public ResponseEntity<Dish> createDish(@Valid @RequestBody DishDTO dish) {
        Dish createdDish = dishService.createDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDish);
    }
    /**
     * Получить блюдо по идентификатору.
     *
     * @param id идентификатор блюда.
     * @return найденное блюдо.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get dish by id")
    public ResponseEntity<DishDTO> getDishById(@PathVariable("id") Long id) {
        Dish dish = dishService.getDishById(id);
        if (dish != null) {
            DishDTO dishDTO = dishMapper.toDto(dish);
            return ResponseEntity.ok(dishDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Обновить информацию о блюде.
     *
     * @param id   идентификатор обновляемого блюда.
     * @param dish новая информация о блюде.
     * @return обновленное блюдо.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update dish")
    public ResponseEntity<DishDTO> updateDish(@PathVariable("id") Long id, @Valid @RequestBody DishDTO dish) {
        Dish updatedDish = dishService.updateDish(id, dish);
        if (updatedDish != null) {
            DishDTO updatedDishDTO = dishMapper.toDto(updatedDish);
            return ResponseEntity.ok(updatedDishDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Удалить блюдо по идентификатору.
     *
     * @param id идентификатор удаляемого блюда.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete dish by id")
    public ResponseEntity<Void> deleteDish(@PathVariable("id") Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}
