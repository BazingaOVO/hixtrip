package com.hixtrip.sample.infra.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hixtrip.sample.infra.db.dataobject.OrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 89539
* @description 针对表【order】的数据库操作Mapper
* @createDate 2024-04-15 14:53:29
* @Entity generator.domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {
    OrderDO selectOder();
}




