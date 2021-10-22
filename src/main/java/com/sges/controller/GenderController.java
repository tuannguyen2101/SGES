package com.sges.controller;

import com.sges.entity.Gender;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gender")
public class GenderController extends GenericController<Gender, Integer>{

}
