/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : mj-mall-member

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-01-01 10:02:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_name` varchar(255) DEFAULT NULL COMMENT '会员姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `address` varchar(255) DEFAULT NULL COMMENT '所在地',
  `position` varchar(255) DEFAULT NULL COMMENT '职业',
  `headimg` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `is_delete` tinyint(255) DEFAULT NULL COMMENT '是否删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `bak1` varchar(1024) DEFAULT NULL,
  `bak2` varchar(1024) DEFAULT NULL,
  `bak3` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
