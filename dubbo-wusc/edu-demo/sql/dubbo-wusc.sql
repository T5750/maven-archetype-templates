/*
Navicat MySQL Data Transfer

Source Server         : localhost_UR_dahua
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : dubbo-wusc

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2017-05-01 11:32:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for edu_edmo_pms_user
-- ----------------------------
DROP TABLE IF EXISTS `edu_edmo_pms_user`;
CREATE TABLE `edu_edmo_pms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT 'version',
  `create_time` datetime NOT NULL DEFAULT '1999-01-01 01:01:01' COMMENT '创建时间',
  `user_no` varchar(50) NOT NULL COMMENT '用户帐号',
  `user_type` varchar(1) NOT NULL COMMENT '用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）',
  `main_user_id` bigint(50) DEFAULT '0' COMMENT '主帐号ID',
  `user_pwd` varchar(256) NOT NULL COMMENT '登录密码',
  `user_name` varchar(50) NOT NULL COMMENT '姓名',
  `mobile_no` varchar(15) DEFAULT NULL COMMENT '手机号',
  `email` varbinary(100) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) NOT NULL COMMENT '状态(100:可用，101:不可用 )',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_changed_pwd` int(11) DEFAULT NULL COMMENT '是否更改过密码',
  `pwd_error_count` int(11) NOT NULL DEFAULT '0' COMMENT '连续输错密码次数',
  `pwd_error_time` datetime DEFAULT NULL COMMENT '最后输错密码时间',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of edu_edmo_pms_user
-- ----------------------------
INSERT INTO `edu_edmo_pms_user` VALUES ('1', '0', '1999-01-01 01:01:01', 'admin', '1', '0', '7c4a8d09ca3762af61e59520943dc26494f8941b', '超级管理员', '13800138000', null, '100', null, '0', '0', null, '超级管理员');
