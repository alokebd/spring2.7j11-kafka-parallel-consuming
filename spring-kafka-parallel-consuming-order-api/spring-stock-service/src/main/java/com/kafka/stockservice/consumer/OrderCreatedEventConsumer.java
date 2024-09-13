package com.kafka.stockservice.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import com.kafka.stockservice.model.Order;

@Component
public class OrderCreatedEventConsumer {

    @KafkaListener(topics = "order-created-event", groupId = "group-id-1", properties = {"spring.json.value.default.type=com.kafka.stockservice.model.Order"})
    public void consume1(Order order, Acknowledgment acknowledgment) {
        System.out.println(String.format("Stock Group, Order ID: %s", order.getOrderId()));
        acknowledgment.acknowledge();
    }
	
}
