package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sges.entity.Brand;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer>{

}
