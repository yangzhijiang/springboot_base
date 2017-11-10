/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_green_farm

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-17 11:04:34
*/

use db_green_farm;

-- ----------------------------
-- Table structure for `t_address_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `t_address_dictionary`;
CREATE TABLE `t_address_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_describe` varchar(255) NOT NULL COMMENT '描述',
  `f_parent` bigint(20) NOT NULL COMMENT '父级地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址字典表 作者 ： 杨治江';

-- ----------------------------
-- Records of t_address_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `t_commodify`
-- ----------------------------
DROP TABLE IF EXISTS `t_commodify`;
CREATE TABLE `t_commodify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_version` int(5) NOT NULL DEFAULT '200' COMMENT '乐观锁 200',
  `f_state` int(2) NOT NULL DEFAULT '1' COMMENT '业务状态  1 上线 2 下线',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_commodify_id` varchar(20) NOT NULL DEFAULT '' COMMENT '商品id,',
  `f_name` varchar(200) NOT NULL DEFAULT '' COMMENT '商品名称',
  `f_type` int(5) NOT NULL COMMENT '商品类型 枚举值',
  `f_introduce` text NOT NULL COMMENT '商品介绍 图片',
  `f_price` int(20) NOT NULL DEFAULT '0' COMMENT '单件商品价格 单位 分',
  `f_showhead_pic` varchar(200) NOT NULL DEFAULT '' COMMENT '商品列表页图片',
  `f_show1_pic` varchar(200) NOT NULL DEFAULT '' COMMENT '商品介绍 图片1',
  `f_show2_pic` varchar(200) NOT NULL DEFAULT '' COMMENT '商品介绍 图片2',
  `f_show3_pic` varchar(200) NOT NULL COMMENT '商品介绍 图片3',
  `f_show4_pic` varchar(200) NOT NULL COMMENT '商品介绍 图片4',
  `f_show5_pic` varchar(200) NOT NULL COMMENT '商品介绍 图片5',
  `f_origin_place` varchar(20) NOT NULL COMMENT '商品产地',
  `f_is_imported` int(2) NOT NULL DEFAULT '1' COMMENT '是否进口 2 进口 1 国产',
  `f_weight` int(5) NOT NULL COMMENT '商品重量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表 作者 ： 杨治江';

-- ----------------------------
-- Records of t_commodify
-- ----------------------------

-- ----------------------------
-- Table structure for `t_commodify_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_commodify_type`;
CREATE TABLE `t_commodify_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为 1',
  `f_state` int(5) NOT NULL DEFAULT '1' COMMENT '物理状态',
  `f_parent` bigint(20) NOT NULL DEFAULT '1' COMMENT '父类型code 1 水果 2 海鲜水产 3 精选肉类 4 冷饮冻食 5 蔬菜蛋品',
  `f_describe` varchar(20) NOT NULL COMMENT '描述',
  `f_sort` int(5) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类型表 作者 ：杨治江';

-- ----------------------------
-- Records of t_commodify_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_version` int(5) NOT NULL DEFAULT '200' COMMENT '乐观锁 200',
  `f_state` int(2) NOT NULL DEFAULT '1' COMMENT '业务状态  1 未支付 2 已支付 3 已取消 4 已发货 5 已退款 默认 1 ',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_commodify_info` text NOT NULL COMMENT '商品信息 json 字符窜数组',
  `f_user_id` bigint(20) NOT NULL COMMENT '用户id',
  `f_discount_price` int(20) NOT NULL DEFAULT '0' COMMENT '优惠金额 0 未优惠 单位 分',
  `f_discount_type` int(4) NOT NULL DEFAULT '0' COMMENT '优惠类型 0 未使用优惠 1 优惠券 2 购物卡',
  `f_order_price` int(20) NOT NULL COMMENT '订单金额 单位 分',
  `f_price` int(20) NOT NULL COMMENT '支付金额 单位 分',
  `f_address_info` varchar(255) NOT NULL COMMENT '地址',
  `f_payment_mode` int(4) NOT NULL DEFAULT '1' COMMENT '支付方式 1 在线支付',
  `f_order_id` bigint(20) NOT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表 作者 ; 杨治江';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_payment_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_payment_order`;
CREATE TABLE `t_payment_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_createtime` datetime NOT NULL COMMENT '创建时间',
  `f_updatetime` datetime NOT NULL COMMENT '更新时间',
  `f_version` int(5) NOT NULL COMMENT '乐观锁 200',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_order_id` bigint(20) NOT NULL COMMENT '订单号',
  `f_payment_price` int(10) NOT NULL COMMENT '支付金额 单位 分',
  `f_thr_id` varchar(50) NOT NULL COMMENT '第三方支付单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付表 作者 ：杨治江';

-- ----------------------------
-- Records of t_payment_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_shoping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_shoping_cart`;
CREATE TABLE `t_shoping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_createtime` datetime NOT NULL COMMENT '创建时间',
  `f_updatetime` datetime NOT NULL COMMENT '更新时间',
  `f_version` int(5) NOT NULL COMMENT '乐观锁 200',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_state` int(2) NOT NULL DEFAULT '1' COMMENT '业务状态  1 有效 0 删除',
  `f_commodify_info` text NOT NULL COMMENT '商品信息 json 字符窜 包含 商品属性、 商品数量,判断商品是否上线状态',
  `f_user_id` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户购物车表 作者 ： 杨治江';

-- ----------------------------
-- Records of t_shoping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_version` int(5) NOT NULL DEFAULT '200' COMMENT '乐观锁 200',
  `f_state` int(2) NOT NULL DEFAULT '1' COMMENT '业务状态  1 有效 2 冻结 ',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_nick_name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `f_real_name` varchar(20) NOT NULL DEFAULT '' COMMENT '真名',
  `f_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `f_password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码，使用MD5加密',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表 作者 ：杨治江';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_address`;
CREATE TABLE `t_user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `f_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `f_version` int(5) NOT NULL DEFAULT '200' COMMENT '乐观锁 200',
  `f_state` int(2) NOT NULL DEFAULT '1' COMMENT '业务状态  1 有效 2 冻结 ',
  `f_stat` int(1) NOT NULL DEFAULT '1' COMMENT '物理状态 0 删除 1 有效 默认 为I 1',
  `f_province_code` bigint(20) NOT NULL COMMENT '省份code',
  `f_province` varchar(200) NOT NULL COMMENT '省份名',
  `f_city_code` bigint(20) NOT NULL COMMENT '市名code',
  `f_city` varchar(200) NOT NULL COMMENT '市名',
  `f_county_code` bigint(20) DEFAULT NULL COMMENT '县的编号',
  `f_county` varchar(200) DEFAULT NULL COMMENT '县名',
  `f_detail_address` varchar(255) NOT NULL COMMENT '详细地址',
  `f_phone` int(11) NOT NULL COMMENT '收件人手机号',
  `f_name` varchar(20) NOT NULL COMMENT '收件人姓名',
  `f_is_default` int(1) NOT NULL DEFAULT '0' COMMENT '1 默认 0 其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表 作者 ：杨治江';

-- ----------------------------
-- Records of t_user_address
-- ----------------------------
