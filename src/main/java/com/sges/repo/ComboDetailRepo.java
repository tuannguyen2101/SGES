package com.sges.repo;

import com.sges.entity.ComboDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboDetailRepo extends JpaRepository<ComboDetail, Integer> {
	
}
