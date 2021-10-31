package com.sges.controller;

import com.sges.entity.Transport;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport")
public class TransportController extends GenericController<Transport, Integer>{

    public TransportController(BaseService<Transport, Integer> baseService) {
        super(baseService);
    }
}
