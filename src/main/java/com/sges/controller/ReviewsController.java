package com.sges.controller;

import com.sges.entity.Reviews;
import com.sges.generic.impl.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController extends GenericController<Reviews, Integer>{

}
