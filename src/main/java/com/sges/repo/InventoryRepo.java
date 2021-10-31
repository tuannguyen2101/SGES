package com.sges.repo;

import com.sges.entity.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends  BaseRepo<Inventory, Integer> {
}
