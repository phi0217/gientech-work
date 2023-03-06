package com.gientech.learn.order.controller;

import com.gientech.learn.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiefei
 * @date 2023/03/06
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create/{accountId}")
    public void create(@PathVariable Long accountId){
        orderService.create(accountId);
    }

}
