package com.taahaagul.accounts.service.impl;

import com.taahaagul.accounts.Entity.Accounts;
import com.taahaagul.accounts.Entity.Customer;
import com.taahaagul.accounts.dto.AccountsDto;
import com.taahaagul.accounts.dto.CardsDto;
import com.taahaagul.accounts.dto.CustomerDetailsDto;
import com.taahaagul.accounts.dto.LoansDto;
import com.taahaagul.accounts.exception.ResourceNotFoundException;
import com.taahaagul.accounts.mapper.AccountsMapper;
import com.taahaagul.accounts.mapper.CustomerMapper;
import com.taahaagul.accounts.repository.AccountsRepository;
import com.taahaagul.accounts.repository.CustomerRepository;
import com.taahaagul.accounts.service.ICustomersService;
import com.taahaagul.accounts.service.client.CardsFeignClient;
import com.taahaagul.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     *
     * @param mobileNumber
     * @return CustomerDetailsDto
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if(null != loansDtoResponseEntity) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if(null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
