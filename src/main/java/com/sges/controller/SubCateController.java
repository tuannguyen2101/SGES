package com.sges.controller;

import com.sges.entity.SubCate;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subCate")
public class SubCateController extends GenericController<SubCate, Integer>{

    public SubCateController(BaseService<SubCate, Integer> baseService) {
        super(baseService);
    }
}
