package net.learnJava.order_service.controller;

import lombok.RequiredArgsConstructor;
import net.learnJava.base_domains.dto.Order;
import net.learnJava.base_domains.dto.OrderEvent;
import net.learnJava.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping(value = "/orders")
    public String placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);
        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully";
    }
}
