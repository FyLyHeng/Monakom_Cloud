package com.example.monakom_cloud.core;

import com.example.monakom_cloud.core.exception.NotFoundException;
import com.example.monakom_cloud.core.response.ResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    /**
     * @override NotFoundException
     *
     * @return RespondDTO Format (with Header status NOT_FOUND)
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<ResponseDTO> handleEntityNotFounds( NotFoundException ex,  WebRequest request) {

        String errors = ex.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;

        ResponseDTO body = new ResponseDTO(
            status.value(),
            errors,
            null
        );

        this.logger.error(ex);
        return new ResponseEntity<>(body, status);
    }

}
