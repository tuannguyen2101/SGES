package com.sges.repo;

import org.springframework.stereotype.Repository;
import com.sges.entity.Gender;

@Repository
public interface GenderRepo extends BaseRepo<Gender, Integer> {

}
