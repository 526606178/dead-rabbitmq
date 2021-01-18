package com.mango.mq.deadrabbitmq.controller;

import com.mango.mq.deadrabbitmq.entitty.OrderEntity;
import com.mango.mq.deadrabbitmq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.generateOrder(orderEntity);
    }
}
