package com.sges.repo;

import com.sges.entity.Combodetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombodetailRepo extends JpaRepository<Combodetail, Integer> {
	
}
