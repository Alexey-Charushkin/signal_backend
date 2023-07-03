package com.example.backend.service;

import com.example.backend.model.dto.DishDTO;
import com.example.backend.model.exception.DishNotFoundException;
import com.example.backend.model.mapper.DishMapper;
import com.example.backend.model.Dish;
import com.example.backend.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**

 Сервис для работы с блюдами.
 */
@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    /**

     Создает новое блюдо на основе переданного DTO.
     @param dishDTO DTO с информацией о блюде.
     @return созданное блюдо. */
    public Dish createDish(DishDTO dishDTO){
        var dish = dishMapper.toEntity(dishDTO);
        return dishRepository.save(dish);
    }

    /**

     Возвращает список всех блюд.
     @return список всех блюд. */
    public List<DishDTO> getAllDishes() {
        List<Dish> dishes = dishRepository.findAll();
        return dishes.stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }
    /**

     Возвращает блюдо по его ID.
     @param id ID блюда.
     @return найденное блюдо.
     @throws RuntimeException если блюдо не было найдено. */
    public Dish getDishById(Long id){
        return dishRepository.findById(id)
                .orElseThrow(()-> new DishNotFoundException(id));
    }
    /**

     Удаляет блюдо по его ID.
     @param id ID блюда. */
    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }
    /**

     Обновляет блюдо по его ID.
     @param id ID блюда.
     @return обновленное блюдо. */
    public Dish updateDish(Long id, DishDTO dishDTO) {
        Dish dish = dishMapper.toEntity(dishDTO);
        return dishRepository.save(dish);
    }
}
