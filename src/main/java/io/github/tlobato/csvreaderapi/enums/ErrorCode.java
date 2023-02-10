package io.github.tlobato.csvreaderapi.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EC001("EC-001", "Product not found!"),
    EC002("EC-002", "Invalid file format"),
    EC101("EC-101", "Número de campos de dados incompatível com o número de cabeçalhos!");

    private final String code;
    private final String message;

}