package com.sges.controller;

import com.sges.entity.ComboDetail;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comboDetail")
public class ComboDetailController extends GenericController<ComboDetail, Integer>{

}
