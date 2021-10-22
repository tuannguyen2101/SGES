package com.sges.controller;

import com.sges.entity.Size;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
public class SizeController extends GenericController<Size, Integer>{

}
