package com.sges.controller;

import com.sges.entity.SupCate;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supCate")
public class SupCateController extends GenericController<SupCate, Integer>{

    public SupCateController(BaseService<SupCate, Integer> baseService) {
        super(baseService);
    }
}
