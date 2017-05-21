/*
Navicat MySQL Data Transfer

Source Server         : localhost_UR_dahua
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : springbootdb_cluster

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-05-21 15:54:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(25) DEFAULT NULL COMMENT '用户名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '泥瓦匠', '他有一个小网站 bysocket.com');
