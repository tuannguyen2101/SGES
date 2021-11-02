package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Reviews;

@Repository
public interface ReviewsRepo extends BaseRepo<Reviews, Integer> {

    void deleteReviewsByProduct_Id(Integer id);
    boolean existsReviewsByProduct_Id(Integer id);

    void deleteReviewsByCombo_Id(Integer id);
    boolean existsReviewsByCombo_Id(Integer id);

    void deleteReviewsByUser_Id(Integer id);
    boolean existsReviewsByUser_Id(Integer id);

}
