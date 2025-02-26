package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
