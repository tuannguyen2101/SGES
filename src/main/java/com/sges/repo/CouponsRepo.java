package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sges.entity.Coupons;

@Repository
public interface CouponsRepo extends JpaRepository<Coupons, Integer> {
	
}
