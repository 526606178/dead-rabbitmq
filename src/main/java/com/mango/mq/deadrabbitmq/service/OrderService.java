package com.mango.mq.deadrabbitmq.service;

import com.mango.mq.deadrabbitmq.config.CommonResult;
import com.mango.mq.deadrabbitmq.entitty.OrderEntity;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderEntity orderEntity);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
