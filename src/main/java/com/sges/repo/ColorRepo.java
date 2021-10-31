package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sges.entity.Color;

@Repository
public interface ColorRepo extends BaseRepo<Color, Integer>{

}
