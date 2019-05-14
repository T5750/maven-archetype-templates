/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50638
 Source Host           : localhost:3306
 Source Schema         : struts2-login

 Target Server Type    : MySQL
 Target Server Version : 50638
 File Encoding         : 65001

 Date: 14/05/2019 09:24:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user3333
-- ----------------------------
DROP TABLE IF EXISTS `user3333`;
CREATE TABLE `user3333`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user3333
-- ----------------------------
INSERT INTO `user3333` VALUES (1, 'admin', 'admin', NULL);

SET FOREIGN_KEY_CHECKS = 1;
