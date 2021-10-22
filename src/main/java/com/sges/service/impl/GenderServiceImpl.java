package com.sges.service.impl;

import com.sges.entity.Gender;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.GenderService;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl extends GenericServiceImpl<Gender, Integer> implements GenderService {

}
