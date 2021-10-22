package com.sges.controller;

import com.sges.entity.Voucher;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voucher")
public class VoucherController extends GenericController<Voucher, Integer>{

}
