package com.sges.controller;

import com.sges.entity.Event;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController extends GenericController<Event, Integer>{

    public EventController(BaseService<Event, Integer> baseService) {
        super(baseService);
    }
}
