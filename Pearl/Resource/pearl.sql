/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : pearl

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-02 11:21:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datacollection
-- ----------------------------
DROP TABLE IF EXISTS `datacollection`;
CREATE TABLE `datacollection` (
  `dataCollection_id` int(10) NOT NULL AUTO_INCREMENT,
  `dataCollection_date` date DEFAULT NULL,
  `dataCollection_time` time DEFAULT NULL,
  `dataCollection_salinity` float(10,4) DEFAULT NULL,
  `dataCollection_nitrite` float(10,4) DEFAULT NULL,
  `dataCollection_nitrogen` float(10,4) DEFAULT NULL,
  `dataCollection_o` float(10,4) DEFAULT NULL,
  `dataCollection_ph` float(10,4) DEFAULT NULL,
  `dataCollection_temperature` float(10,4) DEFAULT NULL,
  `dataCollection_waterdepth` float(10,4) DEFAULT NULL,
  PRIMARY KEY (`dataCollection_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����ռ�����';

-- ----------------------------
-- Records of datacollection
-- ----------------------------

-- ----------------------------
-- Table structure for disease
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `disease_id` int(20) NOT NULL AUTO_INCREMENT,
  `disease_name` varchar(20) DEFAULT NULL,
  `disease_pathogeny` longtext,
  `disease_symptom` longtext,
  `disease_cure` longtext,
  PRIMARY KEY (`disease_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------

-- ----------------------------
-- Table structure for employ_information
-- ----------------------------
DROP TABLE IF EXISTS `employ_information`;
CREATE TABLE `employ_information` (
  `employ_information_id` int(10) NOT NULL AUTO_INCREMENT,
  `employ_information_content` longtext,
  `farmeruser_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`employ_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employ_information
-- ----------------------------

-- ----------------------------
-- Table structure for expert
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `expert_id` int(10) NOT NULL AUTO_INCREMENT,
  `expert_name` varchar(20) DEFAULT NULL,
  `expert_sex` varchar(2) DEFAULT NULL,
  ` expert_phone` varchar(20) DEFAULT NULL,
  `expert_qq` varchar(20) DEFAULT NULL,
  `expert_job` varchar(20) DEFAULT NULL,
  `expert_jobarea` varchar(20) DEFAULT NULL,
  `expert_jobpalace` varchar(40) DEFAULT NULL,
  `expeert_honor` varchar(100) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`expert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert
-- ----------------------------

-- ----------------------------
-- Table structure for expert_application
-- ----------------------------
DROP TABLE IF EXISTS `expert_application`;
CREATE TABLE `expert_application` (
  `application_id` int(10) NOT NULL AUTO_INCREMENT,
  `expert_name` varchar(20) DEFAULT NULL,
  `expert_sex` varchar(2) DEFAULT NULL,
  `expert_phone` varchar(20) DEFAULT NULL,
  `expert_qq` varchar(20) DEFAULT NULL,
  `expert_job` varchar(20) DEFAULT NULL,
  `expert_jobarea` varchar(20) DEFAULT NULL,
  `expert_jobpalace` varchar(40) DEFAULT NULL,
  `expeert_honor` varchar(100) DEFAULT NULL,
  `application_ishandle` int(2) DEFAULT NULL,
  `application_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert_application
-- ----------------------------

-- ----------------------------
-- Table structure for expert_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `expert_evaluate`;
CREATE TABLE `expert_evaluate` (
  `expert_evaluate_id` int(10) NOT NULL AUTO_INCREMENT,
  `expert_evaluate_expertid` int(10) DEFAULT NULL,
  `expert_evaluate_point` int(2) DEFAULT NULL,
  PRIMARY KEY (`expert_evaluate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for farmer
-- ----------------------------
DROP TABLE IF EXISTS `farmer`;
CREATE TABLE `farmer` (
  `farmer_id` int(10) NOT NULL,
  `farmer_name` varchar(40) DEFAULT NULL,
  `farmer_pass` varchar(20) DEFAULT NULL,
  `farmer_company` varchar(20) DEFAULT NULL,
  `farmer_phone` varchar(20) DEFAULT NULL,
  `farmer_address` varchar(60) DEFAULT NULL,
  `farmer_email` varchar(20) DEFAULT NULL,
  `farmer_registertime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`farmer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmer
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(20) NOT NULL AUTO_INCREMENT,
  `file_title` varchar(40) DEFAULT NULL,
  `file_resource` varchar(40) DEFAULT NULL,
  `file_size` int(20) DEFAULT NULL,
  `file_path` varchar(40) DEFAULT NULL,
  `file_readcount` int(10) DEFAULT NULL,
  `file_downloadcount` int(10) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for filecomment
-- ----------------------------
DROP TABLE IF EXISTS `filecomment`;
CREATE TABLE `filecomment` (
  `filecomment_id` int(10) NOT NULL AUTO_INCREMENT,
  `filecomment_content` varchar(200) DEFAULT NULL,
  `filecomment_starcount` int(2) DEFAULT NULL,
  `filecomment_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(10) DEFAULT NULL,
  `file_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`filecomment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filecomment
-- ----------------------------

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movie_id` int(20) NOT NULL AUTO_INCREMENT,
  `movie_title` varchar(40) DEFAULT NULL,
  `movie_resoure` varchar(20) DEFAULT NULL,
  `movie_picturepath` varchar(40) DEFAULT NULL,
  `movie_size` varchar(10) DEFAULT NULL,
  `movie_path` varchar(40) DEFAULT NULL,
  `movie_playnumber` int(10) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------

-- ----------------------------
-- Table structure for moviecomment
-- ----------------------------
DROP TABLE IF EXISTS `moviecomment`;
CREATE TABLE `moviecomment` (
  `moviecomment_id` int(10) NOT NULL AUTO_INCREMENT,
  `moviecomment_content` varchar(250) DEFAULT NULL,
  `moviecomment_starcount` int(5) DEFAULT NULL,
  `moviecomment_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(20) DEFAULT NULL,
  `movie_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`moviecomment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moviecomment
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(40) DEFAULT NULL,
  `news_from` varchar(20) DEFAULT NULL,
  `news_author` varchar(10) DEFAULT NULL,
  `news_content` longtext,
  `news_clicknum` int(10) DEFAULT NULL,
  `news_createtime` timestamp NULL DEFAULT NULL,
  `news_lastupdatetime` timestamp NULL DEFAULT NULL,
  `news_category_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for news_category
-- ----------------------------
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE `news_category` (
  `news_category_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_category_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`news_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_category
-- ----------------------------

-- ----------------------------
-- Table structure for news_temporary
-- ----------------------------
DROP TABLE IF EXISTS `news_temporary`;
CREATE TABLE `news_temporary` (
  `news_temporary_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_temporary_title` varchar(40) DEFAULT NULL,
  `news_temporary_from` varchar(10) DEFAULT NULL,
  `news_temporary_author` varchar(10) DEFAULT NULL,
  `news_temporary_content` longtext,
  `news_temporary_createtime` timestamp NULL DEFAULT NULL,
  `news_temporary_lastupdatetime` timestamp NULL DEFAULT NULL,
  `news_temporary_categoryID` int(10) NOT NULL,
  PRIMARY KEY (`news_temporary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���ŵ���ʱ������ڴ���δ����������';

-- ----------------------------
-- Records of news_temporary
-- ----------------------------

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_name` varchar(10) DEFAULT NULL,
  `parameter_min` float(10,4) DEFAULT NULL,
  `parameter_max` float(10,4) DEFAULT NULL,
  `parameter_minharm` longtext,
  `parameter_minmeasure` longtext,
  `parameter_maxharm` longtext,
  `parameter_maxmeasure` longtext,
  PRIMARY KEY (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ԥ�����ˮ�ʵĸ������ָ��';

-- ----------------------------
-- Records of parameter
-- ----------------------------

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` int(10) NOT NULL AUTO_INCREMENT,
  `photo_path` varchar(40) DEFAULT NULL,
  `photegallery_ID` int(11) DEFAULT NULL,
  `photo_index` int(5) DEFAULT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ͼƬ����ϸ��Ϣ';

-- ----------------------------
-- Records of photo
-- ----------------------------

-- ----------------------------
-- Table structure for photogallery
-- ----------------------------
DROP TABLE IF EXISTS `photogallery`;
CREATE TABLE `photogallery` (
  `photogallery_id` int(10) NOT NULL AUTO_INCREMENT,
  `photogallery_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`photogallery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ͼƬ��������';

-- ----------------------------
-- Records of photogallery
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(10) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(20) DEFAULT NULL,
  `post_userid` int(11) DEFAULT NULL,
  `post_time` timestamp NULL DEFAULT NULL,
  `istop` int(2) DEFAULT '0',
  `post_toptime` timestamp NULL DEFAULT NULL,
  `post_status` int(2) DEFAULT '0',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for post_collected
-- ----------------------------
DROP TABLE IF EXISTS `post_collected`;
CREATE TABLE `post_collected` (
  `post_collected_id` int(10) NOT NULL AUTO_INCREMENT,
  `post_collected_postid` int(10) DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`post_collected_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_collected
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_type` int(2) DEFAULT NULL,
  `reply_userid` int(11) DEFAULT NULL,
  `reply_time` timestamp NULL DEFAULT NULL,
  `reply_postid` int(11) DEFAULT NULL,
  `reply_content` longtext,
  `reply_isread` int(2) DEFAULT '0',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for second_reply
-- ----------------------------
DROP TABLE IF EXISTS `second_reply`;
CREATE TABLE `second_reply` (
  `second_reply_id` int(10) NOT NULL AUTO_INCREMENT,
  `second_reply_type` int(2) DEFAULT NULL,
  `second_reply_userid` int(11) DEFAULT NULL,
  `second_reply_time` timestamp NULL DEFAULT NULL,
  `second_reply_replyid` int(10) DEFAULT NULL,
  `second_reply_content` longtext,
  `second_reply_isread` int(2) DEFAULT '0',
  PRIMARY KEY (`second_reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_reply
-- ----------------------------

-- ----------------------------
-- Table structure for superuser
-- ----------------------------
DROP TABLE IF EXISTS `superuser`;
CREATE TABLE `superuser` (
  `super_id` int(10) NOT NULL AUTO_INCREMENT,
  `super_name` varchar(20) DEFAULT NULL,
  `super_pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`super_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superuser
-- ----------------------------

-- ----------------------------
-- Table structure for symptom
-- ----------------------------
DROP TABLE IF EXISTS `symptom`;
CREATE TABLE `symptom` (
  `symptom_id` int(10) NOT NULL AUTO_INCREMENT,
  `symptom_name` varchar(40) DEFAULT NULL,
  `symptom_photo` varchar(40) DEFAULT NULL,
  `symptomGroup_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`symptom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptom
-- ----------------------------

-- ----------------------------
-- Table structure for symptomgroup
-- ----------------------------
DROP TABLE IF EXISTS `symptomgroup`;
CREATE TABLE `symptomgroup` (
  `symptomGroup_id` int(3) NOT NULL AUTO_INCREMENT,
  `symptomGroup_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`symptomGroup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptomgroup
-- ----------------------------

-- ----------------------------
-- Table structure for symptompower
-- ----------------------------
DROP TABLE IF EXISTS `symptompower`;
CREATE TABLE `symptompower` (
  `symptompower_id` int(10) NOT NULL AUTO_INCREMENT,
  `symptom_id` int(10) DEFAULT NULL,
  `disease_id` int(10) DEFAULT NULL,
  `symptompower` int(2) DEFAULT NULL,
  PRIMARY KEY (`symptompower_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptompower
-- ----------------------------

-- ----------------------------
-- Table structure for symptomsmap
-- ----------------------------
DROP TABLE IF EXISTS `symptomsmap`;
CREATE TABLE `symptomsmap` (
  `symptomsMap_id` int(10) NOT NULL AUTO_INCREMENT,
  `symptomsMap_title` varchar(40) DEFAULT NULL,
  `symptomsMap_picture` varchar(40) DEFAULT NULL,
  `disease_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`symptomsMap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of symptomsmap
-- ----------------------------

-- ----------------------------
-- Table structure for system_message
-- ----------------------------
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE `system_message` (
  `system_message_id` int(11) NOT NULL AUTO_INCREMENT,
  `system_message_content` longtext,
  `userid` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT '1',
  PRIMARY KEY (`system_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_message
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) DEFAULT NULL,
  `user_pass` varchar(20) DEFAULT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_ismanager` int(5) DEFAULT NULL,
  `user_level` varchar(10) DEFAULT NULL,
  `user_imagepath` varchar(40) DEFAULT NULL,
  `user_isstopspeak` int(5) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for warn_message
-- ----------------------------
DROP TABLE IF EXISTS `warn_message`;
CREATE TABLE `warn_message` (
  `warn_message_id` int(10) NOT NULL AUTO_INCREMENT,
  `warn_message_content` longtext,
  `farmeruser_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`warn_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warn_message
-- ----------------------------

select this_.parameter_id as y0_, this_.parameter_name as y1_, this_.parameter_min as y2_, this_.parameter_max as y3_ from pearl.parameter this_ inner join pearl.farmer farmer1_ on this_.parameter_farmerID=farmer1_.farmer_id where farmer1_.farmer_id=4