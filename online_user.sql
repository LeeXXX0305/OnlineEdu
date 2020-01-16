/*
Navicat MySQL Data Transfer

Source Server         : testRoot
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online_user

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-01-16 11:51:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_member
-- ----------------------------
DROP TABLE IF EXISTS `user_member`;
CREATE TABLE `user_member` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员表';

-- ----------------------------
-- Records of user_member
-- ----------------------------
INSERT INTO `user_member` VALUES ('1080736474191646722', null, '13700000000', '96e79218965eb72c92a549dd5a330112', '用户nVexScJJoi', '1', '20', null, null, '0', '0', '2019-01-01 12:11:33', '2019-01-12 11:00:22');
INSERT INTO `user_member` VALUES ('1080736474267144193', null, '13700000001', '96e79218965eb72c92a549dd5a330112', '用户XJtDfaYeKk', '1', '19', null, null, '0', '0', '2019-01-02 12:12:45', '2019-01-02 12:12:56');
INSERT INTO `user_member` VALUES ('1080736474355224577', null, '13700000002', '96e79218965eb72c92a549dd5a330112', '用户wUrNkzAPrc', '1', '27', null, null, '0', '0', '2019-01-02 12:13:56', '2019-01-02 12:14:07');
INSERT INTO `user_member` VALUES ('1086387099449442306', null, '13520191388', '96e79218965eb72c92a549dd5a330112', '用户XTMUeHDAoj', '2', '20', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user_member` VALUES ('1086387099520745473', null, '13520191389', '96e79218965eb72c92a549dd5a330112', '用户vSdKeDlimn', '1', '21', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user_member` VALUES ('1086387099608825858', null, '13520191381', '96e79218965eb72c92a549dd5a330112', '用户EoyWUVXQoP', '1', '18', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user_member` VALUES ('1086387099701100545', null, '13520191382', '96e79218965eb72c92a549dd5a330112', '用户LcAYbxLNdN', '2', '24', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user_member` VALUES ('1086387099776598018', null, '13520191383', '96e79218965eb72c92a549dd5a330112', '用户dZdjcgltnk', '2', '25', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user_member` VALUES ('1086387099852095490', null, '13520191384', '96e79218965eb72c92a549dd5a330112', '用户wNHGHlxUwX', '2', '23', null, null, '0', '0', '2019-01-19 06:17:23', '2019-01-19 06:17:23');

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` varchar(80) NOT NULL,
  `user_id` varchar(80) NOT NULL,
  `create_time` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES ('1216660669621915650', '1', '2020-01-15 20:03:06', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1NzkwODk3ODUsImV4cCI6MTU3OTY5NDU4NSwianRpIjoiMSIsInN1YiI6ImFkbWluIiwiaXNzIjoibGVvcGFyZCJ9.5P5vAZko2kfJo8JuqET_ih3esn9KfyaSgfAxA66eKWEbvyx6g5ImB7SOK14DgA9GDqVmqBNY301e3KSl6cDp2Q');
INSERT INTO `user_token` VALUES ('1217356705516494849', '2', '2020-01-15 20:03:26', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1NzkwODk4MDYsImV4cCI6MTU3OTY5NDYwNiwianRpIjoiMiIsInN1YiI6ImtrayIsImlzcyI6Imxlb3BhcmQifQ.LRoymKpoj3NdaK1SN7iAzNY94zns7NG6VGv6vdz7qRDohJlcvQTL0ckFpQOPWQ9e1hL5qU8pXwV1sAMGJJ0AMQ');
