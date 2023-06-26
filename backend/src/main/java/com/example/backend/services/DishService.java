package com.example.backend.services;

import com.example.backend.dto.DishDTO;
import com.example.backend.model.Dish;
import com.example.backend.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**

 Сервис для работы с блюдами.
 */
@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    /**

     Создает новое блюдо на основе переданного DTO.
     @param dishDTO DTO с информацией о блюде.
     @return созданное блюдо. */
    public Dish createDish(DishDTO dishDTO){
        var dish = Dish.builder()
                .description(dishDTO.getDescription())
                .price(dishDTO.getPrice())
                .category(dishDTO.getCategory())
                .preparationTime(dishDTO.getPreparationTime())
                .build();
        return dishRepository.save(dish);
    }

    /**

     Возвращает список всех блюд.
     @return список всех блюд. */
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
    /**

     Возвращает блюдо по его ID.
     @param id ID блюда.
     @return найденное блюдо.
     @throws RuntimeException если блюдо не было найдено. */
    public Dish getDishById(Long id){
        return dishRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Dish not found with id " + id));
    }
    /**

     Удаляет блюдо по его ID.
     @param id ID блюда. */
    public void deleteDish(Long id){
        Dish dish = getDishById(id);
        dishRepository.delete(dish);
    }
    /**

     Обновляет блюдо по его ID.
     @param id ID блюда.
     @return обновленное блюдо. */
    public Dish updateDish(Long id, Dish dish) {
        Dish updatedDish = getDishById(id);
        updatedDish.setDescription(dish.getDescription());
        updatedDish.setPrice(dish.getPrice());
        updatedDish.setCategory(dish.getCategory());
        updatedDish.setPreparationTime(dish.getPreparationTime());
        return dishRepository.save(updatedDish);
    }
}
