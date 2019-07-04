/*
Navicat MySQL Data Transfer

Source Server         : 喵喵喵
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : sbeam

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-07-04 09:33:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `flag` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `speak_id` varchar(100) NOT NULL COMMENT '评论消息或评论的id',
  `user_id` int(10) NOT NULL COMMENT '评论的用户id',
  `content` text NOT NULL COMMENT '评论的内容',
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1:', '1', '2', '2019-07-03 16:02:31');
INSERT INTO `comment` VALUES ('2', '2', '1', '222', '2019-07-03 14:17:18');
INSERT INTO `comment` VALUES ('3', '1:1242107668', '1', '喵喵喵', '2019-07-03 14:17:22');

-- ----------------------------
-- Table structure for gamedeveloper_info
-- ----------------------------
DROP TABLE IF EXISTS `gamedeveloper_info`;
CREATE TABLE `gamedeveloper_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `developername` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `released_game` text COMMENT '已发布游戏',
  `debug_game` text COMMENT '审核中的游戏',
  `message_ids` text COMMENT '发布的消息的id',
  `alipay_id` varchar(30) DEFAULT NULL COMMENT '支付宝账户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamedeveloper_info
-- ----------------------------
INSERT INTO `gamedeveloper_info` VALUES ('1', '1', '1', '1', null, '1', '1');

-- ----------------------------
-- Table structure for gamer_friends
-- ----------------------------
DROP TABLE IF EXISTS `gamer_friends`;
CREATE TABLE `gamer_friends` (
  `gamer_id` int(10) NOT NULL AUTO_INCREMENT,
  `friend_id` varchar(200) DEFAULT NULL COMMENT '好友的id',
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `qq` varchar(40) DEFAULT NULL,
  `have_games` varchar(100) DEFAULT NULL COMMENT '已拥有的游戏',
  `wish_list` varchar(100) DEFAULT NULL COMMENT '愿望单里的游戏',
  `like_class` varchar(100) DEFAULT NULL COMMENT '喜欢的类型',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(10) DEFAULT NULL COMMENT '年龄 根据用户年龄推荐R18游戏',
  `flag` int(10) NOT NULL DEFAULT '1' COMMENT '代表这个玩家有没有被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamer_info
-- ----------------------------
INSERT INTO `gamer_info` VALUES ('1', '111', '111', '1@qq.com', null, '111', null, '3', null, '2019-07-01', '18', '1');

-- ----------------------------
-- Table structure for gamer_speak
-- ----------------------------
DROP TABLE IF EXISTS `gamer_speak`;
CREATE TABLE `gamer_speak` (
  `gamer_id` int(10) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(200) DEFAULT NULL COMMENT '该用户评论过的消息',
  `comment_id` varchar(200) DEFAULT NULL COMMENT '该用户评论过的评论',
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gamename` varchar(20) NOT NULL,
  `original_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '原价',
  `now_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '现在价钱',
  `lowest_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '史低',
  `discount` double(100,2) NOT NULL DEFAULT '1.00' COMMENT '当前折扣',
  `type` set('动作','设计','休闲','体育','冒险','大型多人在线','独立','角色扮演','竞速','沙盒','第三人称','色情','裸露','血腥','暴力') NOT NULL COMMENT '游戏类型',
  `intro` text COMMENT '简介',
  `file_path` varchar(50) NOT NULL COMMENT '游戏文件的路径',
  `img_path` varchar(50) DEFAULT NULL COMMENT '游戏图片的路径',
  `developer` varchar(50) NOT NULL COMMENT '开发商',
  `sales` int(100) NOT NULL DEFAULT '0' COMMENT '销量',
  `about_topicid` varchar(200) DEFAULT NULL COMMENT '该游戏的评论',
  `flag` int(100) NOT NULL DEFAULT '0' COMMENT '0表示审核中游戏，1表示上架的游戏，2表示下架的游戏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game_info
-- ----------------------------
INSERT INTO `game_info` VALUES ('1', '1', '1', '1', '1', '0.20', '动作', null, '1', '1', '1', '0', '1:', '1');
INSERT INTO `game_info` VALUES ('2', '2', '2', '2', '2', '1.00', '动作', null, '2', '2', '2', '0', '2:', '1');

-- ----------------------------
-- Table structure for game_type
-- ----------------------------
DROP TABLE IF EXISTS `game_type`;
CREATE TABLE `game_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  `games` varchar(2000) DEFAULT NULL COMMENT '这一类型的游戏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game_type
-- ----------------------------
INSERT INTO `game_type` VALUES ('1', '动作', null);
INSERT INTO `game_type` VALUES ('2', '射击', null);
INSERT INTO `game_type` VALUES ('3', '休闲', null);
INSERT INTO `game_type` VALUES ('4', '体育', null);
INSERT INTO `game_type` VALUES ('5', '冒险', null);
INSERT INTO `game_type` VALUES ('6', '大型多人在线', null);
INSERT INTO `game_type` VALUES ('7', '独立', null);
INSERT INTO `game_type` VALUES ('8', '角色扮演', null);
INSERT INTO `game_type` VALUES ('9', '策略', null);
INSERT INTO `game_type` VALUES ('10', '竞速', null);
INSERT INTO `game_type` VALUES ('11', '沙盒', null);
INSERT INTO `game_type` VALUES ('12', '第三人称', null);
INSERT INTO `game_type` VALUES ('13', '色情', null);
INSERT INTO `game_type` VALUES ('14', '裸露', null);
INSERT INTO `game_type` VALUES ('15', '血猩', null);
INSERT INTO `game_type` VALUES ('16', '暴力', null);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `topic_id` varchar(200) NOT NULL,
  `topic_name` varchar(100) NOT NULL,
  `topic_type` varchar(50) NOT NULL COMMENT '主题类型',
  `related_img` varchar(50) DEFAULT NULL COMMENT '相关图片的路径',
  `message` varchar(1000) DEFAULT NULL COMMENT '发布的消息',
  `form_uid` varchar(200) DEFAULT NULL COMMENT '评论的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('2', '1', '1', '游戏评论', '1', '1', '1');
INSERT INTO `message` VALUES ('23', '1:1242208590', '1的评论', '游戏评论', null, null, null);
INSERT INTO `message` VALUES ('24', '1:1242107668', '1的评论', '游戏评论', null, null, null);

-- ----------------------------
-- Table structure for message_type
-- ----------------------------
DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(30) NOT NULL,
  `message_id` varchar(200) DEFAULT NULL COMMENT '这一类型的消息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_type
-- ----------------------------
INSERT INTO `message_type` VALUES ('1', '游戏评论', null);
INSERT INTO `message_type` VALUES ('2', '评论回复', null);
INSERT INTO `message_type` VALUES ('3', '消息回复', null);
INSERT INTO `message_type` VALUES ('4', '对话消息', null);
INSERT INTO `message_type` VALUES ('5', '厂商消息', null);
