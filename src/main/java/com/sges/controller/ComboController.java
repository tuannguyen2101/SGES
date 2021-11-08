package com.sges.controller;

import com.sges.entity.Combo;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
@CrossOrigin(origins = "*")
public class ComboController extends GenericController<Combo, Integer>{

    public ComboController(BaseService<Combo, Integer> baseService) {
        super(baseService);
    }
}
