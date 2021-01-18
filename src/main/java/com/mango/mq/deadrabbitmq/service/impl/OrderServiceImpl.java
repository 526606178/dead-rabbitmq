package com.mango.mq.deadrabbitmq.service.impl;

import com.mango.mq.deadrabbitmq.config.CancelOrderSender;
import com.mango.mq.deadrabbitmq.config.CommonResult;
import com.mango.mq.deadrabbitmq.entitty.OrderEntity;
import com.mango.mq.deadrabbitmq.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderEntity orderEntity) {
        //创建订单一系列操作
        log.info("创建订单，返回订单ID");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        cancelOrderSender.sendMessage(11l, orderEntity.getDelayTimes()); //发送延迟消息
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        // 这里执行取消订单操作
        log.info("订单未支付，时间过期，取消订单:{}",orderId);
    }


}
