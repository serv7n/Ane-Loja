package leandro.aneloja.shared.controller;

import leandro.aneloja.shared.exception.EntityNotFoundException;
import leandro.aneloja.shared.exception.UploadImagemErroException;
import leandro.aneloja.shared.exception.dto.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErroDTO> handleNotFoundException(EntityNotFoundException e) {
        var erro = new ErroDTO(e.getMessage(),e.getCampo());
        return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UploadImagemErroException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErroDTO> handleNotFoundException(UploadImagemErroException e) {
        var erro = new ErroDTO(e.getMessage(), null);
        return new ResponseEntity<>(erro,HttpStatus.BAD_REQUEST);
    }
}
