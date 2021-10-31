package com.sges.controller;

import com.sges.entity.Address;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends GenericController<Address, Integer>{

    public AddressController(BaseService<Address, Integer> baseService) {
        super(baseService);
    }
}
