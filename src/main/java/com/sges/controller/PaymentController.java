package com.sges.controller;

import com.sges.entity.Payment;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController extends GenericController<Payment, Integer>{

}
