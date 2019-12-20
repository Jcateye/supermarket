/*
 Navicat Premium Data Transfer

 Source Server         : localConnection
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : municipal

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 21/12/2019 02:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `bookId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(10) NULL DEFAULT 0,
  `bookName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT ' ',
  `pirce` float(32, 2) NULL DEFAULT 0.00,
  `count` int(10) NULL DEFAULT 0,
  `detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT ' ',
  PRIMARY KEY (`bookId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('123', 1, ' 债务危机', 100.00, 12, '无');
INSERT INTO `goods` VALUES ('1233', 1, ' 债务危机454', 10045.00, 121, '无');
INSERT INTO `goods` VALUES ('f732dd3b8fd141658f6ef84b04ce9913', 21, 'java', 10.00, 3, '无');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3a008ed4c12046dcad1e4df065ca6919', '5456', '4564');
INSERT INTO `user` VALUES ('3c0566cdaf194b278965f5c5ffe810d3', '123', '4324');
INSERT INTO `user` VALUES ('9175426f59f5421bb1fff4641e613158', '212', '123');
INSERT INTO `user` VALUES ('bedfab88c5b04508bbd8264a292e670b', '1234', '13432');

SET FOREIGN_KEY_CHECKS = 1;
