package com.sges.service.impl;

import com.sges.entity.ComboDetail;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.repo.ComboDetailRepo;
import com.sges.service.ComboDetailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ComboDetailServiceImpl extends GenericServiceImpl<ComboDetail, Integer> implements ComboDetailService {

    final ComboDetailRepo comboDetailRepo;

    public ComboDetailServiceImpl(JpaRepository<ComboDetail, Integer> jpaRepository, ComboDetailRepo comboDetailRepo) {
        super(jpaRepository);
        this.comboDetailRepo = comboDetailRepo;
    }

    @Override
    public void deleteComboDetailByProductDetail_Id(Integer id) {
        if (comboDetailRepo.existsComboDetailByProductDetail_Id(id)) {
            comboDetailRepo.deleteComboDetailByProductDetail_Id(id);
        }
    }

    @Override
    public void deleteComboDetailByCombo_Id(Integer id) {
        if (comboDetailRepo.existsComboDetailByCombo_Id(id)) {
            comboDetailRepo.deleteComboDetailByCombo_Id(id);
        }
    }
}
