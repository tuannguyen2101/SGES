package com.sges.service.impl;

import com.sges.entity.Event;
import com.sges.generic.impl.GenericServiceImpl;
import com.sges.service.EventService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends GenericServiceImpl<Event, Integer> implements EventService {

    public EventServiceImpl(JpaRepository<Event, Integer> jpaRepository) {
        super(jpaRepository);
    }
}
