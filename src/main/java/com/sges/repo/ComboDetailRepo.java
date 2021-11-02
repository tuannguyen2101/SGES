package com.sges.repo;

import com.sges.entity.ComboDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboDetailRepo extends BaseRepo<ComboDetail, Integer> {
	void deleteComboDetailByProductDetail_Id(Integer id);
	boolean existsComboDetailByProductDetail_Id(Integer id);

	void deleteComboDetailByCombo_Id(Integer id);
	boolean existsComboDetailByCombo_Id(Integer id);
}
