package com.sges.service;

import com.sges.entity.Reviews;
import com.sges.generic.BaseService;

public interface ReviewsService extends BaseService<Reviews, Integer> {

    void deleteReviewsByProduct_Id(Integer id);

    void deleteReviewsByCombo_Id(Integer id);

    void deleteReviewsByUser_Id(Integer id);
}
