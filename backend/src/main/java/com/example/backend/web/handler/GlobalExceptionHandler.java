package com.example.backend.web.handler;

import com.example.backend.web.exception.IllegalParameterException;
import com.example.backend.web.response.BaseResponse;
import com.example.backend.web.response.FailedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
*Единый глобальный компонент обработки исключений в приложении.
*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обработка {@code IllegalParameterException}
     *
     * @param   exception   IllegalParameterException.class
     */
    @ExceptionHandler(IllegalParameterException.class)
    public ResponseEntity<BaseResponse> catchNoSuchClientException(IllegalParameterException exception) {
        return new ResponseEntity<>(new FailedResponse(exception.getStatusCode(), exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
