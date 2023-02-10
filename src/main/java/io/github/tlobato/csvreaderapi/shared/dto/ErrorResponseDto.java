package io.github.tlobato.csvreaderapi.shared.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    private Integer status;
    private String message;
    private String internalCode;
    private String path;
    private LocalDateTime timestamp;
}