package com.kafka.paymentservice.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.kafka.paymentservice.model.Order;

@Component
public class OrderCreatedEventConsumer {

    @KafkaListener(
    		topics = "order-created-event", 
    		groupId = "payment-group", 
    		properties = {"spring.json.value.default.type=com.kafka.paymentservice.model.Order"})
    public void consumeOrderCreatedEvent(Order order, Acknowledgment acknowledgment) {
        System.out.println(String.format("Payment Group,  Order ID: %s", order.getOrderId()));
        acknowledgment.acknowledge();
    }

}
