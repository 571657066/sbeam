/*
Navicat MySQL Data Transfer

Source Server         : 喵喵喵
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : sbeam

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-06-29 15:14:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` int(10) NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `flag` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) NOT NULL,
  `speak_id` int(10) NOT NULL COMMENT '评论消息或评论的id',
  `user_id` int(10) NOT NULL COMMENT '评论的用户id',
  `content` varchar(1000) NOT NULL COMMENT '评论的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for gamedeveloper_info
-- ----------------------------
DROP TABLE IF EXISTS `gamedeveloper_info`;
CREATE TABLE `gamedeveloper_info` (
  `id` int(10) NOT NULL,
  `developername` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `released_game` set('') DEFAULT NULL COMMENT '已发布游戏',
  `debug_game` set('') DEFAULT NULL COMMENT '审核中的游戏',
  `message_ids` set('') DEFAULT NULL,
  `alipay_id` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamedeveloper_info
-- ----------------------------

-- ----------------------------
-- Table structure for gamer_friends
-- ----------------------------
DROP TABLE IF EXISTS `gamer_friends`;
CREATE TABLE `gamer_friends` (
  `gamer_id` int(10) NOT NULL,
  `friend_id` set('') DEFAULT NULL COMMENT '好友的id',
  PRIMARY KEY (`gamer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamer_friends
-- ----------------------------

-- ----------------------------
-- Table structure for gamer_info
-- ----------------------------
DROP TABLE IF EXISTS `gamer_info`;
CREATE TABLE `gamer_info` (
  `id` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `qq` varchar(40) DEFAULT NULL,
  `have_games` set('') DEFAULT NULL COMMENT '已拥有的游戏',
  `wish_list` set('') DEFAULT NULL COMMENT '愿望单里的游戏',
  `like_class` set('') DEFAULT NULL COMMENT '喜欢的类型',
  `age` int(10) NOT NULL COMMENT '年龄 根据用户年龄推荐R18游戏',
  `flag` int(10) NOT NULL DEFAULT '1' COMMENT '代表这个玩家有没有被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamer_info
-- ----------------------------

-- ----------------------------
-- Table structure for gamer_speak
-- ----------------------------
DROP TABLE IF EXISTS `gamer_speak`;
CREATE TABLE `gamer_speak` (
  `gamer_id` int(10) NOT NULL,
  `message_id` set('') DEFAULT NULL COMMENT '该用户评论过的消息',
  `comment_id` set('') DEFAULT NULL COMMENT '该用户评论过的评论',
  PRIMARY KEY (`gamer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamer_speak
-- ----------------------------

-- ----------------------------
-- Table structure for game_info
-- ----------------------------
DROP TABLE IF EXISTS `game_info`;
CREATE TABLE `game_info` (
  `id` int(10) NOT NULL,
  `gamename` varchar(20) NOT NULL,
  `original_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '原价',
  `now_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '现在价钱',
  `lowest_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '史低',
  `discount` double(10,0) NOT NULL DEFAULT '1' COMMENT '当前折扣',
  `class` set('') NOT NULL COMMENT '游戏类型',
  `desc` varchar(1000) DEFAULT NULL COMMENT '简介',
  `file_path` varchar(50) NOT NULL COMMENT '游戏文件的路径',
  `img_path` varchar(50) DEFAULT NULL COMMENT '游戏图片的路径',
  `developer` varchar(50) NOT NULL COMMENT '开发商',
  `sales` int(100) NOT NULL DEFAULT '0' COMMENT '销量',
  `flag` int(10) NOT NULL DEFAULT '0' COMMENT '0表示审核中游戏，1表示上架的游戏，2表示下架的游戏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game_info
-- ----------------------------

-- ----------------------------
-- Table structure for game_type
-- ----------------------------
DROP TABLE IF EXISTS `game_type`;
CREATE TABLE `game_type` (
  `id` int(10) NOT NULL,
  `type_name` varchar(20) NOT NULL,
  `games` set('') DEFAULT NULL COMMENT '这一类型的游戏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game_type
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) NOT NULL,
  `topic_id` int(10) NOT NULL COMMENT '主题id',
  `topic_type` varchar(50) NOT NULL COMMENT '主题类型',
  `related_img` varchar(50) DEFAULT NULL COMMENT '相关图片的路径',
  `message` varchar(1000) NOT NULL COMMENT '发布的消息',
  `form_uid` set('') DEFAULT NULL COMMENT '评论的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for message_type
-- ----------------------------
DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type` (
  `id` int(10) NOT NULL,
  `type_name` varchar(30) NOT NULL,
  `message_id` set('') DEFAULT NULL COMMENT '这一类型的消息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_type
-- ----------------------------
