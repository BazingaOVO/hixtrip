package com.hixtrip.sample.infra;

import com.hixtrip.sample.domain.order.model.Order;
import com.hixtrip.sample.domain.order.repository.OrderRepository;
import com.hixtrip.sample.domain.pay.model.CommandPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public void createOrder(Order order) {
        redisTemplate.opsForValue().set(order.getId(),order);
    }

    @Override
    public void orderPaySuccess(CommandPay commandPay) {
        Object object = redisTemplate.opsForValue().get(commandPay.getOrderId());
        Order order = (Order) object;
        order.setPayStatus("payed");
        order.setPayTime(LocalDateTime.now());
        redisTemplate.opsForValue().set(order.getId(),order);
    }

    @Override
    public void orderPayFail(CommandPay commandPay) {

    }
}
