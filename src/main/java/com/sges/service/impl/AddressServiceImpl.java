package com.sges.service.impl;

import com.sges.entity.Address;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.AddressRepo;
import com.sges.service.AddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Address, Integer> implements AddressService {

    public AddressServiceImpl(JpaRepository<Address, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
