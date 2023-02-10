package io.github.tlobato.csvreaderapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class InvalidCSVException extends RuntimeException{

    private String message;

    private String errorCode;
}