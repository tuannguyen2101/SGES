package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sges.entity.Gender;

@Repository
public interface GenderRepo extends JpaRepository<Gender, Integer> {

}
