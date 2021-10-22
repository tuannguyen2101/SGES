package com.sges.controller;

import com.sges.entity.Combo;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
public class ComboController extends GenericController<Combo, Integer>{

}
