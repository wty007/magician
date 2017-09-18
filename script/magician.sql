/*
Navicat MySQL Data Transfer

Source Server         : 10.100.142.94
Source Server Version : 50620
Source Host           : 10.100.142.94:3306
Source Database       : magician

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2017-09-15 11:26:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1a995225-13c5-4807-958d-1343c8073409', '团队旅游签证', '1', 'visaType', '团队旅游签证');
INSERT INTO `dict` VALUES ('1ecb6887-50d2-442c-98b8-6d58167344e6', '一星级', '1', 'hotelLevel', 'oneStar');
INSERT INTO `dict` VALUES ('319bf493-0ccf-44fe-90c3-6ad50f5327a2', '计算机与应用类', '2', 'profession', '计算机与应用类');
INSERT INTO `dict` VALUES ('35ac45da-dbe3-43c4-b436-5ff80f83b4c9', '信息与电子类', '1', 'profession', '信息与电子类');
INSERT INTO `dict` VALUES ('432b1980-c298-4233-a612-baf455a31c0f', '如家', '1', 'hotelBrand', '如家');
INSERT INTO `dict` VALUES ('441a8d72-23ab-40f4-a67f-2a0de5c3a878', '探访签证', '3', 'visaType', '探访签证');
INSERT INTO `dict` VALUES ('488b65cb-1318-4178-b3bc-e0dd99883948', '二星级', '2', 'hotelLevel', 'twoStar');
INSERT INTO `dict` VALUES ('4fe34459-3801-402e-b2eb-d7f55cf6f0eb', '客栈', '8', 'hotelLevel', 'inn');
INSERT INTO `dict` VALUES ('58734150-98ca-4aad-bfab-8456a8f85cef', '国外酒店', '2', 'hotelType', 'abroad');
INSERT INTO `dict` VALUES ('595fd219-ceef-4585-968a-953b7854a22e', '工程技术类', '3', 'profession', '工程技术类');
INSERT INTO `dict` VALUES ('645f858a-c4e7-42ac-bb2c-cfdc22a5e392', '酒店式公寓', '7', 'hotelLevel', 'hotelStyleApartment');
INSERT INTO `dict` VALUES ('74a54f8d-8bb6-4789-965f-a42eb1f55869', 'AAAAA', '5', 'sceneryLevel', 'AAAAA');
INSERT INTO `dict` VALUES ('8134649c-09e5-4243-acc4-0fd4d63b0653', 'AAAA', '4', 'sceneryLevel', 'AAAA');
INSERT INTO `dict` VALUES ('81924a36-ae8c-4492-b801-730b0f8412c5', '初中及以下', '1', 'educationLevel', '1');
INSERT INTO `dict` VALUES ('8319ae03-55dc-4726-9445-4806e54810ea', '经济型酒店', '7', 'hotelLevel', 'econoHotel');
INSERT INTO `dict` VALUES ('8c02af80-10e3-4661-b35f-1b139891b35c', '国内酒店', '1', 'hotelType', 'domestic');
INSERT INTO `dict` VALUES ('ac9c891e-4d29-4408-b896-a0ac8172c22d', '商务签证', '2', 'visaType', '商务签证');
INSERT INTO `dict` VALUES ('b0769e3d-79f3-464a-a9c7-c73df29ad015', '五星级', '5', 'hotelLevel', 'fiveStar');
INSERT INTO `dict` VALUES ('ba2fb840-46aa-429d-9862-6952bf649a0c', 'A', '1', 'sceneryLevel', 'A');
INSERT INTO `dict` VALUES ('bdc3d479-03d4-4269-96d4-85b01d9458ea', '青年旅舍ssss', '6', 'hotelLevel', 'youthHoste');
INSERT INTO `dict` VALUES ('c02d0684-818f-4f00-bc2a-7380330f078e', '七天', '2', 'hotelBrand', '七天');
INSERT INTO `dict` VALUES ('c05c182a-47ab-4696-861b-b26db9b87803', 'AA', '2', 'sceneryLevel', 'AA');
INSERT INTO `dict` VALUES ('d95e2ae5-e652-491c-949c-b8d341850915', '四星级', '4', 'hotelLevel', 'fourStar');
INSERT INTO `dict` VALUES ('e277075a-6929-4b4c-87ce-eb6eca62a338', 'AAA', '3', 'sceneryLevel', 'AAA');
INSERT INTO `dict` VALUES ('fe917c68-0709-4848-a4e1-a035b4d823ff', '三星级', '3', 'hotelLevel', 'threeStar');

-- ----------------------------
-- Table structure for dict_group
-- ----------------------------
DROP TABLE IF EXISTS `dict_group`;
CREATE TABLE `dict_group` (
  `id` varchar(64) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict_group
-- ----------------------------

-- ----------------------------
-- Table structure for dict_many_to_many
-- ----------------------------
DROP TABLE IF EXISTS `dict_many_to_many`;
CREATE TABLE `dict_many_to_many` (
  `id` varchar(64) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `source_id` varchar(64) DEFAULT NULL,
  `dict_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdtbtgejtb5m5yk5co8abvebsw` (`dict_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict_many_to_many
-- ----------------------------

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `append_service` varchar(1024) DEFAULT NULL,
  `brief_description` varchar(255) DEFAULT NULL,
  `contact_information` varchar(255) DEFAULT NULL,
  `decoration_time` datetime DEFAULT NULL,
  `hide` bit(1) DEFAULT NULL,
  `introduction` varchar(1024) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `opening_time` datetime DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `position_distance` varchar(1024) DEFAULT NULL,
  `recommend` bit(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `special_tips` varchar(1024) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `surrounding_environment` varchar(1024) DEFAULT NULL,
  `traffic_guide` varchar(1024) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(64) DEFAULT NULL,
  `brand` varchar(64) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `starting_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('83069f1e-1393-4992-a6dc-c253f4bc240d', '2', '<p>5</p>', '<p>2</p>', '2', null, '', '<p>1<br/></p>', '432431', null, null, '<p>3</p>', null, null, '<p>4</p>', null, '2', '<p>2</p>', '<p>1</p>', null, '58734150-98ca-4aad-bfab-8456a8f85cef', '4fe34459-3801-402e-b2eb-d7f55cf6f0eb', 'c02d0684-818f-4f00-bc2a-7380330f078e', null, null);

-- ----------------------------
-- Table structure for hotel_order
-- ----------------------------
DROP TABLE IF EXISTS `hotel_order`;
CREATE TABLE `hotel_order` (
  `id` varchar(64) NOT NULL,
  `booking_person_mobile_phone` varchar(16) DEFAULT NULL,
  `booking_person_real_name` varchar(16) DEFAULT NULL,
  `cancel_reason` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `check_in_time` datetime DEFAULT NULL,
  `hotel_id` varchar(64) DEFAULT NULL,
  `keep_till_time` datetime DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `room_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_order
-- ----------------------------

-- ----------------------------
-- Table structure for hotel_order_person
-- ----------------------------
DROP TABLE IF EXISTS `hotel_order_person`;
CREATE TABLE `hotel_order_person` (
  `id` varchar(64) NOT NULL,
  `hotel_order_id` varchar(64) DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_order_person
-- ----------------------------

-- ----------------------------
-- Table structure for hotel_support_service
-- ----------------------------
DROP TABLE IF EXISTS `hotel_support_service`;
CREATE TABLE `hotel_support_service` (
  `id` varchar(255) NOT NULL,
  `hotel_id` varchar(255) DEFAULT NULL,
  `service_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasebe9idjiwt3drq6o7gmvmsj` (`hotel_id`),
  KEY `FK25m4megg7yh0erhkq38avxu5t` (`service_id`),
  CONSTRAINT `FK25m4megg7yh0erhkq38avxu5t` FOREIGN KEY (`service_id`) REFERENCES `support_service` (`id`),
  CONSTRAINT `FKasebe9idjiwt3drq6o7gmvmsj` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_support_service
-- ----------------------------
INSERT INTO `hotel_support_service` VALUES ('01ee2030-2bd4-4475-a9ca-3ff3b9409c56', '83069f1e-1393-4992-a6dc-c253f4bc240d', '5366e072-4912-4164-89e8-8e969129e6b9');
INSERT INTO `hotel_support_service` VALUES ('05a3271b-1e0c-46ea-8692-d4a336e389ab', '83069f1e-1393-4992-a6dc-c253f4bc240d', '18c61510-07d8-4c6a-997a-1a48e6e9f7f4');
INSERT INTO `hotel_support_service` VALUES ('0b2c11fb-4893-4957-8877-228cf18120db', '83069f1e-1393-4992-a6dc-c253f4bc240d', '4eed22f7-e90d-46c1-b89a-9f8df169faf4');
INSERT INTO `hotel_support_service` VALUES ('11543311-f47b-4c82-a332-dc286acab833', '83069f1e-1393-4992-a6dc-c253f4bc240d', '4e127cff-cc33-4210-bb49-b5e3b651713c');
INSERT INTO `hotel_support_service` VALUES ('165ebf80-cbcb-4da5-8f2c-83938777772d', '83069f1e-1393-4992-a6dc-c253f4bc240d', '8675eb3c-dff7-4dbc-8502-2e01dff312b4');
INSERT INTO `hotel_support_service` VALUES ('1f12a1e9-a8e7-488d-95af-786321bce69a', '83069f1e-1393-4992-a6dc-c253f4bc240d', '9061e8ed-add5-4316-b474-bd8b544bb398');
INSERT INTO `hotel_support_service` VALUES ('1f30cff3-ca05-4339-8abb-145c77224c58', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'e1a886c6-1f78-4a65-842d-6b5c32146316');
INSERT INTO `hotel_support_service` VALUES ('1fe9fc2d-a217-4a05-a6da-2d0bfeee3b1e', '83069f1e-1393-4992-a6dc-c253f4bc240d', '8d70fad6-044f-4d2a-8018-7faecdef9330');
INSERT INTO `hotel_support_service` VALUES ('22f24dcb-36b5-4ea9-8433-6b4a08f7ff84', '83069f1e-1393-4992-a6dc-c253f4bc240d', '1b682c8e-fdfc-404a-ab06-5a72476b585e');
INSERT INTO `hotel_support_service` VALUES ('24f396b2-06cf-421f-90f5-cd8878146f3e', '83069f1e-1393-4992-a6dc-c253f4bc240d', '67f3be32-932b-4704-91ff-4a9f2b5ef23b');
INSERT INTO `hotel_support_service` VALUES ('283172ec-e562-4ad6-b3e0-7f824379f5c1', '83069f1e-1393-4992-a6dc-c253f4bc240d', '0efee95d-4dc2-45d5-958b-bc17a9a21c11');
INSERT INTO `hotel_support_service` VALUES ('28e6da67-efa7-46f1-b0df-56f0ec8be1bc', '83069f1e-1393-4992-a6dc-c253f4bc240d', '4675ec41-a60c-45db-b266-84d98b25cc20');
INSERT INTO `hotel_support_service` VALUES ('2f744894-2405-48cb-a206-8c81be0e1064', '83069f1e-1393-4992-a6dc-c253f4bc240d', '95d4f825-e975-4a88-a7d9-01d67ee9ff67');
INSERT INTO `hotel_support_service` VALUES ('308fd5b8-0076-42c5-bf77-276d40706eec', '83069f1e-1393-4992-a6dc-c253f4bc240d', '3b1ac366-9a19-4e2a-92b0-04c94ffa2991');
INSERT INTO `hotel_support_service` VALUES ('3373802e-60de-44b9-a4bf-d3048ab742e8', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'ba138a9f-73ad-48df-82b4-a06ad809d160');
INSERT INTO `hotel_support_service` VALUES ('363736df-96de-4e43-b4b2-3b44daccd94e', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'eabc9d46-db99-4554-9991-f2eed6623e76');
INSERT INTO `hotel_support_service` VALUES ('364bd4eb-9ef6-4f3b-b21a-fe178c341578', '83069f1e-1393-4992-a6dc-c253f4bc240d', '6f75cc06-7a6e-4aed-b6ec-c7da6bd13ee9');
INSERT INTO `hotel_support_service` VALUES ('380e8341-a6d0-4ed1-a6c1-515be467f39d', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'f5e177f8-6b7b-4355-87c1-e89cba04c7d3');
INSERT INTO `hotel_support_service` VALUES ('3a28ad58-bd44-47a1-af38-4db91a7a2511', '83069f1e-1393-4992-a6dc-c253f4bc240d', '2ea6fb6d-d749-4237-89c6-6b67747a9ee7');
INSERT INTO `hotel_support_service` VALUES ('3f6a403e-dd28-485a-885d-6a7c24d4bad7', '83069f1e-1393-4992-a6dc-c253f4bc240d', '0858da35-52fd-4214-90eb-02e3854e237d');
INSERT INTO `hotel_support_service` VALUES ('3fa978d6-0332-438e-92cc-fde96bb55fd5', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'fd89ade8-1162-4d94-8c98-42e14fd56aad');
INSERT INTO `hotel_support_service` VALUES ('4147a40a-2b21-482c-b9b1-a550d16dfc0a', '83069f1e-1393-4992-a6dc-c253f4bc240d', '5e9cd795-fa01-4dbb-809e-bd7d34725a57');
INSERT INTO `hotel_support_service` VALUES ('5a0fc568-f273-4e40-8dd7-2a7310e5e05a', '83069f1e-1393-4992-a6dc-c253f4bc240d', '82ca6c3c-6a7a-4e1b-b7ed-82c6a561bad7');
INSERT INTO `hotel_support_service` VALUES ('5a1ccf76-b36e-4efe-a3bf-516d3c291b54', '83069f1e-1393-4992-a6dc-c253f4bc240d', '93dc7b0f-b963-47b2-a87b-19e5ae44ef17');
INSERT INTO `hotel_support_service` VALUES ('61a61282-9ba7-4210-80f5-f3df788055d6', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'f645f325-9d73-407e-8c85-18a95d7afa23');
INSERT INTO `hotel_support_service` VALUES ('6332d62e-1587-46d2-b7e6-3b2838882589', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'b71d4bbf-f823-4ede-88b8-169d8c091e5c');
INSERT INTO `hotel_support_service` VALUES ('641734d6-84f8-4dc3-b670-18d2ff072243', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'c9588223-1e5d-46b5-b93a-7dae4d7899c2');
INSERT INTO `hotel_support_service` VALUES ('668650a8-84aa-4004-92b8-cbea9685b55f', '83069f1e-1393-4992-a6dc-c253f4bc240d', '83f50c08-1667-4089-bfd7-d88edaa855b6');
INSERT INTO `hotel_support_service` VALUES ('71d6dbce-f624-41f6-a05e-4cda824afd8b', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'e646b89d-c35b-4fac-9756-429722468368');
INSERT INTO `hotel_support_service` VALUES ('734118bc-0735-412e-b6f5-71827e2e7bb5', '83069f1e-1393-4992-a6dc-c253f4bc240d', '4339aec3-858e-49a6-82f5-c3d3129e218d');
INSERT INTO `hotel_support_service` VALUES ('76e5014d-7921-4d87-bfe2-256120368bb8', '83069f1e-1393-4992-a6dc-c253f4bc240d', '5dc26cb6-b01b-4e00-89bd-56ebbc474dfd');
INSERT INTO `hotel_support_service` VALUES ('77da0c81-17ca-4aaa-9e34-b772487ac2cf', '83069f1e-1393-4992-a6dc-c253f4bc240d', '3e6829bc-cdee-4516-9ed4-667a0ce1d1f9');
INSERT INTO `hotel_support_service` VALUES ('79902138-ac2c-453e-952e-b1406ba001b5', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'ebb3c35b-bcbd-4565-a90c-9a308099620b');
INSERT INTO `hotel_support_service` VALUES ('80607196-7faf-45a7-929b-4ced46863c28', '83069f1e-1393-4992-a6dc-c253f4bc240d', '40b138e2-b9aa-4ad0-83de-a7575865ac0c');
INSERT INTO `hotel_support_service` VALUES ('8438a95b-22a6-4df5-9ef4-3e0d9a34f121', '83069f1e-1393-4992-a6dc-c253f4bc240d', '7d94e8b3-78f6-4637-b9cb-91456ebeee67');
INSERT INTO `hotel_support_service` VALUES ('8e907452-6f09-4576-b9fe-b768df489a3c', '83069f1e-1393-4992-a6dc-c253f4bc240d', '48961b81-2eee-48a9-a7ba-724b788e0cd1');
INSERT INTO `hotel_support_service` VALUES ('977f8f49-40a9-4442-99bd-5606d7fd2893', '83069f1e-1393-4992-a6dc-c253f4bc240d', '64107e84-e7e1-4add-9419-00a5511df19d');
INSERT INTO `hotel_support_service` VALUES ('9b33826f-af38-47dd-b253-4ec61c1df3cc', '83069f1e-1393-4992-a6dc-c253f4bc240d', '27fba53f-765e-47d5-b064-77123ab40941');
INSERT INTO `hotel_support_service` VALUES ('a9dc7311-a495-4363-aeac-9807e15bc21d', '83069f1e-1393-4992-a6dc-c253f4bc240d', '4adf161e-0f77-4b4d-863f-08f09428087c');
INSERT INTO `hotel_support_service` VALUES ('abb9e67d-923a-4f98-a947-c5a343d0057a', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'b5d0ff22-cb34-4cf3-98a7-0a6012e851a2');
INSERT INTO `hotel_support_service` VALUES ('b01375e2-bd59-4dba-af32-2f3dfb8aab78', '83069f1e-1393-4992-a6dc-c253f4bc240d', '47be9138-5b64-4e60-88bf-7a5dc09e5559');
INSERT INTO `hotel_support_service` VALUES ('b081a034-0555-4476-a2c4-bd7f4cc568b1', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'e0a39218-8d49-48d3-bcd9-cca2e22bd44a');
INSERT INTO `hotel_support_service` VALUES ('b4ca9e76-5a94-41b5-bf42-09cea40683ee', '83069f1e-1393-4992-a6dc-c253f4bc240d', '35a350a3-4176-4c0a-9894-25d5e889efde');
INSERT INTO `hotel_support_service` VALUES ('b6271edd-cf62-4dab-a095-0b9f54ffc06a', '83069f1e-1393-4992-a6dc-c253f4bc240d', '90e12053-283a-4dd7-ab39-64282641f232');
INSERT INTO `hotel_support_service` VALUES ('bad576c5-eafb-46cf-a13f-e5aedfd7b0f5', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'd735bca9-7535-4e2c-87b3-622fdc6772dc');
INSERT INTO `hotel_support_service` VALUES ('bb34482c-2a6b-49a1-b18e-1e5edfe7ec99', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'ce1c943d-389f-48eb-8ad5-dcdb061186c5');
INSERT INTO `hotel_support_service` VALUES ('bcd118ac-ae80-47c9-af65-32add43cfe36', '83069f1e-1393-4992-a6dc-c253f4bc240d', '21e32d65-ea5c-44d0-a929-c40193351729');
INSERT INTO `hotel_support_service` VALUES ('bcf9c5a2-33da-47ad-a854-077fc8dc8889', '83069f1e-1393-4992-a6dc-c253f4bc240d', '931d8437-0f66-4429-9d0d-781be6b8b9b6');
INSERT INTO `hotel_support_service` VALUES ('be2dbe1d-c379-48b1-b6ad-6ae48992bc96', '83069f1e-1393-4992-a6dc-c253f4bc240d', '37bcf8cb-4e87-4eeb-9403-456d505ba349');
INSERT INTO `hotel_support_service` VALUES ('c6adaba8-d94d-49ec-b4f1-301871c3afa9', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'e1fbc29a-9052-4777-88f1-2b36032906af');
INSERT INTO `hotel_support_service` VALUES ('c815de1b-3930-4338-b1d4-934f3962c7f1', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'e8ec3a70-e280-47d8-b130-f2df3962eece');
INSERT INTO `hotel_support_service` VALUES ('cf5f32da-fb54-4480-bde6-adc9e8c31890', '83069f1e-1393-4992-a6dc-c253f4bc240d', '9a302365-70c8-43bd-8f5f-de48d525be35');
INSERT INTO `hotel_support_service` VALUES ('e6ad09b6-a9a6-4f2c-ad70-b1beae504633', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'c5c1bd2c-5cce-432e-803c-ba7eeb97a402');
INSERT INTO `hotel_support_service` VALUES ('ea242661-4c34-420a-ad89-6669d665ba24', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'cc019370-564c-40a3-8df6-0d1bbd612d7a');
INSERT INTO `hotel_support_service` VALUES ('f351072a-99a4-46a8-ac0a-661a747be06f', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'c627d3dc-47bf-4e30-93a3-6926ebbedc54');
INSERT INTO `hotel_support_service` VALUES ('ffe703f1-1a1d-4ab2-a737-b83c15087bdc', '83069f1e-1393-4992-a6dc-c253f4bc240d', 'fb705028-285e-40ce-9af4-079cbd8653de');

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance` (
  `id` varchar(64) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `period` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insurance
-- ----------------------------

-- ----------------------------
-- Table structure for line
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` varchar(255) NOT NULL,
  `booking_information` varchar(1024) DEFAULT NULL,
  `booking_process` varchar(1024) DEFAULT NULL,
  `brief_description` varchar(1024) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `featured_introduction` varchar(1024) DEFAULT NULL,
  `highest_score` int(11) DEFAULT NULL,
  `introduction` varchar(1024) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `max_use_score` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_process_type` int(11) DEFAULT NULL,
  `pay_amount` double DEFAULT NULL,
  `pay_type` int(11) DEFAULT NULL,
  `recommended_days_of_advance` int(11) DEFAULT NULL,
  `round_trip_traffic` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `starting_price` double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `tips` varchar(1024) DEFAULT NULL,
  `cost_introduction` varchar(1024) DEFAULT NULL,
  `group_purchase` bit(1) DEFAULT NULL,
  `hide` bit(1) DEFAULT NULL,
  `hot_sale` bit(1) DEFAULT NULL,
  `new_product` bit(1) DEFAULT NULL,
  `recommend` bit(1) DEFAULT NULL,
  `special_offer` bit(1) DEFAULT NULL,
  `start_city` varchar(255) DEFAULT NULL,
  `travel_introduction` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('389d5781-fcd2-4995-a5ab-1ae7b15e5d1e', '<p>1</p>', '<p>1</p>', '<p>1fdsfds</p>', null, '<p>1</p>', '1', '<p>1</p>', '1', '1', '1', '1', null, '1', '1', ',', '1', '1', null, '1', '<p>1</p>', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for line_insurance
-- ----------------------------
DROP TABLE IF EXISTS `line_insurance`;
CREATE TABLE `line_insurance` (
  `id` varchar(64) NOT NULL,
  `insurance_id` varchar(64) DEFAULT NULL,
  `line_id` varchar(64) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line_insurance
-- ----------------------------

-- ----------------------------
-- Table structure for line_order
-- ----------------------------
DROP TABLE IF EXISTS `line_order`;
CREATE TABLE `line_order` (
  `id` varchar(64) NOT NULL,
  `booking_person_mobile_phone` varchar(16) DEFAULT NULL,
  `booking_person_real_name` varchar(16) DEFAULT NULL,
  `cancel_reason` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `adult_count` int(11) DEFAULT NULL,
  `booking_person_email` varchar(128) DEFAULT NULL,
  `booking_person_remark` varchar(256) DEFAULT NULL,
  `child_count` int(11) DEFAULT NULL,
  `line_id` varchar(64) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line_order
-- ----------------------------

-- ----------------------------
-- Table structure for line_order_insurance
-- ----------------------------
DROP TABLE IF EXISTS `line_order_insurance`;
CREATE TABLE `line_order_insurance` (
  `id` varchar(64) NOT NULL,
  `insurance_id` varchar(64) DEFAULT NULL,
  `line_order_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line_order_insurance
-- ----------------------------

-- ----------------------------
-- Table structure for line_order_visitor
-- ----------------------------
DROP TABLE IF EXISTS `line_order_visitor`;
CREATE TABLE `line_order_visitor` (
  `id` varchar(64) NOT NULL,
  `certificate_number` varchar(32) DEFAULT NULL,
  `certificate_type` int(11) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `order_id` varchar(64) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `mobile_phone` varchar(16) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line_order_visitor
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(255) NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(32) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `education_level` varchar(64) DEFAULT NULL,
  `id_number` varchar(32) DEFAULT NULL,
  `profession` varchar(64) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `token` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('031ce7b2-1aff-4dc4-90ab-1a9fea9f7ca3', '690732060@qq.com', '69073260@qq.com', '15010506169', '夜奔Er', '1234567', null, '81924a36-ae8c-4492-b801-730b0f8412c5', '1', '595fd219-ceef-4585-968a-953b7854a22e', '1', null);

-- ----------------------------
-- Table structure for member_favorite
-- ----------------------------
DROP TABLE IF EXISTS `member_favorite`;
CREATE TABLE `member_favorite` (
  `id` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` varchar(64) NOT NULL,
  `hotel_id` varchar(64) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for room_order
-- ----------------------------
DROP TABLE IF EXISTS `room_order`;
CREATE TABLE `room_order` (
  `id` varchar(64) NOT NULL,
  `booking_person_mobile_phone` varchar(16) DEFAULT NULL,
  `booking_person_real_name` varchar(16) DEFAULT NULL,
  `cancel_reason` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `check_in_time` datetime DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `hotel_id` varchar(64) DEFAULT NULL,
  `keep_till_time` int(11) DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `room_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_order
-- ----------------------------

-- ----------------------------
-- Table structure for room_order_guest
-- ----------------------------
DROP TABLE IF EXISTS `room_order_guest`;
CREATE TABLE `room_order_guest` (
  `id` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `room_order_id` varchar(64) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_order_guest
-- ----------------------------

-- ----------------------------
-- Table structure for scenery
-- ----------------------------
DROP TABLE IF EXISTS `scenery`;
CREATE TABLE `scenery` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `brief_description` varchar(255) DEFAULT NULL,
  `buy_ticket_notes` varchar(1024) DEFAULT NULL,
  `characteristic_shopping` varchar(1024) DEFAULT NULL,
  `contact_information` varchar(255) DEFAULT NULL,
  `hide` bit(1) DEFAULT NULL,
  `introduction` varchar(1024) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `recommend` bit(1) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `specialty_food` varchar(1024) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `ticket_taking_place` varchar(255) DEFAULT NULL,
  `traffic_guide` varchar(1024) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `level` varchar(64) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `opening_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenery
-- ----------------------------
INSERT INTO `scenery` VALUES ('88daf7a4-4212-4cf6-b543-1be10bc957a8', '1', '<p>1</p>', '<p>1</p>', '<p>1</p>', '1', '', '<p>1</p>', '5', '1', '', '1', '<p>1</p>', '1', '1', '<p>1</p>', '1', '74a54f8d-8bb6-4789-965f-a42eb1f55869', null, null);
INSERT INTO `scenery` VALUES ('bbdfda36-0f2b-4bf9-8cc7-9c0d45f31827', '1', '<p>1</p>', '<p>1</p>', '<p>fdsfdsfds1</p>', '1', '', '<p>1</p>', '6', '1', '', '1', '<p>1</p>', '1', '1', '<p>1</p>', '1', null, null, null);

-- ----------------------------
-- Table structure for scenery_order
-- ----------------------------
DROP TABLE IF EXISTS `scenery_order`;
CREATE TABLE `scenery_order` (
  `id` varchar(64) NOT NULL,
  `booking_person_mobile_phone` varchar(16) DEFAULT NULL,
  `booking_person_real_name` varchar(16) DEFAULT NULL,
  `cancel_reason` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `play_time` datetime DEFAULT NULL,
  `scenery_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scenery_order
-- ----------------------------

-- ----------------------------
-- Table structure for sms_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_log`;
CREATE TABLE `sms_log` (
  `id` varchar(255) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `mobile_phone` varchar(32) DEFAULT NULL,
  `origin_result` varchar(64) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `return_code` varchar(255) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_log
-- ----------------------------
INSERT INTO `sms_log` VALUES ('10104e81-ca5b-4b70-9f1f-e7c833b6e632', '644364', '15010506169', '', '2017-07-06 15:28:48', '1', null, null);
INSERT INTO `sms_log` VALUES ('6e2644cf-ff13-4cac-a407-b9e3a8ab82cd', '000000', '15010506169', '', '2017-07-06 15:26:03', '1', null, null);
INSERT INTO `sms_log` VALUES ('91656f28-c6b3-4208-9343-ff60406295c9', '884149', '15010506169', '', '2017-07-06 15:26:28', '1', null, null);
INSERT INTO `sms_log` VALUES ('b722b6de-ec92-47d8-b08d-4b414e54bf87', '218913', '15010506169', '', '2017-07-06 15:41:06', '1', null, null);
INSERT INTO `sms_log` VALUES ('bb2a3ae6-147f-446d-b94b-53cdda9d79db', '000000', '15010506169', '', '2017-07-06 15:21:16', '1', null, null);
INSERT INTO `sms_log` VALUES ('c5274688-af3a-48e4-a77d-a8dffd4dbd51', '344925', '15010506169', '', '2017-07-06 15:31:29', '1', null, null);
INSERT INTO `sms_log` VALUES ('d766ee95-99ea-4ef4-bff2-101566ba53fa', '311812', '15010506169', '', '2017-07-06 15:52:24', '1', null, null);

-- ----------------------------
-- Table structure for storage_object
-- ----------------------------
DROP TABLE IF EXISTS `storage_object`;
CREATE TABLE `storage_object` (
  `id` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storage_object
-- ----------------------------

-- ----------------------------
-- Table structure for support_service
-- ----------------------------
DROP TABLE IF EXISTS `support_service`;
CREATE TABLE `support_service` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsv5ow7v7pvus0isi27s1r5xf` (`category_id`),
  CONSTRAINT `FKsv5ow7v7pvus0isi27s1r5xf` FOREIGN KEY (`category_id`) REFERENCES `support_service_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of support_service
-- ----------------------------
INSERT INTO `support_service` VALUES ('0858da35-52fd-4214-90eb-02e3854e237d', '咖啡厅', '3', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('0efee95d-4dc2-45d5-958b-bc17a9a21c11', '叫醒服务', '14', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('18c61510-07d8-4c6a-997a-1a48e6e9f7f4', '公共音响系统', '7', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('1b682c8e-fdfc-404a-ab06-5a72476b585e', '110V电压插', '4', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('21e32d65-ea5c-44d0-a929-c40193351729', 'JCB卡', '6', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('27fba53f-765e-47d5-b064-77123ab40941', '自动取款机', '15', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('2ea6fb6d-d749-4237-89c6-6b67747a9ee7', '洗衣服务', '12', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('35a350a3-4176-4c0a-9894-25d5e889efde', '健身室', '6', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');
INSERT INTO `support_service` VALUES ('37bcf8cb-4e87-4eeb-9403-456d505ba349', '遮光窗帘', '13', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('3b1ac366-9a19-4e2a-92b0-04c94ffa2991', '餐厅服务', '3', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');
INSERT INTO `support_service` VALUES ('3e6829bc-cdee-4516-9ed4-667a0ce1d1f9', '夜总会送餐服务', '6', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('40b138e2-b9aa-4ad0-83de-a7575865ac0c', '国内长途电话', '1', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('4339aec3-858e-49a6-82f5-c3d3129e218d', '拖鞋', '3', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('4675ec41-a60c-45db-b266-84d98b25cc20', '浴室化妆放大镜', '5', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('47be9138-5b64-4e60-88bf-7a5dc09e5559', '限时送餐服务', '7', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('48961b81-2eee-48a9-a7ba-724b788e0cd1', '多功能厅', '5', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('4adf161e-0f77-4b4d-863f-08f09428087c', '茶壶', '9', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('4e127cff-cc33-4210-bb49-b5e3b651713c', '室内游泳池', '5', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('4eed22f7-e90d-46c1-b89a-9f8df169faf4', '按摩室', '3', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('5366e072-4912-4164-89e8-8e969129e6b9', '多媒体演示系统', '8', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('5dc26cb6-b01b-4e00-89bd-56ebbc474dfd', '独立写字台', '12', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('5e9cd795-fa01-4dbb-809e-bd7d34725a57', '国际长途电话', '2', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('64107e84-e7e1-4add-9419-00a5511df19d', '机场接送', '2', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');
INSERT INTO `support_service` VALUES ('67f3be32-932b-4704-91ff-4a9f2b5ef23b', '日式餐厅', '6', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('6f75cc06-7a6e-4aed-b6ec-c7da6bd13ee9', '会议厅', '7', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('7d94e8b3-78f6-4637-b9cb-91456ebeee67', '威士 (VISA)', '3', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('82ca6c3c-6a7a-4e1b-b7ed-82c6a561bad7', '24小时热水', '6', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('83f50c08-1667-4089-bfd7-d88edaa855b6', '国内发行银联卡', '1', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('8675eb3c-dff7-4dbc-8502-2e01dff312b4', '大堂吧', '4', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('8d70fad6-044f-4d2a-8018-7faecdef9330', '礼宾服', '3', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('9061e8ed-add5-4316-b474-bd8b544bb398', '中央空调', '11', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('90e12053-283a-4dd7-ab39-64282641f232', '大堂免费报纸', '4', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('931d8437-0f66-4429-9d0d-781be6b8b9b6', '酒吧', '5', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('93dc7b0f-b963-47b2-a87b-19e5ae44ef17', '旅游票务服务', '10', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('95d4f825-e975-4a88-a7d9-01d67ee9ff67', '商场', '11', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('9a302365-70c8-43bd-8f5f-de48d525be35', '免费瓶装水', '10', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('b5d0ff22-cb34-4cf3-98a7-0a6012e851a2', '万事达 (Master)', '2', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('b71d4bbf-f823-4ede-88b8-169d8c091e5c', '大堂吧', '2', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('ba138a9f-73ad-48df-82b4-a06ad809d160', '停车场', '5', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');
INSERT INTO `support_service` VALUES ('c5c1bd2c-5cce-432e-803c-ba7eeb97a402', '多功能厅', '6', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('c627d3dc-47bf-4e30-93a3-6926ebbedc54', '有线', '14', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('c9588223-1e5d-46b5-b93a-7dae4d7899c2', '健身室', '2', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('cc019370-564c-40a3-8df6-0d1bbd612d7a', '咖啡壶', '8', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('ce1c943d-389f-48eb-8ad5-dcdb061186c5', '宽带上网', '1', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');
INSERT INTO `support_service` VALUES ('d735bca9-7535-4e2c-87b3-622fdc6772dc', '桑拿浴室', '4', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('e0a39218-8d49-48d3-bcd9-cca2e22bd44a', '卫星电视送餐服务', '15', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('e1a886c6-1f78-4a65-842d-6b5c32146316', '大来 (Diners Club)', '5', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('e1fbc29a-9052-4777-88f1-2b36032906af', '电热水壶', '7', 'df12fd1f-b08b-4128-b892-81a15b73bf0a');
INSERT INTO `support_service` VALUES ('e646b89d-c35b-4fac-9756-429722468368', '卡拉OK厅', '1', 'c2437749-7371-4ddf-8361-cd3d5e989f32');
INSERT INTO `support_service` VALUES ('e8ec3a70-e280-47d8-b130-f2df3962eece', '运通 (AMEX)', '4', '8105fe69-af88-446e-8923-1d9136ace527');
INSERT INTO `support_service` VALUES ('eabc9d46-db99-4554-9991-f2eed6623e76', '外币兑换', '9', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('ebb3c35b-bcbd-4565-a90c-9a308099620b', '行李存放服务', '13', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('f5e177f8-6b7b-4355-87c1-e89cba04c7d3', '商务中心服务', '1', 'bc83ed48-f0cb-4b15-b2f8-0247cc158d6e');
INSERT INTO `support_service` VALUES ('f645f325-9d73-407e-8c85-18a95d7afa23', '中餐厅', '1', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('fb705028-285e-40ce-9af4-079cbd8653de', '西餐厅', '2', '9e5b1852-b5cd-4679-bdff-da148675e42b');
INSERT INTO `support_service` VALUES ('fd89ade8-1162-4d94-8c98-42e14fd56aad', '游泳池', '4', '43c8f557-5a00-4b92-82e7-069bdcf3bb88');

-- ----------------------------
-- Table structure for support_service_category
-- ----------------------------
DROP TABLE IF EXISTS `support_service_category`;
CREATE TABLE `support_service_category` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of support_service_category
-- ----------------------------
INSERT INTO `support_service_category` VALUES ('43c8f557-5a00-4b92-82e7-069bdcf3bb88', '特色服务', null);
INSERT INTO `support_service_category` VALUES ('8105fe69-af88-446e-8923-1d9136ace527', '支持卡类', '1');
INSERT INTO `support_service_category` VALUES ('9e5b1852-b5cd-4679-bdff-da148675e42b', '餐饮服务', '4');
INSERT INTO `support_service_category` VALUES ('bc83ed48-f0cb-4b15-b2f8-0247cc158d6e', '服务项目', '3');
INSERT INTO `support_service_category` VALUES ('c2437749-7371-4ddf-8361-cd3d5e989f32', '休闲娱乐', null);
INSERT INTO `support_service_category` VALUES ('df12fd1f-b08b-4128-b892-81a15b73bf0a', '房间设施', null);

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` varchar(64) NOT NULL,
  `market_price` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `scenery_id` varchar(64) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------

-- ----------------------------
-- Table structure for ticket_order
-- ----------------------------
DROP TABLE IF EXISTS `ticket_order`;
CREATE TABLE `ticket_order` (
  `id` varchar(64) NOT NULL,
  `booking_person_mobile_phone` varchar(16) DEFAULT NULL,
  `booking_person_real_name` varchar(16) DEFAULT NULL,
  `cancel_reason` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_id` varchar(64) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `adult_count` int(11) DEFAULT NULL,
  `child_count` int(11) DEFAULT NULL,
  `play_time` datetime DEFAULT NULL,
  `scenery_id` varchar(64) DEFAULT NULL,
  `ticket_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket_order
-- ----------------------------

-- ----------------------------
-- Table structure for ticket_order_visitor
-- ----------------------------
DROP TABLE IF EXISTS `ticket_order_visitor`;
CREATE TABLE `ticket_order_visitor` (
  `id` varchar(64) NOT NULL,
  `certificate_number` varchar(32) DEFAULT NULL,
  `certificate_type` int(11) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `order_id` varchar(64) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket_order_visitor
-- ----------------------------

-- ----------------------------
-- Table structure for verify_code
-- ----------------------------
DROP TABLE IF EXISTS `verify_code`;
CREATE TABLE `verify_code` (
  `id` varchar(255) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `use_time` datetime DEFAULT NULL,
  `used` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verify_code
-- ----------------------------
INSERT INTO `verify_code` VALUES ('9c13c7b0-8b7c-48fb-b0ad-43850f33aad7', '311812', '2017-07-06 15:52:24', '2017-07-06 16:22:24', '15010506169', '101', '2017-07-06 15:52:39', '');

-- ----------------------------
-- Table structure for visa
-- ----------------------------
DROP TABLE IF EXISTS `visa`;
CREATE TABLE `visa` (
  `id` varchar(255) NOT NULL,
  `booking_notice` varchar(1024) DEFAULT NULL,
  `can_use_score` int(11) DEFAULT NULL,
  `comments_score` int(11) DEFAULT NULL,
  `contract_payment` varchar(1024) DEFAULT NULL,
  `entry_times` varchar(255) DEFAULT NULL,
  `express_fee_description` varchar(1024) DEFAULT NULL,
  `freelancer_materials_needed` varchar(1024) DEFAULT NULL,
  `friendship_tips` varchar(1024) DEFAULT NULL,
  `handle_duration` varchar(255) DEFAULT NULL,
  `hide` bit(1) DEFAULT NULL,
  `interview` varchar(64) DEFAULT NULL,
  `issue_city` varchar(64) DEFAULT NULL,
  `maximum_stay_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `preschool_children_materials_needed` varchar(1024) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `process_type` int(11) DEFAULT NULL,
  `recommend` bit(1) DEFAULT NULL,
  `retiree_materials_needed` varchar(1024) DEFAULT NULL,
  `school_student_materials_needed` varchar(1024) DEFAULT NULL,
  `serving_officer_materials_needed` varchar(1024) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `tips` varchar(1024) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `valid_period` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visa
-- ----------------------------
INSERT INTO `visa` VALUES ('997639ca-eeca-4581-afa8-f7f96da1c82b', null, '5', '4', null, '9', null, '<p>2</p>', null, '7', '\0', '2', null, '8', '1', '<p>5</p>', null, null, '\0', '<p>3</p>', '<p>4</p>', '<p>1</p>', '10', null, '441a8d72-23ab-40f4-a67f-2a0de5c3a878', '6');
