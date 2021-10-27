/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2021-10-26 23:49:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
  `id` bigint(50) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `product_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商品名称',
  `nums` int(10) DEFAULT NULL COMMENT '数量',
  `price` decimal(10,5) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO `sys_product` VALUES ('1', '水杯', '2', '15.00000');
INSERT INTO `sys_product` VALUES ('2', '水杯', '2', '15.00000');
INSERT INTO `sys_product` VALUES ('3', '日记本', '2', '12.50000');
INSERT INTO `sys_product` VALUES ('4', '阿萨姆奶茶', '2', '5.50000');
INSERT INTO `sys_product` VALUES ('5', '百岁山', '3', '2.50000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lisi', 'male');
INSERT INTO `user` VALUES ('2', 'lisi', 'male');
INSERT INTO `user` VALUES ('3', 'lisi', 'male');
INSERT INTO `user` VALUES ('4', 'lisi', 'male');
INSERT INTO `user` VALUES ('5', 'lisi', 'male');
INSERT INTO `user` VALUES ('6', 'lisi', 'male');
INSERT INTO `user` VALUES ('7', 'lisi', 'male');
INSERT INTO `user` VALUES ('8', 'lisi', 'male');
