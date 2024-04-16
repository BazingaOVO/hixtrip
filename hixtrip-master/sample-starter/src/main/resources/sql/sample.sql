#todo 你的建表语句,包含索引

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
    `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
    `sku_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品ID',
     `amount` int(32) NULL DEFAULT NULL COMMENT '购买数量',
     `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
     `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
     `pay_status` int(1) NULL DEFAULT NULL COMMENT '支付状态  unpay(未支付)，payed(已支付)',
     `del_flag` int(1) NULL DEFAULT NULL COMMENT '删除标志  0(存在)，1(已删除)',
     `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
     `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
     `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改时间',
     `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `unique_skuId`(`sku_id` ASC) USING BTREE,
     INDEX `ind_userId_payStatus_delFlag`(`user_id` ASC, `pay_status` ASC, `del_flag` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;



INSERT INTO `<table_name>` (`Table`, `Non_unique`, `Key_name`, `Seq_in_index`, `Column_name`, `Collation`, `Cardinality`, `Sub_part`, `Packed`, `Null`, `Index_type`, `Comment`, `Index_comment`, `Visible`) VALUES ('order', 0, 'PRIMARY', 1, 'id', 'A', 0, NULL, NULL, '', 'BTREE', '', '', 'YES');
INSERT INTO `<table_name>` (`Table`, `Non_unique`, `Key_name`, `Seq_in_index`, `Column_name`, `Collation`, `Cardinality`, `Sub_part`, `Packed`, `Null`, `Index_type`, `Comment`, `Index_comment`, `Visible`) VALUES ('order', 0, 'unique_skuId', 1, 'sku_id', 'A', 0, NULL, NULL, 'YES', 'BTREE', '', '', 'YES');
INSERT INTO `<table_name>` (`Table`, `Non_unique`, `Key_name`, `Seq_in_index`, `Column_name`, `Collation`, `Cardinality`, `Sub_part`, `Packed`, `Null`, `Index_type`, `Comment`, `Index_comment`, `Visible`) VALUES ('order', 1, 'ind_userId_payStatus_delFlag', 1, 'user_id', 'A', 0, NULL, NULL, 'YES', 'BTREE', '', '', 'YES');
INSERT INTO `<table_name>` (`Table`, `Non_unique`, `Key_name`, `Seq_in_index`, `Column_name`, `Collation`, `Cardinality`, `Sub_part`, `Packed`, `Null`, `Index_type`, `Comment`, `Index_comment`, `Visible`) VALUES ('order', 1, 'ind_userId_payStatus_delFlag', 2, 'pay_status', 'A', 0, NULL, NULL, 'YES', 'BTREE', '', '', 'YES');
INSERT INTO `<table_name>` (`Table`, `Non_unique`, `Key_name`, `Seq_in_index`, `Column_name`, `Collation`, `Cardinality`, `Sub_part`, `Packed`, `Null`, `Index_type`, `Comment`, `Index_comment`, `Visible`) VALUES ('order', 1, 'ind_userId_payStatus_delFlag', 3, 'del_flag', 'A', 0, NULL, NULL, 'YES', 'BTREE', '', '', 'YES');



