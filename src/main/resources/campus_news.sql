/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26 : Database - campus_news
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`campus_news` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `campus_news`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
                         `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `userid` varchar(20) DEFAULT NULL COMMENT '账号密码',
                         `password` varchar(20) DEFAULT NULL COMMENT '密码',
                         `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`userid`,`password`,`time`) values (1,'123','321','2022-02-15 17:08:07');

/*Table structure for table `campus_n` */

DROP TABLE IF EXISTS `campus_n`;

CREATE TABLE `campus_n` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(20) DEFAULT NULL COMMENT '姓名',
                            `gender` char(1) DEFAULT NULL COMMENT '1表示男、0表示女',
                            `resume` longtext COMMENT '履历',
                            `motto` varchar(200) DEFAULT NULL COMMENT '座右铭',
                            `elegant` longtext COMMENT '个人风采',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `campus_n` */

insert  into `campus_n`(`id`,`name`,`gender`,`resume`,`motto`,`elegant`) values (1,'普京','1','普京在讲话中表示，顿巴斯局势极其严峻。今天（当地时间2月21日）他发表电视讲话，不仅是为了评估事态，也是为了告诉国民俄罗斯所做的决定以及就此可能采取的措施。普京在讲话中首先回顾了历史，随后表示美国和北约等西方国家已开始无耻地利用乌克兰作为潜在的战争场所，他们源源不断地向乌克兰输送武器，派遣军事教官和顾问。北约与乌克兰举行联合军演，在乌克兰境内驻军，乌克兰的空域和水域也向北约开放。北约总部甚至可以直接指挥乌克兰武装部队。','据央视新闻，当地时间2月21日，俄罗斯总统普京发表全国视频讲话，宣布承认乌东民间武装自称的顿涅茨克人民共和国和卢甘斯克人民共和国为独立国家。','<div style=\"max-width: 100%; overflow-x: visible; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); margin-top: 22px; font-family: arial;\"><p style=\"margin-top: 0px; margin-bottom: 0px; overflow-y: auto; max-width: 100%; line-height: 24px;\">普京表示，俄罗斯深知自己对捍卫地区稳定和安全的责任。正因如此，俄罗斯提出关于欧洲安全的相关建议。而美国和北约对俄方关于安全保障建议的答复没有回应俄方的三个核心关切，包括北约停止东扩、北约在欧洲的军事基础设施恢复至1997年时的水平、停止在俄罗斯边境附近部署打击性武器。俄方愿与美国和北约讨论一些安全议题，但前提是要就涉及俄方核心关切的主要问题进行一揽子探讨。俄罗斯完全有权利使用一切回应手段捍卫国家安全。</p><p style=\"margin-top: 0px; margin-bottom: 0px; overflow-y: auto; max-width: 100%; line-height: 24px;\"></p></div><div style=\"max-width: 100%; overflow-x: visible; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); margin-top: 22px; font-family: arial;\"><p style=\"margin-top: 0px; margin-bottom: 0px; overflow-y: auto; max-width: 100%; line-height: 24px;\"></p><p style=\"margin-top: 0px; margin-bottom: 0px; overflow-y: auto; max-width: 100%; line-height: 24px;\">普京表示，顿巴斯地区正在发生“种族灭绝”等人道主义危机。乌克兰当局正试图在顿巴斯上演“闪电战”，而其本身并不想执行明斯克协议。</p></div>'),(4,'123','1','123','123123','<p><br></p>'),(5,'123','1','123','123123','<p><br></p>'),(6,'123','1','123','123123','<p><br></p>'),(7,'123','1','123','123123','<p><br></p>'),(8,'123','1','123','123','<p><br></p>'),(9,'1','1','1','1','<p><br></p>'),(12,'212','1','334','3434','<p><br></p>'),(15,'212','0','123','123','<p><br></p><p>123456</p>'),(16,'212','0','123','123777','<p><br></p><p>1234567</p>'),(18,'213','0','13','123','<p>1213</p>'),(19,'123','1','qwe','qwe','你好啊啊啊啊啊啊啊啊啊啊啊啊啊');

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
                              `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `userid` char(12) NOT NULL COMMENT '用户ID',
                              `news_id` int(11) NOT NULL COMMENT '新闻ID',
                              `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `collection` */

insert  into `collection`(`id`,`userid`,`news_id`,`time`) values (1,'2',58,'2022-03-01 10:28:49'),(16,'1',11,'2022-03-01 13:07:12'),(17,'1',13,'2022-03-01 13:07:15'),(18,'1',16,'2022-03-01 13:07:23'),(19,'1',27,'2022-03-01 13:54:35');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
                           `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `news_id` int(11) NOT NULL COMMENT '新闻id',
                           `userid` char(12) NOT NULL COMMENT '评论者id',
                           `content` varchar(500) NOT NULL COMMENT '评论内容',
                           `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`news_id`,`userid`,`content`,`time`) values (1,18,'123','1231','2022-02-14 12:52:22'),(5,18,'12','12','2022-02-22 12:17:39'),(6,18,'12','12','2022-02-22 12:17:42'),(7,58,'1','学校书记好！','2022-02-28 21:40:18'),(8,58,'1','真不错啊','2022-02-28 22:19:19'),(9,58,'1','评论发布','2022-02-28 22:21:44'),(10,59,'1','你好啊！','2022-02-28 23:06:21'),(11,28,'1','123123','2022-02-28 23:07:44'),(12,58,'1','4','2022-03-01 12:23:52'),(13,58,'1','455','2022-03-01 12:23:57'),(14,58,'1','455额外','2022-03-01 12:24:01'),(15,58,'1','额外','2022-03-01 12:24:05'),(16,58,'1','额外啊十大黑科技','2022-03-01 12:24:12'),(17,58,'1','额外啊十大黑科技ad','2022-03-01 12:24:15'),(18,58,'1','额外啊十大','2022-03-01 12:24:19'),(19,58,'1','额外啊十大qew','2022-03-01 12:24:26');

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
                            `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `content` varchar(500) NOT NULL COMMENT '内容',
                            `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '反馈时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

insert  into `feedback`(`id`,`content`,`time`) values (2,'好好写代码','2022-03-01 16:55:44'),(3,'2','2022-03-01 18:58:08'),(4,'3','2022-03-01 18:58:09'),(5,'4','2022-03-01 18:58:10'),(6,'4','2022-03-01 18:58:11'),(7,'5','2022-03-01 18:58:12'),(8,'6','2022-03-01 18:58:14'),(9,'5','2022-03-01 18:58:23'),(10,'5','2022-03-01 18:58:23'),(12,'5','2022-03-01 18:58:25'),(13,'5','2022-03-01 18:58:25'),(14,'5','2022-03-01 18:58:26'),(17,'5','2022-03-01 18:58:30'),(18,'5','2022-03-01 18:58:31'),(19,'5','2022-03-01 18:58:32'),(20,'5','2022-03-01 18:58:33');

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `news_id` int(11) NOT NULL COMMENT '新闻ID',
                        `name` varchar(100) NOT NULL COMMENT '原始名称',
                        `uuid` varchar(50) NOT NULL COMMENT 'uuid',
                        `type` varchar(10) DEFAULT NULL COMMENT '文件类型',
                        `size` varchar(10) DEFAULT NULL COMMENT '文件大小',
                        `path` varchar(500) NOT NULL COMMENT '文件路径',
                        `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `file` */

insert  into `file`(`id`,`news_id`,`name`,`uuid`,`type`,`size`,`path`,`time`) values (4,1,'2月13日盘州市重点场所视频巡查记录表.xls','0a1482641b134711b4694cb5a0e0661d','xls','22016','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8084.1359167138141221939\\WEB-INF\\upload\\0a1482641b134711b4694cb5a0e0661d.xls','2022-02-16 23:06:09'),(5,1,'2月13日盘州市重点场所视频巡查记录表.xls','36e15c5f988b4cf9999267aa30f4e26a','xls','22016','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8084.1122174328006664034\\WEB-INF\\upload\\36e15c5f988b4cf9999267aa30f4e26a.xls','2022-02-16 23:07:48'),(7,18,'2月13日盘州市重点场所视频巡查记录表.xls','b3ee192e4d1d458cbf06a831450f60d2','xls','22016','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8084.894645754510983540\\WEB-INF\\upload\\b3ee192e4d1d458cbf06a831450f60d2.xls','2022-02-16 23:28:42'),(8,20,'2月13日盘州市重点场所视频巡查记录表.xls','5dbcc23dd22b44a5ab0bed5e598356cc','xls','22016','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8084.9171968670721761163\\WEB-INF\\upload\\5dbcc23dd22b44a5ab0bed5e598356cc.xls','2022-02-16 23:31:17'),(9,28,'2月13日盘州市疫情防控督查情况汇报(3)(1).docx','a4c6aa87ab9b493cb215aa1db9ec1bc5','docx','14253','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.4446219654733482911\\WEB-INF\\upload\\a4c6aa87ab9b493cb215aa1db9ec1bc5.docx','2022-02-22 20:26:55'),(10,29,'2月13日盘州市疫情防控督查情况汇报(3)(1).docx','1962132c929f48088f5ab119a036f945','docx','14253','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.4446219654733482911\\WEB-INF\\upload\\1962132c929f48088f5ab119a036f945.docx','2022-02-22 20:35:16'),(11,49,'2月13日盘州市疫情防控督查情况汇报(3)(1).docx','6180dad2876140e995fdf9dce03ee263','docx','14253','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5778431168202131310\\WEB-INF\\upload\\6180dad2876140e995fdf9dce03ee263.docx','2022-02-22 22:18:07'),(12,52,'appid.txt','b3a6c28eb97a4a3e8eddc01b3a55c600','txt','104','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5108705624709248788\\WEB-INF\\upload\\b3a6c28eb97a4a3e8eddc01b3a55c600.txt','2022-02-22 22:42:00'),(13,53,'appid.txt','189e5f88926f44ba8bbc5db7d2e03798','txt','104','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5108705624709248788\\WEB-INF\\upload\\189e5f88926f44ba8bbc5db7d2e03798.txt','2022-02-22 22:42:17'),(14,54,'campus_news.sql','3a57c907b5a14d1ca2c52285b591fa0c','sql','19631','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5108705624709248788\\WEB-INF\\upload\\3a57c907b5a14d1ca2c52285b591fa0c.sql','2022-02-22 22:43:45'),(15,55,'appid.txt','3cc6b258241649488014bc416338d743','txt','104','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5108705624709248788\\WEB-INF\\upload\\3cc6b258241649488014bc416338d743.txt','2022-02-22 22:46:20'),(16,56,'appid.txt','e9adf89f1dc64b318ccface6d21b8f98','txt','104','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.5108705624709248788\\WEB-INF\\upload\\e9adf89f1dc64b318ccface6d21b8f98.txt','2022-02-22 22:46:29'),(17,58,'中文成绩单.pdf','8435b7cd68a54d76a3eebfa4cd88560f','pdf','226047','C:\\Users\\17579\\AppData\\Local\\Temp\\tomcat-docbase.8085.8731255801317685953\\WEB-INF\\upload\\8435b7cd68a54d76a3eebfa4cd88560f.pdf','2022-03-01 18:44:27');

/*Table structure for table `likes` */

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
                         `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `news_id` int(11) NOT NULL COMMENT '新闻ID',
                         `userid` char(12) NOT NULL COMMENT '用户ID',
                         `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
                         PRIMARY KEY (`id`,`news_id`,`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `likes` */

insert  into `likes`(`id`,`news_id`,`userid`,`time`) values (10,58,'1','2022-03-01 11:45:35');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `title` varchar(300) DEFAULT NULL COMMENT '标题',
                        `author` varchar(100) DEFAULT '管理员' COMMENT '作者',
                        `content` longtext COMMENT '内容',
                        `likes_number` varchar(6) DEFAULT '0' COMMENT '点赞数',
                        `tourist_number` varchar(6) DEFAULT '0' COMMENT '游览量',
                        `collections_number` varchar(6) DEFAULT '0' COMMENT '收藏数',
                        `category_id` int(11) DEFAULT NULL COMMENT '分类ID',
                        `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`title`,`author`,`content`,`likes_number`,`tourist_number`,`collections_number`,`category_id`,`time`) values (10,'测试','测试','<p>在这里输入内容</p><p><br></p>','0','1','0',2,'2022-02-16 23:06:09'),(11,'测试','测试','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-16 23:07:48'),(13,'123','321','<p>在这里输入内容</p><p><br></p>','0','1','0',2,'2022-02-16 23:20:42'),(16,'测试','测试','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-16 23:24:38'),(17,'测试','测试','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-16 23:25:50'),(18,'测试','测试','<p>在这里输入内容</p><p><br></p>','0','5','0',2,'2022-02-16 23:28:42'),(20,'12','21','<p>在这里输入内容</p><p><br></p>','0','4','0',2,'2022-02-16 23:31:17'),(24,'ter','qwer','<p>在这里输入内容</p><p><br></p>','0','4','0',1,'2022-02-16 23:47:11'),(26,'党建','记者','<p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">正在举办的北京2022年冬奥会不仅是一场体育盛会，更折射出中国推动构建人类命运共同体的价值追求。党建网微平台整理了习近平总书记关于构建人类命运共同体的部分重要论述，一起学习领会！</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\"><strong>人类已经成为你中有我、我中有你的命运共同体</strong></p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">这个世界，各国相互联系、相互依存的程度空前加深，人类生活在同一个地球村里，生活在历史和现实交汇的同一个时空里，越来越成为你中有我、我中有你的命运共同体。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2013年3月23日，习近平在莫斯科国际关系学院的演讲</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">人类已经成为你中有我、我中有你的命运共同体，利益高度融合，彼此相互依存。每个国家都有发展权利，同时都应该在更加广阔的层面考虑自身利益，不能以损害其他国家利益为代价。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2017年1月17日，习近平在瑞士达沃斯举行的世界经济论坛2017年年会开幕式上的主旨演讲</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">人类发展进步大潮滚滚向前，世界经济时有波折起伏，但各国走向开放、走向融合的大趋势没有改变。产业链、价值链、供应链不断延伸和拓展，带动了生产要素全球流动，助力数十亿人口脱贫致富。各国相互协作、优势互补是生产力发展的客观要求，也代表着生产关系演变的前进方向。在这一进程中，各国逐渐形成利益共同体、责任共同体、命运共同体。无论前途是晴是雨，携手合作、互利共赢是唯一正确选择。这既是经济规律使然，也符合人类社会发展的历史逻辑。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2018年11月30日，习近平在二十国集团领导人峰会第一阶段会议上的发言</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">人民渴望富足安康，渴望公平正义。大时代需要大格局，大格局呼唤大胸怀。从“本国优先”的角度看，世界是狭小拥挤的，时时都是“激烈竞争”。从命运与共的角度看，世界是宽广博大的，处处都有合作机遇。我们要倾听人民心声，顺应时代潮流，推动各国加强协调和合作，把本国人民利益同世界各国人民利益统一起来，朝着构建人类命运共同体的方向前行。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年7月6日，习近平在中国共产党与世界政党领导人峰会上的主旨讲话</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\"><strong>朝着构建人类命运共同体方向不断迈进</strong></p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">“大道之行也，天下为公。”和平、发展、公平、正义、民主、自由，是全人类的共同价值，也是联合国的崇高目标。目标远未完成，我们仍须努力。当今世界，各国相互依存、休戚与共。我们要继承和弘扬联合国宪章的宗旨和原则，构建以合作共赢为核心的新型国际关系，打造人类命运共同体。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2015年9月28日，习近平在美国纽约联合国总部举行的第七十届联合国大会一般性辩论时的讲话</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">让和平的薪火代代相传，让发展的动力源源不断，让文明的光芒熠熠生辉，是各国人民的期待，也是我们这一代政治家应有的担当。中国方案是：构建人类命运共同体，实现共赢共享。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2017年1月18日，习近平在联合国日内瓦总部的演讲</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">我们所处的时代充满挑战，也充满希望。人类社会应该向何处去？中方倡议，世界各国人民一道努力，回应时代呼唤，加强全球治理，以创新引领发展，朝着构建人类命运共同体的方向不断迈进。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年10月1日，习近平在迪拜世博会中国馆的致辞</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">人类是一个整体，地球是一个家园。任何人、任何国家都无法独善其身。人类应该和衷共济、和合共生，朝着构建人类命运共同体方向不断迈进，共同创造更加美好未来。推动构建人类命运共同体，不是以一种制度代替另一种制度，不是以一种文明代替另一种文明，而是不同社会制度、不同意识形态、不同历史文化、不同发展水平的国家在国际事务中利益共生、权利共享、责任共担，形成共建美好世界的最大公约数。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年10月25日，习近平在中华人民共和国恢复联合国合法席位50周年纪念会议上的讲话</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\"><strong>以中国的新发展为世界提供新机遇</strong></p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">中国共产党是世界上最大的政党。我说过，大就要有大的样子。中国共产党所做的一切，就是为中国人民谋幸福、为中华民族谋复兴、为人类谋和平与发展。我们要把自己的事情做好，这本身就是对构建人类命运共同体的贡献。我们也要通过推动中国发展给世界创造更多机遇，通过深化自身实践探索人类社会发展规律并同世界各国分享。我们不“输入”外国模式，也不“输出”中国模式，不会要求别国“复制”中国的做法。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2017年12月1日，习近平在中国共产党与世界政党高层对话会上的主旨讲话</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">中国共产党是为中国人民谋幸福的政党，也是为人类进步事业而奋斗的政党。我们将高举和平、发展、合作、共赢旗帜，同世界各国人民深化友谊、加强交流，推动建设新型国际关系，推动构建人类命运共同体，推动共建“一带一路”高质量发展，以中国的新发展为世界提供新机遇。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年7月16日，习近平在参观“友好往来 命运与共——党和国家领导人外交活动礼品展”时强调</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">中华民族传承和追求的是和平和睦和谐理念。我们过去没有，今后也不会侵略、欺负他人，不会称王称霸。中国始终是世界和平的建设者、全球发展的贡献者、国际秩序的维护者、公共产品的提供者，将继续以中国的新发展为世界提供新机遇。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年9月21日，习近平在第七十六届联合国大会一般性辩论上的讲话</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">中国共产党百年奋斗的一条重要历史经验就是坚持胸怀天下，始终关注人类前途命运。中国支持多边主义的决心不会改变，将坚定维护多边主义的核心价值和基本原则，坚持互利共赢，坚持求同存异，坚持公平正义，坚持合作发展，为人类文明进步贡献智慧和力量。</p><p style=\"margin-top: 23px; margin-bottom: 0px; text-align: justify; font-size: 20px; line-height: 38px; text-indent: 2em; font-family: &quot;Microsoft YaHei&quot;, 微软雅黑;\">——2021年12月5日，习近平向“2021从都国际论坛”开幕式发表视频致辞</p>','0','0','0',3,'2022-02-17 21:36:06'),(27,'12','12','<p>请在这里输入内容.....1212</p>','0','2','1',1,'2022-02-22 20:26:41'),(28,'12','12','<p>请在这里输入内容.....1212</p>','0','12','0',1,'2022-02-22 20:26:55'),(29,'213deweq','123qwe','<p>请在这里输入内容.....qwre</p><p><br></p>','0','7','0',1,'2022-02-22 20:35:16'),(30,'123','123','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',3,'2022-02-22 20:36:07'),(31,'12','12','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',2,'2022-02-22 20:36:22'),(32,'123','123','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',2,'2022-02-22 20:36:45'),(33,'12','12','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',2,'2022-02-22 20:37:03'),(34,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',1,'2022-02-22 21:11:36'),(35,'','','<p>在这里输入内容</p><p><br></p>','0','1','0',1,'2022-02-22 21:12:18'),(36,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',1,'2022-02-22 21:14:48'),(37,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:25:50'),(38,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:28:24'),(39,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:29:24'),(40,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:30:24'),(41,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:32:56'),(42,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:35:01'),(43,'','','<p>在这里输入内容</p><p><br></p>','0','1','0',2,'2022-02-22 21:36:31'),(44,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:36:56'),(45,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:41:22'),(46,'','','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:41:25'),(47,'测试2','测试2','<p>在这里输入内容</p><p><br></p>','0','0','0',2,'2022-02-22 21:53:44'),(48,'ce','ce','<p>请在这里输入内容.....eee</p><p><br></p>','0','0','0',1,'2022-02-22 22:17:51'),(49,'cd','cd','<p>请在这里输入内容.....ddd</p><p><br></p>','0','3','0',3,'2022-02-22 22:18:07'),(50,'2131231','cesi','<p>请在这里输入内容.....21312</p><p><br></p>','0','0','0',1,'2022-02-22 22:18:53'),(51,'213222','1232222','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',2,'2022-02-22 22:19:27'),(52,'12','12','<p>请在这里输入内容.....</p><p><br></p>','0','9','0',1,'2022-02-22 22:42:00'),(53,'12','12','<p>12</p>','0','0','0',2,'2022-02-22 22:42:17'),(54,'qwe','qwe','<p>请在这里输入内容.....</p><p><br></p>','0','0','0',2,'2022-02-22 22:43:45'),(55,'sdf','sdf','<p>ds</p>','0','1','0',2,'2022-02-22 22:46:20'),(56,'sdf','sdf','<p>ds</p>','0','2','0',2,'2022-02-22 22:46:29'),(57,'123','123','<p>13</p>','0','1','0',2,'2022-02-22 22:48:28'),(58,'党委书记张波到体育学院、西区食堂调研',' 宣传部','<p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">2月25日下午，为落实全省教育系统2022年春季学期开学工作暨省教育厅“四下基层”部署会精神，学校党委书记张波到体育学院、西区食堂进行调研。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center; margin-top: 12px !important; margin-bottom: 12px !important;\"><img src=\"http://www.zync.edu.cn/__local/8/03/39/43D63F47032723FD972C085CAE7_4D5EB918_59B9A.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/8033943D63F47032723FD972C085CAE7/4D5EB918/59B9A\" vheight=\"\" vwidth=\"600\" vspace=\"0\" hspace=\"0\" border=\"0\" title=\"undefined\" alt=\"undefined\" orisrc=\"/__local/8/03/39/43D63F47032723FD972C085CAE7_4D5EB918_59B9A.jpg\" style=\"border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204);\"></p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">在体育学院，张波通过实地走访、听取汇报等方式，了解开学工作准备情况和体育场馆卫生情况。目前，室内外体育场馆、设备设施均达到卫生防疫要求，能够有效保障体育教学、日常训练、师生体育活动等的开展。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center; margin-top: 12px !important; margin-bottom: 12px !important;\"><img src=\"http://www.zync.edu.cn/__local/1/7C/F5/F1A21B08CA41773B5E70BA22182_FE1F2C1B_60B8A.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/17CF5F1A21B08CA41773B5E70BA22182/FE1F2C1B/60B8A\" vheight=\"\" vwidth=\"600\" vspace=\"0\" hspace=\"0\" border=\"0\" title=\"undefined\" alt=\"undefined\" orisrc=\"/__local/1/7C/F5/F1A21B08CA41773B5E70BA22182_FE1F2C1B_60B8A.jpg\" style=\"border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204);\"></p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">根据遵义师范学院与贵州省体育局的协议，以“省队校办”的模式在遵义师范学院共建贵州省乒乓球队。当日，有一批乒乓球运动员在乒乓球馆参加集训。张波慰问了这些运动员，并表示，要进一步完善“省队校办”有关工作，加强体育设施的建设和管理，为建好贵州省乒乓球队提供有力保障。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center; margin-top: 12px !important; margin-bottom: 12px !important;\"><img src=\"http://www.zync.edu.cn/__local/D/BF/E6/23A1F6E4EB04CF1CD903A563D02_3BB29CAB_4FD21.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/DBFE623A1F6E4EB04CF1CD903A563D02/3BB29CAB/4FD21\" vheight=\"\" vwidth=\"600\" orisrc=\"/__local/D/BF/E6/23A1F6E4EB04CF1CD903A563D02_3BB29CAB_4FD21.jpg\" style=\"border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204);\"></p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">目前，学校食堂各档口已陆续面向师生供餐。张波走进西区食堂，了解疫情防控、食品安全、餐具消毒、就餐环境等情况，并表示，要进一步落实好常态化疫情防控措施，做好卫生清洁、通风消毒等工作，完善隔断就餐等用餐方式；严格落实食品安全管理规定，为师生提供安全健康、营养均衡的餐饮服务。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center; margin-top: 12px !important; margin-bottom: 12px !important;\"><img src=\"http://www.zync.edu.cn/__local/0/1A/3D/D33817498C82BAEE4A03B398604_3A2B6D01_5DF62.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/01A3DD33817498C82BAEE4A03B398604/3A2B6D01/5DF62\" vheight=\"\" vwidth=\"600\" orisrc=\"/__local/0/1A/3D/D33817498C82BAEE4A03B398604_3A2B6D01_5DF62.jpg\" style=\"border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204);\"></p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">调研中，张波与学生亲切交谈，关心学生身心健康，了解学生的学习、生活情况，详细询问学生对教学、校园管理等的意见建议，并就学生反映的问题现场办公，要求相关职能部门及时拿出解决方案，尽快予以解决，切实做到以学生为中心，为学生营造温馨、舒适的学习、生活环境，提高学生的获得感、幸福感和安全感。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">此次调研也是持续深入推进“我为群众办实事”实践活动的具体体现，学校将进一步听取师生意见，了解师生需求，着力解决好师生“急难愁盼”问题。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">党政办公室、团委、后勤管理处、体育学院、附属实验学校有关负责同志参加调研。</p>','0','161','-1',4,'2022-02-27 17:43:09'),(59,'我校老干部工作获全省表彰','本网综合 ','<p><span style=\"color: rgb(34, 34, 34); font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; font-size: 16px; text-align: justify; text-indent: 32px;\">2月25日，贵州省老干部工作先进集体和先进个人表彰大会在贵阳召开，表彰了全省老干部工作先进集体50个、先进个人100名。遵义师范学院离退休干部工作处获评全省老干部工作先进集体。</span><br></p>','0','16','0',4,'2022-02-27 17:45:28'),(60,'我校参加全省教育系统2022年春季学期开学工作暨省教育厅“四下基层”部署会','本网综合 ','<p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center; margin-top: 12px !important; margin-bottom: 12px !important;\"><img src=\"http://www.zync.edu.cn/__local/F/4E/2F/066CB00E4F8677E337ABC583DA7_7026D0B4_53AB3.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/F4E2F066CB00E4F8677E337ABC583DA7/7026D0B4/53AB3\" vheight=\"\" vwidth=\"600\" orisrc=\"/__local/F/4E/2F/066CB00E4F8677E337ABC583DA7_7026D0B4_53AB3.jpg\" style=\"border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204);\"></p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">2月24日，省教育厅召开全省教育系统2022年春季学期开学工作暨省教育厅“四下基层”部署会议，深入学习宣传贯彻落实新国发2号文件精神，安排部署2022年春季学期开学工作及省教育厅“四下基层”工作。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">会议在遵义师范学院行政楼214会议室设分会场，遵义师范学院党委班子成员、副处级以上干部、附属实验学校班子成员参加会议。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">会议指出，在习近平总书记视察贵州一周年之际，在国发〔2012〕2号出台十周年之际，国务院再次出台新国发2号文件，支持贵州在新时代西部大开发上闯新路，充分体现了习近平总书记对贵州人民的关怀厚爱，是贵州发展史上又一具有里程碑意义的重大事件。新国发2号文件第二十四条“推动教育高质量发展”，用了3个推进、4个支持等对贵州各级各类教育给予项目、资金、政策等支持，让我们倍感温暖、倍感振奋、倍感鼓舞，也倍感责任重大。全省教育系统要牢记嘱托、感恩奋进闯新路，全力推动新国发2号文件在全省教育系统落地落实。要自觉从战略和全局高度深刻认识出台新国发2号文件的重大政治意义，深切感悟以习近平同志为核心的党中央对贵州的亲切关怀，深刻领会新国发2号文件赋予贵州“四区一高地”的战略定位，深刻领会新国发2号文件带来的政策红利。要怀着“一枝一叶总关情”的初心感党恩。国发〔2012〕2 号为贵州教育改革发展提供了前所未有的政策支撑，贵州教育面貌发生了历史性变化，创造了赶超跨越的“黄金十年”。要从发展巨变中深刻感悟习近平总书记深厚的人民情怀，时刻铭记总书记对贵州人民的好，对贵州教育人的恩。要怀着“咬定青山不放松”的恒心抓学习。始终把学习宣传贯彻落实新国发2号文件作为当前和今后一个时期的重大政治任务，开展大学习、大宣讲、大讨论，在全省教育系统迅速掀起学习宣传贯彻落实热潮，形成学习宣传贯彻落实新国发2号文件的浓厚氛围。要上好“牢记嘱托感党恩、勇担使命闯新路”春季学期开学第一课，让新国发2号文件精神家喻户晓、深入人心。要怀着“不破楼兰终不还”的决心闯新路。全面准确把握文件精神实质和丰富内涵，紧扣教育发展“十四五”规划、特色教育强省建设、攻坚行动及其“七大提升工程”各项部署，系统地谋、积极地争、勇敢的闯、大胆地试、务实地干，切实抓好新国发2号文件的贯彻落实。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">会议强调，要坚持稳字当头、做好充分准备，确保2022年春季学期开学工作平稳有序。要坚持把学校安全稳定工作作为当前学校工作的首要任务，扎扎实实做好教育系统安全稳定工作。开学工作要做到收心归位再出发、开学方案再细化、疫情防控再精准、双减工作再发力、安全底线再筑牢、开学之课再深入。开学前，各市（州）、县（市、区）和各校要组织力量，逐一排查准备情况，确保方案准备到位、教材准备到位、场地准备到位、物资准备到位、控辍准备到位、教学准备到位。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">会议要求，要认真贯彻全省政府系统“改进作风、狠抓落实”年部署要求，落实省教育厅1号文件《关于进一步改进作风狠抓落实服务发展的通知》要求，以过硬作风保障特色教育强省建设和全省教育高质量发展，扎实开展“信访接待下基层、现场办公下基层、调查研究下基层、宣传党的方针政策下基层”等“四下基层”工作。要认清“四下基层”的时代意义，充分认识“四下基层”工作是忠诚践行“两个维护”的实践行动、是深化模范机关创建的实践落点、是改进作风狠抓落实的实践举措。要把握“四下基层”的重要内涵，“信访接待下基层”就是要变群众上访为干部下访、“现场办公下基层”就是要变发现问题为解决问题、“调查研究下基层”就是要变宏观指导为精准指导、“宣传政策下基层”就是要变大水漫灌为精准滴灌。要落实好“四下基层”的工作要求，改进作风、真抓实干，形成合力、齐抓共管，固化机制、保持常态。</p><p style=\"color: rgb(34, 34, 34); line-height: 28px; text-indent: 2em; font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: justify; margin-top: 12px !important; margin-bottom: 12px !important;\">会议强调，全省教育系统要始终坚持以习近平新时代中国特色社会主义思想为指导，深刻感悟习近平总书记对贵州人民的深厚感情，倍加感恩总书记、感恩党中央，以实际行动衷心拥护“两个确立”、忠诚践行“两个维护”，抓住用好新国发2号文件带来的重大历史机遇，全力推动全省教育高质量发展，以优异成绩迎接党的二十大和省第十三次党代会胜利召开！</p>','0','15','0',4,'2022-02-27 17:46:38'),(61,'省委党史学习教育第十八巡回指导组向我校发来感谢信','本网综合 ','<h2 align=\"center\" style=\"margin-top: 0px; margin-bottom: 0px; font-size: 26px; color: rgb(51, 51, 51); font-family: 微软雅黑, Tahoma, Arial, SimSun, 宋体, &quot;Microsoft YaHei&quot;, SimHei, 黑体; text-align: center;\"><p style=\"margin-top: 0px; margin-bottom: 0px; color: rgb(34, 34, 34); font-size: 14px; text-indent: 28px;\"><br><div style=\"text-align: left;\"><img src=\"http://www.zync.edu.cn/__local/F/3B/66/41E7276D9C4F99E479A04A2DA67_D1169825_CF29B.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/F3B6641E7276D9C4F99E479A04A2DA67/D1169825/CF29B\" vheight=\"\" vwidth=\"600\" orisrc=\"/__local/F/3B/66/41E7276D9C4F99E479A04A2DA67_D1169825_CF29B.jpg\" style=\"border-width: 0px; border-style: initial;\"></div></p><p style=\"margin-top: 0px; margin-bottom: 0px; color: rgb(34, 34, 34); font-size: 14px; text-indent: 28px;\"><img src=\"http://www.zync.edu.cn/__local/4/D8/01/163DD6DA91A6A7E8DD8DA6A64E4_14B26683_AA3F0.jpg\" width=\"600\" vsbhref=\"vurl\" vurl=\"/_vsl/4D801163DD6DA91A6A7E8DD8DA6A64E4/14B26683/AA3F0\" vheight=\"\" vwidth=\"600\" orisrc=\"/__local/4/D8/01/163DD6DA91A6A7E8DD8DA6A64E4_14B26683_AA3F0.jpg\" style=\"border-width: 0px; border-style: initial;\"></p></h2>','0','8','0',4,'2022-02-27 17:47:30');

/*Table structure for table `news_category` */

DROP TABLE IF EXISTS `news_category`;

CREATE TABLE `news_category` (
                                 `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `category` varchar(40) DEFAULT NULL COMMENT '类别',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `news_category` */

insert  into `news_category`(`id`,`category`) values (1,'公告'),(2,'学术活动'),(3,'党建'),(4,'首页'),(5,'新闻'),(6,'人物风采');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `userid` char(12) NOT NULL COMMENT '学号',
                        `password` varchar(16) NOT NULL DEFAULT '888888' COMMENT '密码最长16位',
                        `name` varchar(20) DEFAULT NULL COMMENT '姓名',
                        `gender` char(1) DEFAULT NULL COMMENT '1表示男 0表示女',
                        `phone` char(11) DEFAULT NULL COMMENT '电话11位',
                        `college` varchar(20) DEFAULT NULL COMMENT '学院',
                        `major` varchar(20) DEFAULT NULL COMMENT '专业',
                        `openid` varchar(40) DEFAULT NULL COMMENT '微信openid',
                        PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`password`,`name`,`gender`,`phone`,`college`,`major`,`openid`) values ('1','888888','123','1','123321',NULL,NULL,'oo7W25HvglaETv-iUJjU-PxpPIIM'),('13','888888','13','0','1333','马克思主义学院','思想政治教育',NULL),('21','888888','12345','0','3211','外国语学院','英语',''),('212','888888','212222','0','12','物理与电子科学学院','科学教育','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
