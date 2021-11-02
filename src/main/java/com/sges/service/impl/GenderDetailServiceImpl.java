package com.sges.service.impl;

import com.sges.entity.GenderDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.GenderDetailRepo;
import com.sges.service.GenderDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenderDetailServiceImpl extends GenericServiceImpl<GenderDetail, Integer> implements GenderDetailService {

    final GenderDetailRepo genderDetailRepo;

    public GenderDetailServiceImpl(JpaRepository<GenderDetail, Integer> jpaRepository, GenderDetailRepo genderDetailRepo) {
        super(jpaRepository);
        this.genderDetailRepo = genderDetailRepo;
    }

    @Override
    public void deleteGenderDetailByProduct_Id(int id) {
        if (genderDetailRepo.existsGenderDetailByProduct_Id(id)) {
            genderDetailRepo.deleteGenderDetailByProduct_Id(id);
        }
    }

}
