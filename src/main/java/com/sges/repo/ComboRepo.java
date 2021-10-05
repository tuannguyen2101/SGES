package com.sges.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sges.entity.Combo;

@Repository
public interface ComboRepo extends JpaRepository<Combo, Integer> {

}
