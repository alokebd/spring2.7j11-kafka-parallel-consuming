package com.kafka.orderservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.orderservice.model.Order;
import com.kafka.orderservice.producer.OrderCreatedEventProducer;

import java.util.Date;

@RestController
@RequestMapping("/kafka")
public class OrderController {

    public final OrderCreatedEventProducer orderCreatedEventProducer;

    public OrderController(OrderCreatedEventProducer orderCreatedEventProducer) {
        this.orderCreatedEventProducer = orderCreatedEventProducer;
    }

    @PostMapping("/v1/orders/{totalOrders}")
    public String publishOrder(@PathVariable Integer totalOrders) {
    	for (int i=0; i<totalOrders; i++) {
	        var id = (int) (Math.random() * 100) + 1;
	        var order = new Order(id, new Date());
	        orderCreatedEventProducer.produce(order);
    	}
        return "Creted "+ totalOrders+ " orders";
    }
}
