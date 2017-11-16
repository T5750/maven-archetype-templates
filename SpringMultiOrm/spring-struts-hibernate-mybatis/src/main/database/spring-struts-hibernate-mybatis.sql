/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : spring-struts-hibernate-mybatis

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-11-16 14:19:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `clientname` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '数量',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
