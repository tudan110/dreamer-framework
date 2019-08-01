/*
 Navicat Premium Data Transfer

 Source Server         : mysql8_local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : tudan

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 01/08/2019 14:12:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '编号，逐渐',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'user' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('605398903319166976', '土旦', 'wtudan@126.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('605398984650915840', '小蓝鲸', '15952023906@163.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('605399053823377408', 'test', 'test@test.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('605438057910370304', 'asdf', 'a@a.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('605509093947342848', 'update-test', 'test@test.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('606165831289667584', 'insert-test', 'test@test.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('606166383591424000', 'insert-test', 'test@test.com', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('606167338433118208', 'insert-test', 'test@test.com', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
