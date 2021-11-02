package com.sges.restcontroller;

import com.sges.entity.Event;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import com.sges.service.EventService;
import com.sges.service.VoucherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/events")
public class EventRestController extends GenericController<Event, Integer> {

    final EventService eventService;
    final VoucherService voucherService;

    public EventRestController(BaseService<Event, Integer> baseService, EventService eventService, VoucherService voucherService) {
        super(baseService);
        this.eventService = eventService;
        this.voucherService = voucherService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        voucherService.deleteByEvent_Id(id);
        eventService.delete(id);
    }
}
