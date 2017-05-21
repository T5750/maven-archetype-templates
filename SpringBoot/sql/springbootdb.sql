/*
Navicat MySQL Data Transfer

Source Server         : localhost_UR_dahua
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : springbootdb

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-05-21 14:49:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '温岭市', 'BYSocket 的家在温岭。');
