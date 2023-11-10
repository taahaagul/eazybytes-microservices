package com.taahaagul.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponseDto", description = "Error Response DTO")
public class ErrorResponseDto {

    @Schema(description = "API path invoked by client")
    private String apiPath;

    @Schema(description = "HTTP Status Code")
    private HttpStatus httpStatus;

    @Schema(description = "Error Message")
    private String errorMessage;

    @Schema(description = "Error Time")
    private LocalDateTime errorTime;
}
