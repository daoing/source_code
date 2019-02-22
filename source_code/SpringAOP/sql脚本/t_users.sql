/*
 Navicat MySQL Data Transfer

 Source Server         : linux
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : 192.168.50.13:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 14/02/2019 17:57:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('jj', 12);

SET FOREIGN_KEY_CHECKS = 1;
