package com.sges.service.impl;

import com.sges.entity.Reviews;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.ReviewsRepo;
import com.sges.service.ReviewsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewsServiceImpl extends GenericServiceImpl<Reviews, Integer> implements ReviewsService {

    final ReviewsRepo reviewsRepo;

    public ReviewsServiceImpl(JpaRepository<Reviews, Integer> jpaRepository, ReviewsRepo reviewsRepo) {
        super(jpaRepository);
        this.reviewsRepo = reviewsRepo;
    }

    @Override
    public void deleteReviewsByProduct_Id(Integer id) {
        if (reviewsRepo.existsReviewsByProduct_Id(id)) {
            reviewsRepo.deleteReviewsByProduct_Id(id);
        }
    }

    @Override
    public void deleteReviewsByCombo_Id(Integer id) {
        if (reviewsRepo.existsReviewsByCombo_Id(id)) {
            reviewsRepo.deleteReviewsByCombo_Id(id);
        }
    }


    @Override
    public void deleteReviewsByUser_Id(Integer id) {
        if (reviewsRepo.existsReviewsByUser_Id(id)) {
            reviewsRepo.deleteReviewsByUser_Id(id);
        }
    }


}
