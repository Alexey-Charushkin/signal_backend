package com.example.backend.DishCRUDTest;

import com.example.backend.model.Dish;
import com.example.backend.repository.DishRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

public class RepositoryTest extends BaseSpringIntegrationTest {
    @Autowired
    private DishRepository dishRepository;

    @Test
    public void testCreate(){
        Dish dish = new Dish();
        dish.setDescription("test description");
        dish.setPrice(BigDecimal.valueOf(111));
        dish.setCategory("test category");
        dish.setPreparationTime(11);
        Dish result = dishRepository.save(dish);

        assertThat(result.getDishId()).isNotNull();
    }
    @Test
    public void testUpdate(){
        Dish dish = new Dish();
        dish.setDescription("test description");
        dish.setPrice(BigDecimal.valueOf(111));
        dish.setCategory("test category");
        dish.setPreparationTime(11);
        Dish saveDish = dishRepository.save(dish);

        saveDish.setDescription("update description");
        Dish updateDish = dishRepository.save(saveDish);

        assertThat(updateDish.getDescription()).isEqualTo("update description");
    }
    @Test
    public void testRead(){
        Dish dish = new Dish();
        dish.setDescription("test description");
        dish.setPrice(BigDecimal.valueOf(111));
        dish.setCategory("test category");
        dish.setPreparationTime(11);
        Dish saveDish = dishRepository.save(dish);

        Optional<Dish> resultOptional = dishRepository.findById(saveDish.getDishId());
        assertThat(resultOptional.isPresent()).isTrue();
        Dish result = resultOptional.get();

        assertThat(result.getDescription()).isEqualTo(dish.getDescription());
    }

    @Test
    public void testDelete(){
        Dish dish = new Dish();
        dish.setDescription("test description");
        dish.setPrice(BigDecimal.valueOf(111));
        dish.setCategory("test category");
        dish.setPreparationTime(11);
        Dish saveDish = dishRepository.save(dish);

        dishRepository.delete(saveDish);

        assertThat(dishRepository.findById(saveDish.getDishId())).isEmpty();
    }
}
