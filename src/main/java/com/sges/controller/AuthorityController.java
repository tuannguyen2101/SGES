package com.sges.controller;

import com.sges.entity.Authority;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authority")
public class AuthorityController extends GenericController<Authority, Integer>{

    public AuthorityController(BaseService<Authority, Integer> baseService) {
        super(baseService);
    }
}
