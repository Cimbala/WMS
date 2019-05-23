/*
 Navicat Premium Data Transfer

 Source Server         : MySQL(local)
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : wms_db

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/05/2019 15:52:55
*/

-- SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wms_access_record
-- ----------------------------
DROP TABLE IF EXISTS `wms_access_record`;
CREATE TABLE `wms_access_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ACCESS_TYPE` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ACCESS_TIME` datetime(0) NOT NULL,
  `ACCESS_IP` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_access_record
-- ----------------------------
INSERT INTO `wms_access_record` VALUES (1, 1001, 'admin', 'login', '2018-10-26 23:49:27', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (2, 1001, 'admin', 'login', '2018-10-26 23:57:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (3, 1001, 'admin', 'logout', '2018-10-26 23:59:11', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (4, 1001, 'admin', 'login', '2018-10-26 23:59:31', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (5, 1001, 'admin', 'logout', '2018-10-27 00:01:19', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (6, 1001, 'admin', 'login', '2018-10-27 00:02:21', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (7, 1001, 'admin', 'login', '2018-10-27 00:05:05', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (8, 1001, 'admin', 'login', '2018-10-27 15:04:16', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (9, 1001, 'admin', 'login', '2018-10-27 15:09:15', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (10, 1001, 'admin', 'login', '2018-10-27 15:20:09', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (11, 1001, 'admin', 'login', '2018-10-27 17:48:51', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (12, 1001, 'admin', 'login', '2018-10-27 17:56:31', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (13, 1001, 'admin', 'login', '2018-10-27 18:01:28', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (14, 1001, 'admin', 'login', '2018-10-27 21:21:23', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (15, 1001, 'admin', 'login', '2018-10-29 17:16:29', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (16, 1001, 'admin', 'login', '2018-10-29 17:52:26', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (17, 1001, 'admin', 'login', '2018-10-29 18:26:14', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (18, 1001, 'admin', 'login', '2018-10-29 18:32:47', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (19, 1001, 'admin', 'login', '2018-10-29 19:00:45', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (20, 1001, 'admin', 'login', '2018-10-29 19:03:45', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (21, 1001, 'admin', 'login', '2018-10-29 20:18:08', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (22, 1001, 'admin', 'login', '2018-10-29 21:11:01', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (23, 1001, 'admin', 'login', '2018-10-29 21:26:04', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (24, 1001, 'admin', 'login', '2018-10-29 21:42:15', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (25, 1001, 'admin', 'login', '2018-10-29 21:45:23', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (26, 1001, 'admin', 'login', '2018-10-29 21:53:30', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (27, 1001, 'admin', 'login', '2018-10-29 21:59:46', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (28, 1001, 'admin', 'login', '2018-10-29 22:03:12', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (29, 1001, 'admin', 'login', '2018-10-29 22:04:58', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (30, 1001, 'admin', 'login', '2018-10-31 15:12:32', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (31, 1001, 'admin', 'login', '2018-10-31 15:17:06', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (32, 1001, 'admin', 'login', '2018-10-31 15:25:26', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (33, 1001, 'admin', 'login', '2018-10-31 16:13:38', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (34, 1001, 'admin', 'login', '2018-10-31 16:55:32', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (35, 1001, 'admin', 'login', '2018-10-31 16:57:42', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (36, 1001, 'admin', 'login', '2018-10-31 17:15:30', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (37, 1001, 'admin', 'login', '2018-10-31 18:31:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (38, 1001, 'admin', 'login', '2018-10-31 18:43:23', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (39, 1001, 'admin', 'login', '2018-10-31 18:52:57', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (40, 1001, 'admin', 'login', '2018-10-31 18:56:35', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (41, 1001, 'admin', 'login', '2018-11-01 18:09:22', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (42, 1001, 'admin', 'login', '2018-11-01 18:19:11', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (43, 1001, 'admin', 'login', '2018-11-05 17:47:45', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (44, 1001, 'admin', 'login', '2018-11-05 18:16:09', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (45, 1001, 'admin', 'login', '2018-11-05 18:22:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (46, 1001, 'admin', 'login', '2018-11-05 18:33:01', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (47, 1001, 'admin', 'login', '2018-11-05 18:40:51', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (48, 1001, 'admin', 'login', '2018-11-05 19:22:17', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (49, 1001, 'admin', 'login', '2018-11-05 19:26:33', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (50, 1001, 'admin', 'login', '2018-11-05 19:29:58', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (51, 1001, 'admin', 'login', '2018-11-05 19:39:27', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (52, 1001, 'admin', 'login', '2018-11-05 19:42:48', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (53, 1001, 'admin', 'login', '2018-11-08 17:34:37', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (54, 1001, 'admin', 'login', '2018-11-08 17:37:30', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (55, 1001, 'admin', 'login', '2018-11-08 17:43:51', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (56, 1001, 'admin0', 'login', '2018-11-08 18:09:06', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (57, 1001, 'admin0', 'login', '2018-11-08 18:49:30', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (58, 1001, 'admin0', 'login', '2018-11-08 18:52:06', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (59, 1001, 'admin0', 'login', '2018-11-08 21:36:49', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (60, 1001, 'admin0', 'logout', '2018-11-08 22:12:38', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (61, 1001, 'admin0', 'login', '2018-11-08 22:32:14', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (62, 1001, 'admin0', 'logout', '2018-11-08 22:32:19', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (63, 1001, 'admin0', 'login', '2018-11-08 22:34:49', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (64, 1001, 'admin0', 'logout', '2018-11-08 22:34:54', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (65, 1001, 'admin0', 'login', '2018-11-08 22:35:40', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (66, 1001, 'admin0', 'logout', '2018-11-08 22:35:43', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (67, 1001, 'admin0', 'login', '2018-11-08 22:35:53', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (68, 1001, 'admin0', 'logout', '2018-11-08 22:36:01', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (69, 1001, 'admin0', 'login', '2018-11-08 22:38:11', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (70, 1001, 'admin0', 'login', '2018-11-08 22:53:35', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (71, 1001, 'admin0', 'logout', '2018-11-08 22:53:48', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (72, 1001, 'admin0', 'login', '2018-11-08 22:54:10', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (73, 1001, 'admin0', 'logout', '2018-11-08 22:55:25', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (74, 1001, 'admin0', 'login', '2018-11-08 22:56:11', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (75, 1001, 'admin0', 'logout', '2018-11-08 22:56:26', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (76, 1001, 'admin0', 'login', '2018-11-08 23:08:39', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (77, 1001, 'admin0', 'logout', '2018-11-08 23:09:12', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (78, 1110, 'admin2', 'login', '2018-11-08 23:14:31', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (79, 1110, 'admin2', 'logout', '2018-11-08 23:15:16', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (80, 1110, 'admin2', 'login', '2018-11-08 23:15:32', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (81, 1110, 'admin2', 'logout', '2018-11-08 23:18:13', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (82, 1001, 'admin0', 'login', '2018-11-09 10:34:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (83, 1001, 'admin0', 'login', '2018-11-09 21:12:53', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (84, 1001, 'admin0', 'logout', '2018-11-09 21:13:00', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (85, 1110, 'admin2', 'login', '2018-11-09 21:22:01', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (86, 1110, 'admin2', 'logout', '2018-11-09 21:31:23', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (87, 1001, 'admin0', 'login', '2018-11-09 21:31:59', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (88, 1110, 'admin2', 'login', '2018-11-09 21:40:45', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (89, 1110, 'admin2', 'login', '2018-11-09 21:50:09', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (90, 1001, 'admin0', 'login', '2018-11-17 16:42:29', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (91, 1001, 'admin0', 'logout', '2018-11-17 17:05:48', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (92, 1110, 'admin2', 'login', '2018-11-17 17:06:03', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (93, 1001, 'admin0', 'login', '2018-12-16 19:42:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (94, 1001, 'admin0', 'login', '2018-12-16 20:11:02', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (95, 1001, 'admin0', 'login', '2018-12-16 20:56:25', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (96, 1001, 'admin0', 'logout', '2018-12-16 21:54:59', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (97, 1001, 'admin0', 'login', '2018-12-16 22:00:16', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (98, 1001, 'admin0', 'login', '2018-12-16 22:30:22', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (99, 1001, 'admin0', 'login', '2018-12-16 22:38:59', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (100, 1001, 'admin0', 'login', '2019-01-02 15:14:53', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (101, 1001, 'admin0', 'login', '2019-01-02 15:37:50', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (102, 1001, 'admin0', 'login', '2019-01-09 09:59:20', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (103, 1001, 'admin0', 'login', '2019-01-09 10:19:24', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (104, 1001, 'admin0', 'login', '2019-01-09 10:23:35', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (105, 1001, 'admin0', 'logout', '2019-01-09 10:30:05', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (106, 1001, 'admin0', 'login', '2019-01-09 10:37:51', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (107, 1001, 'admin0', 'login', '2019-01-09 15:12:47', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (108, 1001, 'admin0', 'login', '2019-01-09 15:16:02', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (109, 1001, 'admin0', 'login', '2019-05-23 15:21:07', '0:0:0:0:0:0:0:1');
INSERT INTO `wms_access_record` VALUES (110, 1001, 'admin0', 'login', '2019-05-23 15:31:51', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for wms_action
-- ----------------------------
DROP TABLE IF EXISTS `wms_action`;
CREATE TABLE `wms_action`  (
  `ACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACTION_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ACTION_DESC` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ACTION_PARAM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ACTION_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_action
-- ----------------------------
INSERT INTO `wms_action` VALUES (1, 'addSupplier', NULL, '/supplierManage/addSupplier');
INSERT INTO `wms_action` VALUES (2, 'deleteSupplier', NULL, '/supplierManage/deleteSupplier');
INSERT INTO `wms_action` VALUES (3, 'updateSupplier', NULL, '/supplierManage/updateSupplier');
INSERT INTO `wms_action` VALUES (4, 'selectSupplier', NULL, '/supplierManage/getSupplierList');
INSERT INTO `wms_action` VALUES (5, 'getSupplierInfo', NULL, '/supplierManage/getSupplierInfo');
INSERT INTO `wms_action` VALUES (6, 'importSupplier', NULL, '/supplierManage/importSupplier');
INSERT INTO `wms_action` VALUES (7, 'exportSupplier', NULL, '/supplierManage/exportSupplier');
INSERT INTO `wms_action` VALUES (8, 'selectCustomer', NULL, '/customerManage/getCustomerList');
INSERT INTO `wms_action` VALUES (9, 'addCustomer', NULL, '/customerManage/addCustomer');
INSERT INTO `wms_action` VALUES (10, 'getCustomerInfo', NULL, '/customerManage/getCustomerInfo');
INSERT INTO `wms_action` VALUES (11, 'updateCustomer', NULL, '/customerManage/updateCustomer');
INSERT INTO `wms_action` VALUES (12, 'deleteCustomer', NULL, '/customerManage/deleteCustomer');
INSERT INTO `wms_action` VALUES (13, 'importCustomer', NULL, '/customerManage/importCustomer');
INSERT INTO `wms_action` VALUES (14, 'exportCustomer', NULL, '/customerManage/exportCustomer');
INSERT INTO `wms_action` VALUES (15, 'selectGoods', NULL, '/goodsManage/getGoodsList');
INSERT INTO `wms_action` VALUES (16, 'addGoods', NULL, '/goodsManage/addGoods');
INSERT INTO `wms_action` VALUES (17, 'getGoodsInfo', NULL, '/goodsManage/getGoodsInfo');
INSERT INTO `wms_action` VALUES (18, 'updateGoods', NULL, '/goodsManage/updateGoods');
INSERT INTO `wms_action` VALUES (19, 'deleteGoods', NULL, '/goodsManage/deleteGoods');
INSERT INTO `wms_action` VALUES (20, 'importGoods', NULL, '/goodsManage/importGoods');
INSERT INTO `wms_action` VALUES (21, 'exportGoods', NULL, '/goodsManage/exportGoods');
INSERT INTO `wms_action` VALUES (22, 'selectRepository', NULL, '/repositoryManage/getRepositoryList');
INSERT INTO `wms_action` VALUES (23, 'addRepository', NULL, '/repositoryManage/addRepository');
INSERT INTO `wms_action` VALUES (24, 'getRepositoryInfo', NULL, '/repositoryManage/getRepository');
INSERT INTO `wms_action` VALUES (25, 'updateRepository', NULL, '/repositoryManage/updateRepository');
INSERT INTO `wms_action` VALUES (26, 'deleteRepository', NULL, '/repositoryManage/deleteRepository');
INSERT INTO `wms_action` VALUES (27, 'importRepository', NULL, '/repositoryManage/importRepository');
INSERT INTO `wms_action` VALUES (28, 'exportRepository', NULL, '/repositoryManage/exportRepository');
INSERT INTO `wms_action` VALUES (29, 'selectRepositoryAdmin', NULL, '/repositoryAdminManage/getRepositoryAdminList');
INSERT INTO `wms_action` VALUES (30, 'addRepositoryAdmin', NULL, '/repositoryAdminManage/addRepositoryAdmin');
INSERT INTO `wms_action` VALUES (31, 'getRepositoryAdminInfo', NULL, '/repositoryAdminManage/getRepositoryAdminInfo');
INSERT INTO `wms_action` VALUES (32, 'updateRepositoryAdmin', NULL, '/repositoryAdminManage/updateRepositoryAdmin');
INSERT INTO `wms_action` VALUES (33, 'deleteRepositoryAdmin', NULL, '/repositoryAdminManage/deleteRepositoryAdmin');
INSERT INTO `wms_action` VALUES (34, 'importRepositoryAd,om', NULL, '/repositoryAdminManage/importRepositoryAdmin');
INSERT INTO `wms_action` VALUES (35, 'exportRepository', NULL, '/repositoryAdminManage/exportRepositoryAdmin');
INSERT INTO `wms_action` VALUES (36, 'getUnassignRepository', NULL, '/repositoryManage/getUnassignRepository');
INSERT INTO `wms_action` VALUES (37, 'getStorageListWithRepository', NULL, '/storageManage/getStorageListWithRepository');
INSERT INTO `wms_action` VALUES (38, 'getStorageList', NULL, '/storageManage/getStorageList');
INSERT INTO `wms_action` VALUES (39, 'addStorageRecord', NULL, '/storageManage/addStorageRecord');
INSERT INTO `wms_action` VALUES (40, 'updateStorageRecord', NULL, '/storageManage/updateStorageRecord');
INSERT INTO `wms_action` VALUES (41, 'deleteStorageRecord', NULL, '/storageManage/deleteStorageRecord');
INSERT INTO `wms_action` VALUES (42, 'importStorageRecord', NULL, '/storageManage/importStorageRecord');
INSERT INTO `wms_action` VALUES (43, 'exportStorageRecord', NULL, '/storageManage/exportStorageRecord');
INSERT INTO `wms_action` VALUES (44, ' stockIn', '货物进库操作', '/stockRecordManage/stockIn');
INSERT INTO `wms_action` VALUES (45, 'stockOut', '货物出库操作', '/stockRecordManage/stockOut');
INSERT INTO `wms_action` VALUES (46, 'searchStockRecord', '查询货物出入库记录', '/stockRecordManage/searchStockRecord');
INSERT INTO `wms_action` VALUES (47, 'getAccessRecords', '查询登入登出记录', '/systemLog/getAccessRecords');
INSERT INTO `wms_action` VALUES (48, 'selectUserOperationRecords', '查村用户操作记录', '/systemLog/selectUserOperationRecords');

-- ----------------------------
-- Table structure for wms_customer
-- ----------------------------
DROP TABLE IF EXISTS `wms_customer`;
CREATE TABLE `wms_customer`  (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CUSTOMER_PERSON` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CUSTOMER_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CUSTOMER_EMAIL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CUSTOMER_ADDRESS` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_customer
-- ----------------------------
INSERT INTO `wms_customer` VALUES (1216, '绿森林家具厂', '刘雅茜', '1259', '1259@qq.com', '大兴安岭');
INSERT INTO `wms_customer` VALUES (100001, '杨美丽', '1', '12388888', '1238888@qq.com', '广西北海市桂电北海校区');
INSERT INTO `wms_customer` VALUES (100002, '陈胖胖', '1', '11111111', '1111111@qq.com', '广西北海市桂电北海校区');
INSERT INTO `wms_customer` VALUES (100003, '刘胖胖', '1', '22222222', '2222222@qq.com', '广西北海市桂电北海校区');

-- ----------------------------
-- Table structure for wms_goods
-- ----------------------------
DROP TABLE IF EXISTS `wms_goods`;
CREATE TABLE `wms_goods`  (
  `GOOD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GOOD_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GOOD_RYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GOOD_SIZE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GOOD_VALUE` double NOT NULL,
  PRIMARY KEY (`GOOD_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_goods
-- ----------------------------
INSERT INTO `wms_goods` VALUES (1001, '小叶紫檀', '1', '15', 800000);
INSERT INTO `wms_goods` VALUES (1002, '海南黄花梨', '1', '5', 500000);

-- ----------------------------
-- Table structure for wms_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `wms_operation_record`;
CREATE TABLE `wms_operation_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OPERATION_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OPERATION_TIME` datetime(0) NOT NULL,
  `OPERATION_RESULT` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_operation_record
-- ----------------------------
INSERT INTO `wms_operation_record` VALUES (1, 1001, 'admin0', '修改库存记录', '2018-11-08 18:09:38', '成功');
INSERT INTO `wms_operation_record` VALUES (2, 1001, 'admin0', '货物入库', '2018-11-08 18:12:08', '成功');
INSERT INTO `wms_operation_record` VALUES (3, 1001, 'admin0', '货物出库', '2018-11-08 18:13:30', '成功');
INSERT INTO `wms_operation_record` VALUES (4, 1001, 'admin0', '添加库存记录', '2018-11-17 16:49:00', '成功');
INSERT INTO `wms_operation_record` VALUES (5, 1001, 'admin0', '删除供应商信息', '2018-11-17 17:05:05', '成功');
INSERT INTO `wms_operation_record` VALUES (6, 1001, 'admin0', '删除供应商信息', '2018-11-17 17:05:14', '成功');
INSERT INTO `wms_operation_record` VALUES (7, 1001, 'admin0', '货物入库', '2018-12-16 22:35:27', '成功');
INSERT INTO `wms_operation_record` VALUES (8, 1001, 'admin0', '货物出库', '2018-12-16 22:40:09', '成功');
INSERT INTO `wms_operation_record` VALUES (9, 1001, 'admin0', '导出库存记录', '2019-01-09 10:19:47', '-');
INSERT INTO `wms_operation_record` VALUES (10, 1001, 'admin0', '导出库存记录', '2019-01-09 10:20:04', '-');
INSERT INTO `wms_operation_record` VALUES (11, 1001, 'admin0', '货物入库', '2019-05-23 15:33:05', '成功');

-- ----------------------------
-- Table structure for wms_order_delivery
-- ----------------------------
DROP TABLE IF EXISTS `wms_order_delivery`;
CREATE TABLE `wms_order_delivery`  (
  `DELIVERY_ID` int(11) NOT NULL,
  `CUSTOMER_ID` int(11) NOT NULL,
  `GOOD_ID` int(11) NOT NULL,
  `NUM` int(12) NOT NULL,
  `CUSTOMER_ADDR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DELIVERY_TIME` datetime(0) NOT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DELIVERY_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;

-- ----------------------------
-- Table structure for wms_order_in
-- ----------------------------
DROP TABLE IF EXISTS `wms_order_in`;
CREATE TABLE `wms_order_in`  (
  `ORDER_IN_ID` int(11) NOT NULL COMMENT '进货单号',
  `ORDER_IN_SUPPLIERID` int(11) NOT NULL COMMENT '供应商名称',
  `ORDER_IN_GOODID` int(11) NOT NULL COMMENT '货物ID',
  `ORDER_IN_NUMBER` int(11) NOT NULL COMMENT '数量',
  `ORDER_IN_TIME` datetime(0) NOT NULL COMMENT '时间',
  `ORDER_IN_PERSION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `SYSTEM_FLAG` int(1) NOT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMAKR1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ORDER_IN_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_order_in
-- ----------------------------
INSERT INTO `wms_order_in` VALUES (301, 123456789, 1001, 5, '2018-01-01 00:00:00', '1', 1, '1', '1');
INSERT INTO `wms_order_in` VALUES (302, 123456789, 1002, 10, '2018-01-03 10:00:00', '3', 1, '1', '1');

-- ----------------------------
-- Table structure for wms_order_out
-- ----------------------------
DROP TABLE IF EXISTS `wms_order_out`;
CREATE TABLE `wms_order_out`  (
  `ORDER_OUT_ID` int(11) NOT NULL COMMENT '客户订货单号',
  `ORDER_OUT_CUSTOMERID` int(11) NOT NULL COMMENT '客户ID',
  `ORDER_OUT_GOODID` int(11) NOT NULL COMMENT '货物ID',
  `ORDER_OUT_NUMBER` int(11) NOT NULL COMMENT '数量',
  `ORDER_OUT_TIME` datetime(0) NOT NULL COMMENT '时间',
  `ORDER_OUT_PERSION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `SYSTEM_FLAG` int(1) NOT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMAKR1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ORDER_OUT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_order_out
-- ----------------------------
INSERT INTO `wms_order_out` VALUES (401, 1, 1001, 1, '2018-02-18 00:00:00', '1', 1, '1', '1');

-- ----------------------------
-- Table structure for wms_person
-- ----------------------------
DROP TABLE IF EXISTS `wms_person`;
CREATE TABLE `wms_person`  (
  `PERSON_ID` int(11) NOT NULL,
  `PERSON_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PERSON_GENDER` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PERSON_JOB` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PERSON_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PERSON_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SYSTEM_FLAG` int(1) NOT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_person
-- ----------------------------
INSERT INTO `wms_person` VALUES (9001, '张大大', '男', '经理', '123123123', '254541', 1, '1', '1');
INSERT INTO `wms_person` VALUES (9002, '赵大大', '男', '董事', '121212121', '121212', 2, '2', '2');

-- ----------------------------
-- Table structure for wms_record_in
-- ----------------------------
DROP TABLE IF EXISTS `wms_record_in`;
CREATE TABLE `wms_record_in`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RECORD_SUPPLIERID` int(11) NOT NULL,
  `RECORD_GOODID` int(11) NOT NULL,
  `RECORD_NUMBER` int(11) NOT NULL,
  `RECORD_TIME` datetime(0) NOT NULL,
  `RECORD_PERSON` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RECORD_REPOSITORYID` int(11) NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  INDEX `RECORD_SUPPLIERID`(`RECORD_SUPPLIERID`) USING BTREE,
  INDEX `RECORD_GOODID`(`RECORD_GOODID`) USING BTREE,
  INDEX `RECORD_REPOSITORYID`(`RECORD_REPOSITORYID`) USING BTREE,
  CONSTRAINT `wms_record_in_ibfk_1` FOREIGN KEY (`RECORD_SUPPLIERID`) REFERENCES `wms_supplier` (`supplier_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_record_in_ibfk_2` FOREIGN KEY (`RECORD_GOODID`) REFERENCES `wms_goods` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_record_in_ibfk_3` FOREIGN KEY (`RECORD_REPOSITORYID`) REFERENCES `wms_respository` (`repo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_record_in
-- ----------------------------
INSERT INTO `wms_record_in` VALUES (5001, 1016, 1001, 100, '2018-12-16 22:35:27', 'admin0', 2101);
INSERT INTO `wms_record_in` VALUES (5002, 1015, 1001, 50, '2019-05-23 15:33:05', 'admin0', 2101);

-- ----------------------------
-- Table structure for wms_record_out
-- ----------------------------
DROP TABLE IF EXISTS `wms_record_out`;
CREATE TABLE `wms_record_out`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RECORD_CUSTOMERID` int(11) NOT NULL,
  `RECORD_GOODID` int(11) NOT NULL,
  `RECORD_NUMBER` int(11) NOT NULL,
  `RECORD_TIME` datetime(0) NOT NULL,
  `RECORD_PERSON` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RECORD_REPOSITORYID` int(11) NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  INDEX `RECORD_CUSTOMERID`(`RECORD_CUSTOMERID`) USING BTREE,
  INDEX `RECORD_GOODID`(`RECORD_GOODID`) USING BTREE,
  INDEX `RECORD_REPOSITORYID`(`RECORD_REPOSITORYID`) USING BTREE,
  CONSTRAINT `wms_record_out_ibfk_1` FOREIGN KEY (`RECORD_CUSTOMERID`) REFERENCES `wms_customer` (`customer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_record_out_ibfk_2` FOREIGN KEY (`RECORD_GOODID`) REFERENCES `wms_goods` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_record_out_ibfk_3` FOREIGN KEY (`RECORD_REPOSITORYID`) REFERENCES `wms_respository` (`repo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_record_out
-- ----------------------------
INSERT INTO `wms_record_out` VALUES (8, 1216, 1001, 50, '2018-12-16 22:40:09', 'admin0', 2101);

-- ----------------------------
-- Table structure for wms_record_sale
-- ----------------------------
DROP TABLE IF EXISTS `wms_record_sale`;
CREATE TABLE `wms_record_sale`  (
  `SALE_ID` int(11) NOT NULL,
  `GOOD_ID` int(11) NOT NULL,
  `SALE_NUM` int(10) NOT NULL,
  `PRICE` int(10) NOT NULL,
  `UNIT` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SALE_AMOUNT` int(16) NOT NULL,
  `SALE_DATE` datetime(0) NOT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REMARK1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SALE_ID`, `GOOD_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8;

-- ----------------------------
-- Records of wms_record_sale
-- ----------------------------
INSERT INTO `wms_record_sale` VALUES (43101, 1001, 20, 800000, '盒', 16000000, '2019-01-09 10:10:38', NULL, NULL);

-- ----------------------------
-- Table structure for wms_record_storage
-- ----------------------------
DROP TABLE IF EXISTS `wms_record_storage`;
CREATE TABLE `wms_record_storage`  (
  `RECORD_GOODID` int(11) NOT NULL AUTO_INCREMENT,
  `RECORD_REPOSITORY` int(11) NOT NULL,
  `RECORD_NUMBER` int(11) NOT NULL,
  PRIMARY KEY (`RECORD_GOODID`, `RECORD_REPOSITORY`) USING BTREE,
  INDEX `RECORD_REPOSITORY`(`RECORD_REPOSITORY`) USING BTREE,
  CONSTRAINT `wms_record_storage_ibfk_1` FOREIGN KEY (`RECORD_GOODID`) REFERENCES `wms_goods` (`good_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_record_storage_ibfk_2` FOREIGN KEY (`RECORD_REPOSITORY`) REFERENCES `wms_respository` (`repo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_record_storage
-- ----------------------------
INSERT INTO `wms_record_storage` VALUES (1001, 2101, 223);

-- ----------------------------
-- Table structure for wms_repo_admin
-- ----------------------------
DROP TABLE IF EXISTS `wms_repo_admin`;
CREATE TABLE `wms_repo_admin`  (
  `REPO_ADMIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REPO_ADMIN_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_ADMIN_SEX` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_ADMIN_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_ADMIN_ADDRESS` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_ADMIN_BIRTH` datetime(0) NOT NULL,
  `REPO_ADMIN_REPOID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`REPO_ADMIN_ID`) USING BTREE,
  INDEX `REPO_ADMIN_REPOID`(`REPO_ADMIN_REPOID`) USING BTREE,
  CONSTRAINT `wms_repo_admin_ibfk_1` FOREIGN KEY (`REPO_ADMIN_REPOID`) REFERENCES `wms_respository` (`repo_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wms_respository
-- ----------------------------
DROP TABLE IF EXISTS `wms_respository`;
CREATE TABLE `wms_respository`  (
  `REPO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REPO_ADDRESS` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_STATUS` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_AREA` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPO_DESC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`REPO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_respository
-- ----------------------------
INSERT INTO `wms_respository` VALUES (2101, '北海桂林', '使用', '60000', NULL);

-- ----------------------------
-- Table structure for wms_role_action
-- ----------------------------
DROP TABLE IF EXISTS `wms_role_action`;
CREATE TABLE `wms_role_action`  (
  `ACTION_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ACTION_ID`, `ROLE_ID`) USING BTREE,
  INDEX `ROLE_ID`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `wms_role_action_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `wms_roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_role_action_ibfk_2` FOREIGN KEY (`ACTION_ID`) REFERENCES `wms_action` (`action_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_role_action
-- ----------------------------
INSERT INTO `wms_role_action` VALUES (1, 1);
INSERT INTO `wms_role_action` VALUES (2, 1);
INSERT INTO `wms_role_action` VALUES (3, 1);
INSERT INTO `wms_role_action` VALUES (4, 1);
INSERT INTO `wms_role_action` VALUES (5, 1);
INSERT INTO `wms_role_action` VALUES (6, 1);
INSERT INTO `wms_role_action` VALUES (7, 1);
INSERT INTO `wms_role_action` VALUES (8, 1);
INSERT INTO `wms_role_action` VALUES (9, 1);
INSERT INTO `wms_role_action` VALUES (10, 1);
INSERT INTO `wms_role_action` VALUES (11, 1);
INSERT INTO `wms_role_action` VALUES (12, 1);
INSERT INTO `wms_role_action` VALUES (13, 1);
INSERT INTO `wms_role_action` VALUES (14, 1);
INSERT INTO `wms_role_action` VALUES (15, 1);
INSERT INTO `wms_role_action` VALUES (16, 1);
INSERT INTO `wms_role_action` VALUES (17, 1);
INSERT INTO `wms_role_action` VALUES (18, 1);
INSERT INTO `wms_role_action` VALUES (19, 1);
INSERT INTO `wms_role_action` VALUES (20, 1);
INSERT INTO `wms_role_action` VALUES (21, 1);
INSERT INTO `wms_role_action` VALUES (22, 1);
INSERT INTO `wms_role_action` VALUES (23, 1);
INSERT INTO `wms_role_action` VALUES (24, 1);
INSERT INTO `wms_role_action` VALUES (25, 1);
INSERT INTO `wms_role_action` VALUES (26, 1);
INSERT INTO `wms_role_action` VALUES (27, 1);
INSERT INTO `wms_role_action` VALUES (28, 1);
INSERT INTO `wms_role_action` VALUES (29, 1);
INSERT INTO `wms_role_action` VALUES (30, 1);
INSERT INTO `wms_role_action` VALUES (31, 1);
INSERT INTO `wms_role_action` VALUES (32, 1);
INSERT INTO `wms_role_action` VALUES (33, 1);
INSERT INTO `wms_role_action` VALUES (34, 1);
INSERT INTO `wms_role_action` VALUES (35, 1);
INSERT INTO `wms_role_action` VALUES (36, 1);
INSERT INTO `wms_role_action` VALUES (37, 1);
INSERT INTO `wms_role_action` VALUES (39, 1);
INSERT INTO `wms_role_action` VALUES (40, 1);
INSERT INTO `wms_role_action` VALUES (41, 1);
INSERT INTO `wms_role_action` VALUES (42, 1);
INSERT INTO `wms_role_action` VALUES (43, 1);
INSERT INTO `wms_role_action` VALUES (44, 1);
INSERT INTO `wms_role_action` VALUES (45, 1);
INSERT INTO `wms_role_action` VALUES (46, 1);
INSERT INTO `wms_role_action` VALUES (47, 1);
INSERT INTO `wms_role_action` VALUES (48, 1);
INSERT INTO `wms_role_action` VALUES (1, 2);
INSERT INTO `wms_role_action` VALUES (2, 2);
INSERT INTO `wms_role_action` VALUES (3, 2);
INSERT INTO `wms_role_action` VALUES (4, 2);
INSERT INTO `wms_role_action` VALUES (5, 2);
INSERT INTO `wms_role_action` VALUES (6, 2);
INSERT INTO `wms_role_action` VALUES (7, 2);
INSERT INTO `wms_role_action` VALUES (8, 2);
INSERT INTO `wms_role_action` VALUES (9, 2);
INSERT INTO `wms_role_action` VALUES (10, 2);
INSERT INTO `wms_role_action` VALUES (11, 2);
INSERT INTO `wms_role_action` VALUES (12, 2);
INSERT INTO `wms_role_action` VALUES (13, 2);
INSERT INTO `wms_role_action` VALUES (14, 2);
INSERT INTO `wms_role_action` VALUES (15, 2);
INSERT INTO `wms_role_action` VALUES (16, 2);
INSERT INTO `wms_role_action` VALUES (17, 2);
INSERT INTO `wms_role_action` VALUES (18, 2);
INSERT INTO `wms_role_action` VALUES (19, 2);
INSERT INTO `wms_role_action` VALUES (20, 2);
INSERT INTO `wms_role_action` VALUES (21, 2);
INSERT INTO `wms_role_action` VALUES (22, 2);
INSERT INTO `wms_role_action` VALUES (23, 2);
INSERT INTO `wms_role_action` VALUES (24, 2);
INSERT INTO `wms_role_action` VALUES (25, 2);
INSERT INTO `wms_role_action` VALUES (26, 2);
INSERT INTO `wms_role_action` VALUES (27, 2);
INSERT INTO `wms_role_action` VALUES (28, 2);
INSERT INTO `wms_role_action` VALUES (29, 2);
INSERT INTO `wms_role_action` VALUES (30, 2);
INSERT INTO `wms_role_action` VALUES (31, 2);
INSERT INTO `wms_role_action` VALUES (32, 2);
INSERT INTO `wms_role_action` VALUES (33, 2);
INSERT INTO `wms_role_action` VALUES (34, 2);
INSERT INTO `wms_role_action` VALUES (35, 2);
INSERT INTO `wms_role_action` VALUES (36, 2);
INSERT INTO `wms_role_action` VALUES (37, 2);
INSERT INTO `wms_role_action` VALUES (39, 2);
INSERT INTO `wms_role_action` VALUES (40, 2);
INSERT INTO `wms_role_action` VALUES (41, 2);
INSERT INTO `wms_role_action` VALUES (42, 2);
INSERT INTO `wms_role_action` VALUES (43, 2);
INSERT INTO `wms_role_action` VALUES (44, 2);
INSERT INTO `wms_role_action` VALUES (45, 2);
INSERT INTO `wms_role_action` VALUES (46, 2);
INSERT INTO `wms_role_action` VALUES (47, 2);
INSERT INTO `wms_role_action` VALUES (48, 2);

-- ----------------------------
-- Table structure for wms_roles
-- ----------------------------
DROP TABLE IF EXISTS `wms_roles`;
CREATE TABLE `wms_roles`  (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ROLE_DESC` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ROLE_URL_PREFIX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_roles
-- ----------------------------
INSERT INTO `wms_roles` VALUES (1, 'systemAdmin', NULL, 'systemAdmin');
INSERT INTO `wms_roles` VALUES (2, 'commonsAdmin', NULL, 'commonsAdmin');

-- ----------------------------
-- Table structure for wms_shop
-- ----------------------------
DROP TABLE IF EXISTS `wms_shop`;
CREATE TABLE `wms_shop`  (
  `SHOP_ID` int(11) NOT NULL,
  `SHOP_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `SHOP_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `PIC_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '门店负责人姓名',
  `PIC_TEL` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '门店负责人联系电话',
  `SHOP_TEL` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `REMARK0` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`SHOP_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_shop
-- ----------------------------
INSERT INTO `wms_shop` VALUES (11001, '浩浩便利店', '西虹市解放路233号', '武极豪', '19812345678', '010-234567', NULL);
INSERT INTO `wms_shop` VALUES (11002, '呵呵哒便利店', '洛圣都市西南大道666号', '柳和', '4896785858', '1244653634', NULL);

-- ----------------------------
-- Table structure for wms_supplier
-- ----------------------------
DROP TABLE IF EXISTS `wms_supplier`;
CREATE TABLE `wms_supplier`  (
  `SUPPLIER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUPPLIER_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SUPPLIER_PERSON` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SUPPLIER_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SUPPLIER_EMAIL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SUPPLIER_ADDRESS` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SUPPLIER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1016 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_supplier
-- ----------------------------
INSERT INTO `wms_supplier` VALUES (1015, '张氏木业', '张大大', '123456', '123456@qq.com', '北海银滩');
INSERT INTO `wms_supplier` VALUES (1016, '赵氏实业', '赵某某', '188121', '188121@qq.com', '黄土高原');

-- ----------------------------
-- Table structure for wms_user
-- ----------------------------
DROP TABLE IF EXISTS `wms_user`;
CREATE TABLE `wms_user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_USERNAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_FIRST_LOGIN` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_user
-- ----------------------------
INSERT INTO `wms_user` VALUES (1001, 'admin0', '6f5379e73c1a9eac6163ab8eaec7e41c', 0);
INSERT INTO `wms_user` VALUES (1110, 'admin2', '7aea8a8b66d9caa66aacb409eee5cb06', 0);

-- ----------------------------
-- Table structure for wms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `wms_user_role`;
CREATE TABLE `wms_user_role`  (
  `ROLE_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROLE_ID`, `USER_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `wms_user_role_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `wms_roles` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wms_user_role_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `wms_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wms_user_role
-- ----------------------------
INSERT INTO `wms_user_role` VALUES (1, 1001);
INSERT INTO `wms_user_role` VALUES (2, 1110);

SET FOREIGN_KEY_CHECKS = 1;
