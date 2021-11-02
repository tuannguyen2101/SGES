package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.GenderDetail;


@Repository
public interface GenderDetailRepo extends BaseRepo<GenderDetail, Integer> {
    void deleteGenderDetailByProduct_Id(Integer id);
    boolean existsGenderDetailByProduct_Id(Integer id);

}
