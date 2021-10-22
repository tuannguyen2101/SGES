package com.sges.controller;

import com.sges.entity.Color;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/color")
public class ColorController extends GenericController<Color, Integer>{

}
