package com.sges.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;

import com.sges.dto.OrderBy;

public class SortUtil {
	public static List<Sort.Order> buildOrders(List<OrderBy> orders) {
        if (AssertionUtil.isNullOrEmpty(orders))
            return new ArrayList<Sort.Order>();
        return orders.stream().map((it) -> {
            return new Sort.Order(Sort.Direction.fromString(it.getDirection()), it.getProperty());
        }).collect(Collectors.toList());
    }

    public static Sort buildSort(List<OrderBy> orders) {
        return Sort.by(buildOrders(orders));
    }
}
