package com.mango.mq.deadrabbitmq.entitty;

import lombok.Getter;

@Getter
public class OrderEntity {

    private Long productId; //商品id

    private Long delayTimes; //订单延时时间，过期则取消


}
