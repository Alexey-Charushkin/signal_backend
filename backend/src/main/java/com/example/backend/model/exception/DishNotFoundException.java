package com.example.backend.model.exception;

/**
 * Исключение, выбрасываемое в случае, если блюдо не найдено.
 */
public class DishNotFoundException extends RuntimeException {
    private final Long dishId;

    /**
     * Конструктор, принимающий идентификатор блюда.
     *
     * @param dishId идентификатор блюда
     */
    public DishNotFoundException(Long dishId) {
        super("Dish не найден по id: " + dishId);
        this.dishId = dishId;
    }

    /**
     * Получить идентификатор блюда, вызвавшего исключение.
     *
     * @return идентификатор блюда
     */
    public Long getDishId() {
        return dishId;
    }
}
