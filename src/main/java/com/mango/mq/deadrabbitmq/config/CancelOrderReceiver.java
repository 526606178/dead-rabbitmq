package com.mango.mq.deadrabbitmq.config;

import com.mango.mq.deadrabbitmq.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * mango on 2020/9/14.
 */
@Component
@RabbitListener(queues = "order.cancel")
@Slf4j
public class CancelOrderReceiver {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void handle(Long orderId){
        log.info(" == 取消订单消息的处理者==  orderId:{}",orderId);
        orderService.cancelOrder(orderId);
    }
}
