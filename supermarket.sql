/*
 Navicat Premium Data Transfer

 Source Server         : ChiMuFeng
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 14/08/2022 13:31:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `color_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '颜色' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES (1, '黑色', 1, '2022-08-02 10:25:31', 1, '2022-08-02 10:25:31', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for detailed_purchase
-- ----------------------------
DROP TABLE IF EXISTS `detailed_purchase`;
CREATE TABLE `detailed_purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `purchase_id` int(11) NULL DEFAULT NULL COMMENT '进货单id 与进货表相关联',
  `vendor_id` int(11) NULL DEFAULT NULL COMMENT '经销商id 与经销商表相关联',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuid 与商品表相关联',
  `batch` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次',
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进货单价',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `status` int(11) NULL DEFAULT NULL COMMENT '1: 同意， 2：代表驳回， 3：供应商没货',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购买详情' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of detailed_purchase
-- ----------------------------
INSERT INTO `detailed_purchase` VALUES (1, 1, 1, 1, '100001', 3.00, 2, 1, 1, '2022-08-04 10:27:50', 1, '2022-08-04 10:27:50', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goodsku
-- ----------------------------
DROP TABLE IF EXISTS `goodsku`;
CREATE TABLE `goodsku`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `spu_id` int(11) NULL DEFAULT NULL COMMENT 'spu id 关联spu表',
  `sku_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku名称',
  `sku_desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku描述',
  `color_id` int(11) NULL DEFAULT NULL COMMENT '颜色表id 与颜色表相关联',
  `price_id` int(11) NULL DEFAULT NULL COMMENT '价格表id 与价格表相关联',
  `Stock_id` int(11) NULL DEFAULT NULL COMMENT '库存表id 与仓库表相关联',
  `sales_volume` int(11) NULL DEFAULT NULL COMMENT '销量',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '单位表id 与单位表相关联',
  `manufacturer` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生产商',
  `Supplier_id` int(11) NULL DEFAULT NULL COMMENT '供应商id 与供应商相关联',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renewId` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品sku' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goodsku
-- ----------------------------
INSERT INTO `goodsku` VALUES (1, 1, '可乐', '饮料', 1, 1, 1, 10, 1, '可口可乐', 1, 1, '2022-08-04 10:27:50', 1, '2022-08-04 10:27:50', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for goodspu
-- ----------------------------
DROP TABLE IF EXISTS `goodspu`;
CREATE TABLE `goodspu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `good_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌商',
  `sort_id` int(11) NULL DEFAULT NULL COMMENT '所属分类id 关联分类表',
  `status` int(11) NULL DEFAULT NULL COMMENT '上架状态 0上架 1下架 2售罄',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 跟用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 跟用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品spu' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goodspu
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '父级id',
  `ordered` int(11) NULL DEFAULT NULL COMMENT '子级id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '路径',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '菜单' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '首页', NULL, 0, '/Home', 'el-icon-s-home');
INSERT INTO `menu` VALUES (2, '零售', NULL, 0, '/Retail', 'el-icon-goods');
INSERT INTO `menu` VALUES (3, '采购', NULL, 0, '/Purchase', 'el-icon-s-shop');
INSERT INTO `menu` VALUES (4, '仓库', NULL, 0, '/Warehouse', 'el-icon-receiving');
INSERT INTO `menu` VALUES (5, '商品管理', NULL, 0, '/Commodity', 'el-icon-s-order');
INSERT INTO `menu` VALUES (6, '财务', NULL, 0, '/Finance', 'el-icon-s-finance');
INSERT INTO `menu` VALUES (7, '供应商', NULL, 0, '/Supplier', 'el-icon-s-custom');
INSERT INTO `menu` VALUES (8, '员工管理', NULL, 0, '/Employee', 'el-icon-user');
INSERT INTO `menu` VALUES (101, '零售出库', '2', 1, '/Retail/Outbound', NULL);
INSERT INTO `menu` VALUES (102, '零售退货', '2', 2, '/Retail/Returns', NULL);
INSERT INTO `menu` VALUES (103, '订单明细', '3', 1, '/Purchase/Detail', NULL);
INSERT INTO `menu` VALUES (104, '采购统计', '3', 2, '/Purchase/Statistics', NULL);
INSERT INTO `menu` VALUES (105, '入库明细', '4', 1, '/Warehouse/Detail', NULL);
INSERT INTO `menu` VALUES (106, '商品信息', '5', 1, '/Commodity/Message', NULL);
INSERT INTO `menu` VALUES (107, '收入', '6', 1, '/Finance/Income', NULL);
INSERT INTO `menu` VALUES (108, '支出', '6', 2, '/Finance/Expend', NULL);
INSERT INTO `menu` VALUES (109, '供应商信息', '7', 1, '/Supplier/Message', NULL);
INSERT INTO `menu` VALUES (110, '收银员', '8', 1, '/Employee/Cashier', NULL);
INSERT INTO `menu` VALUES (111, '验货员', '8', 2, '/Employee/Inspector', NULL);
INSERT INTO `menu` VALUES (112, '理货员', '8', 3, '/Employee/TallyClerk', NULL);
INSERT INTO `menu` VALUES (113, '采购商品', '3', 3, '/Purchase/Stock', NULL);

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `can_use` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可使用功能',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 跟用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 跟用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, 1, '全部功能', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `power` VALUES (2, 2, '收钱', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `power` VALUES (3, 3, '验货', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `power` VALUES (4, 4, '理货', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `power` VALUES (5, 4, '理货', 0, '2022-08-13 18:03:01', 0, '2022-08-13 18:03:01', '0', '0', '0');

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuid goodsku表关联',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '价格表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES (1, 1, 3.50, 2, '2022-08-09 10:26:47', 2, '2022-08-09 10:26:47', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `purchase_desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进货说明',
  `purchase_number` int(11) NULL DEFAULT NULL COMMENT '进货数量',
  `examine_user_id` int(11) NULL DEFAULT NULL COMMENT '审核人id 与用户表相关联',
  `examine_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `examine_opinion` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人意见',
  `examine_status` int(11) NULL DEFAULT NULL COMMENT '审核状态 0通过 1不通过',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购买表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (1, '可乐', 100, 2, '2022-08-13 10:22:20', '无', 1, 1, '2022-08-13 10:22:20', 2, '2022-08-13 10:22:20', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_power` int(32) NULL DEFAULT NULL COMMENT '用户权限',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '所属上级',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 跟用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 跟用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '老大', 1, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (2, '收银员', 2, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (3, '验货员', 3, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (4, '理货员', 4, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `sort_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `module` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属模块 0家电 1手机 2日用品...',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '碳酸', '饮料类', 1, '2022-08-13 10:30:51', 2, '2022-08-13 10:30:55', NULL, NULL, NULL);
INSERT INTO `sort` VALUES (2, '果汁', '饮料类', 2, '2022-08-31 10:31:20', 1, '2022-08-23 10:31:24', NULL, NULL, NULL);
INSERT INTO `sort` VALUES (3, '白酒', '酒类', 1, '2022-08-19 10:31:45', 2, '2022-08-19 10:31:50', NULL, NULL, NULL);
INSERT INTO `sort` VALUES (4, '米酒', '酒类', 2, '2022-08-20 10:32:06', 1, '2022-08-21 10:32:12', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for units
-- ----------------------------
DROP TABLE IF EXISTS `units`;
CREATE TABLE `units`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `units_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位名称',
  `module` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属于什么计量单位',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES (1, '毫米', '长度单位', 1, '2022-08-13 09:48:04', 2, '2022-08-19 09:48:10', NULL, NULL, NULL);
INSERT INTO `units` VALUES (2, '厘米', '长度单位', 2, '2022-08-10 09:48:17', 1, '2022-08-24 09:48:22', NULL, NULL, NULL);
INSERT INTO `units` VALUES (3, '分米', '长度单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (4, '米', '长度单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (5, '千米', '长度单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (6, '平方毫米', '面积单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (7, '平方分米', '面积单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (8, '平方厘米', '面积单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (9, '平方米', '面积单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (10, '秒', '时间单位', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 跟用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 跟用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, '张三', '123', '南京', '13003405082', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '1', '0', '0');
INSERT INTO `user` VALUES (2, 3, '狗蛋啊', '1231', '南京', '1234645', 1, '2022-08-11 00:00:00', 1, '2022-08-13 19:22:00', '1', '0', '0');
INSERT INTO `user` VALUES (3, 3, '胖虎', '123', '南京', '13003405082', 0, '2022-08-11 00:00:00', 1, '2022-08-13 14:48:29', '1', '0', '0');
INSERT INTO `user` VALUES (4, 4, '小夫', '123', '南京', '13003405082', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '1', '0', '0');
INSERT INTO `user` VALUES (5, 4, '啊啊', '123', '啊啊', '13003405082', 0, '2022-11-04 12:01:33', 0, '2022-06-08 12:01:39', '1', '0', '0');
INSERT INTO `user` VALUES (6, 4, '坤坤', '123', '美国', '1234567845', 1, '2022-08-12 13:00:21', 1, '2022-08-12 13:00:21', '1', '0', '0');
INSERT INTO `user` VALUES (7, 4, '特朗普', '123', '南京', '13003405082', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '1', '0', '0');
INSERT INTO `user` VALUES (8, 8, '狗头', '123', '南京', '130034055', 1, '2022-08-13 14:43:35', 1, '2022-08-13 15:03:35', '1', NULL, NULL);
INSERT INTO `user` VALUES (9, 2, '啊啊啊', '多少', '多少', '1321313', 1, '2022-08-13 14:49:01', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, 2, '马儿哈啊', '123', '天津', '1234567546', 1, '2022-08-13 14:53:40', 1, '2022-08-13 16:22:09', '1', NULL, NULL);
INSERT INTO `user` VALUES (11, 2, '二五', '123', '新疆', '12365456417', 1, '2022-08-13 15:04:59', 1, '2022-08-13 15:05:12', '1', NULL, NULL);
INSERT INTO `user` VALUES (12, 3, '麦子', '123', '安徽', '15694510461', 1, '2022-08-13 16:23:38', 1, '2022-08-13 17:30:38', '1', NULL, NULL);
INSERT INTO `user` VALUES (13, 2, '哈皮', '123', '哈尔滨', '15454672343', 1, '2022-08-13 16:45:54', 1, '2022-08-13 16:45:54', '1', NULL, NULL);
INSERT INTO `user` VALUES (14, 2, '盖伦', '123', '内蒙古', '6545646614', 1, '2022-08-13 16:56:38', 1, '2022-08-13 16:56:38', '1', NULL, NULL);
INSERT INTO `user` VALUES (15, 2, '打多少', '1231', '南京', '16545313213', 1, '2022-08-13 16:57:59', 1, '2022-08-13 16:57:59', '1', NULL, NULL);
INSERT INTO `user` VALUES (16, 2, '大萨达', '211321', '南京', '123', 1, '2022-08-13 17:03:16', 1, '2022-08-13 17:03:16', '1', NULL, NULL);
INSERT INTO `user` VALUES (17, 4, '打速度', '123', '南京', '1231313', 1, '2022-08-13 17:04:07', 1, '2022-08-13 17:04:07', '1', NULL, NULL);
INSERT INTO `user` VALUES (18, 4, '理啊啊', '3123', '南京', '1300340163', 1, '2022-08-13 17:09:34', 1, '2022-08-13 17:22:29', '1', NULL, NULL);
INSERT INTO `user` VALUES (19, 3, '打速度', '的速度', '大萨达', '12313213', 1, '2022-08-13 17:12:26', 1, '2022-08-13 17:26:57', '1', NULL, NULL);
INSERT INTO `user` VALUES (20, 2, '滴滴啊', '1231', '哈耳边', '1646132163', 1, '2022-08-13 17:17:39', 1, '2022-08-13 17:28:14', '1', NULL, NULL);
INSERT INTO `user` VALUES (50, 4, '麦子', '123', '南京', '13001587164', 1, '2022-08-13 18:04:29', 1, '2022-08-13 18:04:29', '1', '0', '0');

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `vendor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuid 与商品表相关联',
  `vendor_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商地址',
  `desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (1, '可口可乐', 1, '南京', '可口可乐公司', '1', '13611111111', 1, '2022-08-01 12:58:52', 1, '2022-08-01 12:58:52', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `dp_id` int(11) NULL DEFAULT NULL COMMENT '进货详细id 与进货详细单相关联',
  `stock_number` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `warehouse_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库练习电话',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for warehousing
-- ----------------------------
DROP TABLE IF EXISTS `warehousing`;
CREATE TABLE `warehousing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `purchase_id` int(11) NULL DEFAULT NULL COMMENT '进货单id 与进货表相关联',
  `examine_user_id` int(11) NULL DEFAULT NULL COMMENT '审核人id 与用户表相关联',
  `examine_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `Warehousing_user_id` int(11) NULL DEFAULT NULL COMMENT '入库人id 与用户表相关联',
  `Warehousing_time` datetime NULL DEFAULT NULL COMMENT '入库时间',
  `Warehousing_number` int(11) NULL DEFAULT NULL COMMENT '入库数量',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of warehousing
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
