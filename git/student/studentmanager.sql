/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : studentmanager

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2017-06-30 11:16:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `st_course`
-- ----------------------------
DROP TABLE IF EXISTS `st_course`;
CREATE TABLE `st_course` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `ispublic` varchar(1) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `credit` varchar(10) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `start` varchar(5) NOT NULL,
  `end` varchar(5) NOT NULL,
  `place` varchar(30) NOT NULL,
  `studentnum` int(11) NOT NULL,
  `realnum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_course
-- ----------------------------
INSERT INTO `st_course` VALUES ('149837947755181', 'java', '1', null, '1.5', '张', '1', '17', 'J7 103', '2', '2');
INSERT INTO `st_course` VALUES ('149837951359909', '软件工程', '0', '计算机科学与技术', '1', '王', '1', '9', 'J7 104', '2', '0');
INSERT INTO `st_course` VALUES ('149837954239248', 'C#', '0', '软件工程', '1.5', '孙', '1', '9', 'J7 121', '2', '0');

-- ----------------------------
-- Table structure for `st_grade`
-- ----------------------------
DROP TABLE IF EXISTS `st_grade`;
CREATE TABLE `st_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseid` bigint(20) NOT NULL,
  `number` varchar(15) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_grade
-- ----------------------------
INSERT INTO `st_grade` VALUES ('2', '149837947755181', '201401060213', '70');
INSERT INTO `st_grade` VALUES ('3', '149837947755181', '201401060201', '75');

-- ----------------------------
-- Table structure for `st_info`
-- ----------------------------
DROP TABLE IF EXISTS `st_info`;
CREATE TABLE `st_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `identity` varchar(18) NOT NULL,
  `nation` varchar(10) NOT NULL,
  `session` varchar(4) NOT NULL,
  `major` varchar(30) NOT NULL,
  `classes` varchar(2) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `graduated` varchar(1) NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_info
-- ----------------------------
INSERT INTO `st_info` VALUES ('9', '201401060213', '刘威', '1', '370724199510104000', '汉族', '2014', '计算机科学与技术', '2', '17854257959', '0', '2017-06-12 16:22:45');
INSERT INTO `st_info` VALUES ('10', '201401060201', '学生1', '1', '370724199510104330', '汉族', '2014', '软件工程', '1', '17854257951', '0', '2017-06-26 06:28:28');
INSERT INTO `st_info` VALUES ('11', '201401060202', '学生2', '0', '370724199510104331', '汉族', '2015', '数字媒体', '2', '17854257959', '0', '2017-06-26 06:29:34');

-- ----------------------------
-- Table structure for `st_option`
-- ----------------------------
DROP TABLE IF EXISTS `st_option`;
CREATE TABLE `st_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(15) NOT NULL,
  `courses` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_option
-- ----------------------------
INSERT INTO `st_option` VALUES ('1', '201401060213', ',149837947755181');
INSERT INTO `st_option` VALUES ('2', '201401060201', '149837947755181');
INSERT INTO `st_option` VALUES ('3', '201401060202', null);

-- ----------------------------
-- Table structure for `st_user`
-- ----------------------------
DROP TABLE IF EXISTS `st_user`;
CREATE TABLE `st_user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  `password` varchar(40) NOT NULL,
  `isteacher` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_user
-- ----------------------------
INSERT INTO `st_user` VALUES ('10', '201401060213', 'f62166264c2cbdc85871dc22ee44bec3', '0');
INSERT INTO `st_user` VALUES ('94', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1');
INSERT INTO `st_user` VALUES ('95', '201401060201', 'f62166264c2cbdc85871dc22ee44bec3', '0');
INSERT INTO `st_user` VALUES ('96', '201401060202', 'f62166264c2cbdc85871dc22ee44bec3', '0');
