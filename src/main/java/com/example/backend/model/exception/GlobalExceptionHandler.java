package com.example.backend.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**

 GlobalExceptionHandler - класс, который обрабатывает исключения глобально для приложения. */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**

     Обрабатывает исключение DishNotFoundException, возвращая соответствующий код ошибки.
     @param ex исключение DishNotFoundException, которое нужно обработать
     @return ResponseEntity с сообщением об ошибке и HTTP-статусом */
    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<String> handleDishNotFoundException(DishNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**

     Обрабатывает другие исключения, возвращая код ошибки по умолчанию.
     @param ex исключение, которое нужно обработать
     @return ResponseEntity с сообщением об ошибке и HTTP-статусом */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleDefaultException(Exception ex) {
        return new ResponseEntity<>("Что-то пошло не так:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**

     Обработчик исключения MethodArgumentNotValidException.

     <p>Этот метод обрабатывает исключение MethodArgumentNotValidException, которое возникает при невалидных аргументах

     методов контроллера. Он извлекает информацию об ошибках валидации из исключения и формирует сообщение об ошибке,

     содержащее список этих ошибок. Затем он возвращает ответ с кодом состояния HttpStatus.BAD_REQUEST и сообщением об

     ошибке.</p>

     @param ex исключение MethodArgumentNotValidException, которое было сгенерировано при невалидных аргументах метода.

     @return ответ, содержащий сообщение об ошибке и код состояния HttpStatus.BAD_REQUEST.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        String errorMessage = String.join(", ", errors);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
