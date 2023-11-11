package com.taahaagul.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "LoansDto", description = "Loans Dto")
@Data
public class LoansDto {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(description = "Mobile Number", example = "1234567890")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number cannot be empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    @Schema(description = "Loan Number", example = "123456789012")
    private String loanNumber;

    @NotEmpty(message = "Loan Type cannot be empty")
    @Schema(description = "Loan Type", example = "Home Loan")
    private String loanType;

    @Positive(message = "Loan Amount must be positive")
    @Schema(description = "Loan Amount", example = "100000")
    private int totalLoan;

    @PositiveOrZero(message = "Amount Paid must be positive or zero")
    @Schema(description = "Amount Paid", example = "10000")
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding Amount must be positive or zero")
    @Schema(description = "Outstanding Amount", example = "90000")
    private int outstandingAmount;
}
