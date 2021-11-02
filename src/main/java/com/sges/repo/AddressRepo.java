package com.sges.repo;

import org.springframework.stereotype.Repository;

import com.sges.entity.Address;

@Repository
public interface AddressRepo extends BaseRepo<Address, Integer> {
	void deleteAddressByUser_Id(Integer id);
    boolean existsAddressByUser_Id(Integer id);
}
