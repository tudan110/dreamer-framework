/*
 Navicat Premium Data Transfer

 Source Server         : localhost-tudan(tudan)
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : tudan

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 15/12/2020 15:57:22
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
INSERT INTO `user` VALUES ('605398903319166976', '土旦', 'wtudan@126.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:01:53', 'default');
INSERT INTO `user` VALUES ('605398984650915840', '小蓝鲸', '15952023906@163.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:01:57', 'default');
INSERT INTO `user` VALUES ('605399053823377408', 'test', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:01:59', 'default');
INSERT INTO `user` VALUES ('605438057910370304', 'asdf', 'a@a.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:02:01', 'default');
INSERT INTO `user` VALUES ('605509093947342848', 'update-test', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:02:03', 'default');
INSERT INTO `user` VALUES ('606165831289667584', 'insert-test', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:02:06', 'default');
INSERT INTO `user` VALUES ('606590761667919872', '1', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:18', 'default');
INSERT INTO `user` VALUES ('606590775215521792', '2', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:19', 'default');
INSERT INTO `user` VALUES ('606590785843888128', '3', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:21', 'default');
INSERT INTO `user` VALUES ('606590810611253248', '4', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:23', 'default');
INSERT INTO `user` VALUES ('606590825303900160', '5', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:26', 'default');
INSERT INTO `user` VALUES ('606590839057022976', '6', 'test@test.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:28', 'default');
INSERT INTO `user` VALUES ('606842564632379392', '77', '7@4.com', '2019-08-02 13:35:24', 'default', '2019-08-02 15:04:30', 'default');
INSERT INTO `user` VALUES ('606842742588309504', '77', '7@4.com', '2019-08-02 13:35:50', 'default', '2019-08-02 15:04:32', 'default');
INSERT INTO `user` VALUES ('606843236501159936', '77asdf', '7@4.com', '2019-08-02 13:38:22', 'default', '2019-08-02 15:04:33', 'default');
INSERT INTO `user` VALUES ('606864816035856384', 'asdfasf', 'test@test.com', '2019-08-02 15:04:07', 'default', '2019-08-02 15:04:36', 'default');

SET FOREIGN_KEY_CHECKS = 1;
