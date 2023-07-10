package com.example.backend.model.exception;

/**
 * Исключение, выбрасываемое в случае, если блюдо не найдено.
 */
public class DishNotFoundException extends RuntimeException {
    /**
     * Конструктор, принимающий идентификатор блюда.
     *
     * @param dishId идентификатор блюда
     */
    public DishNotFoundException(Long dishId) {
        super("Dish не найден по id: " + dishId);
    }
}
