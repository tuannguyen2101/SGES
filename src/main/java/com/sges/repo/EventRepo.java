package com.sges.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sges.entity.Event;

@Repository
public interface EventRepo extends BaseRepo<Event, Integer> {

}
