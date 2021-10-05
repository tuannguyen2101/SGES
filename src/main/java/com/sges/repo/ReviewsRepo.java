package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Reviews;

@Repository
public interface ReviewsRepo extends BaseRepo<Reviews, Integer> {
}
