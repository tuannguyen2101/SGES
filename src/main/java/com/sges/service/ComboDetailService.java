package com.sges.service;

import com.sges.entity.ComboDetail;
import com.sges.generic.BaseService;

public interface ComboDetailService extends BaseService<ComboDetail, Integer> {

    void deleteComboDetailByProductDetail_Id(Integer id);

    void deleteComboDetailByCombo_Id(Integer id);
}
