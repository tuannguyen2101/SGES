package com.sges.restcontroller;

import com.sges.entity.User;
import com.sges.generic.BaseService;
import com.sges.generic.impl.GenericController;
import com.sges.service.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/users")
public class UserRestController extends GenericController<User, Integer> {

    final AuthorityService authorityService;
    final AddressService addressService;
    final ReviewsService reviewsService;
    final OrderService orderService;
    final UserService userService;


    public UserRestController(BaseService<User, Integer> baseService, AuthorityService authorityService, AddressService addressService, ReviewsService reviewsService, OrderService orderService, UserService userService) {
        super(baseService);
        this.authorityService = authorityService;
        this.addressService = addressService;
        this.reviewsService = reviewsService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.deleteAuthorityByUser_Id(id);
        addressService.deleteAddressByUser_Id(id);
        reviewsService.deleteReviewsByUser_Id(id);
        orderService.deleteOrderByUser_Id(id);
        userService.delete(id);
    }
}
