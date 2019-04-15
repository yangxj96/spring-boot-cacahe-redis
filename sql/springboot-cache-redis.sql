/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云-docker
Source Server Version : 50643
Source Host           : 118.24.36.40:3307
Source Database       : springboot-cache-redis

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-04-15 16:51:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'user1', 'pwd1');
INSERT INTO `t_user` VALUES ('2', 'user2', 'pwd2');
INSERT INTO `t_user` VALUES ('3', 'user3', 'pwd3');
