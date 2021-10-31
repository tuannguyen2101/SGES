package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sges.entity.Address;

@Repository
public interface AddressRepo extends BaseRepo<Address, Integer> {
	
}
