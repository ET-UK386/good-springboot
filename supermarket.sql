/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 30/08/2022 17:25:59
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES (1, '远峰蓝', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (2, '中国红', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (3, '珠玉白', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (4, '土豪金', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (5, '银色', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (6, '白色', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (7, '黑色', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (8, '其他', 1, '2022-01-08 22:11:28', 1, '2022-01-08 22:11:45', NULL, NULL, NULL);
INSERT INTO `color` VALUES (9, '透明', 1, '2022-08-29 15:41:28', 1, '2022-08-29 15:41:28', NULL, NULL, NULL);

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
  `logic_del` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detailed_purchase
-- ----------------------------
INSERT INTO `detailed_purchase` VALUES (101, 21, 1, 15, '196df3', 123.00, 123, 4, 0, NULL, '2022-08-30 13:31:52', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_purchase` VALUES (102, 22, 4, 6, '38fdca', 234.00, 234, 4, 0, NULL, '2022-08-30 13:32:00', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_purchase` VALUES (103, 23, 5, 5, 'ba47f0', 345.00, 345, 4, 0, NULL, '2022-08-30 13:32:45', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_purchase` VALUES (104, 24, 2, 13, '6a0fe6', 7999.00, 1, 0, 0, NULL, '2022-08-30 14:15:06', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_purchase` VALUES (105, 25, 1, 15, '01803b', 600.00, 1, 4, 0, NULL, '2022-08-30 14:16:10', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_purchase` VALUES (106, 25, 2, 13, 'fbf627', 10000.00, 1, 4, 0, NULL, '2022-08-30 14:16:10', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for detailed_warehousing
-- ----------------------------
DROP TABLE IF EXISTS `detailed_warehousing`;
CREATE TABLE `detailed_warehousing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `warehousing_id` int(11) NULL DEFAULT NULL COMMENT '入库审核表id 与进货表相关联',
  `vendor_id` int(11) NULL DEFAULT NULL COMMENT '经销商id 与经销商表相关联',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuid 与商品表相关联',
  `batch` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次',
  `purchase_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进货单价',
  `number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `status` int(11) NULL DEFAULT NULL COMMENT '1: 同意， 2：代表驳回， 3：供应商没货',
  `logic_del` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detailed_warehousing
-- ----------------------------
INSERT INTO `detailed_warehousing` VALUES (118, 68, 1, 15, '08fdd9', 123.00, 123, -1, 0, NULL, '2022-08-30 13:32:07', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_warehousing` VALUES (119, 69, 4, 6, 'c45781', 234.00, 234, 1, 0, NULL, '2022-08-30 13:32:12', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_warehousing` VALUES (120, 70, 5, 5, 'c44e70', 345.00, 345, -1, 0, NULL, '2022-08-30 13:33:16', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_warehousing` VALUES (121, 71, 1, 15, 'a0dad4', 600.00, 1, 1, 0, NULL, '2022-08-30 14:22:10', NULL, NULL, NULL, NULL);
INSERT INTO `detailed_warehousing` VALUES (122, 71, 2, 13, 'c5ecd0', 10000.00, 1, 1, 0, NULL, '2022-08-30 14:22:10', NULL, NULL, NULL, NULL);

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
  `logic_status` int(1) NULL DEFAULT 0,
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsku
-- ----------------------------
INSERT INTO `goodsku` VALUES (1, 1, 'iphone8plus', '128G 国行', 1, 1, 1, 100, 4, 'apple公司', 1, 1, '2022-08-11 22:16:33', 1, '2022-08-11 22:16:42', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (2, 2, 'huaweip40旗舰版', '256G 国行', 2, 50, 1, 100, 4, 'huawei公司', 2, 2, '2022-08-11 22:16:33', 1, '2022-08-20 22:42:05', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (3, 3, '小米12S pro', '512G 国行', 3, 3, 3, 100, 4, '小米公司', 6, 3, '2022-08-11 22:16:33', 1, '2022-08-21 15:00:17', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (4, 4, '米家扫地机器人 r700', '托扫一体', 4, 3, 3, 888, 1, '小米公司', 6, 1, '2022-08-11 22:16:33', 1, '2022-08-21 14:59:34', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (5, 5, '小米手环', '运动尊享版', 2, 49, 29, 887, 3, '小米公司', 30, 5, '2022-08-11 22:16:33', 1, '2022-08-21 10:37:07', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (6, 6, '小米冰箱', '双开门 至尊版', 6, 6, 2, 10000, 3, '小米公司', 6, 6, '2022-08-11 22:16:33', 1, '2022-08-22 13:09:08', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (7, 7, 'Macbook air', '轻薄更出色', 5, 1, 1, 69, 4, 'apple公司', 7, 7, '2022-08-11 22:16:33', 1, '2022-08-21 15:00:53', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (8, 8, '小米电视6', '65寸极致大屏', 5, 1, 3, 5000, 4, '小米公司', 6, 3, '2022-08-11 22:16:33', 1, '2022-08-21 14:58:15', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (12, 12, '1', '1', 1, 54, 11, 1, 2, '1', 35, 1, '2022-08-22 22:35:35', 1, '2022-08-22 22:35:35', 1, NULL, NULL);
INSERT INTO `goodsku` VALUES (13, 13, '1', '1', 1, 55, 14, 1, 1, '1', 36, 1, '2022-08-23 15:08:15', 1, '2022-08-23 15:08:15', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (14, 14, NULL, '小米9', 7, 56, NULL, NULL, 4, NULL, NULL, 1, '2022-08-29 15:41:58', 1, '2022-08-29 15:41:58', 0, NULL, NULL);
INSERT INTO `goodsku` VALUES (15, 14, '小米6', '钉子户', 7, 57, NULL, NULL, 4, NULL, NULL, 1, '2022-08-29 16:03:47', 1, '2022-08-29 16:03:47', 0, NULL, NULL);

-- ----------------------------
-- Table structure for goodspu
-- ----------------------------
DROP TABLE IF EXISTS `goodspu`;
CREATE TABLE `goodspu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `good_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌商',
  `sort_id` int(11) NULL DEFAULT NULL COMMENT '所属分类id 关联分类表',
  `status` int(11) NULL DEFAULT 0 COMMENT '上架状态 0上架 1下架 2售罄',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 跟用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 跟用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodspu
-- ----------------------------
INSERT INTO `goodspu` VALUES (1, 'iphone8plus', 'apple', 1, 0, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (2, 'huaweip40旗舰版', 'huawei', 1, 1, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (3, '小米12S pro', 'xiaomi', 1, 2, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (4, '米家扫地机器人 r700', 'xiaomi', 2, 0, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (5, '小米手环', 'xiaomi', 2, 0, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (6, '小米冰箱', 'xiaomi', 2, 1, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (7, 'Macbook air', 'apple2', 4, 0, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (8, '小米电视6', 'xiaomi', 5, 0, 1, '2021-01-08 20:16:20', 2, '2022-01-08 20:16:49', NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (12, '1', '1', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (13, '1', '1', 1, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `goodspu` VALUES (14, '小米', '小米', 1, NULL, 1, '2022-08-29 15:40:46', 1, '2022-08-29 15:40:46', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for images_fk
-- ----------------------------
DROP TABLE IF EXISTS `images_fk`;
CREATE TABLE `images_fk`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) NULL DEFAULT NULL COMMENT 'good_sku ID ',
  `spu_id` int(11) NULL DEFAULT NULL COMMENT 'good_spu ID',
  `images_path_id` int(11) NULL DEFAULT NULL COMMENT 'images_path ID',
  `is_look` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否展示  0：可看   1：不可看',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of images_fk
-- ----------------------------
INSERT INTO `images_fk` VALUES (10, 6, NULL, 11, 0);
INSERT INTO `images_fk` VALUES (11, 6, NULL, 12, 0);
INSERT INTO `images_fk` VALUES (12, 6, NULL, 13, 0);
INSERT INTO `images_fk` VALUES (13, 2, NULL, 14, 0);
INSERT INTO `images_fk` VALUES (14, 8, NULL, 15, 0);
INSERT INTO `images_fk` VALUES (15, 13, NULL, 16, 0);
INSERT INTO `images_fk` VALUES (16, 13, NULL, 17, 0);
INSERT INTO `images_fk` VALUES (17, 13, NULL, 18, 0);
INSERT INTO `images_fk` VALUES (18, 15, NULL, 19, 0);
INSERT INTO `images_fk` VALUES (19, 3, NULL, 20, 0);
INSERT INTO `images_fk` VALUES (20, 3, NULL, 21, 0);
INSERT INTO `images_fk` VALUES (21, 5, NULL, 22, 0);
INSERT INTO `images_fk` VALUES (22, 4, NULL, 23, 0);
INSERT INTO `images_fk` VALUES (23, 14, NULL, 24, 0);
INSERT INTO `images_fk` VALUES (24, 14, NULL, 25, 0);
INSERT INTO `images_fk` VALUES (25, 14, NULL, 26, 0);
INSERT INTO `images_fk` VALUES (26, 15, NULL, 27, 0);

-- ----------------------------
-- Table structure for images_path
-- ----------------------------
DROP TABLE IF EXISTS `images_path`;
CREATE TABLE `images_path`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `images_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `is_look` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否展示  0：展示  1：不展示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of images_path
-- ----------------------------
INSERT INTO `images_path` VALUES (11, '小米冰箱', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/9F280E99E5C743D6851E024558D1CFA1.jpg', 0);
INSERT INTO `images_path` VALUES (12, '小米冰箱', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/3DBDBCE1D59F4E27AF38CAC0110A4241.jpg', 0);
INSERT INTO `images_path` VALUES (13, '小米冰箱', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/F83F69F7CE9746AEA14AB10DC35E58F7.jpg', 0);
INSERT INTO `images_path` VALUES (14, 'huaweip40旗舰版', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/0E8950E8BEA14AC38F01AEA36E84DA02.jpg', 0);
INSERT INTO `images_path` VALUES (15, '小米电视6', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/6E5F7A8830504BF48A9E08DC275CF6A4.jpg', 0);
INSERT INTO `images_path` VALUES (16, '1', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/E457B984E2C644618C2A99906663C2B5.jpg', 0);
INSERT INTO `images_path` VALUES (17, '1', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/873E49CA367344109707F24A98D89567.jpg', 0);
INSERT INTO `images_path` VALUES (18, '1', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/196CE5543B0A42A3A121B07864D00526.jpg', 0);
INSERT INTO `images_path` VALUES (19, '小米6', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/0266F997B0124ED287F1D01F6F029D9B.jpeg', 0);
INSERT INTO `images_path` VALUES (20, '小米12S pro', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/DC000DD3EF6F443793B87D23A3E02296.jpg', 0);
INSERT INTO `images_path` VALUES (21, '小米12S pro', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/097547CD18BD49829CBB36CB18DD92C5.jpg', 0);
INSERT INTO `images_path` VALUES (22, '小米手环', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/EF932834CC6A4122AFDA1181FC072846.jpg', 0);
INSERT INTO `images_path` VALUES (23, '米家扫地机器人 r700', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/2F28208FEBEF4453B6B378CA7714E318.jpg', 0);
INSERT INTO `images_path` VALUES (24, 'null', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/F02F52E6B7C44D859BD29D5AED385E3D.jpg', 0);
INSERT INTO `images_path` VALUES (25, 'null', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/DFE2034380DA4C28A2B65B4C4FA8814A.jpg', 0);
INSERT INTO `images_path` VALUES (26, 'null', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/383D12BAD6294C6988C45B56DA41553E.jpg', 0);
INSERT INTO `images_path` VALUES (27, '小米6', 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/1CAC07ADC2BC4894A484705F453361D9.jpg', 0);

-- ----------------------------
-- Table structure for inventory_verification
-- ----------------------------
DROP TABLE IF EXISTS `inventory_verification`;
CREATE TABLE `inventory_verification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NULL DEFAULT NULL COMMENT '入库id',
  `check_user_id` int(11) NULL DEFAULT NULL COMMENT '盘点人id',
  `check_time` datetime NULL DEFAULT NULL COMMENT '盘点时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态，正常\r\n/\r\n与商品库存不对',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `discrepancy` int(11) NULL DEFAULT NULL COMMENT '与实际库存差异\r\n对一个		+1\r\n\r\n少一个		 -1',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '修改人ID',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inventory_verification
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
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

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
INSERT INTO `menu` VALUES (9, '上架管理', NULL, 0, NULL, NULL);
INSERT INTO `menu` VALUES (101, '零售出库', '2', 1, '/Retail/Outbound', NULL);
INSERT INTO `menu` VALUES (102, '零售退货', '2', 2, '/Retail/Returns', NULL);
INSERT INTO `menu` VALUES (103, '采购商品', '3', 1, '/Purchase/Stock', NULL);
INSERT INTO `menu` VALUES (104, '待审列表', '3', 1, '/Purchase/Detail', NULL);
INSERT INTO `menu` VALUES (105, '流程列表', '3', 2, '/Purchase/Statistics', NULL);
INSERT INTO `menu` VALUES (106, '流程列表', '4', 1, '/Warehouse/Detail', NULL);
INSERT INTO `menu` VALUES (107, '商品信息', '5', 1, '/Commodity/Message', NULL);
INSERT INTO `menu` VALUES (108, '收入', '6', 1, '/Finance/Income', NULL);
INSERT INTO `menu` VALUES (109, '支出', '6', 2, '/Finance/Expend', NULL);
INSERT INTO `menu` VALUES (110, '供应商信息', '7', 1, '/Supplier/Message', NULL);
INSERT INTO `menu` VALUES (111, '收银员', '8', 1, '/Employee/Cashier', NULL);
INSERT INTO `menu` VALUES (112, '验货员', '8', 2, '/Employee/Inspector', NULL);
INSERT INTO `menu` VALUES (113, '理货员', '8', 3, '/Employee/TallyClerk', NULL);
INSERT INTO `menu` VALUES (114, '验货审核', '4', 2, '/Warehouse/CheckAudit', NULL);
INSERT INTO `menu` VALUES (115, '入库审核', '4', 3, '/Warehouse/StorageAudit', NULL);
INSERT INTO `menu` VALUES (116, '库存列表', '4', 4, '/Warehouse/warehouseList', NULL);
INSERT INTO `menu` VALUES (117, '商品spu信息', '5', 2, '/Commodity/goodspu', NULL);
INSERT INTO `menu` VALUES (118, '商品上架', '9', 1, '/goodrise', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, 1, '全部功能', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '1', '0', '0');
INSERT INTO `power` VALUES (2, 1, '收钱', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '2', '0', '0');
INSERT INTO `power` VALUES (3, 1, '验货', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '3', '0', '0');
INSERT INTO `power` VALUES (4, 1, '理货', 0, '2022-08-11 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `power` VALUES (5, 1, '理货', 0, '2022-08-13 18:03:01', 0, '2022-08-13 18:03:01', '0', '0', '0');

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
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES (1, 1, 6999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (2, 2, 5999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (3, 3, 8999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (4, 4, 1999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (5, 5, 299.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (6, 6, 3499.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (48, 5, 699.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (49, 5, 6991.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (50, 2, 5998.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (51, 9, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (52, 10, 111.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (53, 11, 66.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (54, 12, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (55, 13, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (56, 14, 3999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (57, 14, 2999.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `price` VALUES (59, 6, 123.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product_rise
-- ----------------------------
DROP TABLE IF EXISTS `product_rise`;
CREATE TABLE `product_rise`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `price_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_rise
-- ----------------------------
INSERT INTO `product_rise` VALUES (1, 6, 234, 1, 59, 1);

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
  `examine_status` int(11) NULL DEFAULT NULL COMMENT '流程状态状态    0：审核中，1：审核完成， 2：审核不通过，3：审核驳回需要修改',
  `sum_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `logic_del` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (21, NULL, 1, 1, '2022-08-30 13:32:07', NULL, 1, 15129.00, 0, NULL, '2022-08-30 13:31:52', NULL, NULL, NULL, NULL);
INSERT INTO `purchase` VALUES (22, NULL, 1, 1, '2022-08-30 13:32:12', NULL, 1, 54756.00, 0, NULL, '2022-08-30 13:32:00', NULL, NULL, NULL, NULL);
INSERT INTO `purchase` VALUES (23, NULL, 1, 1, '2022-08-30 13:33:17', NULL, 1, 119025.00, 0, NULL, '2022-08-30 13:32:45', NULL, NULL, NULL, NULL);
INSERT INTO `purchase` VALUES (24, NULL, 1, NULL, NULL, NULL, 0, 7999.00, 0, NULL, '2022-08-30 14:15:06', NULL, NULL, NULL, NULL);
INSERT INTO `purchase` VALUES (25, NULL, 2, 1, '2022-08-30 14:22:11', NULL, 1, 10600.00, 0, NULL, '2022-08-30 14:16:10', NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '老大', 1, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (2, '收银员', 2, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (3, '验货员', 3, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');
INSERT INTO `role` VALUES (4, '理货员', 4, 1, 0, '2022-08-10 00:00:00', 0, '2022-08-11 00:00:00', '0', '0', '0');

-- ----------------------------
-- Table structure for sku_img
-- ----------------------------
DROP TABLE IF EXISTS `sku_img`;
CREATE TABLE `sku_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) NOT NULL,
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_img
-- ----------------------------
INSERT INTO `sku_img` VALUES (1, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/B14124B65F13404491A8BD47955BE1F2.jpg');
INSERT INTO `sku_img` VALUES (2, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/8B196BAD14824BB3923B7A0DBA03049F.jpg');
INSERT INTO `sku_img` VALUES (3, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/1BAA677C37A64030A4A6A9B6A24BA633.jpg');
INSERT INTO `sku_img` VALUES (4, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/900B7AB947DC4489AE55F7BD797A9FFF.jpg');
INSERT INTO `sku_img` VALUES (5, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/E3D92621B1B6488B9DFCE8D988F7ACDB.jpg');
INSERT INTO `sku_img` VALUES (6, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/173B38D0379148198628EB94B1721B35.jpg');
INSERT INTO `sku_img` VALUES (7, 1, 'https://uesc.oss-cn-shanghai.aliyuncs.com/demo/A7185B9051CD4A1784B876753A54EA39.jpg');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `sort_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级id',
  `module` int(11) NULL DEFAULT NULL COMMENT '所属模块 0家电 1手机 2日用品...',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `con1` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段1',
  `con2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段2',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '手机', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sort` VALUES (2, '电器', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sort` VALUES (3, '穿戴', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sort` VALUES (4, '电脑', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sort` VALUES (5, '电视', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES (1, '个', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (2, '件', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (3, '台', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `units` VALUES (4, '部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `vendor_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuid 与商品表相关联',
  `vendor_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商地址',
  `desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `purchase_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (1, '富士康有限公司', NULL, NULL, NULL, NULL, '18652417777', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (2, '富士康有限公司', NULL, NULL, NULL, NULL, '13865486134', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (3, '富士康有限公司', NULL, NULL, NULL, NULL, '18945679851', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (4, '台积电有限公司', NULL, NULL, NULL, NULL, '15961313213', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (5, '三星有限公司', NULL, NULL, NULL, NULL, '18674681646', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (6, '小米有限公司', NULL, NULL, NULL, NULL, '19876454788', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (7, 'apple有限公司', NULL, NULL, NULL, NULL, '16769879789', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (30, '小米有限公司1', NULL, NULL, NULL, NULL, '19876454789', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (31, 'apple有限公司1', NULL, NULL, NULL, NULL, '16769879799', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (32, '1', NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (33, '111', NULL, NULL, NULL, NULL, '1111111111111', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (34, '66', NULL, NULL, NULL, NULL, '66666666666', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (35, '1', NULL, NULL, NULL, NULL, '1111111111', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `vendor` VALUES (36, '1', NULL, NULL, NULL, NULL, '1111111111', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `detailed_Warehousing_id` int(11) NULL DEFAULT NULL COMMENT '进货详细id',
  `stock_number` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `warehouse_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库地址',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库练习电话',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `sku_id` int(11) NULL DEFAULT NULL COMMENT '商品skuID ',
  `batch` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (34, 119, 234, '1号仓库', '13003405082', 1, '2022-08-30 13:33:37', NULL, NULL, 6, '65bcc26e3c1b4b248ca808baa377543e', NULL);
INSERT INTO `warehouse` VALUES (35, 121, 1, '1号仓库', '13003405082', 1, '2022-08-30 14:25:01', NULL, NULL, 15, '964c3c88c2424884a3229333f152f398', NULL);
INSERT INTO `warehouse` VALUES (36, 122, 1, '1号仓库', '13003405082', 1, '2022-08-30 14:25:01', NULL, NULL, 13, '1413223a824645a6a8019ee82f5d00ab', NULL);

-- ----------------------------
-- Table structure for warehousing
-- ----------------------------
DROP TABLE IF EXISTS `warehousing`;
CREATE TABLE `warehousing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 自增',
  `purchase_id` int(11) NULL DEFAULT NULL COMMENT '进货单id 与进货表相关联',
  `detailed_purchase_id` int(11) NULL DEFAULT NULL COMMENT '进货详细单',
  `examine_user_id` int(11) NULL DEFAULT NULL COMMENT '审核人id 与用户表相关联',
  `examine_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `Warehousing_user_id` int(11) NULL DEFAULT NULL COMMENT '入库人id 与用户表相关联',
  `Warehousing_time` datetime NULL DEFAULT NULL COMMENT '入库时间',
  `Warehousing_number` int(11) NULL DEFAULT NULL COMMENT '入库数量',
  `status` int(11) NULL DEFAULT NULL COMMENT '入库明细',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '创建人id 与用户表相关联',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_renew_id` int(11) NULL DEFAULT NULL COMMENT '更新人id 与用户表相关联',
  `renew_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `signing_details` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签收明细',
  `inventory_details` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库明细',
  `con3` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehousing
-- ----------------------------
INSERT INTO `warehousing` VALUES (68, 21, NULL, 1, '2022-08-30 13:33:26', NULL, NULL, 123, 1, NULL, '2022-08-30 13:32:07', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `warehousing` VALUES (69, 22, NULL, 1, '2022-08-30 13:33:30', 1, '2022-08-30 13:33:38', 234, 200, NULL, '2022-08-30 13:32:12', NULL, NULL, '', NULL, NULL);
INSERT INTO `warehousing` VALUES (70, 23, NULL, 1, '2022-08-30 13:33:32', 1, '2022-08-30 13:33:40', 345, 4, NULL, '2022-08-30 13:33:17', NULL, NULL, '', NULL, NULL);
INSERT INTO `warehousing` VALUES (71, 25, NULL, 1, '2022-08-30 14:24:13', 1, '2022-08-30 14:25:01', 2, 200, NULL, '2022-08-30 14:22:11', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- View structure for goodsku_warehouse
-- ----------------------------
DROP VIEW IF EXISTS `goodsku_warehouse`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `goodsku_warehouse` AS select `goodsku`.`id` AS `gid`,`warehouse`.`id` AS `wid`,`warehouse`.`detailed_Warehousing_id` AS `detailed_Warehousing_id`,`goodsku`.`sku_name` AS `sku_name`,`goodsku`.`sku_desc` AS `sku_desc`,`goodsku`.`color_id` AS `color_id`,`goodsku`.`price_id` AS `price_id`,`goodsku`.`spu_id` AS `spu_id`,`goodsku`.`Stock_id` AS `Stock_id`,`goodsku`.`sales_volume` AS `sales_volume`,`goodsku`.`company_id` AS `company_id`,`goodsku`.`manufacturer` AS `manufacturer`,`goodsku`.`Supplier_id` AS `Supplier_id`,`goodsku`.`logic_status` AS `logic_status`,`warehouse`.`stock_number` AS `stock_number`,`warehouse`.`warehouse_address` AS `warehouse_address`,`warehouse`.`phone` AS `phone`,`warehouse`.`sku_id` AS `sku_id`,`warehouse`.`batch` AS `batch` from (`goodsku` join `warehouse` on((`goodsku`.`id` = `warehouse`.`sku_id`)));

SET FOREIGN_KEY_CHECKS = 1;
