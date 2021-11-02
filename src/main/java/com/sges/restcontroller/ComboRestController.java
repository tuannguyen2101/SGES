package com.sges.restcontroller;

import com.sges.entity.Combo;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import com.sges.service.ComboDetailService;
import com.sges.service.ComboService;
import com.sges.service.ReviewsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/combos")
public class ComboRestController extends GenericController<Combo, Integer> {

    final ComboDetailService comboDetailService;
    final ReviewsService reviewsService;
    final ComboService comboService;

    public ComboRestController(BaseService<Combo, Integer> baseService, ComboService comboService, ComboDetailService comboDetailService, ReviewsService reviewsService) {
        super(baseService);
        this.comboService = comboService;
        this.comboDetailService = comboDetailService;
        this.reviewsService = reviewsService;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        comboDetailService.deleteComboDetailByCombo_Id(id);
        reviewsService.deleteReviewsByCombo_Id(id);
        comboService.delete(id);
    }
}
