package com.taahaagul.cards.service;

import com.taahaagul.cards.dto.CardsDto;

public interface ICardsService {

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    void createCard(String mobileNumber);

    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return - Newly created Card
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     * @param cardsDto - Card details to be updated
     * @return - true if update is successful, false otherwise
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return - true if delete is successful, false otherwise
     */
    boolean deleteCard(String mobileNumber);
}