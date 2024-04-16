package com.hixtrip.sample.infra.db.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class InventoryDO {

    private String skuId;
    private Long sellableQuantity;
    private Long withholdingQuantity;
    private Long occupiedQuantity;

}
