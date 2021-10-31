package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sges.entity.Authority;

@Repository
public interface AuthorityRepo extends BaseRepo<Authority, Integer> {
	
}
