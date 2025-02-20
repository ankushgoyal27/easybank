package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.AccountsDTO;
import com.easybytes.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO maptoAccountsDTO(Accounts accounts, AccountsDTO accountsDTO){

        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());

        return accountsDTO;
    }

    public static Accounts maptoAccounts(Accounts accounts, AccountsDTO accountsDTO){

        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());

        return accounts;
    }
}
