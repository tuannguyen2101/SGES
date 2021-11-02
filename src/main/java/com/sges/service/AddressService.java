package com.sges.service;

import com.sges.entity.Address;
import com.sges.generic.BaseService;

public interface AddressService extends BaseService<Address, Integer> {

    void deleteAddressByUser_Id(Integer id);
}
