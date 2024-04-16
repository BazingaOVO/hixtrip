package com.hixtrip.sample.infra;

import com.hixtrip.sample.domain.inventory.repository.InventoryRepository;
import com.hixtrip.sample.infra.db.dataobject.InventoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * infra层是domain定义的接口具体的实现
 */
@Component
public class InventoryRepositoryImpl implements InventoryRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public Integer getInventory(String skuId) {
        Object object = redisTemplate.opsForValue().get(skuId);
        if(object == null){
            return 200;
        }else {
            InventoryDO inventoryDO = (InventoryDO) object;
            return inventoryDO.getSellableQuantity().intValue();
        }
    }

    @Override
    public Boolean changeInventory(String skuId, Long sellableQuantity, Long withholdingQuantity, Long occupiedQuantity) {
        InventoryDO inventoryDO = InventoryDO.builder()
                .skuId(skuId)
                .sellableQuantity(sellableQuantity)
                .withholdingQuantity(withholdingQuantity)
                .occupiedQuantity(occupiedQuantity)
                .build();
            redisTemplate.opsForValue().set(skuId,inventoryDO);

            return true;
    }
}
