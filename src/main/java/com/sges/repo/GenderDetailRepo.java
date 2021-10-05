package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sges.entity.GenderDetail;


@Repository
public interface GenderDetailRepo extends JpaRepository<GenderDetail, Integer> {

}
