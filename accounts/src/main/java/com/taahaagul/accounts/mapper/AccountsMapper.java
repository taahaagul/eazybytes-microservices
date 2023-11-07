package com.taahaagul.accounts.mapper;

import com.taahaagul.accounts.Entity.Accounts;
import com.taahaagul.accounts.dto.AccountsDto;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(
            Accounts accounts, AccountsDto accountsDto) {

        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(
            AccountsDto accountsDto, Accounts accounts) {

        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
