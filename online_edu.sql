/*
Navicat MySQL Data Transfer

Source Server         : testRoot
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online_edu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-01-16 11:51:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1', '14', '第一章：HTML', '0', '2019-01-01 12:27:40', '2019-01-01 12:55:30');
INSERT INTO `edu_chapter` VALUES ('1209398830831816705', '1207993571169333250', 'aa', '1', '2019-12-24 17:02:05', '2019-12-24 17:02:05');
INSERT INTO `edu_chapter` VALUES ('1209398932518522882', '1207993571169333250', 'fgggh', '2', '2019-12-24 17:02:30', '2019-12-24 17:02:30');
INSERT INTO `edu_chapter` VALUES ('1209403438731927554', '1209403404653207554', 'fgfgh', '1', '2019-12-24 17:20:24', '2019-12-24 17:20:24');
INSERT INTO `edu_chapter` VALUES ('1209403537520369666', '1209403404653207554', 'dfbdnn', '2', '2019-12-24 17:20:48', '2019-12-24 17:20:48');
INSERT INTO `edu_chapter` VALUES ('1209739988791574530', '1207992937657462786', 'q', '1', '2019-12-25 15:37:44', '2019-12-25 15:37:44');
INSERT INTO `edu_chapter` VALUES ('1209740004385996801', '1207992937657462786', 'w', '0', '2019-12-25 15:37:48', '2019-12-25 15:37:48');
INSERT INTO `edu_chapter` VALUES ('1209740020727005186', '1207992937657462786', 'e', '0', '2019-12-25 15:37:51', '2019-12-25 15:37:51');
INSERT INTO `edu_chapter` VALUES ('1209740038099812354', '1207992937657462786', 'r', '0', '2019-12-25 15:37:56', '2019-12-25 15:37:56');
INSERT INTO `edu_chapter` VALUES ('15', '18', '第一章：Java入门', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('3', '14', '第二章：CSS', '0', '2019-01-01 12:55:35', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('32', '18', '第二章：控制台输入和输出', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('44', '18', '第三章：控制流', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('48', '18', '第四章：类的定义', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('63', '18', '第五章：数组', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('64', '18', '第六章：继承', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('65', '18', '第七章：多态性和抽象类', '0', '2019-01-01 12:27:40', '2019-01-01 12:27:40');

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程';

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('10', '1', '1101348944971091969', '1101348944920760321', '零基础入门学习Python课程学习', '1.0000', '10', 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/06/866e9aca-b530-4f71-a690-72d4a4bfd1e7.jpg', '80', '165', '21', 'Normal', '2018-03-26 00:00:28', '2019-02-21 20:46:36');
INSERT INTO `edu_course` VALUES ('1207948954327662594', 'string', 'string', 'string', 'string', '0.0000', '0', 'string', '0', '0', '1', 'Draft', '2019-12-20 17:00:48', '2019-12-20 17:00:48');
INSERT INTO `edu_course` VALUES ('1207952664189493249', '', '', '', 'springboot学习', '100.0000', '5', '', '0', '0', '1', 'Draft', '2019-12-20 17:15:32', '2019-12-20 17:15:32');
INSERT INTO `edu_course` VALUES ('1207986815269662721', 'string', 'string', 'string', 'string', '0.0000', '0', 'string', '0', '0', '1', 'Draft', '2019-12-20 19:31:15', '2019-12-20 19:31:15');
INSERT INTO `edu_course` VALUES ('1207989324210040833', '10', '1101348944971091969', '1101348944920760321', 'springboot学习', '100.0000', '10', '', '0', '0', '1', 'Draft', '2019-12-20 19:41:13', '2019-12-20 19:41:13');
INSERT INTO `edu_course` VALUES ('1207989877417766914', '4', '1101348944971091969', '1101348944920760321', 'java学习', '200.0000', '5', '', '0', '0', '1', 'Draft', '2019-12-20 19:43:25', '2019-12-20 19:43:25');
INSERT INTO `edu_course` VALUES ('1207991080881025026', '6', '1101348945411493889', '1101348945352773634', 'docker', '1.0000', '1', '', '0', '0', '1', 'Draft', '2019-12-20 19:48:12', '2019-12-20 19:48:12');
INSERT INTO `edu_course` VALUES ('1207992164181667842', '7', '1101348944971091969', '1101348944920760321', '机器学习', '10.0000', '1', '', '0', '0', '1', 'Draft', '2019-12-20 19:52:30', '2019-12-20 19:52:30');
INSERT INTO `edu_course` VALUES ('1207992937657462786', '6', '1103221676134481922', '1103221676071567362', '大数据', '10.0000', '10', '', '0', '0', '1', 'Draft', '2019-12-20 19:55:34', '2019-12-25 15:37:37');
INSERT INTO `edu_course` VALUES ('1207993571169333250', '6', '1101348945050783746', '1101348944920760321', '对方是否违法', '10.0000', '10', '', '0', '0', '1', 'Normal', '2019-12-20 19:58:05', '2019-12-24 18:24:56');
INSERT INTO `edu_course` VALUES ('1209403404653207554', '4', '1101348945411493889', '1101348945352773634', 'beirhewil', '6.0000', '5', 'http://guli-file-181128.oss-cn-beijing.aliyuncs.com/cover/default.gif', '0', '0', '1', 'Normal', '2019-12-24 17:20:16', '2019-12-24 18:23:13');
INSERT INTO `edu_course` VALUES ('14', '1', '1101348944971091969', '1101348944920760321', 'XHTML CSS2 JS整站制作教程课程学习', '0.0000', '3', 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/d0086eb0-f2dc-45f7-bba1-744d95e5be0f.jpg', '3', '38', '15', 'Normal', '2018-04-02 18:33:34', '2019-04-10 11:36:38');
INSERT INTO `edu_course` VALUES ('15', '1', '1101348944971091969', '1101348944920760321', 'HTML5入门课程学习', '0.0000', '23', 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/22997b8e-3606-4d2e-9b4f-09f48418b6e4.jpg', '0', '39', '17', 'Normal', '2018-04-02 18:34:32', '2019-03-13 06:04:22');
INSERT INTO `edu_course` VALUES ('17', '2', '1101348944971091969', '1101348944920760321', 'MySql从入门到精通', '0.0000', '100', 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/258d399d-27fc-4f87-9534-619118028b39.jpg', '34', '130', '4', 'Normal', '2018-04-02 21:13:58', '2019-03-13 06:00:56');
INSERT INTO `edu_course` VALUES ('18', '1', '1101348944971091969', '1101348944920760321', 'Java精品课程', '111111.9900', '20', 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/06/866e9aca-b530-4f71-a690-72d4a4bfd1e7.jpg', '150', '601', '6', 'Normal', '2018-04-02 21:28:46', '2019-04-10 11:34:57');
INSERT INTO `edu_course` VALUES ('25', '3', '223', '', '听力口语训练营', '0.0000', '0', '', '0', '13', '14', 'Normal', '2018-02-26 19:23:48', '2019-02-21 20:46:42');
INSERT INTO `edu_course` VALUES ('26', '4', '223', '', 'CAD4零基础教学', '0.0000', '0', '', '0', '34', '35', 'Normal', '2018-02-26 19:24:44', '2019-02-21 20:46:43');

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程简介';

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1104870479077879809', '<p>11</p>', '2019-03-11 06:23:44', '2019-03-11 06:23:44');
INSERT INTO `edu_course_description` VALUES ('1207948954327662594', 'string', '2019-12-20 17:00:48', '2019-12-20 17:00:48');
INSERT INTO `edu_course_description` VALUES ('1207952664189493249', '', '2019-12-20 17:15:33', '2019-12-20 17:15:33');
INSERT INTO `edu_course_description` VALUES ('1207986815269662721', 'string', '2019-12-20 19:31:15', '2019-12-20 19:31:15');
INSERT INTO `edu_course_description` VALUES ('1207989324210040833', '<p>springboot学习</p>', '2019-12-20 19:41:13', '2019-12-20 19:41:13');
INSERT INTO `edu_course_description` VALUES ('1207989877417766914', '<p>java</p>', '2019-12-20 19:43:25', '2019-12-20 19:43:25');
INSERT INTO `edu_course_description` VALUES ('1207991080881025026', '<p>滴答滴答滴答的</p>', '2019-12-20 19:48:12', '2019-12-20 19:48:12');
INSERT INTO `edu_course_description` VALUES ('1207992164181667842', '<p>发的散发芬芳</p>', '2019-12-20 19:52:30', '2019-12-20 19:52:30');
INSERT INTO `edu_course_description` VALUES ('1207992937657462786', '<p>自主招生的范儿</p>', '2019-12-20 19:55:34', '2019-12-20 19:55:34');
INSERT INTO `edu_course_description` VALUES ('1207993571169333250', '<p>的说法我特我容易让他</p>', '2019-12-20 19:58:05', '2019-12-20 19:58:05');
INSERT INTO `edu_course_description` VALUES ('1209403404653207554', '<p>ffgewrth</p>', '2019-12-24 17:20:16', '2019-12-24 17:20:16');
INSERT INTO `edu_course_description` VALUES ('14', '', '2019-03-13 06:04:43', '2019-03-13 06:05:33');
INSERT INTO `edu_course_description` VALUES ('15', '', '2019-03-13 06:03:33', '2019-03-13 06:04:22');
INSERT INTO `edu_course_description` VALUES ('17', '', '2019-03-13 05:59:11', '2019-03-13 06:00:56');
INSERT INTO `edu_course_description` VALUES ('18', '<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>', '2019-03-06 18:06:36', '2019-03-06 19:45:30');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) NOT NULL COMMENT '类别名称',
  `parent_id` char(19) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程科目';

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1101348944920760321', '后端开发	', '0', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348944971091969', 'Java', '1101348944920760321', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945050783746', 'Python', '1101348944920760321', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945101115393', '前端开发	', '0', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945155641345', 'HTML/CSS', '1101348945101115393', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945235333122', 'JavaScript', '1101348945101115393', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945352773634', '云计算	', '0', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945411493889', 'Docker', '1101348945352773634', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1101348945482797058', '云服务', '1101348945352773634', '0', '2019-03-01 13:10:25', '2019-03-01 13:10:25');
INSERT INTO `edu_subject` VALUES ('1103221675555667970', '系统/运维	', '0', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221675761188866', 'Linux', '1103221675555667970', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221675840880641', 'Windows', '1103221675555667970', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221675895406594', '数据库	', '0', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221675928961025', 'MySQL', '1103221675895406594', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221676012847105', 'MongoDB', '1103221675895406594', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221676071567362', '大数据	', '0', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221676134481922', 'Hadoop', '1103221676071567362', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');
INSERT INTO `edu_subject` VALUES ('1103221676209979394', 'Spark', '1103221676071567362', '0', '2019-03-06 17:11:59', '2019-03-06 17:11:59');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(255) NOT NULL COMMENT '讲师资历,一句话说明讲师',
  `career` text COMMENT '讲师简介',
  `level` int(10) unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='讲师';

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1', '刘德华9', '毕业于师范大学数学系，热爱教育事业，执教数学思维6年有余', '具备深厚的数学思维功底、丰富的小学教育经验，授课风格生动活泼，擅长用形象生动的比喻帮助理解、简单易懂的语言讲解难题，深受学生喜欢', '2', 'http://guli-file.oss-cn-beijing.aliyuncs.com/avatar/2019/02/27/073eb5d2-f5f4-488a-82ed-aec8a5289a5d.png', '10', '1', '2018-03-30 17:15:57', '2019-02-23 05:48:45');
INSERT INTO `edu_teacher` VALUES ('10', '唐嫣', '北京师范大学法学院副教授', '北京师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。', '1', 'http://guli-file.oss-cn-beijing.aliyuncs.com/avatar/2019/02/27/073eb5d2-f5f4-488a-82ed-aec8a5289a5d.png', '20', '0', '2018-04-03 14:32:19', '2019-02-22 02:01:26');
INSERT INTO `edu_teacher` VALUES ('2', '周润发', '中国人民大学附属中学数学一级教师', '中国科学院数学与系统科学研究院应用数学专业博士，研究方向为数字图像处理，中国工业与应用数学学会会员。参与全国教育科学“十五”规划重点课题“信息化进程中的教育技术发展研究”的子课题“基与课程改革的资源开发与应用”，以及全国“十五”科研规划全国重点项目“掌上型信息技术产品在教学中的运用和开发研究”的子课题“用技术学数学”。', '2', 'http://guli-file.oss-cn-beijing.aliyuncs.com/avatar/2019/02/26/e99253b5-8235-4952-90b3-b0151ccc0d53.jpg', '1', '1', '2018-03-30 18:28:26', '2019-02-22 02:01:26');
INSERT INTO `edu_teacher` VALUES ('3', '钟汉良', '钟汉良钟汉良钟汉良钟汉良', '中教一级职称。讲课极具亲和力。', '1', 'http://guli-file.oss-cn-beijing.aliyuncs.com/avatar/2019/02/26/250bab5f-bbd6-49ab-80c3-7413ce806e83.jpg', '2', '0', '2018-03-31 09:20:46', '2019-02-22 02:01:27');
INSERT INTO `edu_teacher` VALUES ('4', '周杰伦', '长期从事考研政治课讲授和考研命题趋势与应试对策研究。考研辅导新锐派的代表。', '政治学博士、管理学博士后，北京师范大学马克思主义学院副教授。多年来总结出了一套行之有效的应试技巧与答题方法，针对性和实用性极强，能帮助考生在轻松中应考，在激励的竞争中取得高分，脱颖而出。', '1', '', '1', '0', '2018-04-03 14:13:51', '2019-02-22 02:01:28');
INSERT INTO `edu_teacher` VALUES ('5', '陈伟霆', '人大附中2009届毕业生', '北京大学数学科学学院2008级本科生，2012年第八届学生五四奖章获得者，在数学领域取得多项国际国内奖项，学术研究成绩突出。曾被两次评为北京大学三好学生、一次评为北京大学三好标兵，获得过北京大学国家奖学金、北京大学廖凯原奖学金、北京大学星光国际一等奖学金、北京大学明德新生奖学金等。', '1', '', '1', '0', '2018-04-03 14:15:36', '2019-02-22 02:01:29');
INSERT INTO `edu_teacher` VALUES ('6', '姚晨', '华东师范大学数学系硕士生导师，中国数学奥林匹克高级教练', '曾参与北京市及全国多项数学活动的命题和组织工作，多次带领北京队参加高中、初中、小学的各项数学竞赛，均取得优异成绩。教学活而新，能够调动学生的学习兴趣并擅长对学生进行思维点拨，对学生学习习惯的养成和非智力因素培养有独到之处，是一位深受学生喜爱的老师。', '1', '', '1', '0', '2018-04-01 14:19:28', '2019-02-22 02:01:29');
INSERT INTO `edu_teacher` VALUES ('7', '胡歌', '考研政治辅导实战派专家，全国考研政治命题研究组核心成员。', '法学博士，北京师范大学马克思主义学院副教授，专攻毛泽东思想概论、邓小平理论，长期从事考研辅导。出版著作两部，发表学术论文30余篇，主持国家社会科学基金项目和教育部重大课题子课题各一项，参与中央实施马克思主义理论研究和建设工程项目。', '2', '', '8', '0', '2018-04-03 14:21:03', '2019-02-22 02:01:30');
INSERT INTO `edu_teacher` VALUES ('8', '旦增尼玛', '上海师范大学法学院副教授', '上海师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。', '1', 'http://guli-file.oss-cn-beijing.aliyuncs.com/avatar/2019/02/26/ba006bc4-b1ca-4e13-a0f1-7ffb0abc0a4e.jpg', '9', '0', '2018-04-03 14:23:06', '2019-02-22 02:01:31');
INSERT INTO `edu_teacher` VALUES ('9', '谢娜', '资深课程设计专家，专注10年AACTP美国培训协会认证导师', '十年课程研发和培训咨询经验，曾任国企人力资源经理、大型外企培训经理，负责企业大学和培训体系搭建；曾任专业培训机构高级顾问、研发部总监，为包括广东移动、东莞移动、深圳移动、南方电网、工商银行、农业银行、民生银行、邮储银行、TCL集团、清华大学继续教育学院、中天路桥、广西扬翔股份等超过200家企业提供过培训与咨询服务，并担任近50个大型项目的总负责人。', '1', '', '10', '0', '2018-04-03 14:23:33', '2019-02-22 02:01:32');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) NOT NULL DEFAULT '' COMMENT '视频状态',
  `size` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='课程视频';

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1209403500870541314', '1209403404653207554', '1209403438731927554', 'ffgghh', '', '', '1', '0', '0', '0', '', '0', '1', '2019-12-24 17:20:39', '2019-12-24 17:20:39');
INSERT INTO `edu_video` VALUES ('1209403562983989249', '1209403404653207554', '1209403537520369666', 'vvbbb', '', '', '1', '0', '0', '0', '', '0', '1', '2019-12-24 17:20:54', '2019-12-24 17:20:54');
INSERT INTO `edu_video` VALUES ('1209403583963897858', '1209403404653207554', '1209403537520369666', 'fdshku', '', '', '2', '0', '0', '0', '', '0', '1', '2019-12-24 17:20:59', '2019-12-24 17:20:59');
INSERT INTO `edu_video` VALUES ('1209740063433408514', '1207992937657462786', '1209740004385996801', 'a', '', '', '0', '0', '0', '0', '', '0', '1', '2019-12-25 15:38:02', '2019-12-25 15:38:02');
INSERT INTO `edu_video` VALUES ('1209740086187507713', '1207992937657462786', '1209740020727005186', 's', '', '', '0', '0', '0', '0', '', '0', '1', '2019-12-25 15:38:07', '2019-12-25 15:38:07');
INSERT INTO `edu_video` VALUES ('17', '18', '15', '第一节：Java简介', 'e669f3decd1049bc93ffd57d65559c12', '第一集', '1', '1000', '1', '100', 'Draft', '0', '1', '2019-01-01 13:08:57', '2019-03-09 08:21:42');
INSERT INTO `edu_video` VALUES ('18', '18', '15', '第二节：表达式和赋值语句', '2d99b08ca0214909899910c9ba042d47', '7 - How Do I Find Time for My ', '2', '999', '1', '100', 'Draft', '0', '1', '2019-01-01 13:09:02', '2019-03-08 03:30:27');
INSERT INTO `edu_video` VALUES ('19', '18', '15', '第三节：String类', '', null, '3', '888', '0', '100', 'Draft', '0', '1', '2019-01-01 13:09:05', '2019-02-21 20:46:10');
INSERT INTO `edu_video` VALUES ('20', '18', '15', '第四节：程序风格', '', null, '4', '666', '0', '100', 'Draft', '0', '1', '2019-01-01 13:09:05', '2019-02-21 20:46:10');
