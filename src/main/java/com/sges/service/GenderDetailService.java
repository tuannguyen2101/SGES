package com.sges.service;

import com.sges.entity.GenderDetail;
import com.sges.generic.BaseService;

public interface GenderDetailService extends BaseService<GenderDetail, Integer> {

    void deleteGenderDetailByProduct_Id(int id);
}
