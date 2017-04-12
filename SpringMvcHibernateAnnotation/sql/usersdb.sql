/*
Navicat MySQL Data Transfer

Source Server         : localhost_UR_dahua
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : usersdb

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-04-08 21:54:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET latin1 NOT NULL,
  `password` varchar(45) CHARACTER SET latin1 NOT NULL,
  `email` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('16', 'root', 'password', 'root@gmail.com');
