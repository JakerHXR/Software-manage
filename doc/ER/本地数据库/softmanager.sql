/*
 Navicat Premium Data Transfer

 Source Server         : jaker
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : localhost:3306
 Source Schema         : softmanager

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 21/12/2023 23:13:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administer
-- ----------------------------
DROP TABLE IF EXISTS `administer`;
CREATE TABLE `administer`  (
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`admin_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administer
-- ----------------------------
INSERT INTO `administer` VALUES ('test', '111', NULL);
INSERT INTO `administer` VALUES ('test2', '11133', NULL);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `select_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `select_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `FK_LOG_LOGGING_USER_BAS`(`user_name` ASC) USING BTREE,
  CONSTRAINT `FK_LOG_LOGGING_USER_BAS` FOREIGN KEY (`user_name`) REFERENCES `user_base` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for menu_food
-- ----------------------------
DROP TABLE IF EXISTS `menu_food`;
CREATE TABLE `menu_food`  (
  `menu_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `menu_feature` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_no`) USING BTREE,
  INDEX `FK_MENU_FOO_MANAGE_ME_ADMINIST`(`admin_name` ASC) USING BTREE,
  CONSTRAINT `FK_MENU_FOO_MANAGE_ME_ADMINIST` FOREIGN KEY (`admin_name`) REFERENCES `administer` (`admin_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_food
-- ----------------------------
INSERT INTO `menu_food` VALUES ('1', NULL, '糖醋里脊', '猪肉');
INSERT INTO `menu_food` VALUES ('10', NULL, '青椒肉丝', '猪肉');
INSERT INTO `menu_food` VALUES ('100', NULL, '白灼虾', '海鲜');
INSERT INTO `menu_food` VALUES ('11', NULL, '梅菜扣肉', '猪肉');
INSERT INTO `menu_food` VALUES ('12', NULL, '茄子煲', '素食');
INSERT INTO `menu_food` VALUES ('13', NULL, '葱爆羊肉', '羊肉');
INSERT INTO `menu_food` VALUES ('14', NULL, '鱼头豆腐汤', '海鲜');
INSERT INTO `menu_food` VALUES ('15', NULL, '水煮鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('16', NULL, '回锅肉', '猪肉');
INSERT INTO `menu_food` VALUES ('17', NULL, '麻辣香锅', '猪肉');
INSERT INTO `menu_food` VALUES ('18', NULL, '番茄炒蛋', '素食');
INSERT INTO `menu_food` VALUES ('19', NULL, '豆腐鱼片汤', '海鲜');
INSERT INTO `menu_food` VALUES ('2', NULL, '老式蒜薹肉', '猪肉');
INSERT INTO `menu_food` VALUES ('20', NULL, '铁板牛肉', '牛肉');
INSERT INTO `menu_food` VALUES ('21', NULL, '豆芽炒肉片', '猪肉');
INSERT INTO `menu_food` VALUES ('22', NULL, '清蒸鲈鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('23', NULL, '素炒三鲜', '素食');
INSERT INTO `menu_food` VALUES ('24', NULL, '酱爆鸭丝', '鸭肉');
INSERT INTO `menu_food` VALUES ('25', NULL, '水煮牛肉', '牛肉');
INSERT INTO `menu_food` VALUES ('26', NULL, '凉拌黄瓜', '素食');
INSERT INTO `menu_food` VALUES ('27', NULL, '青椒鸡蛋', '素食');
INSERT INTO `menu_food` VALUES ('28', NULL, '黑椒牛柳', '牛肉');
INSERT INTO `menu_food` VALUES ('29', NULL, '拔丝地瓜', '素食');
INSERT INTO `menu_food` VALUES ('3', NULL, '鱼香肉丝', '猪肉');
INSERT INTO `menu_food` VALUES ('30', NULL, '蚝油生菜', '素食');
INSERT INTO `menu_food` VALUES ('31', NULL, '辣子鸡', '鸡肉');
INSERT INTO `menu_food` VALUES ('32', NULL, '炸酱面', '猪肉');
INSERT INTO `menu_food` VALUES ('33', NULL, '干锅花菜', '素食');
INSERT INTO `menu_food` VALUES ('34', NULL, '冬瓜排骨汤', '猪肉');
INSERT INTO `menu_food` VALUES ('35', NULL, '芹菜炒腰花', '羊肉');
INSERT INTO `menu_food` VALUES ('36', NULL, '酸辣粉', '素食');
INSERT INTO `menu_food` VALUES ('37', NULL, '素炸春卷', '素食');
INSERT INTO `menu_food` VALUES ('38', NULL, '芝士烤牛肉', '牛肉');
INSERT INTO `menu_food` VALUES ('39', NULL, '扬州炒饭', '素食');
INSERT INTO `menu_food` VALUES ('4', NULL, '宫保鸡丁', '鸡肉');
INSERT INTO `menu_food` VALUES ('40', NULL, '炸藕片', '素食');
INSERT INTO `menu_food` VALUES ('41', NULL, '沙拉三明治', '素食');
INSERT INTO `menu_food` VALUES ('42', NULL, '水果沙拉', '素食');
INSERT INTO `menu_food` VALUES ('43', NULL, '咖喱鸡饭', '鸡肉');
INSERT INTO `menu_food` VALUES ('44', NULL, '叉烧包', '猪肉');
INSERT INTO `menu_food` VALUES ('45', NULL, '扬州炖鸭', '鸭肉');
INSERT INTO `menu_food` VALUES ('46', NULL, '西湖牛肉羹', '牛肉');
INSERT INTO `menu_food` VALUES ('47', NULL, '豆腐脑', '素食');
INSERT INTO `menu_food` VALUES ('48', NULL, '酸菜鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('49', NULL, '拉面', '素食');
INSERT INTO `menu_food` VALUES ('5', NULL, '红烧排骨', '猪肉');
INSERT INTO `menu_food` VALUES ('50', NULL, '醋溜木耳', '素食');
INSERT INTO `menu_food` VALUES ('51', NULL, '糖醋鲤鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('52', NULL, '铁板烧', '猪肉');
INSERT INTO `menu_food` VALUES ('53', NULL, '麻辣烫', '素食');
INSERT INTO `menu_food` VALUES ('54', NULL, '虾仁炒饭', '海鲜');
INSERT INTO `menu_food` VALUES ('55', NULL, '红烧茄子', '素食');
INSERT INTO `menu_food` VALUES ('56', NULL, '花生鸡丁', '鸡肉');
INSERT INTO `menu_food` VALUES ('57', NULL, '爆炒腰花', '羊肉');
INSERT INTO `menu_food` VALUES ('58', NULL, '烤鸭', '鸭肉');
INSERT INTO `menu_food` VALUES ('59', NULL, '炒年糕', '素食');
INSERT INTO `menu_food` VALUES ('6', NULL, '酸辣土豆丝', '素食');
INSERT INTO `menu_food` VALUES ('60', NULL, '姜葱蟹', '海鲜');
INSERT INTO `menu_food` VALUES ('61', NULL, '翅尖', '鸡肉');
INSERT INTO `menu_food` VALUES ('62', NULL, '蒜蓉粉丝蒸扇贝', '海鲜');
INSERT INTO `menu_food` VALUES ('63', NULL, '蒜蓉生蚝', '海鲜');
INSERT INTO `menu_food` VALUES ('64', NULL, '美味海鲜粥', '海鲜');
INSERT INTO `menu_food` VALUES ('65', NULL, '黑椒蟹', '海鲜');
INSERT INTO `menu_food` VALUES ('66', NULL, '芝士焗大虾', '海鲜');
INSERT INTO `menu_food` VALUES ('67', NULL, '泡椒鱼头', '海鲜');
INSERT INTO `menu_food` VALUES ('68', NULL, '椒盐鸡翅', '鸡肉');
INSERT INTO `menu_food` VALUES ('69', NULL, '红烧鲳鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('7', NULL, '醋溜白菜', '素食');
INSERT INTO `menu_food` VALUES ('70', NULL, '干锅包菜', '素食');
INSERT INTO `menu_food` VALUES ('71', NULL, '梅干菜扣肉', '猪肉');
INSERT INTO `menu_food` VALUES ('72', NULL, '冰糖葫芦', '素食');
INSERT INTO `menu_food` VALUES ('73', NULL, '香煎鳕鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('74', NULL, '炸鸡', '鸡肉');
INSERT INTO `menu_food` VALUES ('75', NULL, '糖醋排骨', '猪肉');
INSERT INTO `menu_food` VALUES ('76', NULL, '古法煮鸡', '鸡肉');
INSERT INTO `menu_food` VALUES ('77', NULL, '香辣蟹', '海鲜');
INSERT INTO `menu_food` VALUES ('78', NULL, '清蒸桂鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('79', NULL, '糖醋黄瓜', '素食');
INSERT INTO `menu_food` VALUES ('8', NULL, '蒜蓉西兰花', '素食');
INSERT INTO `menu_food` VALUES ('80', NULL, '茭白炒肉丝', '猪肉');
INSERT INTO `menu_food` VALUES ('81', NULL, '青椒鸡块', '鸡肉');
INSERT INTO `menu_food` VALUES ('82', NULL, '凉拌海蜇', '海鲜');
INSERT INTO `menu_food` VALUES ('83', NULL, '麻辣牛肉面', '牛肉');
INSERT INTO `menu_food` VALUES ('84', NULL, '老北京炸酱面', '猪肉');
INSERT INTO `menu_food` VALUES ('85', NULL, '酸辣粉', '素食');
INSERT INTO `menu_food` VALUES ('86', NULL, '鱼香茄子', '素食');
INSERT INTO `menu_food` VALUES ('87', NULL, '茄汁蒸鲈鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('88', NULL, '醋溜鲤鱼', '海鲜');
INSERT INTO `menu_food` VALUES ('89', NULL, '西红柿鸡蛋面', '素食');
INSERT INTO `menu_food` VALUES ('9', NULL, '孜然羊肉', '羊肉');
INSERT INTO `menu_food` VALUES ('90', NULL, '水煮肉片', '牛肉');
INSERT INTO `menu_food` VALUES ('91', NULL, '辣子鸡丁', '鸡肉');
INSERT INTO `menu_food` VALUES ('92', NULL, '素炒四季豆', '素食');
INSERT INTO `menu_food` VALUES ('93', NULL, '葱油拌面', '素食');
INSERT INTO `menu_food` VALUES ('94', NULL, '清蒸鸡', '鸡肉');
INSERT INTO `menu_food` VALUES ('95', NULL, '小炒肉', '猪肉');
INSERT INTO `menu_food` VALUES ('96', NULL, '干锅牛蛙', '海鲜');
INSERT INTO `menu_food` VALUES ('97', NULL, '香辣蟹煲', '海鲜');
INSERT INTO `menu_food` VALUES ('98', NULL, '爆炒腰花', '羊肉');
INSERT INTO `menu_food` VALUES ('99', NULL, '清炒时蔬', '素食');

-- ----------------------------
-- Table structure for menu_tag
-- ----------------------------
DROP TABLE IF EXISTS `menu_tag`;
CREATE TABLE `menu_tag`  (
  `food_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `food_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `food_tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`food_no`) USING BTREE,
  INDEX `FK_MENU_TAG_MANAGE_TA_ADMINIST`(`admin_name` ASC) USING BTREE,
  CONSTRAINT `FK_MENU_TAG_MANAGE_TA_ADMINIST` FOREIGN KEY (`admin_name`) REFERENCES `administer` (`admin_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_tag
-- ----------------------------
INSERT INTO `menu_tag` VALUES ('1', NULL, '糖醋里脊', '酸甜');
INSERT INTO `menu_tag` VALUES ('10', NULL, '青椒肉丝', '咸辣');
INSERT INTO `menu_tag` VALUES ('100', NULL, '白灼虾', '咸鲜');
INSERT INTO `menu_tag` VALUES ('11', NULL, '梅菜扣肉', '咸甜');
INSERT INTO `menu_tag` VALUES ('12', NULL, '茄子煲', '咸甜');
INSERT INTO `menu_tag` VALUES ('13', NULL, '葱爆羊肉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('14', NULL, '鱼头豆腐汤', '咸鲜');
INSERT INTO `menu_tag` VALUES ('15', NULL, '水煮鱼', '清淡');
INSERT INTO `menu_tag` VALUES ('16', NULL, '回锅肉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('17', NULL, '麻辣香锅', '麻辣');
INSERT INTO `menu_tag` VALUES ('18', NULL, '番茄炒蛋', '咸甜');
INSERT INTO `menu_tag` VALUES ('19', NULL, '豆腐鱼片汤', '清淡');
INSERT INTO `menu_tag` VALUES ('2', NULL, '老式蒜薹肉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('20', NULL, '铁板牛肉', '咸辣');
INSERT INTO `menu_tag` VALUES ('21', NULL, '豆芽炒肉片', '咸辣');
INSERT INTO `menu_tag` VALUES ('22', NULL, '清蒸鲈鱼', '清淡');
INSERT INTO `menu_tag` VALUES ('23', NULL, '素炒三鲜', '清淡');
INSERT INTO `menu_tag` VALUES ('24', NULL, '酱爆鸭丝', '咸甜');
INSERT INTO `menu_tag` VALUES ('25', NULL, '水煮牛肉', '麻辣');
INSERT INTO `menu_tag` VALUES ('26', NULL, '凉拌黄瓜', '清淡');
INSERT INTO `menu_tag` VALUES ('27', NULL, '青椒鸡蛋', '咸辣');
INSERT INTO `menu_tag` VALUES ('28', NULL, '黑椒牛柳', '咸鲜');
INSERT INTO `menu_tag` VALUES ('29', NULL, '拔丝地瓜', '咸甜');
INSERT INTO `menu_tag` VALUES ('3', NULL, '鱼香肉丝', '咸甜');
INSERT INTO `menu_tag` VALUES ('30', NULL, '蚝油生菜', '咸鲜');
INSERT INTO `menu_tag` VALUES ('31', NULL, '辣子鸡', '咸辣');
INSERT INTO `menu_tag` VALUES ('32', NULL, '炸酱面', '咸甜');
INSERT INTO `menu_tag` VALUES ('33', NULL, '干锅花菜', '清淡');
INSERT INTO `menu_tag` VALUES ('34', NULL, '冬瓜排骨汤', '清淡');
INSERT INTO `menu_tag` VALUES ('35', NULL, '芹菜炒腰花', '咸鲜');
INSERT INTO `menu_tag` VALUES ('36', NULL, '酸辣粉', '酸辣');
INSERT INTO `menu_tag` VALUES ('37', NULL, '素炸春卷', '咸甜');
INSERT INTO `menu_tag` VALUES ('38', NULL, '芝士烤牛肉', '咸甜');
INSERT INTO `menu_tag` VALUES ('39', NULL, '扬州炒饭', '咸鲜');
INSERT INTO `menu_tag` VALUES ('4', NULL, '宫保鸡丁', '咸辣');
INSERT INTO `menu_tag` VALUES ('40', NULL, '炸藕片', '咸鲜');
INSERT INTO `menu_tag` VALUES ('41', NULL, '沙拉三明治', '清淡');
INSERT INTO `menu_tag` VALUES ('42', NULL, '水果沙拉', '清淡');
INSERT INTO `menu_tag` VALUES ('43', NULL, '咖喱鸡饭', '咸鲜');
INSERT INTO `menu_tag` VALUES ('44', NULL, '叉烧包', '咸鲜');
INSERT INTO `menu_tag` VALUES ('45', NULL, '扬州炖鸭', '咸鲜');
INSERT INTO `menu_tag` VALUES ('46', NULL, '西湖牛肉羹', '咸鲜');
INSERT INTO `menu_tag` VALUES ('47', NULL, '豆腐脑', '咸鲜');
INSERT INTO `menu_tag` VALUES ('48', NULL, '酸菜鱼', '酸辣');
INSERT INTO `menu_tag` VALUES ('49', NULL, '拉面', '咸鲜');
INSERT INTO `menu_tag` VALUES ('5', NULL, '红烧排骨', '咸鲜');
INSERT INTO `menu_tag` VALUES ('50', NULL, '醋溜木耳', '咸鲜');
INSERT INTO `menu_tag` VALUES ('51', NULL, '糖醋鲤鱼', '酸甜');
INSERT INTO `menu_tag` VALUES ('52', NULL, '铁板烧', '咸鲜');
INSERT INTO `menu_tag` VALUES ('53', NULL, '麻辣烫', '麻辣');
INSERT INTO `menu_tag` VALUES ('54', NULL, '虾仁炒饭', '咸鲜');
INSERT INTO `menu_tag` VALUES ('55', NULL, '红烧茄子', '咸鲜');
INSERT INTO `menu_tag` VALUES ('56', NULL, '花生鸡丁', '咸鲜');
INSERT INTO `menu_tag` VALUES ('57', NULL, '爆炒腰花', '咸鲜');
INSERT INTO `menu_tag` VALUES ('58', NULL, '烤鸭', '咸鲜');
INSERT INTO `menu_tag` VALUES ('59', NULL, '炒年糕', '咸鲜');
INSERT INTO `menu_tag` VALUES ('6', NULL, '酸辣土豆丝', '酸辣');
INSERT INTO `menu_tag` VALUES ('60', NULL, '姜葱蟹', '咸鲜');
INSERT INTO `menu_tag` VALUES ('61', NULL, '翅尖', '咸鲜');
INSERT INTO `menu_tag` VALUES ('62', NULL, '蒜蓉粉丝蒸扇贝', '咸鲜');
INSERT INTO `menu_tag` VALUES ('63', NULL, '蒜蓉生蚝', '咸鲜');
INSERT INTO `menu_tag` VALUES ('64', NULL, '美味海鲜粥', '咸鲜');
INSERT INTO `menu_tag` VALUES ('65', NULL, '黑椒蟹', '咸鲜');
INSERT INTO `menu_tag` VALUES ('66', NULL, '芝士焗大虾', '咸鲜');
INSERT INTO `menu_tag` VALUES ('67', NULL, '泡椒鱼头', '咸鲜');
INSERT INTO `menu_tag` VALUES ('68', NULL, '椒盐鸡翅', '咸鲜');
INSERT INTO `menu_tag` VALUES ('69', NULL, '红烧鲳鱼', '咸鲜');
INSERT INTO `menu_tag` VALUES ('7', NULL, '醋溜白菜', '酸辣');
INSERT INTO `menu_tag` VALUES ('70', NULL, '干锅包菜', '咸鲜');
INSERT INTO `menu_tag` VALUES ('71', NULL, '梅干菜扣肉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('72', NULL, '冰糖葫芦', '咸鲜');
INSERT INTO `menu_tag` VALUES ('73', NULL, '香煎鳕鱼', '咸鲜');
INSERT INTO `menu_tag` VALUES ('74', NULL, '炸鸡', '咸鲜');
INSERT INTO `menu_tag` VALUES ('75', NULL, '糖醋排骨', '咸鲜');
INSERT INTO `menu_tag` VALUES ('76', NULL, '古法煮鸡', '咸鲜');
INSERT INTO `menu_tag` VALUES ('77', NULL, '香辣蟹', '咸鲜');
INSERT INTO `menu_tag` VALUES ('78', NULL, '清蒸桂鱼', '咸鲜');
INSERT INTO `menu_tag` VALUES ('79', NULL, '糖醋黄瓜', '咸鲜');
INSERT INTO `menu_tag` VALUES ('8', NULL, '蒜蓉西兰花', '咸鲜');
INSERT INTO `menu_tag` VALUES ('80', NULL, '茭白炒肉丝', '咸鲜');
INSERT INTO `menu_tag` VALUES ('81', NULL, '青椒鸡块', '咸鲜');
INSERT INTO `menu_tag` VALUES ('82', NULL, '凉拌海蜇', '咸鲜');
INSERT INTO `menu_tag` VALUES ('83', NULL, '麻辣牛肉面', '咸鲜');
INSERT INTO `menu_tag` VALUES ('84', NULL, '老北京炸酱面', '咸鲜');
INSERT INTO `menu_tag` VALUES ('85', NULL, '酸辣粉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('86', NULL, '鱼香茄子', '咸鲜');
INSERT INTO `menu_tag` VALUES ('87', NULL, '茄汁蒸鲈鱼', '咸鲜');
INSERT INTO `menu_tag` VALUES ('88', NULL, '醋溜鲤鱼', '咸鲜');
INSERT INTO `menu_tag` VALUES ('89', NULL, '西红柿鸡蛋面', '咸鲜');
INSERT INTO `menu_tag` VALUES ('9', NULL, '孜然羊肉', '孜然');
INSERT INTO `menu_tag` VALUES ('90', NULL, '水煮肉片', '咸鲜');
INSERT INTO `menu_tag` VALUES ('91', NULL, '辣子鸡丁', '咸鲜');
INSERT INTO `menu_tag` VALUES ('92', NULL, '素炒四季豆', '咸鲜');
INSERT INTO `menu_tag` VALUES ('93', NULL, '葱油拌面', '咸鲜');
INSERT INTO `menu_tag` VALUES ('94', NULL, '清蒸鸡', '咸鲜');
INSERT INTO `menu_tag` VALUES ('95', NULL, '小炒肉', '咸鲜');
INSERT INTO `menu_tag` VALUES ('96', NULL, '干锅牛蛙', '咸鲜');
INSERT INTO `menu_tag` VALUES ('97', NULL, '香辣蟹煲', '咸鲜');
INSERT INTO `menu_tag` VALUES ('98', NULL, '爆炒腰花', '咸鲜');
INSERT INTO `menu_tag` VALUES ('99', NULL, '清炒时蔬', '咸鲜');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `FK_USER_BELONG2_USER_BAS`(`user_name` ASC) USING BTREE,
  CONSTRAINT `FK_USER_BELONG2_USER_BAS` FOREIGN KEY (`user_name`) REFERENCES `user_base` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('test_user', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base`  (
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_base
-- ----------------------------
INSERT INTO `user_base` VALUES ('test_user', '12345');

SET FOREIGN_KEY_CHECKS = 1;
