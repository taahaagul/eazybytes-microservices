package com.taahaagul.loans.service;

import com.taahaagul.loans.dto.LoansDto;

public interface ILoansService {

    /**
     * @param mobileNumber - mobile number of the customer
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber - mobile number of the customer
     * @return - LoansDto
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     * @param loansDto - LoansDto
     * @return - boolean
     */
    boolean updateLoan(LoansDto loansDto);


    /**
     * @param mobileNumber - mobile number of the customer
     * @return - boolean
     */
    boolean deleteLoan(String mobileNumber);
}
