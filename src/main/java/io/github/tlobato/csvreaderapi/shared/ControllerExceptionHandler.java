package io.github.tlobato.csvreaderapi.shared;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.github.tlobato.csvreaderapi.enums.ErrorCode;
import io.github.tlobato.csvreaderapi.exception.InvalidCSVException;
import io.github.tlobato.csvreaderapi.exception.ProductNotFoundException;
import io.github.tlobato.csvreaderapi.shared.dto.ErrorResponseDto;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseDto handleProductNotFoundException(ProductNotFoundException exception, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseDto.setMessage(ErrorCode.EC001.getMessage());
        errorResponseDto.setInternalCode(ErrorCode.EC001.getCode());
        errorResponseDto.setPath(request.getDescription(false));
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return errorResponseDto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CsvRequiredFieldEmptyException.class)
    public ErrorResponseDto handleCsvRequiredException(CsvRequiredFieldEmptyException exception, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseDto.setMessage(ErrorCode.EC101.getMessage());
        errorResponseDto.setInternalCode(ErrorCode.EC101.getCode());
        errorResponseDto.setPath(request.getDescription(false));
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return errorResponseDto;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCSVException.class)
    public ErrorResponseDto handleCsvRequiredException(InvalidCSVException exception, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto();

        errorResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseDto.setMessage(ErrorCode.EC002.getMessage());
        errorResponseDto.setInternalCode(ErrorCode.EC002.getCode());
        errorResponseDto.setPath(request.getDescription(false));
        errorResponseDto.setTimestamp(LocalDateTime.now());

        return errorResponseDto;

    }

}