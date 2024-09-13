package com.kafka.orderservice.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kafka.orderservice.model.Order;

@Component
public class OrderCreatedEventProducer {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public OrderCreatedEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Order order) {
        this.kafkaTemplate.send("order-created-event", order);
    }
}