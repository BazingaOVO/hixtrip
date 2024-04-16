package com.hixtrip.sample.app.service;

import com.hixtrip.sample.app.api.OrderService;
import com.hixtrip.sample.app.convertor.OrderConvertor;
import com.hixtrip.sample.client.order.dto.CommandOderCreateDTO;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;
import com.hixtrip.sample.domain.commodity.CommodityDomainService;
import com.hixtrip.sample.domain.inventory.InventoryDomainService;
import com.hixtrip.sample.domain.order.OrderDomainService;
import com.hixtrip.sample.domain.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * app层负责处理request请求，调用领域服务
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private InventoryDomainService inventoryDomainService;

    @Autowired
    private CommodityDomainService commodityDomainService;

    @Override
    public String create(CommandOderCreateDTO commandOderCreateDTO) {
        Integer inventory = inventoryDomainService.getInventory(commandOderCreateDTO.getSkuId());
        if(inventory >= commandOderCreateDTO.getAmount()) {
            Order order = OrderConvertor.INSTANCE.toOrder(commandOderCreateDTO);
            order.setId(UUID.randomUUID().toString());
            BigDecimal price = commodityDomainService.getSkuPrice(order.getSkuId());
            order.setMoney(price.multiply(BigDecimal.valueOf(order.getAmount().longValue())));
            order.setDelFlag(0L);
            order.setPayStatus("unPay");
            order.setCreateBy(order.getUserId());
            order.setCreateTime(LocalDateTime.now());
            orderDomainService.createOrder(order);
            return "success";
        }
        return "false";
    }

    @Override
    public String payCallback(CommandPayDTO commandPayDTO) {
        return null;
    }
}
