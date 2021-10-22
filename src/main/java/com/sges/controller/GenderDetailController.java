package com.sges.controller;

import com.sges.entity.GenderDetail;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genderDetail")
public class GenderDetailController extends GenericController<GenderDetail, Integer>{

}
