package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {

    /**
     *
     * @param customerDTO - CustomerDTO object
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber
     * @return CustomerDTO
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDTO
     * @return
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount( String mobileNumber);

}
