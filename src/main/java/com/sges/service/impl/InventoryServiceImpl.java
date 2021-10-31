package com.sges.service.impl;

import com.sges.entity.Inventory;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.InventoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl extends GenericServiceImpl<Inventory, Integer> implements InventoryService {

    public InventoryServiceImpl(JpaRepository<Inventory, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
