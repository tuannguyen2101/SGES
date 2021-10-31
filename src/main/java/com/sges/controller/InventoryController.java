package com.sges.controller;

import com.sges.entity.Inventory;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController extends GenericController<Inventory, Integer>{

    public InventoryController(BaseService<Inventory, Integer> baseService) {
        super(baseService);
    }
}
