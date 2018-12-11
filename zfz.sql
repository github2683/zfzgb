/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL8
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3308
 Source Schema         : zfz

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 10/12/2018 18:33:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zfz_modular
-- ----------------------------
DROP TABLE IF EXISTS `zfz_modular`;
CREATE TABLE `zfz_modular`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块图标地址',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0为无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seg` int(10) NULL DEFAULT NULL COMMENT '排序值',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_org
-- ----------------------------
DROP TABLE IF EXISTS `zfz_org`;
CREATE TABLE `zfz_org`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织名',
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父组织ID',
  `pids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所有父组织ID',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织图标地址',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0为无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seg` int(10) NULL DEFAULT NULL COMMENT '排序值',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_permission
-- ----------------------------
DROP TABLE IF EXISTS `zfz_permission`;
CREATE TABLE `zfz_permission`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modular_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限归属模块ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限图标地址',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0为无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seg` int(10) NULL DEFAULT NULL COMMENT '排序值',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_region
-- ----------------------------
DROP TABLE IF EXISTS `zfz_region`;
CREATE TABLE `zfz_region`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名',
  `pid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父区域ID',
  `pids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所有父区域ID',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域图标地址',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0为无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seg` int(10) NULL DEFAULT NULL COMMENT '排序值',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '区域表，国-省-市-县-区-街道' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_role
-- ----------------------------
DROP TABLE IF EXISTS `zfz_role`;
CREATE TABLE `zfz_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色图标地址',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：0为无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seg` int(10) NULL DEFAULT NULL COMMENT '排序值',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_role_modular
-- ----------------------------
DROP TABLE IF EXISTS `zfz_role_modular`;
CREATE TABLE `zfz_role_modular`  (
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modular_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `modular_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-模块关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `zfz_role_permission`;
CREATE TABLE `zfz_role_permission`  (
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for zfz_user
-- ----------------------------
DROP TABLE IF EXISTS `zfz_user`;
CREATE TABLE `zfz_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `org_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属组织ID',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weixin` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0 COMMENT '状态：0为无效',
  `seg` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `opt_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zfz_user
-- ----------------------------
INSERT INTO `zfz_user` VALUES ('036c7968-61ed-4e16-8db4-5871535ee3e6', NULL, 'fjweiaojfo0012', 'jfiwoeajfowj', 'fjwoaejfoew', 'fjiowaejf@fjweo.com', 'ac3ba33b527038a47dd448133b825342', NULL, 1, 2, 'fawfwea fawe fewf wefe', '2018-12-07 18:24:46', '2018-12-07 18:24:46', NULL);
INSERT INTO `zfz_user` VALUES ('33443c0f-aa84-40f3-aee1-854c2433c380', NULL, 'oooooooooooooo', '9999999', 'uuuuuuuuuu', 'aaaaaaaaaaaaaaa@aa.com', '88e42e96cc71151b6e1938a1699b0a27', NULL, 1, 1, 'aaaaaaaaaa aaaaaaaaaaaaaa aaaaaaaaaaa', '2018-12-10 16:45:17', '2018-12-10 16:45:17', NULL);
INSERT INTO `zfz_user` VALUES ('3b180c91-c869-426a-8e09-a2c4ea58dbab', NULL, 'fweafewffefe00000001', '312983719889', 'fwefewf', 'fjaweiofj@jfie.com', '919f7eb3a32ffa11da52ae26a23fa7e3', NULL, 1, 1, 'fjaiwoejf ewjfi oawejf ieowa', '2018-12-07 18:16:34', '2018-12-07 18:16:34', NULL);
INSERT INTO `zfz_user` VALUES ('492b9592-e864-4126-b123-514b17c72558', NULL, 'qqqqqqqqqqqqqqqqqqqqqq', '11111111111', 'joerjgio', 'gfiofjwieo@qq.com', '3d079e14ae24c755a86c4939b67558ef', NULL, 1, 1, 'fawfwaef f waef aewf fewa few', '2018-12-10 16:41:26', '2018-12-10 16:41:26', NULL);
INSERT INTO `zfz_user` VALUES ('6a4710ec-da52-456c-93fb-796763238363', NULL, 'oooooooooo', '13123123213', 'fjaefowein', 'awejifoweiaj@jfoie.com', '87d5bddc36965797954215066b6a1f41', NULL, 1, 1, 'fjwaiof fjaweiofj ioawjfwaeo i', '2018-12-07 18:14:20', '2018-12-07 18:14:20', NULL);
INSERT INTO `zfz_user` VALUES ('6fc8012c-25e2-429a-b2a8-f359c0ee8547', NULL, 'fjwaeifji', 'jiofjwaepofj', 'oijfoiwejfioj', 'oijfeowfjie@121.com', '852e1c6107f8ad8ee0b551491e1b8146', NULL, 1, 1, 'fjwaofjioawe ffjeawiojf awef', '2018-12-07 18:21:14', '2018-12-07 18:21:14', NULL);
INSERT INTO `zfz_user` VALUES ('87e2b10f-4a3f-4b19-9b6e-914ac7715b21', NULL, 'aaaaaa', '999999999999', 'fjwaeifj', 'fjawoeijf@qq.com', 'ddeced2eff689365cd4fb449065a2bee', NULL, 1, 1, 'jfaiweo fjaweoifj aw fjiawoejf', '2018-12-07 18:11:29', '2018-12-07 18:11:29', NULL);
INSERT INTO `zfz_user` VALUES ('a211d16d-3d18-41f5-899f-eeba661bef5b', NULL, 'qqqqqqqqqqqqq', '1232143129', 'fjwiaeofjweo', 'fjwiaeofj@qq.com', 'afed53a4d4ba1bc9f6e3f09c0e0a8d8b', NULL, 1, 1, 'fjiwe fwjeiofjf jifeowjf  wejafo f awe fewaf', '2018-12-10 16:51:46', '2018-12-10 16:51:46', 'zhc');
INSERT INTO `zfz_user` VALUES ('a4143d3e-e557-4862-b096-f3c099e00acb', NULL, '广州人', '13890324839', 'abc', 'fjaweoifj@qq.com', 'cb298e8517d6e7502dcceba56ae5784a', NULL, 1, 1, 'fjiaweof fjwaeoifj fjweiaofj fewafj', '2018-12-10 17:15:07', '2018-12-10 17:16:15', 'zhc');
INSERT INTO `zfz_user` VALUES ('b35c6c7d-0363-4314-9d4b-025dd3c52c34', NULL, '中国人', '13598765235', 'wwwxxxx', 'wwwww@qq.com', '2f505316bfa4818804eed23cd4d6d734', NULL, 1, 1, 'fweajioafj fjiweaofj fjweiaofj', '2018-12-10 16:53:36', '2018-12-10 16:53:36', 'zhc');
INSERT INTO `zfz_user` VALUES ('b6ee8bd8-613e-403b-9d71-5c4d7b969a19', NULL, 'fewfiwjeij', 'jifwajeifoj', 'ijifjweafiojweij', 'jfwieafjei@11.com', 'e7108bf667425c923ce32a05fd6fbd7b', NULL, 1, 1, 'jfwoifjweoafjweaio feawf ewf ', '2018-12-07 18:13:11', '2018-12-07 18:13:11', NULL);
INSERT INTO `zfz_user` VALUES ('bd9a4004-2c9e-4ae7-9689-e1aa0f73b63b', NULL, '88888888', '9999999999999999', 'fjieofj', 'fieowjf@fjeaowifj.com', '7927a8f282f4b25ac98265ca01332f41', NULL, 1, 1, 'fjawoiefj fjawoe fjowef', '2018-12-07 18:17:15', '2018-12-07 18:17:15', NULL);
INSERT INTO `zfz_user` VALUES ('c284e9d7-6776-4692-b688-41d9c2287d8f', NULL, 'fffffffff', '1111111111', 'fweafje', 'fjiaweofjieawo@qq.com', '96881a52865846593c7ded2acc6e0b4c', NULL, 1, 1, 'fjiwaeofj fjweaiofj iwe jfwieoafj ', '2018-12-07 18:06:44', '2018-12-07 18:06:44', NULL);
INSERT INTO `zfz_user` VALUES ('c5551622-94ee-4f9e-8d23-7ee25c683232', NULL, 'fjewaifjiaofj0009', '1344832948323', 'fjweaofjiow', 'fjweiofij@jfwe.com', '2fd12a1338fd5cd1c9cfe51409f0b185', NULL, 1, 1, 'fjwaoefj fjweiaofj  fweajfoijwea', '2018-12-07 18:28:00', '2018-12-07 18:28:00', NULL);
INSERT INTO `zfz_user` VALUES ('d717bb84-fda9-4e72-bcbe-521572fb25d2', NULL, 'zhc12321', NULL, NULL, NULL, '202cb962ac59075b964b07152d234b70', NULL, 1, 100, NULL, '2018-12-07 11:20:22', '2018-12-07 11:20:22', NULL);
INSERT INTO `zfz_user` VALUES ('d82f7503-b494-4855-91e6-9f0dee6050f8', NULL, 'fjweiaojfo', 'jfiwoeajfowj', 'fjwoaejfoew', 'fjiowaejf@fjweo.com', 'ac3ba33b527038a47dd448133b825342', NULL, 1, 2, 'fawfwea fawe fewf wefe', '2018-12-07 18:24:36', '2018-12-07 18:24:36', NULL);

SET FOREIGN_KEY_CHECKS = 1;
