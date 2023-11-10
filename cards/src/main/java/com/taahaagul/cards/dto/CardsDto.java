package com.taahaagul.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Cards",
        description = "Scheme to hold Card information"
)
@Data
public class CardsDto {

    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Schema(description = "Mobile number of the card holder", example = "1234567890")
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")
    @Schema(description = "Card number of the card holder", example = "123456789012")
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be empty")
    @Schema(description = "Card type of the card holder", example = "VISA")
    private String cardType;

    @Positive(message = "Total limit must be positive")
    @Schema(description = "Total limit of the card holder", example = "10000")
    private int totalLimit;

    @PositiveOrZero(message = "Amount used must be positive or zero")
    @Schema(description = "Amount used of the card holder", example = "1000")
    private int amountUsed;

    @PositiveOrZero(message = "Available amount must be positive or zero")
    @Schema(description = "Available amount of the card holder", example = "9000")
    private int availableAmount;
}
