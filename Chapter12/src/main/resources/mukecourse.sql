/*
Navicat MySQL Data Transfer

Source Server         : cjj
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : mukecourse

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-06 20:31:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `addusercase`
-- ----------------------------
DROP TABLE IF EXISTS `addusercase`;
CREATE TABLE `addusercase` (
  `id` int(11) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `isDelete` varchar(100) DEFAULT NULL,
  `expected` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addusercase
-- ----------------------------
INSERT INTO `addusercase` VALUES ('1', 'Jack', '123456', 'man', '22', '0', '0', 'true');

-- ----------------------------
-- Table structure for `getuserinfocase`
-- ----------------------------
DROP TABLE IF EXISTS `getuserinfocase`;
CREATE TABLE `getuserinfocase` (
  `userId` int(11) DEFAULT NULL,
  `expected` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getuserinfocase
-- ----------------------------
INSERT INTO `getuserinfocase` VALUES ('1', 'true', '1');

-- ----------------------------
-- Table structure for `getuserlistcase`
-- ----------------------------
DROP TABLE IF EXISTS `getuserlistcase`;
CREATE TABLE `getuserlistcase` (
  `id` int(11) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `expected` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of getuserlistcase
-- ----------------------------
INSERT INTO `getuserlistcase` VALUES ('1', '', '', 'man', 'true');
INSERT INTO `getuserlistcase` VALUES ('2', '', '22', '', 'true');

-- ----------------------------
-- Table structure for `logincase`
-- ----------------------------
DROP TABLE IF EXISTS `logincase`;
CREATE TABLE `logincase` (
  `id` int(11) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `expected` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logincase
-- ----------------------------
INSERT INTO `logincase` VALUES ('4', 'cheng4', '123456', 'true');
INSERT INTO `logincase` VALUES ('3', 'cheng', '000000', 'false');
INSERT INTO `logincase` VALUES ('1', 'cheng', '123456', 'true');
INSERT INTO `logincase` VALUES ('2', 'aa', '123456', 'false');

-- ----------------------------
-- Table structure for `updateuserinfocase`
-- ----------------------------
DROP TABLE IF EXISTS `updateuserinfocase`;
CREATE TABLE `updateuserinfocase` (
  `id` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `isDelete` varchar(100) DEFAULT NULL,
  `expected` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of updateuserinfocase
-- ----------------------------
INSERT INTO `updateuserinfocase` VALUES ('1', '3', 'new1122name', 'women', '66', '0', '0', 'true');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `isDelete` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'cheng', 'man', '22', '123456', '0', '0');
INSERT INTO `user` VALUES ('2', 'liudehua2', 'man', '40', '123', '0', '0');
INSERT INTO `user` VALUES ('3', 'new11name', 'women', '66', '123', '0', '0');
INSERT INTO `user` VALUES ('41', 'Jack', 'man', '22', '123456', '0', '0');
