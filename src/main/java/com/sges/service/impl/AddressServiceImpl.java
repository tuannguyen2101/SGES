package com.sges.service.impl;

import com.sges.entity.Address;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.AddressRepo;
import com.sges.service.AddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Address, Integer> implements AddressService {

    final AddressRepo addressRepo;

    public AddressServiceImpl(JpaRepository<Address, Integer> jpaRepository, AddressRepo addressRepo) {
        super(jpaRepository);
        this.addressRepo = addressRepo;
    }

    @Override
    public void deleteAddressByUser_Id(Integer id) {
        if (addressRepo.existsAddressByUser_Id(id)) {
            addressRepo.deleteAddressByUser_Id(id);
        }
    }
}
