/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : caipiao

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-10 17:28:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(11) DEFAULT NULL COMMENT '管理员网名',
  `username` varchar(11) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', '云主机', 'admin', '5A54707451EEDFAFA37FD41532DF6CF7', null);

-- ----------------------------
-- Table structure for `appversion`
-- ----------------------------
DROP TABLE IF EXISTS `appversion`;
CREATE TABLE `appversion` (
  `avid` int(11) NOT NULL COMMENT 'App版本主键id',
  `Avappid` varchar(32) DEFAULT NULL COMMENT '软件appid',
  `Avurl` varchar(50) DEFAULT NULL COMMENT 'App路径',
  `Aversion` varchar(50) DEFAULT NULL COMMENT 'App版本',
  `avtype` int(1) DEFAULT NULL COMMENT '版本类别',
  `avtime` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`avid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of appversion
-- ----------------------------

-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `arId` int(11) NOT NULL AUTO_INCREMENT COMMENT '区/县ID',
  `ctId` int(11) NOT NULL COMMENT '市ID',
  `arName` varchar(32) NOT NULL COMMENT '区/县名称',
  PRIMARY KEY (`arId`),
  KEY `ctId` (`ctId`),
  KEY `arId` (`arId`),
  KEY `arId_2` (`arId`),
  KEY `arId_3` (`arId`),
  KEY `arId_4` (`arId`),
  KEY `arId_5` (`arId`),
  KEY `arId_6` (`arId`),
  KEY `arId_7` (`arId`),
  KEY `arId_8` (`arId`),
  KEY `arId_9` (`arId`),
  CONSTRAINT `area_fk` FOREIGN KEY (`ctId`) REFERENCES `city` (`ctId`)
) ENGINE=InnoDB AUTO_INCREMENT=5001 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 9216 kB; (`ctId`) REFER `shuiguoshop/city`(`ctI';

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('378', '33', '东城区');
INSERT INTO `area` VALUES ('379', '33', '西城区');
INSERT INTO `area` VALUES ('382', '33', '朝阳区');
INSERT INTO `area` VALUES ('383', '33', '丰台区');
INSERT INTO `area` VALUES ('384', '33', '石景山区');
INSERT INTO `area` VALUES ('385', '33', '海淀区');
INSERT INTO `area` VALUES ('386', '33', '门头沟区');
INSERT INTO `area` VALUES ('387', '33', '房山区');
INSERT INTO `area` VALUES ('388', '33', '通州区');
INSERT INTO `area` VALUES ('389', '33', '顺义区');
INSERT INTO `area` VALUES ('390', '33', '昌平区');
INSERT INTO `area` VALUES ('391', '33', '大兴区');
INSERT INTO `area` VALUES ('392', '33', '怀柔区');
INSERT INTO `area` VALUES ('393', '33', '平谷区');
INSERT INTO `area` VALUES ('394', '34', '密云县');
INSERT INTO `area` VALUES ('395', '34', '延庆县');
INSERT INTO `area` VALUES ('396', '35', '和平区');
INSERT INTO `area` VALUES ('397', '35', '河东区');
INSERT INTO `area` VALUES ('398', '35', '河西区');
INSERT INTO `area` VALUES ('399', '35', '南开区');
INSERT INTO `area` VALUES ('400', '35', '河北区');
INSERT INTO `area` VALUES ('401', '35', '红桥区');
INSERT INTO `area` VALUES ('404', '35', '滨海新区');
INSERT INTO `area` VALUES ('405', '35', '东丽区');
INSERT INTO `area` VALUES ('406', '35', '西青区');
INSERT INTO `area` VALUES ('407', '35', '津南区');
INSERT INTO `area` VALUES ('408', '35', '北辰区');
INSERT INTO `area` VALUES ('409', '35', '武清区');
INSERT INTO `area` VALUES ('410', '35', '宝坻区');
INSERT INTO `area` VALUES ('411', '36', '宁河县');
INSERT INTO `area` VALUES ('412', '36', '静海县');
INSERT INTO `area` VALUES ('413', '36', '蓟县');
INSERT INTO `area` VALUES ('414', '37', '市辖区');
INSERT INTO `area` VALUES ('415', '37', '长安区');
INSERT INTO `area` VALUES ('416', '37', '桥东区');
INSERT INTO `area` VALUES ('417', '37', '桥西区');
INSERT INTO `area` VALUES ('418', '37', '新华区');
INSERT INTO `area` VALUES ('419', '37', '井陉矿区');
INSERT INTO `area` VALUES ('420', '37', '裕华区');
INSERT INTO `area` VALUES ('421', '37', '井陉县');
INSERT INTO `area` VALUES ('422', '37', '正定县');
INSERT INTO `area` VALUES ('423', '37', '栾城县');
INSERT INTO `area` VALUES ('424', '37', '行唐县');
INSERT INTO `area` VALUES ('425', '37', '灵寿县');
INSERT INTO `area` VALUES ('426', '37', '高邑县');
INSERT INTO `area` VALUES ('427', '37', '深泽县');
INSERT INTO `area` VALUES ('428', '37', '赞皇县');
INSERT INTO `area` VALUES ('429', '37', '无极县');
INSERT INTO `area` VALUES ('430', '37', '平山县');
INSERT INTO `area` VALUES ('431', '37', '元氏县');
INSERT INTO `area` VALUES ('432', '37', '赵县');
INSERT INTO `area` VALUES ('433', '37', '辛集市');
INSERT INTO `area` VALUES ('434', '37', '藁城市');
INSERT INTO `area` VALUES ('435', '37', '晋州市');
INSERT INTO `area` VALUES ('436', '37', '新乐市');
INSERT INTO `area` VALUES ('437', '37', '鹿泉市');
INSERT INTO `area` VALUES ('438', '38', '市辖区');
INSERT INTO `area` VALUES ('439', '38', '路南区');
INSERT INTO `area` VALUES ('440', '38', '路北区');
INSERT INTO `area` VALUES ('441', '38', '古冶区');
INSERT INTO `area` VALUES ('442', '38', '开平区');
INSERT INTO `area` VALUES ('443', '38', '丰南区');
INSERT INTO `area` VALUES ('444', '38', '丰润区');
INSERT INTO `area` VALUES ('445', '38', '滦县');
INSERT INTO `area` VALUES ('446', '38', '滦南县');
INSERT INTO `area` VALUES ('447', '38', '乐亭县');
INSERT INTO `area` VALUES ('448', '38', '迁西县');
INSERT INTO `area` VALUES ('449', '38', '玉田县');
INSERT INTO `area` VALUES ('450', '38', '唐海县');
INSERT INTO `area` VALUES ('451', '38', '遵化市');
INSERT INTO `area` VALUES ('452', '38', '迁安市');
INSERT INTO `area` VALUES ('453', '39', '市辖区');
INSERT INTO `area` VALUES ('454', '39', '海港区');
INSERT INTO `area` VALUES ('455', '39', '山海关区');
INSERT INTO `area` VALUES ('456', '39', '北戴河区');
INSERT INTO `area` VALUES ('457', '39', '青龙满族自治县');
INSERT INTO `area` VALUES ('458', '39', '昌黎县');
INSERT INTO `area` VALUES ('459', '39', '抚宁县');
INSERT INTO `area` VALUES ('460', '39', '卢龙县');
INSERT INTO `area` VALUES ('461', '40', '市辖区');
INSERT INTO `area` VALUES ('462', '40', '邯山区');
INSERT INTO `area` VALUES ('463', '40', '丛台区');
INSERT INTO `area` VALUES ('464', '40', '复兴区');
INSERT INTO `area` VALUES ('465', '40', '峰峰矿区');
INSERT INTO `area` VALUES ('466', '40', '邯郸县');
INSERT INTO `area` VALUES ('467', '40', '临漳县');
INSERT INTO `area` VALUES ('468', '40', '成安县');
INSERT INTO `area` VALUES ('469', '40', '大名县');
INSERT INTO `area` VALUES ('470', '40', '涉县');
INSERT INTO `area` VALUES ('471', '40', '磁县');
INSERT INTO `area` VALUES ('472', '40', '肥乡县');
INSERT INTO `area` VALUES ('473', '40', '永年县');
INSERT INTO `area` VALUES ('474', '40', '邱县');
INSERT INTO `area` VALUES ('475', '40', '鸡泽县');
INSERT INTO `area` VALUES ('476', '40', '广平县');
INSERT INTO `area` VALUES ('477', '40', '馆陶县');
INSERT INTO `area` VALUES ('478', '40', '魏县');
INSERT INTO `area` VALUES ('479', '40', '曲周县');
INSERT INTO `area` VALUES ('480', '40', '武安市');
INSERT INTO `area` VALUES ('481', '41', '市辖区');
INSERT INTO `area` VALUES ('482', '41', '桥东区');
INSERT INTO `area` VALUES ('483', '41', '桥西区');
INSERT INTO `area` VALUES ('484', '41', '邢台县');
INSERT INTO `area` VALUES ('485', '41', '临城县');
INSERT INTO `area` VALUES ('486', '41', '内丘县');
INSERT INTO `area` VALUES ('487', '41', '柏乡县');
INSERT INTO `area` VALUES ('488', '41', '隆尧县');
INSERT INTO `area` VALUES ('489', '41', '任县');
INSERT INTO `area` VALUES ('490', '41', '南和县');
INSERT INTO `area` VALUES ('491', '41', '宁晋县');
INSERT INTO `area` VALUES ('492', '41', '巨鹿县');
INSERT INTO `area` VALUES ('493', '41', '新河县');
INSERT INTO `area` VALUES ('494', '41', '广宗县');
INSERT INTO `area` VALUES ('495', '41', '平乡县');
INSERT INTO `area` VALUES ('496', '41', '威县');
INSERT INTO `area` VALUES ('497', '41', '清河县');
INSERT INTO `area` VALUES ('498', '41', '临西县');
INSERT INTO `area` VALUES ('499', '41', '南宫市');
INSERT INTO `area` VALUES ('500', '41', '沙河市');
INSERT INTO `area` VALUES ('501', '42', '市辖区');
INSERT INTO `area` VALUES ('502', '42', '新市区');
INSERT INTO `area` VALUES ('503', '42', '北市区');
INSERT INTO `area` VALUES ('504', '42', '南市区');
INSERT INTO `area` VALUES ('505', '42', '满城县');
INSERT INTO `area` VALUES ('506', '42', '清苑县');
INSERT INTO `area` VALUES ('507', '42', '涞水县');
INSERT INTO `area` VALUES ('508', '42', '阜平县');
INSERT INTO `area` VALUES ('509', '42', '徐水县');
INSERT INTO `area` VALUES ('510', '42', '定兴县');
INSERT INTO `area` VALUES ('511', '42', '唐县');
INSERT INTO `area` VALUES ('512', '42', '高阳县');
INSERT INTO `area` VALUES ('513', '42', '容城县');
INSERT INTO `area` VALUES ('514', '42', '涞源县');
INSERT INTO `area` VALUES ('515', '42', '望都县');
INSERT INTO `area` VALUES ('516', '42', '安新县');
INSERT INTO `area` VALUES ('517', '42', '易县');
INSERT INTO `area` VALUES ('518', '42', '曲阳县');
INSERT INTO `area` VALUES ('519', '42', '蠡县');
INSERT INTO `area` VALUES ('520', '42', '顺平县');
INSERT INTO `area` VALUES ('521', '42', '博野县');
INSERT INTO `area` VALUES ('522', '42', '雄县');
INSERT INTO `area` VALUES ('523', '42', '涿州市');
INSERT INTO `area` VALUES ('524', '42', '定州市');
INSERT INTO `area` VALUES ('525', '42', '安国市');
INSERT INTO `area` VALUES ('526', '42', '高碑店市');
INSERT INTO `area` VALUES ('527', '43', '市辖区');
INSERT INTO `area` VALUES ('528', '43', '桥东区');
INSERT INTO `area` VALUES ('529', '43', '桥西区');
INSERT INTO `area` VALUES ('530', '43', '宣化区');
INSERT INTO `area` VALUES ('531', '43', '下花园区');
INSERT INTO `area` VALUES ('532', '43', '宣化县');
INSERT INTO `area` VALUES ('533', '43', '张北县');
INSERT INTO `area` VALUES ('534', '43', '康保县');
INSERT INTO `area` VALUES ('535', '43', '沽源县');
INSERT INTO `area` VALUES ('536', '43', '尚义县');
INSERT INTO `area` VALUES ('537', '43', '蔚县');
INSERT INTO `area` VALUES ('538', '43', '阳原县');
INSERT INTO `area` VALUES ('539', '43', '怀安县');
INSERT INTO `area` VALUES ('540', '43', '万全县');
INSERT INTO `area` VALUES ('541', '43', '怀来县');
INSERT INTO `area` VALUES ('542', '43', '涿鹿县');
INSERT INTO `area` VALUES ('543', '43', '赤城县');
INSERT INTO `area` VALUES ('544', '43', '崇礼县');
INSERT INTO `area` VALUES ('545', '44', '市辖区');
INSERT INTO `area` VALUES ('546', '44', '双桥区');
INSERT INTO `area` VALUES ('547', '44', '双滦区');
INSERT INTO `area` VALUES ('548', '44', '鹰手营子矿区');
INSERT INTO `area` VALUES ('549', '44', '承德县');
INSERT INTO `area` VALUES ('550', '44', '兴隆县');
INSERT INTO `area` VALUES ('551', '44', '平泉县');
INSERT INTO `area` VALUES ('552', '44', '滦平县');
INSERT INTO `area` VALUES ('553', '44', '隆化县');
INSERT INTO `area` VALUES ('554', '44', '丰宁满族自治县');
INSERT INTO `area` VALUES ('555', '44', '宽城满族自治县');
INSERT INTO `area` VALUES ('556', '44', '围场满族蒙古族自治县');
INSERT INTO `area` VALUES ('557', '45', '市辖区');
INSERT INTO `area` VALUES ('558', '45', '新华区');
INSERT INTO `area` VALUES ('559', '45', '运河区');
INSERT INTO `area` VALUES ('560', '45', '沧县');
INSERT INTO `area` VALUES ('561', '45', '青县');
INSERT INTO `area` VALUES ('562', '45', '东光县');
INSERT INTO `area` VALUES ('563', '45', '海兴县');
INSERT INTO `area` VALUES ('564', '45', '盐山县');
INSERT INTO `area` VALUES ('565', '45', '肃宁县');
INSERT INTO `area` VALUES ('566', '45', '南皮县');
INSERT INTO `area` VALUES ('567', '45', '吴桥县');
INSERT INTO `area` VALUES ('568', '45', '献县');
INSERT INTO `area` VALUES ('569', '45', '孟村回族自治县');
INSERT INTO `area` VALUES ('570', '45', '泊头市');
INSERT INTO `area` VALUES ('571', '45', '任丘市');
INSERT INTO `area` VALUES ('572', '45', '黄骅市');
INSERT INTO `area` VALUES ('573', '45', '河间市');
INSERT INTO `area` VALUES ('574', '46', '市辖区');
INSERT INTO `area` VALUES ('575', '46', '安次区');
INSERT INTO `area` VALUES ('576', '46', '广阳区');
INSERT INTO `area` VALUES ('577', '46', '固安县');
INSERT INTO `area` VALUES ('578', '46', '永清县');
INSERT INTO `area` VALUES ('579', '46', '香河县');
INSERT INTO `area` VALUES ('580', '46', '大城县');
INSERT INTO `area` VALUES ('581', '46', '文安县');
INSERT INTO `area` VALUES ('582', '46', '大厂回族自治县');
INSERT INTO `area` VALUES ('583', '46', '霸州市');
INSERT INTO `area` VALUES ('584', '46', '三河市');
INSERT INTO `area` VALUES ('585', '47', '市辖区');
INSERT INTO `area` VALUES ('586', '47', '桃城区');
INSERT INTO `area` VALUES ('587', '47', '枣强县');
INSERT INTO `area` VALUES ('588', '47', '武邑县');
INSERT INTO `area` VALUES ('589', '47', '武强县');
INSERT INTO `area` VALUES ('590', '47', '饶阳县');
INSERT INTO `area` VALUES ('591', '47', '安平县');
INSERT INTO `area` VALUES ('592', '47', '故城县');
INSERT INTO `area` VALUES ('593', '47', '景县');
INSERT INTO `area` VALUES ('594', '47', '阜城县');
INSERT INTO `area` VALUES ('595', '47', '冀州市');
INSERT INTO `area` VALUES ('596', '47', '深州市');
INSERT INTO `area` VALUES ('597', '48', '市辖区');
INSERT INTO `area` VALUES ('598', '48', '小店区');
INSERT INTO `area` VALUES ('599', '48', '迎泽区');
INSERT INTO `area` VALUES ('600', '48', '杏花岭区');
INSERT INTO `area` VALUES ('601', '48', '尖草坪区');
INSERT INTO `area` VALUES ('602', '48', '万柏林区');
INSERT INTO `area` VALUES ('603', '48', '晋源区');
INSERT INTO `area` VALUES ('604', '48', '清徐县');
INSERT INTO `area` VALUES ('605', '48', '阳曲县');
INSERT INTO `area` VALUES ('606', '48', '娄烦县');
INSERT INTO `area` VALUES ('607', '48', '古交市');
INSERT INTO `area` VALUES ('608', '49', '市辖区');
INSERT INTO `area` VALUES ('609', '49', '城区');
INSERT INTO `area` VALUES ('610', '49', '矿区');
INSERT INTO `area` VALUES ('611', '49', '南郊区');
INSERT INTO `area` VALUES ('612', '49', '新荣区');
INSERT INTO `area` VALUES ('613', '49', '阳高县');
INSERT INTO `area` VALUES ('614', '49', '天镇县');
INSERT INTO `area` VALUES ('615', '49', '广灵县');
INSERT INTO `area` VALUES ('616', '49', '灵丘县');
INSERT INTO `area` VALUES ('617', '49', '浑源县');
INSERT INTO `area` VALUES ('618', '42', '左云县');
INSERT INTO `area` VALUES ('619', '49', '大同县');
INSERT INTO `area` VALUES ('620', '50', '市辖区');
INSERT INTO `area` VALUES ('621', '50', '城区');
INSERT INTO `area` VALUES ('622', '50', '矿区');
INSERT INTO `area` VALUES ('623', '50', '郊区');
INSERT INTO `area` VALUES ('624', '50', '平定县');
INSERT INTO `area` VALUES ('625', '50', '盂县');
INSERT INTO `area` VALUES ('626', '51', '市辖区');
INSERT INTO `area` VALUES ('627', '51', '城区');
INSERT INTO `area` VALUES ('628', '51', '郊区');
INSERT INTO `area` VALUES ('629', '51', '长治县');
INSERT INTO `area` VALUES ('630', '51', '襄垣县');
INSERT INTO `area` VALUES ('631', '51', '屯留县');
INSERT INTO `area` VALUES ('632', '51', '平顺县');
INSERT INTO `area` VALUES ('633', '51', '黎城县');
INSERT INTO `area` VALUES ('634', '51', '壶关县');
INSERT INTO `area` VALUES ('635', '51', '长子县');
INSERT INTO `area` VALUES ('636', '51', '武乡县');
INSERT INTO `area` VALUES ('637', '51', '沁县');
INSERT INTO `area` VALUES ('638', '51', '沁源县');
INSERT INTO `area` VALUES ('639', '51', '潞城市');
INSERT INTO `area` VALUES ('640', '52', '市辖区');
INSERT INTO `area` VALUES ('641', '52', '城区');
INSERT INTO `area` VALUES ('642', '52', '沁水县');
INSERT INTO `area` VALUES ('643', '52', '阳城县');
INSERT INTO `area` VALUES ('644', '52', '陵川县');
INSERT INTO `area` VALUES ('645', '52', '泽州县');
INSERT INTO `area` VALUES ('646', '52', '高平市');
INSERT INTO `area` VALUES ('647', '53', '市辖区');
INSERT INTO `area` VALUES ('648', '53', '朔城区');
INSERT INTO `area` VALUES ('649', '53', '平鲁区');
INSERT INTO `area` VALUES ('650', '53', '山阴县');
INSERT INTO `area` VALUES ('651', '53', '应县');
INSERT INTO `area` VALUES ('652', '53', '右玉县');
INSERT INTO `area` VALUES ('653', '53', '怀仁县');
INSERT INTO `area` VALUES ('654', '54', '市辖区');
INSERT INTO `area` VALUES ('655', '54', '榆次区');
INSERT INTO `area` VALUES ('656', '54', '榆社县');
INSERT INTO `area` VALUES ('657', '54', '左权县');
INSERT INTO `area` VALUES ('658', '54', '和顺县');
INSERT INTO `area` VALUES ('659', '54', '昔阳县');
INSERT INTO `area` VALUES ('660', '54', '寿阳县');
INSERT INTO `area` VALUES ('661', '54', '太谷县');
INSERT INTO `area` VALUES ('662', '54', '祁县');
INSERT INTO `area` VALUES ('663', '54', '平遥县');
INSERT INTO `area` VALUES ('664', '54', '灵石县');
INSERT INTO `area` VALUES ('665', '54', '介休市');
INSERT INTO `area` VALUES ('666', '55', '市辖区');
INSERT INTO `area` VALUES ('667', '55', '盐湖区');
INSERT INTO `area` VALUES ('668', '55', '临猗县');
INSERT INTO `area` VALUES ('669', '55', '万荣县');
INSERT INTO `area` VALUES ('670', '55', '闻喜县');
INSERT INTO `area` VALUES ('671', '55', '稷山县');
INSERT INTO `area` VALUES ('672', '55', '新绛县');
INSERT INTO `area` VALUES ('673', '55', '绛县');
INSERT INTO `area` VALUES ('674', '55', '垣曲县');
INSERT INTO `area` VALUES ('675', '55', '夏县');
INSERT INTO `area` VALUES ('676', '55', '平陆县');
INSERT INTO `area` VALUES ('677', '55', '芮城县');
INSERT INTO `area` VALUES ('678', '55', '永济市');
INSERT INTO `area` VALUES ('679', '55', '河津市');
INSERT INTO `area` VALUES ('680', '56', '市辖区');
INSERT INTO `area` VALUES ('681', '56', '忻府区');
INSERT INTO `area` VALUES ('682', '56', '定襄县');
INSERT INTO `area` VALUES ('683', '56', '五台县');
INSERT INTO `area` VALUES ('684', '56', '代县');
INSERT INTO `area` VALUES ('685', '56', '繁峙县');
INSERT INTO `area` VALUES ('686', '56', '宁武县');
INSERT INTO `area` VALUES ('687', '56', '静乐县');
INSERT INTO `area` VALUES ('688', '56', '神池县');
INSERT INTO `area` VALUES ('689', '56', '五寨县');
INSERT INTO `area` VALUES ('690', '56', '岢岚县');
INSERT INTO `area` VALUES ('691', '56', '河曲县');
INSERT INTO `area` VALUES ('692', '56', '保德县');
INSERT INTO `area` VALUES ('693', '56', '偏关县');
INSERT INTO `area` VALUES ('694', '56', '原平市');
INSERT INTO `area` VALUES ('695', '57', '市辖区');
INSERT INTO `area` VALUES ('696', '57', '尧都区');
INSERT INTO `area` VALUES ('697', '57', '曲沃县');
INSERT INTO `area` VALUES ('698', '57', '翼城县');
INSERT INTO `area` VALUES ('699', '57', '襄汾县');
INSERT INTO `area` VALUES ('700', '57', '洪洞县');
INSERT INTO `area` VALUES ('701', '57', '古县');
INSERT INTO `area` VALUES ('702', '57', '安泽县');
INSERT INTO `area` VALUES ('703', '57', '浮山县');
INSERT INTO `area` VALUES ('704', '57', '吉县');
INSERT INTO `area` VALUES ('705', '57', '乡宁县');
INSERT INTO `area` VALUES ('706', '57', '大宁县');
INSERT INTO `area` VALUES ('707', '57', '隰县');
INSERT INTO `area` VALUES ('708', '57', '永和县');
INSERT INTO `area` VALUES ('709', '57', '蒲县');
INSERT INTO `area` VALUES ('710', '57', '汾西县');
INSERT INTO `area` VALUES ('711', '57', '侯马市');
INSERT INTO `area` VALUES ('712', '57', '霍州市');
INSERT INTO `area` VALUES ('713', '58', '市辖区');
INSERT INTO `area` VALUES ('714', '58', '离石区');
INSERT INTO `area` VALUES ('715', '58', '文水县');
INSERT INTO `area` VALUES ('716', '58', '交城县');
INSERT INTO `area` VALUES ('717', '58', '兴县');
INSERT INTO `area` VALUES ('718', '58', '临县');
INSERT INTO `area` VALUES ('719', '58', '柳林县');
INSERT INTO `area` VALUES ('720', '58', '石楼县');
INSERT INTO `area` VALUES ('721', '58', '岚县');
INSERT INTO `area` VALUES ('722', '58', '方山县');
INSERT INTO `area` VALUES ('723', '58', '中阳县');
INSERT INTO `area` VALUES ('724', '58', '交口县');
INSERT INTO `area` VALUES ('725', '58', '孝义市');
INSERT INTO `area` VALUES ('726', '58', '汾阳市');
INSERT INTO `area` VALUES ('727', '59', '市辖区');
INSERT INTO `area` VALUES ('728', '59', '新城区');
INSERT INTO `area` VALUES ('729', '59', '回民区');
INSERT INTO `area` VALUES ('730', '59', '玉泉区');
INSERT INTO `area` VALUES ('731', '59', '赛罕区');
INSERT INTO `area` VALUES ('732', '59', '土默特左旗');
INSERT INTO `area` VALUES ('733', '59', '托克托县');
INSERT INTO `area` VALUES ('734', '59', '和林格尔县');
INSERT INTO `area` VALUES ('735', '59', '清水河县');
INSERT INTO `area` VALUES ('736', '59', '武川县');
INSERT INTO `area` VALUES ('737', '60', '市辖区');
INSERT INTO `area` VALUES ('738', '60', '东河区');
INSERT INTO `area` VALUES ('739', '60', '昆都仑区');
INSERT INTO `area` VALUES ('740', '60', '青山区');
INSERT INTO `area` VALUES ('741', '60', '石拐区');
INSERT INTO `area` VALUES ('742', '60', '白云鄂博矿区');
INSERT INTO `area` VALUES ('743', '60', '九原区');
INSERT INTO `area` VALUES ('744', '60', '土默特右旗');
INSERT INTO `area` VALUES ('745', '60', '固阳县');
INSERT INTO `area` VALUES ('746', '60', '达尔罕茂明安联合旗');
INSERT INTO `area` VALUES ('747', '61', '市辖区');
INSERT INTO `area` VALUES ('748', '61', '海勃湾区');
INSERT INTO `area` VALUES ('749', '61', '海南区');
INSERT INTO `area` VALUES ('750', '61', '乌达区');
INSERT INTO `area` VALUES ('751', '62', '市辖区');
INSERT INTO `area` VALUES ('752', '62', '红山区');
INSERT INTO `area` VALUES ('753', '62', '元宝山区');
INSERT INTO `area` VALUES ('754', '62', '松山区');
INSERT INTO `area` VALUES ('755', '62', '阿鲁科尔沁旗');
INSERT INTO `area` VALUES ('756', '62', '巴林左旗');
INSERT INTO `area` VALUES ('757', '62', '巴林右旗');
INSERT INTO `area` VALUES ('758', '62', '林西县');
INSERT INTO `area` VALUES ('759', '62', '克什克腾旗');
INSERT INTO `area` VALUES ('760', '62', '翁牛特旗');
INSERT INTO `area` VALUES ('761', '62', '喀喇沁旗');
INSERT INTO `area` VALUES ('762', '62', '宁城县');
INSERT INTO `area` VALUES ('763', '62', '敖汉旗');
INSERT INTO `area` VALUES ('764', '63', '市辖区');
INSERT INTO `area` VALUES ('765', '63', '科尔沁区');
INSERT INTO `area` VALUES ('766', '63', '科尔沁左翼中旗');
INSERT INTO `area` VALUES ('767', '63', '科尔沁左翼后旗');
INSERT INTO `area` VALUES ('768', '63', '开鲁县');
INSERT INTO `area` VALUES ('769', '63', '库伦旗');
INSERT INTO `area` VALUES ('770', '63', '奈曼旗');
INSERT INTO `area` VALUES ('771', '63', '扎鲁特旗');
INSERT INTO `area` VALUES ('772', '63', '霍林郭勒市');
INSERT INTO `area` VALUES ('773', '64', '东胜区');
INSERT INTO `area` VALUES ('774', '64', '达拉特旗');
INSERT INTO `area` VALUES ('775', '64', '准格尔旗');
INSERT INTO `area` VALUES ('776', '64', '鄂托克前旗');
INSERT INTO `area` VALUES ('777', '64', '鄂托克旗');
INSERT INTO `area` VALUES ('778', '64', '杭锦旗');
INSERT INTO `area` VALUES ('779', '64', '乌审旗');
INSERT INTO `area` VALUES ('780', '64', '伊金霍洛旗');
INSERT INTO `area` VALUES ('781', '65', '市辖区');
INSERT INTO `area` VALUES ('782', '65', '海拉尔区');
INSERT INTO `area` VALUES ('783', '65', '阿荣旗');
INSERT INTO `area` VALUES ('784', '65', '莫力达瓦达斡尔族自治旗');
INSERT INTO `area` VALUES ('785', '65', '鄂伦春自治旗');
INSERT INTO `area` VALUES ('786', '65', '鄂温克族自治旗');
INSERT INTO `area` VALUES ('787', '65', '陈巴尔虎旗');
INSERT INTO `area` VALUES ('788', '65', '新巴尔虎左旗');
INSERT INTO `area` VALUES ('789', '65', '新巴尔虎右旗');
INSERT INTO `area` VALUES ('790', '65', '满洲里市');
INSERT INTO `area` VALUES ('791', '65', '牙克石市');
INSERT INTO `area` VALUES ('792', '65', '扎兰屯市');
INSERT INTO `area` VALUES ('793', '65', '额尔古纳市');
INSERT INTO `area` VALUES ('794', '65', '根河市');
INSERT INTO `area` VALUES ('795', '66', '市辖区');
INSERT INTO `area` VALUES ('796', '66', '临河区');
INSERT INTO `area` VALUES ('797', '66', '五原县');
INSERT INTO `area` VALUES ('798', '66', '磴口县');
INSERT INTO `area` VALUES ('799', '66', '乌拉特前旗');
INSERT INTO `area` VALUES ('800', '66', '乌拉特中旗');
INSERT INTO `area` VALUES ('801', '66', '乌拉特后旗');
INSERT INTO `area` VALUES ('802', '66', '杭锦后旗');
INSERT INTO `area` VALUES ('803', '67', '市辖区');
INSERT INTO `area` VALUES ('804', '67', '集宁区');
INSERT INTO `area` VALUES ('805', '67', '卓资县');
INSERT INTO `area` VALUES ('806', '67', '化德县');
INSERT INTO `area` VALUES ('807', '67', '商都县');
INSERT INTO `area` VALUES ('808', '67', '兴和县');
INSERT INTO `area` VALUES ('809', '67', '凉城县');
INSERT INTO `area` VALUES ('810', '67', '察哈尔右翼前旗');
INSERT INTO `area` VALUES ('811', '67', '察哈尔右翼中旗');
INSERT INTO `area` VALUES ('812', '67', '察哈尔右翼后旗');
INSERT INTO `area` VALUES ('813', '67', '四子王旗');
INSERT INTO `area` VALUES ('814', '67', '丰镇市');
INSERT INTO `area` VALUES ('815', '68', '乌兰浩特市');
INSERT INTO `area` VALUES ('816', '68', '阿尔山市');
INSERT INTO `area` VALUES ('817', '68', '科尔沁右翼前旗');
INSERT INTO `area` VALUES ('818', '68', '科尔沁右翼中旗');
INSERT INTO `area` VALUES ('819', '68', '扎赉特旗');
INSERT INTO `area` VALUES ('820', '68', '突泉县');
INSERT INTO `area` VALUES ('821', '69', '二连浩特市');
INSERT INTO `area` VALUES ('822', '69', '锡林浩特市');
INSERT INTO `area` VALUES ('823', '69', '阿巴嘎旗');
INSERT INTO `area` VALUES ('824', '69', '苏尼特左旗');
INSERT INTO `area` VALUES ('825', '69', '苏尼特右旗');
INSERT INTO `area` VALUES ('826', '69', '东乌珠穆沁旗');
INSERT INTO `area` VALUES ('827', '69', '西乌珠穆沁旗');
INSERT INTO `area` VALUES ('828', '69', '太仆寺旗');
INSERT INTO `area` VALUES ('829', '69', '镶黄旗');
INSERT INTO `area` VALUES ('830', '69', '正镶白旗');
INSERT INTO `area` VALUES ('831', '69', '正蓝旗');
INSERT INTO `area` VALUES ('832', '69', '多伦县');
INSERT INTO `area` VALUES ('833', '70', '阿拉善左旗');
INSERT INTO `area` VALUES ('834', '70', '阿拉善右旗');
INSERT INTO `area` VALUES ('835', '70', '额济纳旗');
INSERT INTO `area` VALUES ('836', '71', '市辖区');
INSERT INTO `area` VALUES ('837', '71', '和平区');
INSERT INTO `area` VALUES ('838', '71', '沈河区');
INSERT INTO `area` VALUES ('839', '71', '大东区');
INSERT INTO `area` VALUES ('840', '71', '皇姑区');
INSERT INTO `area` VALUES ('841', '71', '铁西区');
INSERT INTO `area` VALUES ('842', '71', '苏家屯区');
INSERT INTO `area` VALUES ('843', '71', '东陵区');
INSERT INTO `area` VALUES ('844', '71', '沈北新区');
INSERT INTO `area` VALUES ('845', '71', '于洪区');
INSERT INTO `area` VALUES ('846', '71', '辽中县');
INSERT INTO `area` VALUES ('847', '71', '康平县');
INSERT INTO `area` VALUES ('848', '71', '法库县');
INSERT INTO `area` VALUES ('849', '71', '新民市');
INSERT INTO `area` VALUES ('850', '72', '市辖区');
INSERT INTO `area` VALUES ('851', '72', '中山区');
INSERT INTO `area` VALUES ('852', '72', '西岗区');
INSERT INTO `area` VALUES ('853', '72', '沙河口区');
INSERT INTO `area` VALUES ('854', '72', '甘井子区');
INSERT INTO `area` VALUES ('855', '72', '旅顺口区');
INSERT INTO `area` VALUES ('856', '72', '金州区');
INSERT INTO `area` VALUES ('857', '72', '长海县');
INSERT INTO `area` VALUES ('858', '72', '瓦房店市');
INSERT INTO `area` VALUES ('859', '72', '普兰店市');
INSERT INTO `area` VALUES ('860', '72', '庄河市');
INSERT INTO `area` VALUES ('861', '73', '市辖区');
INSERT INTO `area` VALUES ('862', '73', '铁东区');
INSERT INTO `area` VALUES ('863', '73', '铁西区');
INSERT INTO `area` VALUES ('864', '73', '立山区');
INSERT INTO `area` VALUES ('865', '73', '千山区');
INSERT INTO `area` VALUES ('866', '73', '台安县');
INSERT INTO `area` VALUES ('867', '73', '岫岩满族自治县');
INSERT INTO `area` VALUES ('868', '73', '海城市');
INSERT INTO `area` VALUES ('869', '74', '市辖区');
INSERT INTO `area` VALUES ('870', '74', '新抚区');
INSERT INTO `area` VALUES ('871', '74', '东洲区');
INSERT INTO `area` VALUES ('872', '74', '望花区');
INSERT INTO `area` VALUES ('873', '74', '顺城区');
INSERT INTO `area` VALUES ('874', '74', '抚顺县');
INSERT INTO `area` VALUES ('875', '74', '新宾满族自治县');
INSERT INTO `area` VALUES ('876', '74', '清原满族自治县');
INSERT INTO `area` VALUES ('877', '75', '市辖区');
INSERT INTO `area` VALUES ('878', '75', '平山区');
INSERT INTO `area` VALUES ('879', '75', '溪湖区');
INSERT INTO `area` VALUES ('880', '75', '明山区');
INSERT INTO `area` VALUES ('881', '75', '南芬区');
INSERT INTO `area` VALUES ('882', '75', '本溪满族自治县');
INSERT INTO `area` VALUES ('883', '75', '桓仁满族自治县');
INSERT INTO `area` VALUES ('884', '76', '市辖区');
INSERT INTO `area` VALUES ('885', '76', '元宝区');
INSERT INTO `area` VALUES ('886', '76', '振兴区');
INSERT INTO `area` VALUES ('887', '76', '振安区');
INSERT INTO `area` VALUES ('888', '76', '宽甸满族自治县');
INSERT INTO `area` VALUES ('889', '76', '东港市');
INSERT INTO `area` VALUES ('890', '76', '凤城市');
INSERT INTO `area` VALUES ('891', '77', '市辖区');
INSERT INTO `area` VALUES ('892', '77', '古塔区');
INSERT INTO `area` VALUES ('893', '77', '凌河区');
INSERT INTO `area` VALUES ('894', '77', '太和区');
INSERT INTO `area` VALUES ('895', '77', '黑山县');
INSERT INTO `area` VALUES ('896', '77', '义县');
INSERT INTO `area` VALUES ('897', '77', '凌海市');
INSERT INTO `area` VALUES ('898', '77', '北镇市');
INSERT INTO `area` VALUES ('899', '78', '市辖区');
INSERT INTO `area` VALUES ('900', '78', '站前区');
INSERT INTO `area` VALUES ('901', '78', '西市区');
INSERT INTO `area` VALUES ('902', '78', '鲅鱼圈区');
INSERT INTO `area` VALUES ('903', '78', '老边区');
INSERT INTO `area` VALUES ('904', '78', '盖州市');
INSERT INTO `area` VALUES ('905', '78', '大石桥市');
INSERT INTO `area` VALUES ('906', '79', '市辖区');
INSERT INTO `area` VALUES ('907', '79', '海州区');
INSERT INTO `area` VALUES ('908', '79', '新邱区');
INSERT INTO `area` VALUES ('909', '79', '太平区');
INSERT INTO `area` VALUES ('910', '79', '清河门区');
INSERT INTO `area` VALUES ('911', '79', '细河区');
INSERT INTO `area` VALUES ('912', '79', '阜新蒙古族自治县');
INSERT INTO `area` VALUES ('913', '79', '彰武县');
INSERT INTO `area` VALUES ('914', '80', '市辖区');
INSERT INTO `area` VALUES ('915', '80', '白塔区');
INSERT INTO `area` VALUES ('916', '80', '文圣区');
INSERT INTO `area` VALUES ('917', '80', '宏伟区');
INSERT INTO `area` VALUES ('918', '80', '弓长岭区');
INSERT INTO `area` VALUES ('919', '80', '太子河区');
INSERT INTO `area` VALUES ('920', '80', '辽阳县');
INSERT INTO `area` VALUES ('921', '80', '灯塔市');
INSERT INTO `area` VALUES ('922', '81', '市辖区');
INSERT INTO `area` VALUES ('923', '81', '双台子区');
INSERT INTO `area` VALUES ('924', '81', '兴隆台区');
INSERT INTO `area` VALUES ('925', '81', '大洼县');
INSERT INTO `area` VALUES ('926', '81', '盘山县');
INSERT INTO `area` VALUES ('927', '82', '市辖区');
INSERT INTO `area` VALUES ('928', '82', '银州区');
INSERT INTO `area` VALUES ('929', '82', '清河区');
INSERT INTO `area` VALUES ('930', '82', '铁岭县');
INSERT INTO `area` VALUES ('931', '82', '西丰县');
INSERT INTO `area` VALUES ('932', '82', '昌图县');
INSERT INTO `area` VALUES ('933', '82', '调兵山市');
INSERT INTO `area` VALUES ('934', '82', '开原市');
INSERT INTO `area` VALUES ('935', '83', '市辖区');
INSERT INTO `area` VALUES ('936', '83', '双塔区');
INSERT INTO `area` VALUES ('937', '83', '龙城区');
INSERT INTO `area` VALUES ('938', '83', '朝阳县');
INSERT INTO `area` VALUES ('939', '83', '建平县');
INSERT INTO `area` VALUES ('940', '83', '喀喇沁左翼蒙古族自治县');
INSERT INTO `area` VALUES ('941', '83', '北票市');
INSERT INTO `area` VALUES ('942', '83', '凌源市');
INSERT INTO `area` VALUES ('943', '84', '市辖区');
INSERT INTO `area` VALUES ('944', '84', '连山区');
INSERT INTO `area` VALUES ('945', '84', '龙港区');
INSERT INTO `area` VALUES ('946', '84', '南票区');
INSERT INTO `area` VALUES ('947', '84', '绥中县');
INSERT INTO `area` VALUES ('948', '84', '建昌县');
INSERT INTO `area` VALUES ('949', '84', '兴城市');
INSERT INTO `area` VALUES ('950', '85', '市辖区');
INSERT INTO `area` VALUES ('951', '85', '南关区');
INSERT INTO `area` VALUES ('952', '85', '宽城区');
INSERT INTO `area` VALUES ('953', '85', '朝阳区');
INSERT INTO `area` VALUES ('954', '85', '二道区');
INSERT INTO `area` VALUES ('955', '85', '绿园区');
INSERT INTO `area` VALUES ('956', '85', '双阳区');
INSERT INTO `area` VALUES ('957', '85', '农安县');
INSERT INTO `area` VALUES ('958', '85', '九台市');
INSERT INTO `area` VALUES ('959', '85', '榆树市');
INSERT INTO `area` VALUES ('960', '85', '德惠市');
INSERT INTO `area` VALUES ('961', '86', '市辖区');
INSERT INTO `area` VALUES ('962', '86', '昌邑区');
INSERT INTO `area` VALUES ('963', '86', '龙潭区');
INSERT INTO `area` VALUES ('964', '86', '船营区');
INSERT INTO `area` VALUES ('965', '86', '丰满区');
INSERT INTO `area` VALUES ('966', '86', '永吉县');
INSERT INTO `area` VALUES ('967', '86', '蛟河市');
INSERT INTO `area` VALUES ('968', '86', '桦甸市');
INSERT INTO `area` VALUES ('969', '86', '舒兰市');
INSERT INTO `area` VALUES ('970', '86', '磐石市');
INSERT INTO `area` VALUES ('971', '87', '市辖区');
INSERT INTO `area` VALUES ('972', '87', '铁西区');
INSERT INTO `area` VALUES ('973', '87', '铁东区');
INSERT INTO `area` VALUES ('974', '87', '梨树县');
INSERT INTO `area` VALUES ('975', '87', '伊通满族自治县');
INSERT INTO `area` VALUES ('976', '87', '公主岭市');
INSERT INTO `area` VALUES ('977', '87', '双辽市');
INSERT INTO `area` VALUES ('978', '88', '市辖区');
INSERT INTO `area` VALUES ('979', '88', '龙山区');
INSERT INTO `area` VALUES ('980', '88', '西安区');
INSERT INTO `area` VALUES ('981', '88', '东丰县');
INSERT INTO `area` VALUES ('982', '88', '东辽县');
INSERT INTO `area` VALUES ('983', '89', '市辖区');
INSERT INTO `area` VALUES ('984', '89', '东昌区');
INSERT INTO `area` VALUES ('985', '89', '二道江区');
INSERT INTO `area` VALUES ('986', '89', '通化县');
INSERT INTO `area` VALUES ('987', '89', '辉南县');
INSERT INTO `area` VALUES ('988', '89', '柳河县');
INSERT INTO `area` VALUES ('989', '89', '梅河口市');
INSERT INTO `area` VALUES ('990', '89', '集安市');
INSERT INTO `area` VALUES ('991', '90', '市辖区');
INSERT INTO `area` VALUES ('992', '90', '八道江区');
INSERT INTO `area` VALUES ('993', '90', '抚松县');
INSERT INTO `area` VALUES ('994', '90', '靖宇县');
INSERT INTO `area` VALUES ('995', '90', '长白朝鲜族自治县');
INSERT INTO `area` VALUES ('996', '90', '江源区');
INSERT INTO `area` VALUES ('997', '90', '临江市');
INSERT INTO `area` VALUES ('998', '91', '市辖区');
INSERT INTO `area` VALUES ('999', '91', '宁江区');
INSERT INTO `area` VALUES ('1000', '91', '前郭尔罗斯蒙古族自治县');
INSERT INTO `area` VALUES ('1001', '91', '长岭县');
INSERT INTO `area` VALUES ('1002', '91', '乾安县');
INSERT INTO `area` VALUES ('1003', '91', '扶余县');
INSERT INTO `area` VALUES ('1004', '92', '市辖区');
INSERT INTO `area` VALUES ('1005', '92', '洮北区');
INSERT INTO `area` VALUES ('1006', '92', '镇赉县');
INSERT INTO `area` VALUES ('1007', '92', '通榆县');
INSERT INTO `area` VALUES ('1008', '92', '洮南市');
INSERT INTO `area` VALUES ('1009', '92', '大安市');
INSERT INTO `area` VALUES ('1010', '93', '延吉市');
INSERT INTO `area` VALUES ('1011', '93', '图们市');
INSERT INTO `area` VALUES ('1012', '93', '敦化市');
INSERT INTO `area` VALUES ('1013', '93', '珲春市');
INSERT INTO `area` VALUES ('1014', '93', '龙井市');
INSERT INTO `area` VALUES ('1015', '93', '和龙市');
INSERT INTO `area` VALUES ('1016', '93', '汪清县');
INSERT INTO `area` VALUES ('1017', '93', '安图县');
INSERT INTO `area` VALUES ('1018', '94', '市辖区');
INSERT INTO `area` VALUES ('1019', '94', '道里区');
INSERT INTO `area` VALUES ('1020', '94', '南岗区');
INSERT INTO `area` VALUES ('1021', '94', '道外区');
INSERT INTO `area` VALUES ('1022', '94', '香坊区');
INSERT INTO `area` VALUES ('1024', '94', '平房区');
INSERT INTO `area` VALUES ('1025', '94', '松北区');
INSERT INTO `area` VALUES ('1026', '94', '呼兰区');
INSERT INTO `area` VALUES ('1027', '94', '依兰县');
INSERT INTO `area` VALUES ('1028', '94', '方正县');
INSERT INTO `area` VALUES ('1029', '94', '宾县');
INSERT INTO `area` VALUES ('1030', '94', '巴彦县');
INSERT INTO `area` VALUES ('1031', '94', '木兰县');
INSERT INTO `area` VALUES ('1032', '94', '通河县');
INSERT INTO `area` VALUES ('1033', '94', '延寿县');
INSERT INTO `area` VALUES ('1034', '94', '阿城区');
INSERT INTO `area` VALUES ('1035', '94', '双城市');
INSERT INTO `area` VALUES ('1036', '94', '尚志市');
INSERT INTO `area` VALUES ('1037', '94', '五常市');
INSERT INTO `area` VALUES ('1038', '95', '市辖区');
INSERT INTO `area` VALUES ('1039', '95', '龙沙区');
INSERT INTO `area` VALUES ('1040', '95', '建华区');
INSERT INTO `area` VALUES ('1041', '95', '铁锋区');
INSERT INTO `area` VALUES ('1042', '95', '昂昂溪区');
INSERT INTO `area` VALUES ('1043', '95', '富拉尔基区');
INSERT INTO `area` VALUES ('1044', '95', '碾子山区');
INSERT INTO `area` VALUES ('1045', '95', '梅里斯达斡尔族区');
INSERT INTO `area` VALUES ('1046', '95', '龙江县');
INSERT INTO `area` VALUES ('1047', '95', '依安县');
INSERT INTO `area` VALUES ('1048', '95', '泰来县');
INSERT INTO `area` VALUES ('1049', '95', '甘南县');
INSERT INTO `area` VALUES ('1050', '95', '富裕县');
INSERT INTO `area` VALUES ('1051', '95', '克山县');
INSERT INTO `area` VALUES ('1052', '95', '克东县');
INSERT INTO `area` VALUES ('1053', '95', '拜泉县');
INSERT INTO `area` VALUES ('1054', '95', '讷河市');
INSERT INTO `area` VALUES ('1055', '96', '市辖区');
INSERT INTO `area` VALUES ('1056', '96', '鸡冠区');
INSERT INTO `area` VALUES ('1057', '96', '恒山区');
INSERT INTO `area` VALUES ('1058', '96', '滴道区');
INSERT INTO `area` VALUES ('1059', '96', '梨树区');
INSERT INTO `area` VALUES ('1060', '96', '城子河区');
INSERT INTO `area` VALUES ('1061', '96', '麻山区');
INSERT INTO `area` VALUES ('1062', '96', '鸡东县');
INSERT INTO `area` VALUES ('1063', '96', '虎林市');
INSERT INTO `area` VALUES ('1064', '96', '密山市');
INSERT INTO `area` VALUES ('1065', '97', '市辖区');
INSERT INTO `area` VALUES ('1066', '97', '向阳区');
INSERT INTO `area` VALUES ('1067', '97', '工农区');
INSERT INTO `area` VALUES ('1068', '97', '南山区');
INSERT INTO `area` VALUES ('1069', '97', '兴安区');
INSERT INTO `area` VALUES ('1070', '97', '东山区');
INSERT INTO `area` VALUES ('1071', '97', '兴山区');
INSERT INTO `area` VALUES ('1072', '97', '萝北县');
INSERT INTO `area` VALUES ('1073', '97', '绥滨县');
INSERT INTO `area` VALUES ('1074', '98', '市辖区');
INSERT INTO `area` VALUES ('1075', '98', '尖山区');
INSERT INTO `area` VALUES ('1076', '98', '岭东区');
INSERT INTO `area` VALUES ('1077', '98', '四方台区');
INSERT INTO `area` VALUES ('1078', '98', '宝山区');
INSERT INTO `area` VALUES ('1079', '98', '集贤县');
INSERT INTO `area` VALUES ('1080', '98', '友谊县');
INSERT INTO `area` VALUES ('1081', '98', '宝清县');
INSERT INTO `area` VALUES ('1082', '98', '饶河县');
INSERT INTO `area` VALUES ('1083', '99', '市辖区');
INSERT INTO `area` VALUES ('1084', '99', '萨尔图区');
INSERT INTO `area` VALUES ('1085', '99', '龙凤区');
INSERT INTO `area` VALUES ('1086', '99', '让胡路区');
INSERT INTO `area` VALUES ('1087', '99', '红岗区');
INSERT INTO `area` VALUES ('1088', '99', '大同区');
INSERT INTO `area` VALUES ('1089', '99', '肇州县');
INSERT INTO `area` VALUES ('1090', '99', '肇源县');
INSERT INTO `area` VALUES ('1091', '99', '林甸县');
INSERT INTO `area` VALUES ('1092', '99', '杜尔伯特蒙古族自治县');
INSERT INTO `area` VALUES ('1093', '100', '市辖区');
INSERT INTO `area` VALUES ('1094', '100', '伊春区');
INSERT INTO `area` VALUES ('1095', '100', '南岔区');
INSERT INTO `area` VALUES ('1096', '100', '友好区');
INSERT INTO `area` VALUES ('1097', '100', '西林区');
INSERT INTO `area` VALUES ('1098', '100', '翠峦区');
INSERT INTO `area` VALUES ('1099', '100', '新青区');
INSERT INTO `area` VALUES ('1100', '100', '美溪区');
INSERT INTO `area` VALUES ('1101', '100', '金山屯区');
INSERT INTO `area` VALUES ('1102', '100', '五营区');
INSERT INTO `area` VALUES ('1103', '100', '乌马河区');
INSERT INTO `area` VALUES ('1104', '100', '汤旺河区');
INSERT INTO `area` VALUES ('1105', '100', '带岭区');
INSERT INTO `area` VALUES ('1106', '100', '乌伊岭区');
INSERT INTO `area` VALUES ('1107', '100', '红星区');
INSERT INTO `area` VALUES ('1108', '100', '上甘岭区');
INSERT INTO `area` VALUES ('1109', '100', '嘉荫县');
INSERT INTO `area` VALUES ('1110', '100', '铁力市');
INSERT INTO `area` VALUES ('1111', '101', '市辖区');
INSERT INTO `area` VALUES ('1113', '101', '向阳区');
INSERT INTO `area` VALUES ('1114', '101', '前进区');
INSERT INTO `area` VALUES ('1115', '101', '东风区');
INSERT INTO `area` VALUES ('1116', '101', '郊区');
INSERT INTO `area` VALUES ('1117', '101', '桦南县');
INSERT INTO `area` VALUES ('1118', '101', '桦川县');
INSERT INTO `area` VALUES ('1119', '101', '汤原县');
INSERT INTO `area` VALUES ('1120', '101', '抚远县');
INSERT INTO `area` VALUES ('1121', '101', '同江市');
INSERT INTO `area` VALUES ('1122', '101', '富锦市');
INSERT INTO `area` VALUES ('1123', '102', '市辖区');
INSERT INTO `area` VALUES ('1124', '102', '新兴区');
INSERT INTO `area` VALUES ('1125', '102', '桃山区');
INSERT INTO `area` VALUES ('1126', '102', '茄子河区');
INSERT INTO `area` VALUES ('1127', '102', '勃利县');
INSERT INTO `area` VALUES ('1128', '103', '市辖区');
INSERT INTO `area` VALUES ('1129', '103', '东安区');
INSERT INTO `area` VALUES ('1130', '103', '阳明区');
INSERT INTO `area` VALUES ('1131', '103', '爱民区');
INSERT INTO `area` VALUES ('1132', '103', '西安区');
INSERT INTO `area` VALUES ('1133', '103', '东宁县');
INSERT INTO `area` VALUES ('1134', '103', '林口县');
INSERT INTO `area` VALUES ('1135', '103', '绥芬河市');
INSERT INTO `area` VALUES ('1136', '103', '海林市');
INSERT INTO `area` VALUES ('1137', '103', '宁安市');
INSERT INTO `area` VALUES ('1138', '103', '穆棱市');
INSERT INTO `area` VALUES ('1139', '104', '市辖区');
INSERT INTO `area` VALUES ('1140', '104', '爱辉区');
INSERT INTO `area` VALUES ('1141', '104', '嫩江县');
INSERT INTO `area` VALUES ('1142', '104', '逊克县');
INSERT INTO `area` VALUES ('1143', '104', '孙吴县');
INSERT INTO `area` VALUES ('1144', '104', '北安市');
INSERT INTO `area` VALUES ('1145', '104', '五大连池市');
INSERT INTO `area` VALUES ('1146', '105', '市辖区');
INSERT INTO `area` VALUES ('1147', '105', '北林区');
INSERT INTO `area` VALUES ('1148', '105', '望奎县');
INSERT INTO `area` VALUES ('1149', '105', '兰西县');
INSERT INTO `area` VALUES ('1150', '105', '青冈县');
INSERT INTO `area` VALUES ('1151', '105', '庆安县');
INSERT INTO `area` VALUES ('1152', '105', '明水县');
INSERT INTO `area` VALUES ('1153', '105', '绥棱县');
INSERT INTO `area` VALUES ('1154', '105', '安达市');
INSERT INTO `area` VALUES ('1155', '105', '肇东市');
INSERT INTO `area` VALUES ('1156', '105', '海伦市');
INSERT INTO `area` VALUES ('1157', '106', '呼玛县');
INSERT INTO `area` VALUES ('1158', '106', '塔河县');
INSERT INTO `area` VALUES ('1159', '106', '漠河县');
INSERT INTO `area` VALUES ('1160', '107', '黄浦区');
INSERT INTO `area` VALUES ('1161', '107', '卢湾区');
INSERT INTO `area` VALUES ('1162', '107', '徐汇区');
INSERT INTO `area` VALUES ('1163', '107', '长宁区');
INSERT INTO `area` VALUES ('1164', '107', '静安区');
INSERT INTO `area` VALUES ('1165', '107', '普陀区');
INSERT INTO `area` VALUES ('1166', '107', '闸北区');
INSERT INTO `area` VALUES ('1167', '107', '虹口区');
INSERT INTO `area` VALUES ('1168', '107', '杨浦区');
INSERT INTO `area` VALUES ('1169', '107', '闵行区');
INSERT INTO `area` VALUES ('1170', '107', '宝山区');
INSERT INTO `area` VALUES ('1171', '107', '嘉定区');
INSERT INTO `area` VALUES ('1172', '107', '浦东新区');
INSERT INTO `area` VALUES ('1173', '107', '金山区');
INSERT INTO `area` VALUES ('1174', '107', '松江区');
INSERT INTO `area` VALUES ('1175', '107', '青浦区');
INSERT INTO `area` VALUES ('1177', '107', '奉贤区');
INSERT INTO `area` VALUES ('1178', '108', '崇明县');
INSERT INTO `area` VALUES ('1179', '109', '市辖区');
INSERT INTO `area` VALUES ('1180', '109', '玄武区');
INSERT INTO `area` VALUES ('1181', '109', '白下区');
INSERT INTO `area` VALUES ('1182', '109', '秦淮区');
INSERT INTO `area` VALUES ('1183', '109', '建邺区');
INSERT INTO `area` VALUES ('1184', '109', '鼓楼区');
INSERT INTO `area` VALUES ('1185', '109', '下关区');
INSERT INTO `area` VALUES ('1186', '109', '浦口区');
INSERT INTO `area` VALUES ('1187', '109', '栖霞区');
INSERT INTO `area` VALUES ('1188', '109', '雨花台区');
INSERT INTO `area` VALUES ('1189', '109', '江宁区');
INSERT INTO `area` VALUES ('1190', '109', '六合区');
INSERT INTO `area` VALUES ('1191', '109', '溧水县');
INSERT INTO `area` VALUES ('1192', '109', '高淳县');
INSERT INTO `area` VALUES ('1193', '110', '市辖区');
INSERT INTO `area` VALUES ('1194', '110', '崇安区');
INSERT INTO `area` VALUES ('1195', '110', '南长区');
INSERT INTO `area` VALUES ('1196', '110', '北塘区');
INSERT INTO `area` VALUES ('1197', '110', '锡山区');
INSERT INTO `area` VALUES ('1198', '110', '惠山区');
INSERT INTO `area` VALUES ('1199', '110', '滨湖区');
INSERT INTO `area` VALUES ('1200', '110', '江阴市');
INSERT INTO `area` VALUES ('1201', '110', '宜兴市');
INSERT INTO `area` VALUES ('1202', '111', '市辖区');
INSERT INTO `area` VALUES ('1203', '111', '鼓楼区');
INSERT INTO `area` VALUES ('1204', '111', '云龙区');
INSERT INTO `area` VALUES ('1206', '111', '贾汪区');
INSERT INTO `area` VALUES ('1207', '111', '泉山区');
INSERT INTO `area` VALUES ('1208', '111', '丰县');
INSERT INTO `area` VALUES ('1209', '111', '沛县');
INSERT INTO `area` VALUES ('1210', '111', '铜山区');
INSERT INTO `area` VALUES ('1211', '111', '睢宁县');
INSERT INTO `area` VALUES ('1212', '111', '新沂市');
INSERT INTO `area` VALUES ('1213', '111', '邳州市');
INSERT INTO `area` VALUES ('1214', '112', '市辖区');
INSERT INTO `area` VALUES ('1215', '112', '天宁区');
INSERT INTO `area` VALUES ('1216', '112', '钟楼区');
INSERT INTO `area` VALUES ('1217', '112', '戚墅堰区');
INSERT INTO `area` VALUES ('1218', '112', '新北区');
INSERT INTO `area` VALUES ('1219', '112', '武进区');
INSERT INTO `area` VALUES ('1220', '112', '溧阳市');
INSERT INTO `area` VALUES ('1221', '112', '金坛市');
INSERT INTO `area` VALUES ('1222', '113', '市辖区');
INSERT INTO `area` VALUES ('1223', '113', '沧浪区');
INSERT INTO `area` VALUES ('1224', '113', '平江区');
INSERT INTO `area` VALUES ('1225', '113', '金阊区');
INSERT INTO `area` VALUES ('1226', '113', '虎丘区');
INSERT INTO `area` VALUES ('1227', '113', '吴中区');
INSERT INTO `area` VALUES ('1228', '113', '相城区');
INSERT INTO `area` VALUES ('1229', '113', '常熟市');
INSERT INTO `area` VALUES ('1230', '113', '张家港市');
INSERT INTO `area` VALUES ('1231', '113', '昆山市');
INSERT INTO `area` VALUES ('1232', '113', '吴江市');
INSERT INTO `area` VALUES ('1233', '113', '太仓市');
INSERT INTO `area` VALUES ('1234', '114', '市辖区');
INSERT INTO `area` VALUES ('1235', '114', '崇川区');
INSERT INTO `area` VALUES ('1236', '114', '港闸区');
INSERT INTO `area` VALUES ('1237', '114', '海安县');
INSERT INTO `area` VALUES ('1238', '114', '如东县');
INSERT INTO `area` VALUES ('1239', '114', '启东市');
INSERT INTO `area` VALUES ('1240', '114', '如皋市');
INSERT INTO `area` VALUES ('1241', '114', '通州区');
INSERT INTO `area` VALUES ('1242', '114', '海门市');
INSERT INTO `area` VALUES ('1243', '115', '市辖区');
INSERT INTO `area` VALUES ('1244', '115', '连云区');
INSERT INTO `area` VALUES ('1245', '115', '新浦区');
INSERT INTO `area` VALUES ('1246', '115', '海州区');
INSERT INTO `area` VALUES ('1247', '115', '赣榆县');
INSERT INTO `area` VALUES ('1248', '115', '东海县');
INSERT INTO `area` VALUES ('1249', '115', '灌云县');
INSERT INTO `area` VALUES ('1250', '115', '灌南县');
INSERT INTO `area` VALUES ('1251', '116', '市辖区');
INSERT INTO `area` VALUES ('1252', '116', '清河区');
INSERT INTO `area` VALUES ('1253', '116', '楚州区');
INSERT INTO `area` VALUES ('1254', '116', '淮阴区');
INSERT INTO `area` VALUES ('1255', '116', '清浦区');
INSERT INTO `area` VALUES ('1256', '116', '涟水县');
INSERT INTO `area` VALUES ('1257', '116', '洪泽县');
INSERT INTO `area` VALUES ('1258', '116', '盱眙县');
INSERT INTO `area` VALUES ('1259', '116', '金湖县');
INSERT INTO `area` VALUES ('1260', '117', '市辖区');
INSERT INTO `area` VALUES ('1261', '117', '亭湖区');
INSERT INTO `area` VALUES ('1262', '117', '盐都区');
INSERT INTO `area` VALUES ('1263', '117', '响水县');
INSERT INTO `area` VALUES ('1264', '117', '滨海县');
INSERT INTO `area` VALUES ('1265', '117', '阜宁县');
INSERT INTO `area` VALUES ('1266', '117', '射阳县');
INSERT INTO `area` VALUES ('1267', '117', '建湖县');
INSERT INTO `area` VALUES ('1268', '117', '东台市');
INSERT INTO `area` VALUES ('1269', '117', '大丰市');
INSERT INTO `area` VALUES ('1270', '118', '市辖区');
INSERT INTO `area` VALUES ('1271', '118', '广陵区');
INSERT INTO `area` VALUES ('1272', '118', '邗江区');
INSERT INTO `area` VALUES ('1273', '118', '维扬区');
INSERT INTO `area` VALUES ('1274', '118', '宝应县');
INSERT INTO `area` VALUES ('1275', '118', '仪征市');
INSERT INTO `area` VALUES ('1276', '118', '高邮市');
INSERT INTO `area` VALUES ('1277', '118', '江都市');
INSERT INTO `area` VALUES ('1278', '119', '市辖区');
INSERT INTO `area` VALUES ('1279', '119', '京口区');
INSERT INTO `area` VALUES ('1280', '119', '润州区');
INSERT INTO `area` VALUES ('1281', '119', '丹徒区');
INSERT INTO `area` VALUES ('1282', '119', '丹阳市');
INSERT INTO `area` VALUES ('1283', '119', '扬中市');
INSERT INTO `area` VALUES ('1284', '119', '句容市');
INSERT INTO `area` VALUES ('1285', '120', '市辖区');
INSERT INTO `area` VALUES ('1286', '120', '海陵区');
INSERT INTO `area` VALUES ('1287', '120', '高港区');
INSERT INTO `area` VALUES ('1288', '120', '兴化市');
INSERT INTO `area` VALUES ('1289', '120', '靖江市');
INSERT INTO `area` VALUES ('1290', '120', '泰兴市');
INSERT INTO `area` VALUES ('1291', '120', '姜堰市');
INSERT INTO `area` VALUES ('1292', '121', '市辖区');
INSERT INTO `area` VALUES ('1293', '121', '宿城区');
INSERT INTO `area` VALUES ('1294', '121', '宿豫区');
INSERT INTO `area` VALUES ('1295', '121', '沭阳县');
INSERT INTO `area` VALUES ('1296', '121', '泗阳县');
INSERT INTO `area` VALUES ('1297', '121', '泗洪县');
INSERT INTO `area` VALUES ('1298', '122', '市辖区');
INSERT INTO `area` VALUES ('1299', '122', '上城区');
INSERT INTO `area` VALUES ('1300', '122', '下城区');
INSERT INTO `area` VALUES ('1301', '122', '江干区');
INSERT INTO `area` VALUES ('1302', '122', '拱墅区');
INSERT INTO `area` VALUES ('1303', '122', '西湖区');
INSERT INTO `area` VALUES ('1304', '122', '滨江区');
INSERT INTO `area` VALUES ('1305', '122', '萧山区');
INSERT INTO `area` VALUES ('1306', '122', '余杭区');
INSERT INTO `area` VALUES ('1307', '122', '桐庐县');
INSERT INTO `area` VALUES ('1308', '122', '淳安县');
INSERT INTO `area` VALUES ('1309', '122', '建德市');
INSERT INTO `area` VALUES ('1310', '122', '富阳市');
INSERT INTO `area` VALUES ('1311', '122', '临安市');
INSERT INTO `area` VALUES ('1312', '123', '市辖区');
INSERT INTO `area` VALUES ('1313', '123', '海曙区');
INSERT INTO `area` VALUES ('1314', '123', '江东区');
INSERT INTO `area` VALUES ('1315', '123', '江北区');
INSERT INTO `area` VALUES ('1316', '123', '北仑区');
INSERT INTO `area` VALUES ('1317', '123', '镇海区');
INSERT INTO `area` VALUES ('1318', '123', '鄞州区');
INSERT INTO `area` VALUES ('1319', '123', '象山县');
INSERT INTO `area` VALUES ('1320', '123', '宁海县');
INSERT INTO `area` VALUES ('1321', '123', '余姚市');
INSERT INTO `area` VALUES ('1322', '123', '慈溪市');
INSERT INTO `area` VALUES ('1323', '123', '奉化市');
INSERT INTO `area` VALUES ('1324', '124', '市辖区');
INSERT INTO `area` VALUES ('1325', '124', '鹿城区');
INSERT INTO `area` VALUES ('1326', '124', '龙湾区');
INSERT INTO `area` VALUES ('1327', '124', '瓯海区');
INSERT INTO `area` VALUES ('1328', '124', '洞头县');
INSERT INTO `area` VALUES ('1329', '124', '永嘉县');
INSERT INTO `area` VALUES ('1330', '124', '平阳县');
INSERT INTO `area` VALUES ('1331', '124', '苍南县');
INSERT INTO `area` VALUES ('1332', '124', '文成县');
INSERT INTO `area` VALUES ('1333', '124', '泰顺县');
INSERT INTO `area` VALUES ('1334', '124', '瑞安市');
INSERT INTO `area` VALUES ('1335', '124', '乐清市');
INSERT INTO `area` VALUES ('1336', '125', '市辖区');
INSERT INTO `area` VALUES ('1338', '125', '秀洲区');
INSERT INTO `area` VALUES ('1339', '125', '嘉善县');
INSERT INTO `area` VALUES ('1340', '125', '海盐县');
INSERT INTO `area` VALUES ('1341', '125', '海宁市');
INSERT INTO `area` VALUES ('1342', '125', '平湖市');
INSERT INTO `area` VALUES ('1343', '125', '桐乡市');
INSERT INTO `area` VALUES ('1344', '126', '市辖区');
INSERT INTO `area` VALUES ('1345', '126', '吴兴区');
INSERT INTO `area` VALUES ('1346', '126', '南浔区');
INSERT INTO `area` VALUES ('1347', '126', '德清县');
INSERT INTO `area` VALUES ('1348', '126', '长兴县');
INSERT INTO `area` VALUES ('1349', '126', '安吉县');
INSERT INTO `area` VALUES ('1350', '127', '市辖区');
INSERT INTO `area` VALUES ('1351', '127', '越城区');
INSERT INTO `area` VALUES ('1352', '127', '绍兴县');
INSERT INTO `area` VALUES ('1353', '127', '新昌县');
INSERT INTO `area` VALUES ('1354', '127', '诸暨市');
INSERT INTO `area` VALUES ('1355', '127', '上虞市');
INSERT INTO `area` VALUES ('1356', '127', '嵊州市');
INSERT INTO `area` VALUES ('1357', '128', '市辖区');
INSERT INTO `area` VALUES ('1358', '128', '婺城区');
INSERT INTO `area` VALUES ('1359', '128', '金东区');
INSERT INTO `area` VALUES ('1360', '128', '武义县');
INSERT INTO `area` VALUES ('1361', '128', '浦江县');
INSERT INTO `area` VALUES ('1362', '128', '磐安县');
INSERT INTO `area` VALUES ('1363', '128', '兰溪市');
INSERT INTO `area` VALUES ('1364', '128', '义乌市');
INSERT INTO `area` VALUES ('1365', '128', '东阳市');
INSERT INTO `area` VALUES ('1366', '128', '永康市');
INSERT INTO `area` VALUES ('1367', '129', '市辖区');
INSERT INTO `area` VALUES ('1368', '129', '柯城区');
INSERT INTO `area` VALUES ('1369', '129', '衢江区');
INSERT INTO `area` VALUES ('1370', '129', '常山县');
INSERT INTO `area` VALUES ('1371', '129', '开化县');
INSERT INTO `area` VALUES ('1372', '129', '龙游县');
INSERT INTO `area` VALUES ('1373', '129', '江山市');
INSERT INTO `area` VALUES ('1374', '130', '市辖区');
INSERT INTO `area` VALUES ('1375', '130', '定海区');
INSERT INTO `area` VALUES ('1376', '130', '普陀区');
INSERT INTO `area` VALUES ('1377', '130', '岱山县');
INSERT INTO `area` VALUES ('1378', '130', '嵊泗县');
INSERT INTO `area` VALUES ('1379', '131', '市辖区');
INSERT INTO `area` VALUES ('1380', '131', '椒江区');
INSERT INTO `area` VALUES ('1381', '131', '黄岩区');
INSERT INTO `area` VALUES ('1382', '131', '路桥区');
INSERT INTO `area` VALUES ('1383', '131', '玉环县');
INSERT INTO `area` VALUES ('1384', '131', '三门县');
INSERT INTO `area` VALUES ('1385', '131', '天台县');
INSERT INTO `area` VALUES ('1386', '131', '仙居县');
INSERT INTO `area` VALUES ('1387', '131', '温岭市');
INSERT INTO `area` VALUES ('1388', '131', '临海市');
INSERT INTO `area` VALUES ('1389', '132', '市辖区');
INSERT INTO `area` VALUES ('1390', '132', '莲都区');
INSERT INTO `area` VALUES ('1391', '132', '青田县');
INSERT INTO `area` VALUES ('1392', '132', '缙云县');
INSERT INTO `area` VALUES ('1393', '132', '遂昌县');
INSERT INTO `area` VALUES ('1394', '132', '松阳县');
INSERT INTO `area` VALUES ('1395', '132', '云和县');
INSERT INTO `area` VALUES ('1396', '132', '庆元县');
INSERT INTO `area` VALUES ('1397', '132', '景宁畲族自治县');
INSERT INTO `area` VALUES ('1398', '132', '龙泉市');
INSERT INTO `area` VALUES ('1399', '133', '市辖区');
INSERT INTO `area` VALUES ('1400', '133', '瑶海区');
INSERT INTO `area` VALUES ('1401', '133', '庐阳区');
INSERT INTO `area` VALUES ('1402', '133', '蜀山区');
INSERT INTO `area` VALUES ('1403', '133', '包河区');
INSERT INTO `area` VALUES ('1404', '133', '长丰县');
INSERT INTO `area` VALUES ('1405', '133', '肥东县');
INSERT INTO `area` VALUES ('1406', '133', '肥西县');
INSERT INTO `area` VALUES ('1407', '134', '市辖区');
INSERT INTO `area` VALUES ('1408', '134', '镜湖区');
INSERT INTO `area` VALUES ('1409', '134', '三山区');
INSERT INTO `area` VALUES ('1410', '134', '弋江区');
INSERT INTO `area` VALUES ('1411', '134', '鸠江区');
INSERT INTO `area` VALUES ('1412', '134', '芜湖市');
INSERT INTO `area` VALUES ('1413', '134', '繁昌县');
INSERT INTO `area` VALUES ('1414', '134', '南陵县');
INSERT INTO `area` VALUES ('1415', '135', '市辖区');
INSERT INTO `area` VALUES ('1416', '135', '龙子湖区');
INSERT INTO `area` VALUES ('1417', '135', '蚌山区');
INSERT INTO `area` VALUES ('1418', '135', '禹会区');
INSERT INTO `area` VALUES ('1419', '135', '淮上区');
INSERT INTO `area` VALUES ('1420', '135', '怀远县');
INSERT INTO `area` VALUES ('1421', '135', '五河县');
INSERT INTO `area` VALUES ('1422', '135', '固镇县');
INSERT INTO `area` VALUES ('1423', '136', '市辖区');
INSERT INTO `area` VALUES ('1424', '136', '大通区');
INSERT INTO `area` VALUES ('1425', '136', '田家庵区');
INSERT INTO `area` VALUES ('1426', '136', '谢家集区');
INSERT INTO `area` VALUES ('1427', '136', '八公山区');
INSERT INTO `area` VALUES ('1428', '136', '潘集区');
INSERT INTO `area` VALUES ('1429', '136', '凤台县');
INSERT INTO `area` VALUES ('1430', '137', '市辖区');
INSERT INTO `area` VALUES ('1431', '137', '金家庄区');
INSERT INTO `area` VALUES ('1432', '137', '花山区');
INSERT INTO `area` VALUES ('1433', '137', '雨山区');
INSERT INTO `area` VALUES ('1434', '137', '当涂县');
INSERT INTO `area` VALUES ('1435', '138', '市辖区');
INSERT INTO `area` VALUES ('1436', '138', '杜集区');
INSERT INTO `area` VALUES ('1437', '138', '相山区');
INSERT INTO `area` VALUES ('1438', '138', '烈山区');
INSERT INTO `area` VALUES ('1439', '138', '濉溪县');
INSERT INTO `area` VALUES ('1440', '139', '市辖区');
INSERT INTO `area` VALUES ('1441', '139', '铜官山区');
INSERT INTO `area` VALUES ('1442', '139', '狮子山区');
INSERT INTO `area` VALUES ('1443', '139', '郊区');
INSERT INTO `area` VALUES ('1444', '139', '铜陵县');
INSERT INTO `area` VALUES ('1445', '140', '市辖区');
INSERT INTO `area` VALUES ('1446', '140', '迎江区');
INSERT INTO `area` VALUES ('1447', '140', '大观区');
INSERT INTO `area` VALUES ('1448', '140', '宜秀区');
INSERT INTO `area` VALUES ('1449', '140', '怀宁县');
INSERT INTO `area` VALUES ('1450', '140', '枞阳县');
INSERT INTO `area` VALUES ('1451', '140', '潜山县');
INSERT INTO `area` VALUES ('1452', '140', '太湖县');
INSERT INTO `area` VALUES ('1453', '140', '宿松县');
INSERT INTO `area` VALUES ('1454', '140', '望江县');
INSERT INTO `area` VALUES ('1455', '140', '岳西县');
INSERT INTO `area` VALUES ('1456', '140', '桐城市');
INSERT INTO `area` VALUES ('1457', '141', '市辖区');
INSERT INTO `area` VALUES ('1458', '141', '屯溪区');
INSERT INTO `area` VALUES ('1459', '141', '黄山区');
INSERT INTO `area` VALUES ('1460', '141', '徽州区');
INSERT INTO `area` VALUES ('1461', '141', '歙县');
INSERT INTO `area` VALUES ('1462', '141', '休宁县');
INSERT INTO `area` VALUES ('1463', '141', '黟县');
INSERT INTO `area` VALUES ('1464', '141', '祁门县');
INSERT INTO `area` VALUES ('1465', '142', '市辖区');
INSERT INTO `area` VALUES ('1466', '142', '琅琊区');
INSERT INTO `area` VALUES ('1467', '142', '南谯区');
INSERT INTO `area` VALUES ('1468', '142', '来安县');
INSERT INTO `area` VALUES ('1469', '142', '全椒县');
INSERT INTO `area` VALUES ('1470', '142', '定远县');
INSERT INTO `area` VALUES ('1471', '142', '凤阳县');
INSERT INTO `area` VALUES ('1472', '142', '天长市');
INSERT INTO `area` VALUES ('1473', '142', '明光市');
INSERT INTO `area` VALUES ('1474', '143', '市辖区');
INSERT INTO `area` VALUES ('1475', '143', '颍州区');
INSERT INTO `area` VALUES ('1476', '143', '颍东区');
INSERT INTO `area` VALUES ('1477', '143', '颍泉区');
INSERT INTO `area` VALUES ('1478', '143', '临泉县');
INSERT INTO `area` VALUES ('1479', '143', '太和县');
INSERT INTO `area` VALUES ('1480', '143', '阜南县');
INSERT INTO `area` VALUES ('1481', '143', '颍上县');
INSERT INTO `area` VALUES ('1482', '143', '界首市');
INSERT INTO `area` VALUES ('1483', '144', '市辖区');
INSERT INTO `area` VALUES ('1484', '144', '埇桥区');
INSERT INTO `area` VALUES ('1485', '144', '砀山县');
INSERT INTO `area` VALUES ('1486', '144', '萧县');
INSERT INTO `area` VALUES ('1487', '144', '灵璧县');
INSERT INTO `area` VALUES ('1488', '144', '泗县');
INSERT INTO `area` VALUES ('1489', '145', '市辖区');
INSERT INTO `area` VALUES ('1490', '145', '居巢区');
INSERT INTO `area` VALUES ('1491', '145', '庐江县');
INSERT INTO `area` VALUES ('1492', '145', '无为县');
INSERT INTO `area` VALUES ('1493', '145', '含山县');
INSERT INTO `area` VALUES ('1494', '145', '和县');
INSERT INTO `area` VALUES ('1495', '146', '市辖区');
INSERT INTO `area` VALUES ('1496', '146', '金安区');
INSERT INTO `area` VALUES ('1497', '146', '裕安区');
INSERT INTO `area` VALUES ('1498', '146', '寿县');
INSERT INTO `area` VALUES ('1499', '146', '霍邱县');
INSERT INTO `area` VALUES ('1500', '146', '舒城县');
INSERT INTO `area` VALUES ('1501', '146', '金寨县');
INSERT INTO `area` VALUES ('1502', '146', '霍山县');
INSERT INTO `area` VALUES ('1503', '147', '市辖区');
INSERT INTO `area` VALUES ('1504', '147', '谯城区');
INSERT INTO `area` VALUES ('1505', '147', '涡阳县');
INSERT INTO `area` VALUES ('1506', '147', '蒙城县');
INSERT INTO `area` VALUES ('1507', '147', '利辛县');
INSERT INTO `area` VALUES ('1508', '148', '市辖区');
INSERT INTO `area` VALUES ('1509', '148', '贵池区');
INSERT INTO `area` VALUES ('1510', '148', '东至县');
INSERT INTO `area` VALUES ('1511', '148', '石台县');
INSERT INTO `area` VALUES ('1512', '148', '青阳县');
INSERT INTO `area` VALUES ('1513', '149', '市辖区');
INSERT INTO `area` VALUES ('1514', '149', '宣州区');
INSERT INTO `area` VALUES ('1515', '149', '郎溪县');
INSERT INTO `area` VALUES ('1516', '149', '广德县');
INSERT INTO `area` VALUES ('1517', '149', '泾县');
INSERT INTO `area` VALUES ('1518', '149', '绩溪县');
INSERT INTO `area` VALUES ('1519', '149', '旌德县');
INSERT INTO `area` VALUES ('1520', '149', '宁国市');
INSERT INTO `area` VALUES ('1521', '150', '市辖区');
INSERT INTO `area` VALUES ('1522', '150', '鼓楼区');
INSERT INTO `area` VALUES ('1523', '150', '台江区');
INSERT INTO `area` VALUES ('1524', '150', '仓山区');
INSERT INTO `area` VALUES ('1525', '150', '马尾区');
INSERT INTO `area` VALUES ('1526', '150', '晋安区');
INSERT INTO `area` VALUES ('1527', '150', '闽侯县');
INSERT INTO `area` VALUES ('1528', '150', '连江县');
INSERT INTO `area` VALUES ('1529', '150', '罗源县');
INSERT INTO `area` VALUES ('1530', '150', '闽清县');
INSERT INTO `area` VALUES ('1531', '150', '永泰县');
INSERT INTO `area` VALUES ('1532', '150', '平潭县');
INSERT INTO `area` VALUES ('1533', '150', '福清市');
INSERT INTO `area` VALUES ('1534', '150', '长乐市');
INSERT INTO `area` VALUES ('1535', '151', '市辖区');
INSERT INTO `area` VALUES ('1536', '151', '思明区');
INSERT INTO `area` VALUES ('1537', '151', '海沧区');
INSERT INTO `area` VALUES ('1538', '151', '湖里区');
INSERT INTO `area` VALUES ('1539', '151', '集美区');
INSERT INTO `area` VALUES ('1540', '151', '同安区');
INSERT INTO `area` VALUES ('1541', '151', '翔安区');
INSERT INTO `area` VALUES ('1542', '152', '市辖区');
INSERT INTO `area` VALUES ('1543', '152', '城厢区');
INSERT INTO `area` VALUES ('1544', '152', '涵江区');
INSERT INTO `area` VALUES ('1545', '152', '荔城区');
INSERT INTO `area` VALUES ('1546', '152', '秀屿区');
INSERT INTO `area` VALUES ('1547', '152', '仙游县');
INSERT INTO `area` VALUES ('1548', '153', '市辖区');
INSERT INTO `area` VALUES ('1549', '153', '梅列区');
INSERT INTO `area` VALUES ('1550', '153', '三元区');
INSERT INTO `area` VALUES ('1551', '153', '明溪县');
INSERT INTO `area` VALUES ('1552', '153', '清流县');
INSERT INTO `area` VALUES ('1553', '153', '宁化县');
INSERT INTO `area` VALUES ('1554', '153', '大田县');
INSERT INTO `area` VALUES ('1555', '153', '尤溪县');
INSERT INTO `area` VALUES ('1556', '153', '沙县');
INSERT INTO `area` VALUES ('1557', '153', '将乐县');
INSERT INTO `area` VALUES ('1558', '153', '泰宁县');
INSERT INTO `area` VALUES ('1559', '153', '建宁县');
INSERT INTO `area` VALUES ('1560', '153', '永安市');
INSERT INTO `area` VALUES ('1561', '154', '市辖区');
INSERT INTO `area` VALUES ('1562', '154', '鲤城区');
INSERT INTO `area` VALUES ('1563', '154', '丰泽区');
INSERT INTO `area` VALUES ('1564', '154', '洛江区');
INSERT INTO `area` VALUES ('1565', '154', '泉港区');
INSERT INTO `area` VALUES ('1566', '154', '惠安县');
INSERT INTO `area` VALUES ('1567', '154', '安溪县');
INSERT INTO `area` VALUES ('1568', '154', '永春县');
INSERT INTO `area` VALUES ('1569', '154', '德化县');
INSERT INTO `area` VALUES ('1570', '154', '金门县');
INSERT INTO `area` VALUES ('1571', '154', '石狮市');
INSERT INTO `area` VALUES ('1572', '154', '晋江市');
INSERT INTO `area` VALUES ('1573', '154', '南安市');
INSERT INTO `area` VALUES ('1574', '155', '市辖区');
INSERT INTO `area` VALUES ('1575', '155', '芗城区');
INSERT INTO `area` VALUES ('1576', '155', '龙文区');
INSERT INTO `area` VALUES ('1577', '155', '云霄县');
INSERT INTO `area` VALUES ('1578', '155', '漳浦县');
INSERT INTO `area` VALUES ('1579', '155', '诏安县');
INSERT INTO `area` VALUES ('1580', '155', '长泰县');
INSERT INTO `area` VALUES ('1581', '155', '东山县');
INSERT INTO `area` VALUES ('1582', '155', '南靖县');
INSERT INTO `area` VALUES ('1583', '155', '平和县');
INSERT INTO `area` VALUES ('1584', '155', '华安县');
INSERT INTO `area` VALUES ('1585', '155', '龙海市');
INSERT INTO `area` VALUES ('1586', '156', '市辖区');
INSERT INTO `area` VALUES ('1587', '156', '延平区');
INSERT INTO `area` VALUES ('1588', '156', '顺昌县');
INSERT INTO `area` VALUES ('1589', '156', '浦城县');
INSERT INTO `area` VALUES ('1590', '156', '光泽县');
INSERT INTO `area` VALUES ('1591', '156', '松溪县');
INSERT INTO `area` VALUES ('1592', '156', '政和县');
INSERT INTO `area` VALUES ('1593', '156', '邵武市');
INSERT INTO `area` VALUES ('1594', '156', '武夷山市');
INSERT INTO `area` VALUES ('1595', '156', '建瓯市');
INSERT INTO `area` VALUES ('1596', '156', '建阳市');
INSERT INTO `area` VALUES ('1597', '157', '市辖区');
INSERT INTO `area` VALUES ('1598', '157', '新罗区');
INSERT INTO `area` VALUES ('1599', '157', '长汀县');
INSERT INTO `area` VALUES ('1600', '157', '永定县');
INSERT INTO `area` VALUES ('1601', '157', '上杭县');
INSERT INTO `area` VALUES ('1602', '157', '武平县');
INSERT INTO `area` VALUES ('1603', '157', '连城县');
INSERT INTO `area` VALUES ('1604', '157', '漳平市');
INSERT INTO `area` VALUES ('1605', '158', '市辖区');
INSERT INTO `area` VALUES ('1606', '158', '蕉城区');
INSERT INTO `area` VALUES ('1607', '158', '霞浦县');
INSERT INTO `area` VALUES ('1608', '158', '古田县');
INSERT INTO `area` VALUES ('1609', '158', '屏南县');
INSERT INTO `area` VALUES ('1610', '158', '寿宁县');
INSERT INTO `area` VALUES ('1611', '158', '周宁县');
INSERT INTO `area` VALUES ('1612', '158', '柘荣县');
INSERT INTO `area` VALUES ('1613', '158', '福安市');
INSERT INTO `area` VALUES ('1614', '158', '福鼎市');
INSERT INTO `area` VALUES ('1615', '159', '市辖区');
INSERT INTO `area` VALUES ('1616', '159', '东湖区');
INSERT INTO `area` VALUES ('1617', '159', '西湖区');
INSERT INTO `area` VALUES ('1618', '159', '青云谱区');
INSERT INTO `area` VALUES ('1619', '159', '湾里区');
INSERT INTO `area` VALUES ('1620', '159', '青山湖区');
INSERT INTO `area` VALUES ('1621', '159', '南昌县');
INSERT INTO `area` VALUES ('1622', '159', '新建县');
INSERT INTO `area` VALUES ('1623', '159', '安义县');
INSERT INTO `area` VALUES ('1624', '159', '进贤县');
INSERT INTO `area` VALUES ('1625', '160', '市辖区');
INSERT INTO `area` VALUES ('1626', '160', '昌江区');
INSERT INTO `area` VALUES ('1627', '160', '珠山区');
INSERT INTO `area` VALUES ('1628', '160', '浮梁县');
INSERT INTO `area` VALUES ('1629', '160', '乐平市');
INSERT INTO `area` VALUES ('1630', '161', '市辖区');
INSERT INTO `area` VALUES ('1631', '161', '安源区');
INSERT INTO `area` VALUES ('1632', '161', '湘东区');
INSERT INTO `area` VALUES ('1633', '161', '莲花县');
INSERT INTO `area` VALUES ('1634', '161', '上栗县');
INSERT INTO `area` VALUES ('1635', '161', '芦溪县');
INSERT INTO `area` VALUES ('1636', '162', '市辖区');
INSERT INTO `area` VALUES ('1637', '162', '庐山区');
INSERT INTO `area` VALUES ('1638', '162', '浔阳区');
INSERT INTO `area` VALUES ('1639', '162', '九江县');
INSERT INTO `area` VALUES ('1640', '162', '武宁县');
INSERT INTO `area` VALUES ('1641', '162', '修水县');
INSERT INTO `area` VALUES ('1642', '162', '永修县');
INSERT INTO `area` VALUES ('1643', '162', '德安县');
INSERT INTO `area` VALUES ('1644', '162', '星子县');
INSERT INTO `area` VALUES ('1645', '162', '都昌县');
INSERT INTO `area` VALUES ('1646', '162', '湖口县');
INSERT INTO `area` VALUES ('1647', '162', '彭泽县');
INSERT INTO `area` VALUES ('1648', '162', '瑞昌市');
INSERT INTO `area` VALUES ('1649', '163', '市辖区');
INSERT INTO `area` VALUES ('1650', '163', '渝水区');
INSERT INTO `area` VALUES ('1651', '163', '分宜县');
INSERT INTO `area` VALUES ('1652', '164', '市辖区');
INSERT INTO `area` VALUES ('1653', '164', '月湖区');
INSERT INTO `area` VALUES ('1654', '164', '余江县');
INSERT INTO `area` VALUES ('1655', '164', '贵溪市');
INSERT INTO `area` VALUES ('1656', '165', '市辖区');
INSERT INTO `area` VALUES ('1657', '165', '章贡区');
INSERT INTO `area` VALUES ('1658', '165', '赣县');
INSERT INTO `area` VALUES ('1659', '165', '信丰县');
INSERT INTO `area` VALUES ('1660', '165', '大余县');
INSERT INTO `area` VALUES ('1661', '165', '上犹县');
INSERT INTO `area` VALUES ('1662', '165', '崇义县');
INSERT INTO `area` VALUES ('1663', '165', '安远县');
INSERT INTO `area` VALUES ('1664', '165', '龙南县');
INSERT INTO `area` VALUES ('1665', '165', '定南县');
INSERT INTO `area` VALUES ('1666', '165', '全南县');
INSERT INTO `area` VALUES ('1667', '165', '宁都县');
INSERT INTO `area` VALUES ('1668', '165', '于都县');
INSERT INTO `area` VALUES ('1669', '165', '兴国县');
INSERT INTO `area` VALUES ('1670', '165', '会昌县');
INSERT INTO `area` VALUES ('1671', '165', '寻乌县');
INSERT INTO `area` VALUES ('1672', '165', '石城县');
INSERT INTO `area` VALUES ('1673', '165', '瑞金市');
INSERT INTO `area` VALUES ('1674', '165', '南康市');
INSERT INTO `area` VALUES ('1675', '166', '市辖区');
INSERT INTO `area` VALUES ('1676', '166', '吉州区');
INSERT INTO `area` VALUES ('1677', '166', '青原区');
INSERT INTO `area` VALUES ('1678', '166', '吉安县');
INSERT INTO `area` VALUES ('1679', '166', '吉水县');
INSERT INTO `area` VALUES ('1680', '166', '峡江县');
INSERT INTO `area` VALUES ('1681', '166', '新干县');
INSERT INTO `area` VALUES ('1682', '166', '永丰县');
INSERT INTO `area` VALUES ('1683', '166', '泰和县');
INSERT INTO `area` VALUES ('1684', '166', '遂川县');
INSERT INTO `area` VALUES ('1685', '166', '万安县');
INSERT INTO `area` VALUES ('1686', '166', '安福县');
INSERT INTO `area` VALUES ('1687', '166', '永新县');
INSERT INTO `area` VALUES ('1688', '166', '井冈山市');
INSERT INTO `area` VALUES ('1689', '167', '市辖区');
INSERT INTO `area` VALUES ('1690', '167', '袁州区');
INSERT INTO `area` VALUES ('1691', '167', '奉新县');
INSERT INTO `area` VALUES ('1692', '167', '万载县');
INSERT INTO `area` VALUES ('1693', '167', '上高县');
INSERT INTO `area` VALUES ('1694', '167', '宜丰县');
INSERT INTO `area` VALUES ('1695', '167', '靖安县');
INSERT INTO `area` VALUES ('1696', '167', '铜鼓县');
INSERT INTO `area` VALUES ('1697', '167', '丰城市');
INSERT INTO `area` VALUES ('1698', '167', '樟树市');
INSERT INTO `area` VALUES ('1699', '167', '高安市');
INSERT INTO `area` VALUES ('1700', '168', '市辖区');
INSERT INTO `area` VALUES ('1701', '168', '临川区');
INSERT INTO `area` VALUES ('1702', '168', '南城县');
INSERT INTO `area` VALUES ('1703', '168', '黎川县');
INSERT INTO `area` VALUES ('1704', '168', '南丰县');
INSERT INTO `area` VALUES ('1705', '168', '崇仁县');
INSERT INTO `area` VALUES ('1706', '168', '乐安县');
INSERT INTO `area` VALUES ('1707', '168', '宜黄县');
INSERT INTO `area` VALUES ('1708', '168', '金溪县');
INSERT INTO `area` VALUES ('1709', '168', '资溪县');
INSERT INTO `area` VALUES ('1710', '168', '东乡县');
INSERT INTO `area` VALUES ('1711', '168', '广昌县');
INSERT INTO `area` VALUES ('1712', '169', '市辖区');
INSERT INTO `area` VALUES ('1713', '169', '信州区');
INSERT INTO `area` VALUES ('1714', '169', '上饶县');
INSERT INTO `area` VALUES ('1715', '169', '广丰县');
INSERT INTO `area` VALUES ('1716', '169', '玉山县');
INSERT INTO `area` VALUES ('1717', '169', '铅山县');
INSERT INTO `area` VALUES ('1718', '169', '横峰县');
INSERT INTO `area` VALUES ('1719', '169', '弋阳县');
INSERT INTO `area` VALUES ('1720', '169', '余干县');
INSERT INTO `area` VALUES ('1721', '169', '鄱阳县');
INSERT INTO `area` VALUES ('1722', '169', '万年县');
INSERT INTO `area` VALUES ('1723', '169', '婺源县');
INSERT INTO `area` VALUES ('1724', '169', '德兴市');
INSERT INTO `area` VALUES ('1725', '170', '市辖区');
INSERT INTO `area` VALUES ('1726', '170', '历下区');
INSERT INTO `area` VALUES ('1727', '170', '市中区');
INSERT INTO `area` VALUES ('1728', '170', '槐荫区');
INSERT INTO `area` VALUES ('1729', '170', '天桥区');
INSERT INTO `area` VALUES ('1730', '170', '历城区');
INSERT INTO `area` VALUES ('1731', '170', '长清区');
INSERT INTO `area` VALUES ('1732', '170', '平阴县');
INSERT INTO `area` VALUES ('1733', '170', '济阳县');
INSERT INTO `area` VALUES ('1734', '170', '商河县');
INSERT INTO `area` VALUES ('1735', '170', '章丘市');
INSERT INTO `area` VALUES ('1736', '171', '市辖区');
INSERT INTO `area` VALUES ('1737', '171', '市南区');
INSERT INTO `area` VALUES ('1738', '171', '市北区');
INSERT INTO `area` VALUES ('1739', '171', '四方区');
INSERT INTO `area` VALUES ('1740', '171', '黄岛区');
INSERT INTO `area` VALUES ('1741', '171', '崂山区');
INSERT INTO `area` VALUES ('1742', '171', '李沧区');
INSERT INTO `area` VALUES ('1743', '171', '城阳区');
INSERT INTO `area` VALUES ('1744', '171', '胶州市');
INSERT INTO `area` VALUES ('1745', '171', '即墨市');
INSERT INTO `area` VALUES ('1746', '171', '平度市');
INSERT INTO `area` VALUES ('1747', '171', '胶南市');
INSERT INTO `area` VALUES ('1748', '171', '莱西市');
INSERT INTO `area` VALUES ('1749', '172', '市辖区');
INSERT INTO `area` VALUES ('1750', '172', '淄川区');
INSERT INTO `area` VALUES ('1751', '172', '张店区');
INSERT INTO `area` VALUES ('1752', '172', '博山区');
INSERT INTO `area` VALUES ('1753', '172', '临淄区');
INSERT INTO `area` VALUES ('1754', '172', '周村区');
INSERT INTO `area` VALUES ('1755', '172', '桓台县');
INSERT INTO `area` VALUES ('1756', '172', '高青县');
INSERT INTO `area` VALUES ('1757', '172', '沂源县');
INSERT INTO `area` VALUES ('1758', '173', '市辖区');
INSERT INTO `area` VALUES ('1759', '173', '市中区');
INSERT INTO `area` VALUES ('1760', '173', '薛城区');
INSERT INTO `area` VALUES ('1761', '173', '峄城区');
INSERT INTO `area` VALUES ('1762', '173', '台儿庄区');
INSERT INTO `area` VALUES ('1763', '173', '山亭区');
INSERT INTO `area` VALUES ('1764', '173', '滕州市');
INSERT INTO `area` VALUES ('1765', '174', '市辖区');
INSERT INTO `area` VALUES ('1766', '174', '东营区');
INSERT INTO `area` VALUES ('1767', '174', '河口区');
INSERT INTO `area` VALUES ('1768', '174', '垦利县');
INSERT INTO `area` VALUES ('1769', '174', '利津县');
INSERT INTO `area` VALUES ('1770', '174', '广饶县');
INSERT INTO `area` VALUES ('1771', '175', '市辖区');
INSERT INTO `area` VALUES ('1772', '175', '芝罘区');
INSERT INTO `area` VALUES ('1773', '175', '福山区');
INSERT INTO `area` VALUES ('1774', '175', '牟平区');
INSERT INTO `area` VALUES ('1775', '175', '莱山区');
INSERT INTO `area` VALUES ('1776', '175', '长岛县');
INSERT INTO `area` VALUES ('1777', '175', '龙口市');
INSERT INTO `area` VALUES ('1778', '175', '莱阳市');
INSERT INTO `area` VALUES ('1779', '175', '莱州市');
INSERT INTO `area` VALUES ('1780', '175', '蓬莱市');
INSERT INTO `area` VALUES ('1781', '175', '招远市');
INSERT INTO `area` VALUES ('1782', '175', '栖霞市');
INSERT INTO `area` VALUES ('1783', '175', '海阳市');
INSERT INTO `area` VALUES ('1784', '176', '市辖区');
INSERT INTO `area` VALUES ('1785', '176', '潍城区');
INSERT INTO `area` VALUES ('1786', '176', '寒亭区');
INSERT INTO `area` VALUES ('1787', '176', '坊子区');
INSERT INTO `area` VALUES ('1788', '176', '奎文区');
INSERT INTO `area` VALUES ('1789', '176', '临朐县');
INSERT INTO `area` VALUES ('1790', '176', '昌乐县');
INSERT INTO `area` VALUES ('1791', '176', '青州市');
INSERT INTO `area` VALUES ('1792', '176', '诸城市');
INSERT INTO `area` VALUES ('1793', '176', '寿光市');
INSERT INTO `area` VALUES ('1794', '176', '安丘市');
INSERT INTO `area` VALUES ('1795', '176', '高密市');
INSERT INTO `area` VALUES ('1796', '176', '昌邑市');
INSERT INTO `area` VALUES ('1797', '177', '市辖区');
INSERT INTO `area` VALUES ('1798', '177', '市中区');
INSERT INTO `area` VALUES ('1799', '177', '任城区');
INSERT INTO `area` VALUES ('1800', '177', '微山县');
INSERT INTO `area` VALUES ('1801', '177', '鱼台县');
INSERT INTO `area` VALUES ('1802', '177', '金乡县');
INSERT INTO `area` VALUES ('1803', '177', '嘉祥县');
INSERT INTO `area` VALUES ('1804', '177', '汶上县');
INSERT INTO `area` VALUES ('1805', '177', '泗水县');
INSERT INTO `area` VALUES ('1806', '177', '梁山县');
INSERT INTO `area` VALUES ('1807', '177', '曲阜市');
INSERT INTO `area` VALUES ('1808', '177', '兖州市');
INSERT INTO `area` VALUES ('1809', '177', '邹城市');
INSERT INTO `area` VALUES ('1810', '178', '市辖区');
INSERT INTO `area` VALUES ('1811', '178', '泰山区');
INSERT INTO `area` VALUES ('1812', '178', '岱岳区');
INSERT INTO `area` VALUES ('1813', '178', '宁阳县');
INSERT INTO `area` VALUES ('1814', '178', '东平县');
INSERT INTO `area` VALUES ('1815', '178', '新泰市');
INSERT INTO `area` VALUES ('1816', '178', '肥城市');
INSERT INTO `area` VALUES ('1817', '179', '市辖区');
INSERT INTO `area` VALUES ('1818', '179', '环翠区');
INSERT INTO `area` VALUES ('1819', '179', '文登市');
INSERT INTO `area` VALUES ('1820', '179', '荣成市');
INSERT INTO `area` VALUES ('1821', '179', '乳山市');
INSERT INTO `area` VALUES ('1822', '180', '市辖区');
INSERT INTO `area` VALUES ('1823', '180', '东港区');
INSERT INTO `area` VALUES ('1824', '180', '岚山区');
INSERT INTO `area` VALUES ('1825', '180', '五莲县');
INSERT INTO `area` VALUES ('1826', '180', '莒县');
INSERT INTO `area` VALUES ('1827', '181', '市辖区');
INSERT INTO `area` VALUES ('1828', '181', '莱城区');
INSERT INTO `area` VALUES ('1829', '181', '钢城区');
INSERT INTO `area` VALUES ('1830', '182', '市辖区');
INSERT INTO `area` VALUES ('1831', '182', '兰山区');
INSERT INTO `area` VALUES ('1832', '182', '罗庄区');
INSERT INTO `area` VALUES ('1833', '182', '河东区');
INSERT INTO `area` VALUES ('1834', '182', '沂南县');
INSERT INTO `area` VALUES ('1835', '182', '郯城县');
INSERT INTO `area` VALUES ('1836', '182', '沂水县');
INSERT INTO `area` VALUES ('1837', '182', '苍山县');
INSERT INTO `area` VALUES ('1838', '182', '费县');
INSERT INTO `area` VALUES ('1839', '182', '平邑县');
INSERT INTO `area` VALUES ('1840', '182', '莒南县');
INSERT INTO `area` VALUES ('1841', '182', '蒙阴县');
INSERT INTO `area` VALUES ('1842', '182', '临沭县');
INSERT INTO `area` VALUES ('1843', '183', '市辖区');
INSERT INTO `area` VALUES ('1844', '183', '德城区');
INSERT INTO `area` VALUES ('1845', '183', '陵县');
INSERT INTO `area` VALUES ('1846', '183', '宁津县');
INSERT INTO `area` VALUES ('1847', '183', '庆云县');
INSERT INTO `area` VALUES ('1848', '183', '临邑县');
INSERT INTO `area` VALUES ('1849', '183', '齐河县');
INSERT INTO `area` VALUES ('1850', '183', '平原县');
INSERT INTO `area` VALUES ('1851', '183', '夏津县');
INSERT INTO `area` VALUES ('1852', '183', '武城县');
INSERT INTO `area` VALUES ('1853', '183', '乐陵市');
INSERT INTO `area` VALUES ('1854', '183', '禹城市');
INSERT INTO `area` VALUES ('1855', '184', '市辖区');
INSERT INTO `area` VALUES ('1856', '184', '东昌府区');
INSERT INTO `area` VALUES ('1857', '184', '阳谷县');
INSERT INTO `area` VALUES ('1858', '184', '莘县');
INSERT INTO `area` VALUES ('1859', '184', '茌平县');
INSERT INTO `area` VALUES ('1860', '184', '东阿县');
INSERT INTO `area` VALUES ('1861', '184', '冠县');
INSERT INTO `area` VALUES ('1862', '184', '高唐县');
INSERT INTO `area` VALUES ('1863', '184', '临清市');
INSERT INTO `area` VALUES ('1864', '185', '市辖区');
INSERT INTO `area` VALUES ('1865', '185', '滨城区');
INSERT INTO `area` VALUES ('1866', '185', '惠民县');
INSERT INTO `area` VALUES ('1867', '185', '阳信县');
INSERT INTO `area` VALUES ('1868', '185', '无棣县');
INSERT INTO `area` VALUES ('1869', '185', '沾化县');
INSERT INTO `area` VALUES ('1870', '185', '博兴县');
INSERT INTO `area` VALUES ('1871', '185', '邹平县');
INSERT INTO `area` VALUES ('1873', '186', '牡丹区');
INSERT INTO `area` VALUES ('1874', '186', '曹县');
INSERT INTO `area` VALUES ('1875', '186', '单县');
INSERT INTO `area` VALUES ('1876', '186', '成武县');
INSERT INTO `area` VALUES ('1877', '186', '巨野县');
INSERT INTO `area` VALUES ('1878', '186', '郓城县');
INSERT INTO `area` VALUES ('1879', '186', '鄄城县');
INSERT INTO `area` VALUES ('1880', '186', '定陶县');
INSERT INTO `area` VALUES ('1881', '186', '东明县');
INSERT INTO `area` VALUES ('1882', '187', '市辖区');
INSERT INTO `area` VALUES ('1883', '187', '中原区');
INSERT INTO `area` VALUES ('1884', '187', '二七区');
INSERT INTO `area` VALUES ('1885', '187', '管城回族区');
INSERT INTO `area` VALUES ('1886', '187', '金水区');
INSERT INTO `area` VALUES ('1887', '187', '上街区');
INSERT INTO `area` VALUES ('1888', '187', '惠济区');
INSERT INTO `area` VALUES ('1889', '187', '中牟县');
INSERT INTO `area` VALUES ('1890', '187', '巩义市');
INSERT INTO `area` VALUES ('1891', '187', '荥阳市');
INSERT INTO `area` VALUES ('1892', '187', '新密市');
INSERT INTO `area` VALUES ('1893', '187', '新郑市');
INSERT INTO `area` VALUES ('1894', '187', '登封市');
INSERT INTO `area` VALUES ('1895', '188', '市辖区');
INSERT INTO `area` VALUES ('1896', '188', '龙亭区');
INSERT INTO `area` VALUES ('1897', '188', '顺河回族区');
INSERT INTO `area` VALUES ('1898', '188', '鼓楼区');
INSERT INTO `area` VALUES ('1899', '188', '禹王台区');
INSERT INTO `area` VALUES ('1900', '188', '金明区');
INSERT INTO `area` VALUES ('1901', '188', '杞县');
INSERT INTO `area` VALUES ('1902', '188', '通许县');
INSERT INTO `area` VALUES ('1903', '188', '尉氏县');
INSERT INTO `area` VALUES ('1904', '188', '开封县');
INSERT INTO `area` VALUES ('1905', '188', '兰考县');
INSERT INTO `area` VALUES ('1906', '189', '市辖区');
INSERT INTO `area` VALUES ('1907', '189', '老城区');
INSERT INTO `area` VALUES ('1908', '189', '西工区');
INSERT INTO `area` VALUES ('1909', '189', '瀍河回族区');
INSERT INTO `area` VALUES ('1910', '189', '涧西区');
INSERT INTO `area` VALUES ('1911', '189', '吉利区');
INSERT INTO `area` VALUES ('1912', '189', '洛龙区');
INSERT INTO `area` VALUES ('1913', '189', '孟津县');
INSERT INTO `area` VALUES ('1914', '189', '新安县');
INSERT INTO `area` VALUES ('1915', '189', '栾川县');
INSERT INTO `area` VALUES ('1916', '189', '嵩县');
INSERT INTO `area` VALUES ('1917', '189', '汝阳县');
INSERT INTO `area` VALUES ('1918', '189', '宜阳县');
INSERT INTO `area` VALUES ('1919', '189', '洛宁县');
INSERT INTO `area` VALUES ('1920', '189', '伊川县');
INSERT INTO `area` VALUES ('1921', '189', '偃师市');
INSERT INTO `area` VALUES ('1922', '190', '市辖区');
INSERT INTO `area` VALUES ('1923', '190', '新华区');
INSERT INTO `area` VALUES ('1924', '190', '卫东区');
INSERT INTO `area` VALUES ('1925', '190', '石龙区');
INSERT INTO `area` VALUES ('1926', '190', '湛河区');
INSERT INTO `area` VALUES ('1927', '190', '宝丰县');
INSERT INTO `area` VALUES ('1928', '190', '叶县');
INSERT INTO `area` VALUES ('1929', '190', '鲁山县');
INSERT INTO `area` VALUES ('1930', '190', '郏县');
INSERT INTO `area` VALUES ('1931', '190', '舞钢市');
INSERT INTO `area` VALUES ('1932', '190', '汝州市');
INSERT INTO `area` VALUES ('1933', '191', '市辖区');
INSERT INTO `area` VALUES ('1934', '191', '文峰区');
INSERT INTO `area` VALUES ('1935', '191', '北关区');
INSERT INTO `area` VALUES ('1936', '191', '殷都区');
INSERT INTO `area` VALUES ('1937', '191', '龙安区');
INSERT INTO `area` VALUES ('1938', '191', '安阳县');
INSERT INTO `area` VALUES ('1939', '191', '汤阴县');
INSERT INTO `area` VALUES ('1940', '191', '滑县');
INSERT INTO `area` VALUES ('1941', '191', '内黄县');
INSERT INTO `area` VALUES ('1942', '191', '林州市');
INSERT INTO `area` VALUES ('1943', '192', '市辖区');
INSERT INTO `area` VALUES ('1944', '192', '鹤山区');
INSERT INTO `area` VALUES ('1945', '192', '山城区');
INSERT INTO `area` VALUES ('1946', '192', '淇滨区');
INSERT INTO `area` VALUES ('1947', '192', '浚县');
INSERT INTO `area` VALUES ('1948', '192', '淇县');
INSERT INTO `area` VALUES ('1949', '193', '市辖区');
INSERT INTO `area` VALUES ('1950', '193', '红旗区');
INSERT INTO `area` VALUES ('1951', '193', '卫滨区');
INSERT INTO `area` VALUES ('1952', '193', '凤泉区');
INSERT INTO `area` VALUES ('1953', '193', '牧野区');
INSERT INTO `area` VALUES ('1954', '193', '新乡县');
INSERT INTO `area` VALUES ('1955', '193', '获嘉县');
INSERT INTO `area` VALUES ('1956', '193', '原阳县');
INSERT INTO `area` VALUES ('1957', '193', '延津县');
INSERT INTO `area` VALUES ('1958', '193', '封丘县');
INSERT INTO `area` VALUES ('1959', '193', '长垣县');
INSERT INTO `area` VALUES ('1960', '193', '卫辉市');
INSERT INTO `area` VALUES ('1961', '193', '辉县市');
INSERT INTO `area` VALUES ('1962', '194', '市辖区');
INSERT INTO `area` VALUES ('1963', '194', '解放区');
INSERT INTO `area` VALUES ('1964', '194', '中站区');
INSERT INTO `area` VALUES ('1965', '194', '马村区');
INSERT INTO `area` VALUES ('1966', '194', '山阳区');
INSERT INTO `area` VALUES ('1967', '194', '修武县');
INSERT INTO `area` VALUES ('1968', '194', '博爱县');
INSERT INTO `area` VALUES ('1969', '194', '武陟县');
INSERT INTO `area` VALUES ('1970', '194', '温县');
INSERT INTO `area` VALUES ('1971', '194', '济源市');
INSERT INTO `area` VALUES ('1972', '194', '沁阳市');
INSERT INTO `area` VALUES ('1973', '194', '孟州市');
INSERT INTO `area` VALUES ('1974', '195', '市辖区');
INSERT INTO `area` VALUES ('1975', '195', '华龙区');
INSERT INTO `area` VALUES ('1976', '195', '清丰县');
INSERT INTO `area` VALUES ('1977', '195', '南乐县');
INSERT INTO `area` VALUES ('1978', '195', '范县');
INSERT INTO `area` VALUES ('1979', '195', '台前县');
INSERT INTO `area` VALUES ('1980', '195', '濮阳县');
INSERT INTO `area` VALUES ('1981', '196', '市辖区');
INSERT INTO `area` VALUES ('1982', '196', '魏都区');
INSERT INTO `area` VALUES ('1983', '196', '许昌县');
INSERT INTO `area` VALUES ('1984', '196', '鄢陵县');
INSERT INTO `area` VALUES ('1985', '196', '襄城县');
INSERT INTO `area` VALUES ('1986', '196', '禹州市');
INSERT INTO `area` VALUES ('1987', '196', '长葛市');
INSERT INTO `area` VALUES ('1988', '197', '市辖区');
INSERT INTO `area` VALUES ('1989', '197', '源汇区');
INSERT INTO `area` VALUES ('1990', '197', '郾城区');
INSERT INTO `area` VALUES ('1991', '197', '召陵区');
INSERT INTO `area` VALUES ('1992', '197', '舞阳县');
INSERT INTO `area` VALUES ('1993', '197', '临颍县');
INSERT INTO `area` VALUES ('1994', '198', '市辖区');
INSERT INTO `area` VALUES ('1995', '198', '湖滨区');
INSERT INTO `area` VALUES ('1996', '198', '渑池县');
INSERT INTO `area` VALUES ('1997', '198', '陕县');
INSERT INTO `area` VALUES ('1998', '198', '卢氏县');
INSERT INTO `area` VALUES ('1999', '198', '义马市');
INSERT INTO `area` VALUES ('2000', '198', '灵宝市');
INSERT INTO `area` VALUES ('2001', '199', '市辖区');
INSERT INTO `area` VALUES ('2002', '199', '宛城区');
INSERT INTO `area` VALUES ('2003', '199', '卧龙区');
INSERT INTO `area` VALUES ('2004', '199', '南召县');
INSERT INTO `area` VALUES ('2005', '199', '方城县');
INSERT INTO `area` VALUES ('2006', '199', '西峡县');
INSERT INTO `area` VALUES ('2007', '199', '镇平县');
INSERT INTO `area` VALUES ('2008', '199', '内乡县');
INSERT INTO `area` VALUES ('2009', '199', '淅川县');
INSERT INTO `area` VALUES ('2010', '199', '社旗县');
INSERT INTO `area` VALUES ('2011', '199', '唐河县');
INSERT INTO `area` VALUES ('2012', '199', '新野县');
INSERT INTO `area` VALUES ('2013', '199', '桐柏县');
INSERT INTO `area` VALUES ('2014', '199', '邓州市');
INSERT INTO `area` VALUES ('2015', '200', '市辖区');
INSERT INTO `area` VALUES ('2016', '200', '梁园区');
INSERT INTO `area` VALUES ('2017', '200', '睢阳区');
INSERT INTO `area` VALUES ('2018', '200', '民权县');
INSERT INTO `area` VALUES ('2019', '200', '睢县');
INSERT INTO `area` VALUES ('2020', '200', '宁陵县');
INSERT INTO `area` VALUES ('2021', '200', '柘城县');
INSERT INTO `area` VALUES ('2022', '200', '虞城县');
INSERT INTO `area` VALUES ('2023', '200', '夏邑县');
INSERT INTO `area` VALUES ('2024', '200', '永城市');
INSERT INTO `area` VALUES ('2025', '201', '市辖区');
INSERT INTO `area` VALUES ('2026', '201', '浉河区');
INSERT INTO `area` VALUES ('2027', '201', '平桥区');
INSERT INTO `area` VALUES ('2028', '201', '罗山县');
INSERT INTO `area` VALUES ('2029', '201', '光山县');
INSERT INTO `area` VALUES ('2030', '201', '新县');
INSERT INTO `area` VALUES ('2031', '201', '商城县');
INSERT INTO `area` VALUES ('2032', '201', '固始县');
INSERT INTO `area` VALUES ('2033', '201', '潢川县');
INSERT INTO `area` VALUES ('2034', '201', '淮滨县');
INSERT INTO `area` VALUES ('2035', '201', '息县');
INSERT INTO `area` VALUES ('2036', '202', '市辖区');
INSERT INTO `area` VALUES ('2037', '202', '川汇区');
INSERT INTO `area` VALUES ('2038', '202', '扶沟县');
INSERT INTO `area` VALUES ('2039', '202', '西华县');
INSERT INTO `area` VALUES ('2040', '202', '商水县');
INSERT INTO `area` VALUES ('2041', '202', '沈丘县');
INSERT INTO `area` VALUES ('2042', '202', '郸城县');
INSERT INTO `area` VALUES ('2043', '202', '淮阳县');
INSERT INTO `area` VALUES ('2044', '202', '太康县');
INSERT INTO `area` VALUES ('2045', '202', '鹿邑县');
INSERT INTO `area` VALUES ('2046', '202', '项城市');
INSERT INTO `area` VALUES ('2047', '203', '市辖区');
INSERT INTO `area` VALUES ('2048', '203', '驿城区');
INSERT INTO `area` VALUES ('2049', '203', '西平县');
INSERT INTO `area` VALUES ('2050', '203', '上蔡县');
INSERT INTO `area` VALUES ('2051', '203', '平舆县');
INSERT INTO `area` VALUES ('2052', '203', '正阳县');
INSERT INTO `area` VALUES ('2053', '203', '确山县');
INSERT INTO `area` VALUES ('2054', '203', '泌阳县');
INSERT INTO `area` VALUES ('2055', '203', '汝南县');
INSERT INTO `area` VALUES ('2056', '203', '遂平县');
INSERT INTO `area` VALUES ('2057', '203', '新蔡县');
INSERT INTO `area` VALUES ('2058', '204', '市辖区');
INSERT INTO `area` VALUES ('2059', '204', '江岸区');
INSERT INTO `area` VALUES ('2060', '204', '江汉区');
INSERT INTO `area` VALUES ('2061', '204', '硚口区');
INSERT INTO `area` VALUES ('2062', '204', '汉阳区');
INSERT INTO `area` VALUES ('2063', '204', '武昌区');
INSERT INTO `area` VALUES ('2064', '204', '青山区');
INSERT INTO `area` VALUES ('2065', '204', '洪山区');
INSERT INTO `area` VALUES ('2066', '204', '东西湖区');
INSERT INTO `area` VALUES ('2067', '204', '汉南区');
INSERT INTO `area` VALUES ('2068', '204', '蔡甸区');
INSERT INTO `area` VALUES ('2069', '204', '江夏区');
INSERT INTO `area` VALUES ('2070', '204', '黄陂区');
INSERT INTO `area` VALUES ('2071', '204', '新洲区');
INSERT INTO `area` VALUES ('2072', '205', '市辖区');
INSERT INTO `area` VALUES ('2073', '205', '黄石港区');
INSERT INTO `area` VALUES ('2074', '205', '西塞山区');
INSERT INTO `area` VALUES ('2075', '205', '下陆区');
INSERT INTO `area` VALUES ('2076', '205', '铁山区');
INSERT INTO `area` VALUES ('2077', '205', '阳新县');
INSERT INTO `area` VALUES ('2078', '205', '大冶市');
INSERT INTO `area` VALUES ('2079', '206', '市辖区');
INSERT INTO `area` VALUES ('2080', '206', '茅箭区');
INSERT INTO `area` VALUES ('2081', '206', '张湾区');
INSERT INTO `area` VALUES ('2082', '206', '郧县');
INSERT INTO `area` VALUES ('2083', '206', '郧西县');
INSERT INTO `area` VALUES ('2084', '206', '竹山县');
INSERT INTO `area` VALUES ('2085', '206', '竹溪县');
INSERT INTO `area` VALUES ('2086', '206', '房县');
INSERT INTO `area` VALUES ('2087', '206', '丹江口市');
INSERT INTO `area` VALUES ('2088', '207', '市辖区');
INSERT INTO `area` VALUES ('2089', '207', '西陵区');
INSERT INTO `area` VALUES ('2090', '207', '伍家岗区');
INSERT INTO `area` VALUES ('2091', '207', '点军区');
INSERT INTO `area` VALUES ('2092', '207', '猇亭区');
INSERT INTO `area` VALUES ('2093', '207', '夷陵区');
INSERT INTO `area` VALUES ('2094', '207', '远安县');
INSERT INTO `area` VALUES ('2095', '207', '兴山县');
INSERT INTO `area` VALUES ('2096', '207', '秭归县');
INSERT INTO `area` VALUES ('2097', '207', '长阳土家族自治县');
INSERT INTO `area` VALUES ('2098', '207', '五峰土家族自治县');
INSERT INTO `area` VALUES ('2099', '207', '宜都市');
INSERT INTO `area` VALUES ('2100', '207', '当阳市');
INSERT INTO `area` VALUES ('2101', '207', '枝江市');
INSERT INTO `area` VALUES ('2102', '208', '市辖区');
INSERT INTO `area` VALUES ('2103', '208', '襄城区');
INSERT INTO `area` VALUES ('2104', '208', '樊城区');
INSERT INTO `area` VALUES ('2105', '208', '襄阳区');
INSERT INTO `area` VALUES ('2106', '208', '南漳县');
INSERT INTO `area` VALUES ('2107', '208', '谷城县');
INSERT INTO `area` VALUES ('2108', '208', '保康县');
INSERT INTO `area` VALUES ('2109', '208', '老河口市');
INSERT INTO `area` VALUES ('2110', '208', '枣阳市');
INSERT INTO `area` VALUES ('2111', '208', '宜城市');
INSERT INTO `area` VALUES ('2112', '209', '市辖区');
INSERT INTO `area` VALUES ('2113', '209', '梁子湖区');
INSERT INTO `area` VALUES ('2114', '209', '华容区');
INSERT INTO `area` VALUES ('2115', '209', '鄂城区');
INSERT INTO `area` VALUES ('2116', '210', '市辖区');
INSERT INTO `area` VALUES ('2117', '210', '东宝区');
INSERT INTO `area` VALUES ('2118', '210', '掇刀区');
INSERT INTO `area` VALUES ('2119', '210', '京山县');
INSERT INTO `area` VALUES ('2120', '210', '沙洋县');
INSERT INTO `area` VALUES ('2121', '210', '钟祥市');
INSERT INTO `area` VALUES ('2122', '211', '市辖区');
INSERT INTO `area` VALUES ('2123', '211', '孝南区');
INSERT INTO `area` VALUES ('2124', '211', '孝昌县');
INSERT INTO `area` VALUES ('2125', '211', '大悟县');
INSERT INTO `area` VALUES ('2126', '211', '云梦县');
INSERT INTO `area` VALUES ('2127', '211', '应城市');
INSERT INTO `area` VALUES ('2128', '211', '安陆市');
INSERT INTO `area` VALUES ('2129', '211', '汉川市');
INSERT INTO `area` VALUES ('2130', '212', '市辖区');
INSERT INTO `area` VALUES ('2131', '212', '沙市区');
INSERT INTO `area` VALUES ('2132', '212', '荆州区');
INSERT INTO `area` VALUES ('2133', '212', '公安县');
INSERT INTO `area` VALUES ('2134', '212', '监利县');
INSERT INTO `area` VALUES ('2135', '212', '江陵县');
INSERT INTO `area` VALUES ('2136', '212', '石首市');
INSERT INTO `area` VALUES ('2137', '212', '洪湖市');
INSERT INTO `area` VALUES ('2138', '212', '松滋市');
INSERT INTO `area` VALUES ('2139', '213', '市辖区');
INSERT INTO `area` VALUES ('2140', '213', '黄州区');
INSERT INTO `area` VALUES ('2141', '213', '团风县');
INSERT INTO `area` VALUES ('2142', '213', '红安县');
INSERT INTO `area` VALUES ('2143', '213', '罗田县');
INSERT INTO `area` VALUES ('2144', '213', '英山县');
INSERT INTO `area` VALUES ('2145', '213', '浠水县');
INSERT INTO `area` VALUES ('2146', '213', '蕲春县');
INSERT INTO `area` VALUES ('2147', '213', '黄梅县');
INSERT INTO `area` VALUES ('2148', '213', '麻城市');
INSERT INTO `area` VALUES ('2149', '213', '武穴市');
INSERT INTO `area` VALUES ('2150', '214', '市辖区');
INSERT INTO `area` VALUES ('2151', '214', '咸安区');
INSERT INTO `area` VALUES ('2152', '214', '嘉鱼县');
INSERT INTO `area` VALUES ('2153', '214', '通城县');
INSERT INTO `area` VALUES ('2154', '214', '崇阳县');
INSERT INTO `area` VALUES ('2155', '214', '通山县');
INSERT INTO `area` VALUES ('2156', '214', '赤壁市');
INSERT INTO `area` VALUES ('2157', '215', '市辖区');
INSERT INTO `area` VALUES ('2158', '215', '曾都区');
INSERT INTO `area` VALUES ('2159', '215', '广水市');
INSERT INTO `area` VALUES ('2160', '216', '恩施市');
INSERT INTO `area` VALUES ('2161', '216', '利川市');
INSERT INTO `area` VALUES ('2162', '216', '建始县');
INSERT INTO `area` VALUES ('2163', '216', '巴东县');
INSERT INTO `area` VALUES ('2164', '216', '宣恩县');
INSERT INTO `area` VALUES ('2165', '216', '咸丰县');
INSERT INTO `area` VALUES ('2166', '216', '来凤县');
INSERT INTO `area` VALUES ('2167', '216', '鹤峰县');
INSERT INTO `area` VALUES ('2168', '217', '仙桃市');
INSERT INTO `area` VALUES ('2169', '217', '潜江市');
INSERT INTO `area` VALUES ('2170', '217', '天门市');
INSERT INTO `area` VALUES ('2171', '217', '神农架林区');
INSERT INTO `area` VALUES ('2172', '218', '市辖区');
INSERT INTO `area` VALUES ('2173', '218', '芙蓉区');
INSERT INTO `area` VALUES ('2174', '218', '天心区');
INSERT INTO `area` VALUES ('2175', '218', '岳麓区');
INSERT INTO `area` VALUES ('2176', '218', '开福区');
INSERT INTO `area` VALUES ('2177', '218', '雨花区');
INSERT INTO `area` VALUES ('2178', '218', '长沙县');
INSERT INTO `area` VALUES ('2179', '218', '望城县');
INSERT INTO `area` VALUES ('2180', '218', '宁乡县');
INSERT INTO `area` VALUES ('2181', '218', '浏阳市');
INSERT INTO `area` VALUES ('2182', '219', '市辖区');
INSERT INTO `area` VALUES ('2183', '219', '荷塘区');
INSERT INTO `area` VALUES ('2184', '219', '芦淞区');
INSERT INTO `area` VALUES ('2185', '219', '石峰区');
INSERT INTO `area` VALUES ('2186', '219', '天元区');
INSERT INTO `area` VALUES ('2187', '219', '株洲县');
INSERT INTO `area` VALUES ('2188', '219', '攸县');
INSERT INTO `area` VALUES ('2189', '219', '茶陵县');
INSERT INTO `area` VALUES ('2190', '219', '炎陵县');
INSERT INTO `area` VALUES ('2191', '219', '醴陵市');
INSERT INTO `area` VALUES ('2192', '220', '市辖区');
INSERT INTO `area` VALUES ('2193', '220', '雨湖区');
INSERT INTO `area` VALUES ('2194', '220', '岳塘区');
INSERT INTO `area` VALUES ('2195', '220', '湘潭县');
INSERT INTO `area` VALUES ('2196', '220', '湘乡市');
INSERT INTO `area` VALUES ('2197', '220', '韶山市');
INSERT INTO `area` VALUES ('2198', '221', '市辖区');
INSERT INTO `area` VALUES ('2199', '221', '珠晖区');
INSERT INTO `area` VALUES ('2200', '221', '雁峰区');
INSERT INTO `area` VALUES ('2201', '221', '石鼓区');
INSERT INTO `area` VALUES ('2202', '221', '蒸湘区');
INSERT INTO `area` VALUES ('2203', '221', '南岳区');
INSERT INTO `area` VALUES ('2204', '221', '衡阳县');
INSERT INTO `area` VALUES ('2205', '221', '衡南县');
INSERT INTO `area` VALUES ('2206', '221', '衡山县');
INSERT INTO `area` VALUES ('2207', '221', '衡东县');
INSERT INTO `area` VALUES ('2208', '221', '祁东县');
INSERT INTO `area` VALUES ('2209', '221', '耒阳市');
INSERT INTO `area` VALUES ('2210', '221', '常宁市');
INSERT INTO `area` VALUES ('2211', '222', '市辖区');
INSERT INTO `area` VALUES ('2212', '222', '双清区');
INSERT INTO `area` VALUES ('2213', '222', '大祥区');
INSERT INTO `area` VALUES ('2214', '222', '北塔区');
INSERT INTO `area` VALUES ('2215', '222', '邵东县');
INSERT INTO `area` VALUES ('2216', '222', '新邵县');
INSERT INTO `area` VALUES ('2217', '222', '邵阳县');
INSERT INTO `area` VALUES ('2218', '222', '隆回县');
INSERT INTO `area` VALUES ('2219', '222', '洞口县');
INSERT INTO `area` VALUES ('2220', '222', '绥宁县');
INSERT INTO `area` VALUES ('2221', '222', '新宁县');
INSERT INTO `area` VALUES ('2222', '222', '城步苗族自治县');
INSERT INTO `area` VALUES ('2223', '222', '武冈市');
INSERT INTO `area` VALUES ('2224', '223', '市辖区');
INSERT INTO `area` VALUES ('2225', '223', '岳阳楼区');
INSERT INTO `area` VALUES ('2226', '223', '云溪区');
INSERT INTO `area` VALUES ('2227', '223', '君山区');
INSERT INTO `area` VALUES ('2228', '223', '岳阳县');
INSERT INTO `area` VALUES ('2229', '223', '华容县');
INSERT INTO `area` VALUES ('2230', '223', '湘阴县');
INSERT INTO `area` VALUES ('2231', '223', '平江县');
INSERT INTO `area` VALUES ('2232', '223', '汨罗市');
INSERT INTO `area` VALUES ('2233', '223', '临湘市');
INSERT INTO `area` VALUES ('2234', '224', '市辖区');
INSERT INTO `area` VALUES ('2235', '224', '武陵区');
INSERT INTO `area` VALUES ('2236', '224', '鼎城区');
INSERT INTO `area` VALUES ('2237', '224', '安乡县');
INSERT INTO `area` VALUES ('2238', '224', '汉寿县');
INSERT INTO `area` VALUES ('2239', '224', '澧县');
INSERT INTO `area` VALUES ('2240', '224', '临澧县');
INSERT INTO `area` VALUES ('2241', '224', '桃源县');
INSERT INTO `area` VALUES ('2242', '224', '石门县');
INSERT INTO `area` VALUES ('2243', '224', '津市市');
INSERT INTO `area` VALUES ('2244', '225', '市辖区');
INSERT INTO `area` VALUES ('2245', '225', '永定区');
INSERT INTO `area` VALUES ('2246', '225', '武陵源区');
INSERT INTO `area` VALUES ('2247', '225', '慈利县');
INSERT INTO `area` VALUES ('2248', '225', '桑植县');
INSERT INTO `area` VALUES ('2249', '226', '市辖区');
INSERT INTO `area` VALUES ('2250', '226', '资阳区');
INSERT INTO `area` VALUES ('2251', '226', '赫山区');
INSERT INTO `area` VALUES ('2252', '226', '南县');
INSERT INTO `area` VALUES ('2253', '226', '桃江县');
INSERT INTO `area` VALUES ('2254', '226', '安化县');
INSERT INTO `area` VALUES ('2255', '226', '沅江市');
INSERT INTO `area` VALUES ('2256', '227', '市辖区');
INSERT INTO `area` VALUES ('2257', '227', '北湖区');
INSERT INTO `area` VALUES ('2258', '227', '苏仙区');
INSERT INTO `area` VALUES ('2259', '227', '桂阳县');
INSERT INTO `area` VALUES ('2260', '227', '宜章县');
INSERT INTO `area` VALUES ('2261', '227', '永兴县');
INSERT INTO `area` VALUES ('2262', '227', '嘉禾县');
INSERT INTO `area` VALUES ('2263', '227', '临武县');
INSERT INTO `area` VALUES ('2264', '227', '汝城县');
INSERT INTO `area` VALUES ('2265', '227', '桂东县');
INSERT INTO `area` VALUES ('2266', '227', '安仁县');
INSERT INTO `area` VALUES ('2267', '227', '资兴市');
INSERT INTO `area` VALUES ('2268', '228', '市辖区');
INSERT INTO `area` VALUES ('2270', '228', '冷水滩区');
INSERT INTO `area` VALUES ('2271', '228', '祁阳县');
INSERT INTO `area` VALUES ('2272', '228', '东安县');
INSERT INTO `area` VALUES ('2273', '228', '双牌县');
INSERT INTO `area` VALUES ('2274', '228', '道县');
INSERT INTO `area` VALUES ('2275', '228', '江永县');
INSERT INTO `area` VALUES ('2276', '228', '宁远县');
INSERT INTO `area` VALUES ('2277', '228', '蓝山县');
INSERT INTO `area` VALUES ('2278', '228', '新田县');
INSERT INTO `area` VALUES ('2279', '228', '江华瑶族自治县');
INSERT INTO `area` VALUES ('2280', '229', '市辖区');
INSERT INTO `area` VALUES ('2281', '229', '鹤城区');
INSERT INTO `area` VALUES ('2282', '229', '中方县');
INSERT INTO `area` VALUES ('2283', '229', '沅陵县');
INSERT INTO `area` VALUES ('2284', '229', '辰溪县');
INSERT INTO `area` VALUES ('2285', '229', '溆浦县');
INSERT INTO `area` VALUES ('2286', '229', '会同县');
INSERT INTO `area` VALUES ('2287', '229', '麻阳苗族自治县');
INSERT INTO `area` VALUES ('2288', '229', '新晃侗族自治县');
INSERT INTO `area` VALUES ('2289', '229', '芷江侗族自治县');
INSERT INTO `area` VALUES ('2290', '229', '靖州苗族侗族自治县');
INSERT INTO `area` VALUES ('2291', '229', '通道侗族自治县');
INSERT INTO `area` VALUES ('2292', '229', '洪江市');
INSERT INTO `area` VALUES ('2293', '230', '市辖区');
INSERT INTO `area` VALUES ('2294', '230', '娄星区');
INSERT INTO `area` VALUES ('2295', '230', '双峰县');
INSERT INTO `area` VALUES ('2296', '230', '新化县');
INSERT INTO `area` VALUES ('2297', '230', '冷水江市');
INSERT INTO `area` VALUES ('2298', '230', '涟源市');
INSERT INTO `area` VALUES ('2299', '231', '吉首市');
INSERT INTO `area` VALUES ('2300', '231', '泸溪县');
INSERT INTO `area` VALUES ('2301', '231', '凤凰县');
INSERT INTO `area` VALUES ('2302', '231', '花垣县');
INSERT INTO `area` VALUES ('2303', '231', '保靖县');
INSERT INTO `area` VALUES ('2304', '231', '古丈县');
INSERT INTO `area` VALUES ('2305', '231', '永顺县');
INSERT INTO `area` VALUES ('2306', '231', '龙山县');
INSERT INTO `area` VALUES ('2307', '232', '市辖区');
INSERT INTO `area` VALUES ('2308', '232', '南沙区');
INSERT INTO `area` VALUES ('2309', '232', '荔湾区');
INSERT INTO `area` VALUES ('2310', '232', '越秀区');
INSERT INTO `area` VALUES ('2311', '232', '海珠区');
INSERT INTO `area` VALUES ('2312', '232', '天河区');
INSERT INTO `area` VALUES ('2313', '232', '萝岗区');
INSERT INTO `area` VALUES ('2314', '232', '白云区');
INSERT INTO `area` VALUES ('2315', '232', '黄埔区');
INSERT INTO `area` VALUES ('2316', '232', '番禺区');
INSERT INTO `area` VALUES ('2317', '232', '花都区');
INSERT INTO `area` VALUES ('2318', '232', '增城市');
INSERT INTO `area` VALUES ('2319', '232', '从化市');
INSERT INTO `area` VALUES ('2320', '233', '市辖区');
INSERT INTO `area` VALUES ('2321', '233', '武江区');
INSERT INTO `area` VALUES ('2322', '233', '浈江区');
INSERT INTO `area` VALUES ('2323', '233', '曲江区');
INSERT INTO `area` VALUES ('2324', '233', '始兴县');
INSERT INTO `area` VALUES ('2325', '233', '仁化县');
INSERT INTO `area` VALUES ('2326', '233', '翁源县');
INSERT INTO `area` VALUES ('2327', '233', '乳源瑶族自治县');
INSERT INTO `area` VALUES ('2328', '233', '新丰县');
INSERT INTO `area` VALUES ('2329', '233', '乐昌市');
INSERT INTO `area` VALUES ('2330', '233', '南雄市');
INSERT INTO `area` VALUES ('2331', '234', '市辖区');
INSERT INTO `area` VALUES ('2332', '234', '罗湖区');
INSERT INTO `area` VALUES ('2333', '234', '福田区');
INSERT INTO `area` VALUES ('2334', '234', '南山区');
INSERT INTO `area` VALUES ('2335', '234', '宝安区');
INSERT INTO `area` VALUES ('2336', '234', '龙岗区');
INSERT INTO `area` VALUES ('2337', '234', '盐田区');
INSERT INTO `area` VALUES ('2338', '235', '市辖区');
INSERT INTO `area` VALUES ('2339', '235', '香洲区');
INSERT INTO `area` VALUES ('2340', '235', '斗门区');
INSERT INTO `area` VALUES ('2341', '235', '金湾区');
INSERT INTO `area` VALUES ('2342', '236', '市辖区');
INSERT INTO `area` VALUES ('2343', '236', '龙湖区');
INSERT INTO `area` VALUES ('2344', '236', '金平区');
INSERT INTO `area` VALUES ('2345', '236', '濠江区');
INSERT INTO `area` VALUES ('2346', '236', '潮阳区');
INSERT INTO `area` VALUES ('2347', '236', '潮南区');
INSERT INTO `area` VALUES ('2348', '236', '澄海区');
INSERT INTO `area` VALUES ('2349', '236', '南澳县');
INSERT INTO `area` VALUES ('2350', '237', '市辖区');
INSERT INTO `area` VALUES ('2351', '237', '禅城区');
INSERT INTO `area` VALUES ('2352', '237', '南海区');
INSERT INTO `area` VALUES ('2353', '237', '顺德区');
INSERT INTO `area` VALUES ('2354', '237', '三水区');
INSERT INTO `area` VALUES ('2355', '237', '高明区');
INSERT INTO `area` VALUES ('2356', '238', '市辖区');
INSERT INTO `area` VALUES ('2357', '238', '蓬江区');
INSERT INTO `area` VALUES ('2358', '238', '江海区');
INSERT INTO `area` VALUES ('2359', '238', '新会区');
INSERT INTO `area` VALUES ('2360', '238', '台山市');
INSERT INTO `area` VALUES ('2361', '238', '开平市');
INSERT INTO `area` VALUES ('2362', '238', '鹤山市');
INSERT INTO `area` VALUES ('2363', '238', '恩平市');
INSERT INTO `area` VALUES ('2364', '239', '市辖区');
INSERT INTO `area` VALUES ('2365', '239', '赤坎区');
INSERT INTO `area` VALUES ('2366', '239', '霞山区');
INSERT INTO `area` VALUES ('2367', '239', '坡头区');
INSERT INTO `area` VALUES ('2368', '239', '麻章区');
INSERT INTO `area` VALUES ('2369', '239', '遂溪县');
INSERT INTO `area` VALUES ('2370', '239', '徐闻县');
INSERT INTO `area` VALUES ('2371', '239', '廉江市');
INSERT INTO `area` VALUES ('2372', '239', '雷州市');
INSERT INTO `area` VALUES ('2373', '239', '吴川市');
INSERT INTO `area` VALUES ('2374', '240', '市辖区');
INSERT INTO `area` VALUES ('2375', '240', '茂南区');
INSERT INTO `area` VALUES ('2376', '240', '茂港区');
INSERT INTO `area` VALUES ('2377', '240', '电白县');
INSERT INTO `area` VALUES ('2378', '240', '高州市');
INSERT INTO `area` VALUES ('2379', '240', '化州市');
INSERT INTO `area` VALUES ('2380', '240', '信宜市');
INSERT INTO `area` VALUES ('2381', '241', '市辖区');
INSERT INTO `area` VALUES ('2382', '241', '端州区');
INSERT INTO `area` VALUES ('2383', '241', '鼎湖区');
INSERT INTO `area` VALUES ('2384', '241', '广宁县');
INSERT INTO `area` VALUES ('2385', '241', '怀集县');
INSERT INTO `area` VALUES ('2386', '241', '封开县');
INSERT INTO `area` VALUES ('2387', '241', '德庆县');
INSERT INTO `area` VALUES ('2388', '241', '高要市');
INSERT INTO `area` VALUES ('2389', '241', '四会市');
INSERT INTO `area` VALUES ('2390', '242', '市辖区');
INSERT INTO `area` VALUES ('2391', '242', '惠城区');
INSERT INTO `area` VALUES ('2392', '242', '惠阳区');
INSERT INTO `area` VALUES ('2393', '242', '博罗县');
INSERT INTO `area` VALUES ('2394', '242', '惠东县');
INSERT INTO `area` VALUES ('2395', '242', '龙门县');
INSERT INTO `area` VALUES ('2396', '243', '市辖区');
INSERT INTO `area` VALUES ('2397', '243', '梅江区');
INSERT INTO `area` VALUES ('2398', '243', '梅县');
INSERT INTO `area` VALUES ('2399', '243', '大埔县');
INSERT INTO `area` VALUES ('2400', '243', '丰顺县');
INSERT INTO `area` VALUES ('2401', '243', '五华县');
INSERT INTO `area` VALUES ('2402', '243', '平远县');
INSERT INTO `area` VALUES ('2403', '243', '蕉岭县');
INSERT INTO `area` VALUES ('2404', '243', '兴宁市');
INSERT INTO `area` VALUES ('2405', '244', '市辖区');
INSERT INTO `area` VALUES ('2406', '244', '城区');
INSERT INTO `area` VALUES ('2407', '244', '海丰县');
INSERT INTO `area` VALUES ('2408', '244', '陆河县');
INSERT INTO `area` VALUES ('2409', '244', '陆丰市');
INSERT INTO `area` VALUES ('2410', '245', '市辖区');
INSERT INTO `area` VALUES ('2411', '245', '源城区');
INSERT INTO `area` VALUES ('2412', '245', '紫金县');
INSERT INTO `area` VALUES ('2413', '245', '龙川县');
INSERT INTO `area` VALUES ('2414', '245', '连平县');
INSERT INTO `area` VALUES ('2415', '245', '和平县');
INSERT INTO `area` VALUES ('2416', '245', '东源县');
INSERT INTO `area` VALUES ('2417', '246', '市辖区');
INSERT INTO `area` VALUES ('2418', '246', '江城区');
INSERT INTO `area` VALUES ('2419', '246', '阳西县');
INSERT INTO `area` VALUES ('2420', '246', '阳东县');
INSERT INTO `area` VALUES ('2421', '246', '阳春市');
INSERT INTO `area` VALUES ('2422', '247', '市辖区');
INSERT INTO `area` VALUES ('2423', '247', '清城区');
INSERT INTO `area` VALUES ('2424', '247', '佛冈县');
INSERT INTO `area` VALUES ('2425', '247', '阳山县');
INSERT INTO `area` VALUES ('2426', '247', '连山壮族瑶族自治县');
INSERT INTO `area` VALUES ('2427', '247', '连南瑶族自治县');
INSERT INTO `area` VALUES ('2428', '247', '清新县');
INSERT INTO `area` VALUES ('2429', '247', '英德市');
INSERT INTO `area` VALUES ('2430', '247', '连州市');
INSERT INTO `area` VALUES ('2431', '250', '市辖区');
INSERT INTO `area` VALUES ('2432', '250', '湘桥区');
INSERT INTO `area` VALUES ('2433', '250', '潮安县');
INSERT INTO `area` VALUES ('2434', '250', '饶平县');
INSERT INTO `area` VALUES ('2435', '251', '市辖区');
INSERT INTO `area` VALUES ('2436', '251', '榕城区');
INSERT INTO `area` VALUES ('2437', '251', '揭东县');
INSERT INTO `area` VALUES ('2438', '251', '揭西县');
INSERT INTO `area` VALUES ('2439', '251', '惠来县');
INSERT INTO `area` VALUES ('2440', '251', '普宁市');
INSERT INTO `area` VALUES ('2441', '252', '市辖区');
INSERT INTO `area` VALUES ('2442', '252', '云城区');
INSERT INTO `area` VALUES ('2443', '252', '新兴县');
INSERT INTO `area` VALUES ('2444', '252', '郁南县');
INSERT INTO `area` VALUES ('2445', '252', '云安县');
INSERT INTO `area` VALUES ('2446', '252', '罗定市');
INSERT INTO `area` VALUES ('2447', '253', '市辖区');
INSERT INTO `area` VALUES ('2448', '253', '兴宁区');
INSERT INTO `area` VALUES ('2449', '253', '青秀区');
INSERT INTO `area` VALUES ('2450', '253', '江南区');
INSERT INTO `area` VALUES ('2451', '253', '西乡塘区');
INSERT INTO `area` VALUES ('2452', '253', '良庆区');
INSERT INTO `area` VALUES ('2453', '253', '邕宁区');
INSERT INTO `area` VALUES ('2454', '253', '武鸣县');
INSERT INTO `area` VALUES ('2455', '253', '隆安县');
INSERT INTO `area` VALUES ('2456', '253', '马山县');
INSERT INTO `area` VALUES ('2457', '253', '上林县');
INSERT INTO `area` VALUES ('2458', '253', '宾阳县');
INSERT INTO `area` VALUES ('2459', '253', '横县');
INSERT INTO `area` VALUES ('2460', '254', '市辖区');
INSERT INTO `area` VALUES ('2461', '254', '城中区');
INSERT INTO `area` VALUES ('2462', '254', '鱼峰区');
INSERT INTO `area` VALUES ('2463', '254', '柳南区');
INSERT INTO `area` VALUES ('2464', '254', '柳北区');
INSERT INTO `area` VALUES ('2465', '254', '柳江县');
INSERT INTO `area` VALUES ('2466', '254', '柳城县');
INSERT INTO `area` VALUES ('2467', '254', '鹿寨县');
INSERT INTO `area` VALUES ('2468', '254', '融安县');
INSERT INTO `area` VALUES ('2469', '254', '融水苗族自治县');
INSERT INTO `area` VALUES ('2470', '254', '三江侗族自治县');
INSERT INTO `area` VALUES ('2471', '255', '市辖区');
INSERT INTO `area` VALUES ('2472', '255', '秀峰区');
INSERT INTO `area` VALUES ('2473', '255', '叠彩区');
INSERT INTO `area` VALUES ('2474', '255', '象山区');
INSERT INTO `area` VALUES ('2475', '255', '七星区');
INSERT INTO `area` VALUES ('2476', '255', '雁山区');
INSERT INTO `area` VALUES ('2477', '255', '阳朔县');
INSERT INTO `area` VALUES ('2478', '255', '临桂县');
INSERT INTO `area` VALUES ('2479', '255', '灵川县');
INSERT INTO `area` VALUES ('2480', '255', '全州县');
INSERT INTO `area` VALUES ('2481', '255', '兴安县');
INSERT INTO `area` VALUES ('2482', '255', '永福县');
INSERT INTO `area` VALUES ('2483', '255', '灌阳县');
INSERT INTO `area` VALUES ('2484', '255', '龙胜各族自治县');
INSERT INTO `area` VALUES ('2485', '255', '资源县');
INSERT INTO `area` VALUES ('2486', '255', '平乐县');
INSERT INTO `area` VALUES ('2487', '255', '荔蒲县');
INSERT INTO `area` VALUES ('2488', '255', '恭城瑶族自治县');
INSERT INTO `area` VALUES ('2489', '256', '市辖区');
INSERT INTO `area` VALUES ('2490', '256', '万秀区');
INSERT INTO `area` VALUES ('2491', '256', '蝶山区');
INSERT INTO `area` VALUES ('2492', '256', '长洲区');
INSERT INTO `area` VALUES ('2493', '256', '苍梧县');
INSERT INTO `area` VALUES ('2494', '256', '藤县');
INSERT INTO `area` VALUES ('2495', '256', '蒙山县');
INSERT INTO `area` VALUES ('2496', '256', '岑溪市');
INSERT INTO `area` VALUES ('2497', '257', '市辖区');
INSERT INTO `area` VALUES ('2498', '257', '海城区');
INSERT INTO `area` VALUES ('2499', '257', '银海区');
INSERT INTO `area` VALUES ('2500', '257', '铁山港区');
INSERT INTO `area` VALUES ('2501', '257', '合浦县');
INSERT INTO `area` VALUES ('2502', '258', '市辖区');
INSERT INTO `area` VALUES ('2503', '258', '港口区');
INSERT INTO `area` VALUES ('2504', '258', '防城区');
INSERT INTO `area` VALUES ('2505', '258', '上思县');
INSERT INTO `area` VALUES ('2506', '258', '东兴市');
INSERT INTO `area` VALUES ('2507', '259', '市辖区');
INSERT INTO `area` VALUES ('2508', '259', '钦南区');
INSERT INTO `area` VALUES ('2509', '259', '钦北区');
INSERT INTO `area` VALUES ('2510', '259', '灵山县');
INSERT INTO `area` VALUES ('2511', '259', '浦北县');
INSERT INTO `area` VALUES ('2512', '260', '市辖区');
INSERT INTO `area` VALUES ('2513', '260', '港北区');
INSERT INTO `area` VALUES ('2514', '260', '港南区');
INSERT INTO `area` VALUES ('2515', '260', '覃塘区');
INSERT INTO `area` VALUES ('2516', '260', '平南县');
INSERT INTO `area` VALUES ('2517', '260', '桂平市');
INSERT INTO `area` VALUES ('2518', '261', '市辖区');
INSERT INTO `area` VALUES ('2519', '261', '玉州区');
INSERT INTO `area` VALUES ('2520', '261', '容县');
INSERT INTO `area` VALUES ('2521', '261', '陆川县');
INSERT INTO `area` VALUES ('2522', '261', '博白县');
INSERT INTO `area` VALUES ('2523', '261', '兴业县');
INSERT INTO `area` VALUES ('2524', '261', '北流市');
INSERT INTO `area` VALUES ('2525', '262', '市辖区');
INSERT INTO `area` VALUES ('2526', '262', '右江区');
INSERT INTO `area` VALUES ('2527', '262', '田阳县');
INSERT INTO `area` VALUES ('2528', '262', '田东县');
INSERT INTO `area` VALUES ('2529', '262', '平果县');
INSERT INTO `area` VALUES ('2530', '262', '德保县');
INSERT INTO `area` VALUES ('2531', '262', '靖西县');
INSERT INTO `area` VALUES ('2532', '262', '那坡县');
INSERT INTO `area` VALUES ('2533', '262', '凌云县');
INSERT INTO `area` VALUES ('2534', '262', '乐业县');
INSERT INTO `area` VALUES ('2535', '262', '田林县');
INSERT INTO `area` VALUES ('2536', '262', '西林县');
INSERT INTO `area` VALUES ('2537', '262', '隆林各族自治县');
INSERT INTO `area` VALUES ('2538', '263', '市辖区');
INSERT INTO `area` VALUES ('2539', '263', '八步区');
INSERT INTO `area` VALUES ('2540', '263', '昭平县');
INSERT INTO `area` VALUES ('2541', '263', '钟山县');
INSERT INTO `area` VALUES ('2542', '263', '富川瑶族自治县');
INSERT INTO `area` VALUES ('2543', '264', '市辖区');
INSERT INTO `area` VALUES ('2544', '264', '金城江区');
INSERT INTO `area` VALUES ('2545', '264', '南丹县');
INSERT INTO `area` VALUES ('2546', '264', '天峨县');
INSERT INTO `area` VALUES ('2547', '264', '凤山县');
INSERT INTO `area` VALUES ('2548', '264', '东兰县');
INSERT INTO `area` VALUES ('2549', '264', '罗城仫佬族自治县');
INSERT INTO `area` VALUES ('2550', '264', '环江毛南族自治县');
INSERT INTO `area` VALUES ('2551', '264', '巴马瑶族自治县');
INSERT INTO `area` VALUES ('2552', '264', '都安瑶族自治县');
INSERT INTO `area` VALUES ('2553', '264', '大化瑶族自治县');
INSERT INTO `area` VALUES ('2554', '264', '宜州市');
INSERT INTO `area` VALUES ('2555', '265', '市辖区');
INSERT INTO `area` VALUES ('2556', '265', '兴宾区');
INSERT INTO `area` VALUES ('2557', '265', '忻城县');
INSERT INTO `area` VALUES ('2558', '265', '象州县');
INSERT INTO `area` VALUES ('2559', '265', '武宣县');
INSERT INTO `area` VALUES ('2560', '265', '金秀瑶族自治县');
INSERT INTO `area` VALUES ('2561', '265', '合山市');
INSERT INTO `area` VALUES ('2562', '266', '市辖区');
INSERT INTO `area` VALUES ('2563', '266', '江洲区');
INSERT INTO `area` VALUES ('2564', '266', '扶绥县');
INSERT INTO `area` VALUES ('2565', '266', '宁明县');
INSERT INTO `area` VALUES ('2566', '266', '龙州县');
INSERT INTO `area` VALUES ('2567', '266', '大新县');
INSERT INTO `area` VALUES ('2568', '266', '天等县');
INSERT INTO `area` VALUES ('2569', '266', '凭祥市');
INSERT INTO `area` VALUES ('2570', '267', '市辖区');
INSERT INTO `area` VALUES ('2571', '267', '秀英区');
INSERT INTO `area` VALUES ('2572', '267', '龙华区');
INSERT INTO `area` VALUES ('2573', '267', '琼山区');
INSERT INTO `area` VALUES ('2574', '267', '美兰区');
INSERT INTO `area` VALUES ('2575', '268', '市辖区');
INSERT INTO `area` VALUES ('2576', '269', '五指山市');
INSERT INTO `area` VALUES ('2577', '269', '琼海市');
INSERT INTO `area` VALUES ('2578', '269', '儋州市');
INSERT INTO `area` VALUES ('2579', '269', '文昌市');
INSERT INTO `area` VALUES ('2580', '269', '万宁市');
INSERT INTO `area` VALUES ('2581', '269', '东方市');
INSERT INTO `area` VALUES ('2582', '269', '定安县');
INSERT INTO `area` VALUES ('2583', '269', '屯昌县');
INSERT INTO `area` VALUES ('2584', '269', '澄迈县');
INSERT INTO `area` VALUES ('2585', '269', '临高县');
INSERT INTO `area` VALUES ('2586', '269', '白沙黎族自治县');
INSERT INTO `area` VALUES ('2587', '269', '昌江黎族自治县');
INSERT INTO `area` VALUES ('2588', '269', '乐东黎族自治县');
INSERT INTO `area` VALUES ('2589', '269', '陵水黎族自治县');
INSERT INTO `area` VALUES ('2590', '269', '保亭黎族苗族自治县');
INSERT INTO `area` VALUES ('2591', '269', '琼中黎族苗族自治县');
INSERT INTO `area` VALUES ('2592', '269', '西沙群岛');
INSERT INTO `area` VALUES ('2593', '269', '南沙群岛');
INSERT INTO `area` VALUES ('2594', '269', '中沙群岛的岛礁及其海域');
INSERT INTO `area` VALUES ('2595', '270', '万州区');
INSERT INTO `area` VALUES ('2596', '270', '涪陵区');
INSERT INTO `area` VALUES ('2597', '270', '渝中区');
INSERT INTO `area` VALUES ('2598', '270', '大渡口区');
INSERT INTO `area` VALUES ('2599', '270', '江北区');
INSERT INTO `area` VALUES ('2600', '270', '沙坪坝区');
INSERT INTO `area` VALUES ('2601', '270', '九龙坡区');
INSERT INTO `area` VALUES ('2602', '270', '南岸区');
INSERT INTO `area` VALUES ('2603', '270', '北碚区');
INSERT INTO `area` VALUES ('2604', '270', '万盛区');
INSERT INTO `area` VALUES ('2605', '270', '双桥区');
INSERT INTO `area` VALUES ('2606', '270', '渝北区');
INSERT INTO `area` VALUES ('2607', '270', '巴南区');
INSERT INTO `area` VALUES ('2608', '270', '黔江区');
INSERT INTO `area` VALUES ('2609', '270', '长寿区');
INSERT INTO `area` VALUES ('2610', '271', '綦江县');
INSERT INTO `area` VALUES ('2611', '271', '潼南县');
INSERT INTO `area` VALUES ('2612', '271', '铜梁县');
INSERT INTO `area` VALUES ('2613', '271', '大足县');
INSERT INTO `area` VALUES ('2614', '271', '荣昌县');
INSERT INTO `area` VALUES ('2615', '271', '璧山县');
INSERT INTO `area` VALUES ('2616', '271', '梁平县');
INSERT INTO `area` VALUES ('2617', '271', '城口县');
INSERT INTO `area` VALUES ('2618', '271', '丰都县');
INSERT INTO `area` VALUES ('2619', '271', '垫江县');
INSERT INTO `area` VALUES ('2620', '271', '武隆县');
INSERT INTO `area` VALUES ('2621', '271', '忠县');
INSERT INTO `area` VALUES ('2622', '271', '开县');
INSERT INTO `area` VALUES ('2623', '271', '云阳县');
INSERT INTO `area` VALUES ('2624', '271', '奉节县');
INSERT INTO `area` VALUES ('2625', '271', '巫山县');
INSERT INTO `area` VALUES ('2626', '271', '巫溪县');
INSERT INTO `area` VALUES ('2627', '271', '石柱土家族自治县');
INSERT INTO `area` VALUES ('2628', '271', '秀山土家族苗族自治县');
INSERT INTO `area` VALUES ('2629', '271', '酉阳土家族苗族自治县');
INSERT INTO `area` VALUES ('2630', '271', '彭水苗族土家族自治县');
INSERT INTO `area` VALUES ('2631', '270', '江津区');
INSERT INTO `area` VALUES ('2632', '270', '合川区');
INSERT INTO `area` VALUES ('2633', '270', '永川区');
INSERT INTO `area` VALUES ('2634', '270', '南川区');
INSERT INTO `area` VALUES ('2635', '273', '市辖区');
INSERT INTO `area` VALUES ('2636', '273', '锦江区');
INSERT INTO `area` VALUES ('2637', '273', '青羊区');
INSERT INTO `area` VALUES ('2638', '273', '金牛区');
INSERT INTO `area` VALUES ('2639', '273', '武侯区');
INSERT INTO `area` VALUES ('2640', '273', '成华区');
INSERT INTO `area` VALUES ('2641', '273', '龙泉驿区');
INSERT INTO `area` VALUES ('2642', '273', '青白江区');
INSERT INTO `area` VALUES ('2643', '273', '新都区');
INSERT INTO `area` VALUES ('2644', '273', '温江区');
INSERT INTO `area` VALUES ('2645', '273', '金堂县');
INSERT INTO `area` VALUES ('2646', '273', '双流县');
INSERT INTO `area` VALUES ('2647', '273', '郫县');
INSERT INTO `area` VALUES ('2648', '273', '大邑县');
INSERT INTO `area` VALUES ('2649', '273', '蒲江县');
INSERT INTO `area` VALUES ('2650', '273', '新津县');
INSERT INTO `area` VALUES ('2651', '273', '都江堰市');
INSERT INTO `area` VALUES ('2652', '273', '彭州市');
INSERT INTO `area` VALUES ('2653', '273', '邛崃市');
INSERT INTO `area` VALUES ('2654', '273', '崇州市');
INSERT INTO `area` VALUES ('2655', '274', '市辖区');
INSERT INTO `area` VALUES ('2656', '274', '自流井区');
INSERT INTO `area` VALUES ('2657', '274', '贡井区');
INSERT INTO `area` VALUES ('2658', '274', '大安区');
INSERT INTO `area` VALUES ('2659', '274', '沿滩区');
INSERT INTO `area` VALUES ('2660', '274', '荣县');
INSERT INTO `area` VALUES ('2661', '274', '富顺县');
INSERT INTO `area` VALUES ('2662', '275', '市辖区');
INSERT INTO `area` VALUES ('2663', '275', '东区');
INSERT INTO `area` VALUES ('2664', '275', '西区');
INSERT INTO `area` VALUES ('2665', '275', '仁和区');
INSERT INTO `area` VALUES ('2666', '275', '米易县');
INSERT INTO `area` VALUES ('2667', '275', '盐边县');
INSERT INTO `area` VALUES ('2668', '276', '市辖区');
INSERT INTO `area` VALUES ('2669', '276', '江阳区');
INSERT INTO `area` VALUES ('2670', '276', '纳溪区');
INSERT INTO `area` VALUES ('2671', '276', '龙马潭区');
INSERT INTO `area` VALUES ('2672', '276', '泸县');
INSERT INTO `area` VALUES ('2673', '276', '合江县');
INSERT INTO `area` VALUES ('2674', '276', '叙永县');
INSERT INTO `area` VALUES ('2675', '276', '古蔺县');
INSERT INTO `area` VALUES ('2676', '277', '市辖区');
INSERT INTO `area` VALUES ('2677', '277', '旌阳区');
INSERT INTO `area` VALUES ('2678', '277', '中江县');
INSERT INTO `area` VALUES ('2679', '277', '罗江县');
INSERT INTO `area` VALUES ('2680', '277', '广汉市');
INSERT INTO `area` VALUES ('2681', '277', '什邡市');
INSERT INTO `area` VALUES ('2682', '277', '绵竹市');
INSERT INTO `area` VALUES ('2683', '278', '市辖区');
INSERT INTO `area` VALUES ('2684', '278', '涪城区');
INSERT INTO `area` VALUES ('2685', '278', '游仙区');
INSERT INTO `area` VALUES ('2686', '278', '三台县');
INSERT INTO `area` VALUES ('2687', '278', '盐亭县');
INSERT INTO `area` VALUES ('2688', '278', '安县');
INSERT INTO `area` VALUES ('2689', '278', '梓潼县');
INSERT INTO `area` VALUES ('2690', '278', '北川羌族自治县');
INSERT INTO `area` VALUES ('2691', '278', '平武县');
INSERT INTO `area` VALUES ('2692', '278', '江油市');
INSERT INTO `area` VALUES ('2693', '279', '市辖区');
INSERT INTO `area` VALUES ('2694', '279', '市中区');
INSERT INTO `area` VALUES ('2695', '279', '元坝区');
INSERT INTO `area` VALUES ('2696', '279', '朝天区');
INSERT INTO `area` VALUES ('2697', '279', '旺苍县');
INSERT INTO `area` VALUES ('2698', '279', '青川县');
INSERT INTO `area` VALUES ('2699', '279', '剑阁县');
INSERT INTO `area` VALUES ('2700', '279', '苍溪县');
INSERT INTO `area` VALUES ('2701', '280', '市辖区');
INSERT INTO `area` VALUES ('2702', '280', '船山区');
INSERT INTO `area` VALUES ('2703', '280', '安居区');
INSERT INTO `area` VALUES ('2704', '280', '蓬溪县');
INSERT INTO `area` VALUES ('2705', '280', '射洪县');
INSERT INTO `area` VALUES ('2706', '280', '大英县');
INSERT INTO `area` VALUES ('2707', '281', '市辖区');
INSERT INTO `area` VALUES ('2708', '281', '市中区');
INSERT INTO `area` VALUES ('2709', '281', '东兴区');
INSERT INTO `area` VALUES ('2710', '281', '威远县');
INSERT INTO `area` VALUES ('2711', '281', '资中县');
INSERT INTO `area` VALUES ('2712', '281', '隆昌县');
INSERT INTO `area` VALUES ('2713', '282', '市辖区');
INSERT INTO `area` VALUES ('2714', '282', '市中区');
INSERT INTO `area` VALUES ('2715', '282', '沙湾区');
INSERT INTO `area` VALUES ('2716', '282', '五通桥区');
INSERT INTO `area` VALUES ('2717', '282', '金口河区');
INSERT INTO `area` VALUES ('2718', '282', '犍为县');
INSERT INTO `area` VALUES ('2719', '282', '井研县');
INSERT INTO `area` VALUES ('2720', '282', '夹江县');
INSERT INTO `area` VALUES ('2721', '282', '沐川县');
INSERT INTO `area` VALUES ('2722', '282', '峨边彝族自治县');
INSERT INTO `area` VALUES ('2723', '282', '马边彝族自治县');
INSERT INTO `area` VALUES ('2724', '282', '峨眉山市');
INSERT INTO `area` VALUES ('2725', '283', '市辖区');
INSERT INTO `area` VALUES ('2726', '283', '顺庆区');
INSERT INTO `area` VALUES ('2727', '283', '高坪区');
INSERT INTO `area` VALUES ('2728', '283', '嘉陵区');
INSERT INTO `area` VALUES ('2729', '283', '南部县');
INSERT INTO `area` VALUES ('2730', '283', '营山县');
INSERT INTO `area` VALUES ('2731', '283', '蓬安县');
INSERT INTO `area` VALUES ('2732', '283', '仪陇县');
INSERT INTO `area` VALUES ('2733', '283', '西充县');
INSERT INTO `area` VALUES ('2734', '283', '阆中市');
INSERT INTO `area` VALUES ('2735', '284', '市辖区');
INSERT INTO `area` VALUES ('2736', '284', '东坡区');
INSERT INTO `area` VALUES ('2737', '284', '仁寿县');
INSERT INTO `area` VALUES ('2738', '284', '彭山县');
INSERT INTO `area` VALUES ('2739', '284', '洪雅县');
INSERT INTO `area` VALUES ('2740', '284', '丹棱县');
INSERT INTO `area` VALUES ('2741', '284', '青神县');
INSERT INTO `area` VALUES ('2742', '285', '市辖区');
INSERT INTO `area` VALUES ('2743', '285', '翠屏区');
INSERT INTO `area` VALUES ('2744', '285', '宜宾县');
INSERT INTO `area` VALUES ('2745', '285', '南溪县');
INSERT INTO `area` VALUES ('2746', '285', '江安县');
INSERT INTO `area` VALUES ('2747', '285', '长宁县');
INSERT INTO `area` VALUES ('2748', '285', '高县');
INSERT INTO `area` VALUES ('2749', '285', '珙县');
INSERT INTO `area` VALUES ('2750', '285', '筠连县');
INSERT INTO `area` VALUES ('2751', '285', '兴文县');
INSERT INTO `area` VALUES ('2752', '285', '屏山县');
INSERT INTO `area` VALUES ('2753', '286', '市辖区');
INSERT INTO `area` VALUES ('2754', '286', '广安区');
INSERT INTO `area` VALUES ('2755', '286', '岳池县');
INSERT INTO `area` VALUES ('2756', '286', '武胜县');
INSERT INTO `area` VALUES ('2757', '286', '邻水县');
INSERT INTO `area` VALUES ('2759', '287', '市辖区');
INSERT INTO `area` VALUES ('2760', '287', '通川区');
INSERT INTO `area` VALUES ('2761', '287', '达县');
INSERT INTO `area` VALUES ('2762', '287', '宣汉县');
INSERT INTO `area` VALUES ('2763', '287', '开江县');
INSERT INTO `area` VALUES ('2764', '287', '大竹县');
INSERT INTO `area` VALUES ('2765', '287', '渠县');
INSERT INTO `area` VALUES ('2766', '287', '万源市');
INSERT INTO `area` VALUES ('2767', '288', '市辖区');
INSERT INTO `area` VALUES ('2768', '288', '雨城区');
INSERT INTO `area` VALUES ('2769', '288', '名山县');
INSERT INTO `area` VALUES ('2770', '288', '荥经县');
INSERT INTO `area` VALUES ('2771', '288', '汉源县');
INSERT INTO `area` VALUES ('2772', '288', '石棉县');
INSERT INTO `area` VALUES ('2773', '288', '天全县');
INSERT INTO `area` VALUES ('2774', '288', '芦山县');
INSERT INTO `area` VALUES ('2775', '288', '宝兴县');
INSERT INTO `area` VALUES ('2776', '289', '市辖区');
INSERT INTO `area` VALUES ('2777', '289', '巴州区');
INSERT INTO `area` VALUES ('2778', '289', '通江县');
INSERT INTO `area` VALUES ('2779', '289', '南江县');
INSERT INTO `area` VALUES ('2780', '289', '平昌县');
INSERT INTO `area` VALUES ('2781', '290', '市辖区');
INSERT INTO `area` VALUES ('2782', '290', '雁江区');
INSERT INTO `area` VALUES ('2783', '290', '安岳县');
INSERT INTO `area` VALUES ('2784', '290', '乐至县');
INSERT INTO `area` VALUES ('2785', '290', '简阳市');
INSERT INTO `area` VALUES ('2786', '291', '汶川县');
INSERT INTO `area` VALUES ('2787', '291', '理县');
INSERT INTO `area` VALUES ('2788', '291', '茂县');
INSERT INTO `area` VALUES ('2789', '291', '松潘县');
INSERT INTO `area` VALUES ('2790', '291', '九寨沟县');
INSERT INTO `area` VALUES ('2791', '291', '金川县');
INSERT INTO `area` VALUES ('2792', '291', '小金县');
INSERT INTO `area` VALUES ('2793', '291', '黑水县');
INSERT INTO `area` VALUES ('2794', '291', '马尔康县');
INSERT INTO `area` VALUES ('2795', '291', '壤塘县');
INSERT INTO `area` VALUES ('2796', '291', '阿坝县');
INSERT INTO `area` VALUES ('2797', '291', '若尔盖县');
INSERT INTO `area` VALUES ('2798', '291', '红原县');
INSERT INTO `area` VALUES ('2799', '292', '康定县');
INSERT INTO `area` VALUES ('2800', '292', '泸定县');
INSERT INTO `area` VALUES ('2801', '292', '丹巴县');
INSERT INTO `area` VALUES ('2802', '292', '九龙县');
INSERT INTO `area` VALUES ('2803', '292', '雅江县');
INSERT INTO `area` VALUES ('2804', '292', '道孚县');
INSERT INTO `area` VALUES ('2805', '292', '炉霍县');
INSERT INTO `area` VALUES ('2806', '292', '甘孜县');
INSERT INTO `area` VALUES ('2807', '292', '新龙县');
INSERT INTO `area` VALUES ('2808', '292', '德格县');
INSERT INTO `area` VALUES ('2809', '292', '白玉县');
INSERT INTO `area` VALUES ('2810', '292', '石渠县');
INSERT INTO `area` VALUES ('2811', '292', '色达县');
INSERT INTO `area` VALUES ('2812', '292', '理塘县');
INSERT INTO `area` VALUES ('2813', '292', '巴塘县');
INSERT INTO `area` VALUES ('2814', '292', '乡城县');
INSERT INTO `area` VALUES ('2815', '292', '稻城县');
INSERT INTO `area` VALUES ('2816', '292', '得荣县');
INSERT INTO `area` VALUES ('2817', '293', '西昌市');
INSERT INTO `area` VALUES ('2818', '293', '木里藏族自治县');
INSERT INTO `area` VALUES ('2819', '293', '盐源县');
INSERT INTO `area` VALUES ('2820', '293', '德昌县');
INSERT INTO `area` VALUES ('2821', '293', '会理县');
INSERT INTO `area` VALUES ('2822', '293', '会东县');
INSERT INTO `area` VALUES ('2823', '293', '宁南县');
INSERT INTO `area` VALUES ('2824', '293', '普格县');
INSERT INTO `area` VALUES ('2825', '293', '布拖县');
INSERT INTO `area` VALUES ('2826', '293', '金阳县');
INSERT INTO `area` VALUES ('2827', '293', '昭觉县');
INSERT INTO `area` VALUES ('2828', '293', '喜德县');
INSERT INTO `area` VALUES ('2829', '293', '冕宁县');
INSERT INTO `area` VALUES ('2830', '293', '越西县');
INSERT INTO `area` VALUES ('2831', '293', '甘洛县');
INSERT INTO `area` VALUES ('2832', '293', '美姑县');
INSERT INTO `area` VALUES ('2833', '293', '雷波县');
INSERT INTO `area` VALUES ('2834', '294', '市辖区');
INSERT INTO `area` VALUES ('2835', '294', '南明区');
INSERT INTO `area` VALUES ('2836', '294', '云岩区');
INSERT INTO `area` VALUES ('2837', '294', '花溪区');
INSERT INTO `area` VALUES ('2838', '294', '乌当区');
INSERT INTO `area` VALUES ('2839', '294', '白云区');
INSERT INTO `area` VALUES ('2840', '294', '小河区');
INSERT INTO `area` VALUES ('2841', '294', '开阳县');
INSERT INTO `area` VALUES ('2842', '294', '息烽县');
INSERT INTO `area` VALUES ('2843', '294', '修文县');
INSERT INTO `area` VALUES ('2844', '294', '清镇市');
INSERT INTO `area` VALUES ('2845', '295', '钟山区');
INSERT INTO `area` VALUES ('2846', '295', '六枝特区');
INSERT INTO `area` VALUES ('2847', '295', '水城县');
INSERT INTO `area` VALUES ('2848', '295', '盘县');
INSERT INTO `area` VALUES ('2849', '296', '市辖区');
INSERT INTO `area` VALUES ('2850', '296', '红花岗区');
INSERT INTO `area` VALUES ('2851', '296', '汇川区');
INSERT INTO `area` VALUES ('2852', '296', '遵义县');
INSERT INTO `area` VALUES ('2853', '296', '桐梓县');
INSERT INTO `area` VALUES ('2854', '296', '绥阳县');
INSERT INTO `area` VALUES ('2855', '296', '正安县');
INSERT INTO `area` VALUES ('2856', '296', '道真仡佬族苗族自治县');
INSERT INTO `area` VALUES ('2857', '296', '务川仡佬族苗族自治县');
INSERT INTO `area` VALUES ('2858', '296', '凤冈县');
INSERT INTO `area` VALUES ('2859', '296', '湄潭县');
INSERT INTO `area` VALUES ('2860', '296', '余庆县');
INSERT INTO `area` VALUES ('2861', '296', '习水县');
INSERT INTO `area` VALUES ('2862', '296', '赤水市');
INSERT INTO `area` VALUES ('2863', '296', '仁怀市');
INSERT INTO `area` VALUES ('2864', '297', '市辖区');
INSERT INTO `area` VALUES ('2865', '297', '西秀区');
INSERT INTO `area` VALUES ('2866', '297', '平坝县');
INSERT INTO `area` VALUES ('2867', '297', '普定县');
INSERT INTO `area` VALUES ('2868', '297', '镇宁布依族苗族自治县');
INSERT INTO `area` VALUES ('2869', '297', '关岭布依族苗族自治县');
INSERT INTO `area` VALUES ('2870', '297', '紫云苗族布依族自治县');
INSERT INTO `area` VALUES ('2871', '298', '铜仁市');
INSERT INTO `area` VALUES ('2872', '298', '江口县');
INSERT INTO `area` VALUES ('2873', '298', '玉屏侗族自治县');
INSERT INTO `area` VALUES ('2874', '298', '石阡县');
INSERT INTO `area` VALUES ('2875', '298', '思南县');
INSERT INTO `area` VALUES ('2876', '298', '印江土家族苗族自治县');
INSERT INTO `area` VALUES ('2877', '298', '德江县');
INSERT INTO `area` VALUES ('2878', '298', '沿河土家族自治县');
INSERT INTO `area` VALUES ('2879', '298', '松桃苗族自治县');
INSERT INTO `area` VALUES ('2880', '298', '万山特区');
INSERT INTO `area` VALUES ('2881', '299', '兴义市');
INSERT INTO `area` VALUES ('2882', '299', '兴仁县');
INSERT INTO `area` VALUES ('2883', '299', '普安县');
INSERT INTO `area` VALUES ('2884', '299', '晴隆县');
INSERT INTO `area` VALUES ('2885', '299', '贞丰县');
INSERT INTO `area` VALUES ('2886', '299', '望谟县');
INSERT INTO `area` VALUES ('2887', '299', '册亨县');
INSERT INTO `area` VALUES ('2888', '299', '安龙县');
INSERT INTO `area` VALUES ('2889', '300', '毕节市');
INSERT INTO `area` VALUES ('2890', '300', '大方县');
INSERT INTO `area` VALUES ('2891', '300', '黔西县');
INSERT INTO `area` VALUES ('2892', '300', '金沙县');
INSERT INTO `area` VALUES ('2893', '300', '织金县');
INSERT INTO `area` VALUES ('2894', '300', '纳雍县');
INSERT INTO `area` VALUES ('2895', '300', '威宁彝族回族苗族自治县');
INSERT INTO `area` VALUES ('2896', '300', '赫章县');
INSERT INTO `area` VALUES ('2897', '301', '凯里市');
INSERT INTO `area` VALUES ('2898', '301', '黄平县');
INSERT INTO `area` VALUES ('2899', '301', '施秉县');
INSERT INTO `area` VALUES ('2900', '301', '三穗县');
INSERT INTO `area` VALUES ('2901', '301', '镇远县');
INSERT INTO `area` VALUES ('2902', '301', '岑巩县');
INSERT INTO `area` VALUES ('2903', '301', '天柱县');
INSERT INTO `area` VALUES ('2904', '301', '锦屏县');
INSERT INTO `area` VALUES ('2905', '301', '剑河县');
INSERT INTO `area` VALUES ('2906', '301', '台江县');
INSERT INTO `area` VALUES ('2907', '301', '黎平县');
INSERT INTO `area` VALUES ('2908', '301', '榕江县');
INSERT INTO `area` VALUES ('2909', '301', '从江县');
INSERT INTO `area` VALUES ('2910', '301', '雷山县');
INSERT INTO `area` VALUES ('2911', '301', '麻江县');
INSERT INTO `area` VALUES ('2912', '301', '丹寨县');
INSERT INTO `area` VALUES ('2913', '302', '都匀市');
INSERT INTO `area` VALUES ('2914', '302', '福泉市');
INSERT INTO `area` VALUES ('2915', '302', '荔波县');
INSERT INTO `area` VALUES ('2916', '302', '贵定县');
INSERT INTO `area` VALUES ('2917', '302', '瓮安县');
INSERT INTO `area` VALUES ('2918', '302', '独山县');
INSERT INTO `area` VALUES ('2919', '302', '平塘县');
INSERT INTO `area` VALUES ('2920', '302', '罗甸县');
INSERT INTO `area` VALUES ('2921', '302', '长顺县');
INSERT INTO `area` VALUES ('2922', '302', '龙里县');
INSERT INTO `area` VALUES ('2923', '302', '惠水县');
INSERT INTO `area` VALUES ('2924', '302', '三都水族自治县');
INSERT INTO `area` VALUES ('2925', '303', '市辖区');
INSERT INTO `area` VALUES ('2926', '303', '五华区');
INSERT INTO `area` VALUES ('2927', '303', '盘龙区');
INSERT INTO `area` VALUES ('2928', '303', '官渡区');
INSERT INTO `area` VALUES ('2929', '303', '西山区');
INSERT INTO `area` VALUES ('2930', '303', '东川区');
INSERT INTO `area` VALUES ('2931', '303', '呈贡县');
INSERT INTO `area` VALUES ('2932', '303', '晋宁县');
INSERT INTO `area` VALUES ('2933', '303', '富民县');
INSERT INTO `area` VALUES ('2934', '303', '宜良县');
INSERT INTO `area` VALUES ('2935', '303', '石林彝族自治县');
INSERT INTO `area` VALUES ('2936', '303', '嵩明县');
INSERT INTO `area` VALUES ('2937', '303', '禄劝彝族苗族自治县');
INSERT INTO `area` VALUES ('2938', '303', '寻甸回族彝族自治县');
INSERT INTO `area` VALUES ('2939', '303', '安宁市');
INSERT INTO `area` VALUES ('2940', '304', '市辖区');
INSERT INTO `area` VALUES ('2941', '304', '麒麟区');
INSERT INTO `area` VALUES ('2942', '304', '马龙县');
INSERT INTO `area` VALUES ('2943', '304', '陆良县');
INSERT INTO `area` VALUES ('2944', '304', '师宗县');
INSERT INTO `area` VALUES ('2945', '304', '罗平县');
INSERT INTO `area` VALUES ('2946', '304', '富源县');
INSERT INTO `area` VALUES ('2947', '304', '会泽县');
INSERT INTO `area` VALUES ('2948', '304', '沾益县');
INSERT INTO `area` VALUES ('2949', '304', '宣威市');
INSERT INTO `area` VALUES ('2950', '305', '市辖区');
INSERT INTO `area` VALUES ('2951', '305', '红塔区');
INSERT INTO `area` VALUES ('2952', '305', '江川县');
INSERT INTO `area` VALUES ('2953', '305', '澄江县');
INSERT INTO `area` VALUES ('2954', '305', '通海县');
INSERT INTO `area` VALUES ('2955', '305', '华宁县');
INSERT INTO `area` VALUES ('2956', '305', '易门县');
INSERT INTO `area` VALUES ('2957', '305', '峨山彝族自治县');
INSERT INTO `area` VALUES ('2958', '305', '新平彝族傣族自治县');
INSERT INTO `area` VALUES ('2959', '305', '元江哈尼族彝族傣族自治县');
INSERT INTO `area` VALUES ('2960', '306', '市辖区');
INSERT INTO `area` VALUES ('2961', '306', '隆阳区');
INSERT INTO `area` VALUES ('2962', '306', '施甸县');
INSERT INTO `area` VALUES ('2963', '306', '腾冲县');
INSERT INTO `area` VALUES ('2964', '306', '龙陵县');
INSERT INTO `area` VALUES ('2965', '306', '昌宁县');
INSERT INTO `area` VALUES ('2966', '307', '市辖区');
INSERT INTO `area` VALUES ('2967', '307', '昭阳区');
INSERT INTO `area` VALUES ('2968', '307', '鲁甸县');
INSERT INTO `area` VALUES ('2969', '307', '巧家县');
INSERT INTO `area` VALUES ('2970', '307', '盐津县');
INSERT INTO `area` VALUES ('2971', '307', '大关县');
INSERT INTO `area` VALUES ('2972', '307', '永善县');
INSERT INTO `area` VALUES ('2973', '307', '绥江县');
INSERT INTO `area` VALUES ('2974', '307', '镇雄县');
INSERT INTO `area` VALUES ('2975', '307', '彝良县');
INSERT INTO `area` VALUES ('2976', '307', '威信县');
INSERT INTO `area` VALUES ('2977', '307', '水富县');
INSERT INTO `area` VALUES ('2978', '308', '市辖区');
INSERT INTO `area` VALUES ('2979', '308', '古城区');
INSERT INTO `area` VALUES ('2980', '308', '玉龙纳西族自治县');
INSERT INTO `area` VALUES ('2981', '308', '永胜县');
INSERT INTO `area` VALUES ('2982', '308', '华坪县');
INSERT INTO `area` VALUES ('2983', '308', '宁蒗彝族自治县');
INSERT INTO `area` VALUES ('2984', '309', '市辖区');
INSERT INTO `area` VALUES ('2985', '309', '思茅区');
INSERT INTO `area` VALUES ('2986', '309', '宁洱哈尼族彝族自治县');
INSERT INTO `area` VALUES ('2987', '309', '墨江哈尼族自治县');
INSERT INTO `area` VALUES ('2988', '309', '景东彝族自治县');
INSERT INTO `area` VALUES ('2989', '309', '景谷傣族彝族自治县');
INSERT INTO `area` VALUES ('2990', '309', '镇沅彝族哈尼族拉祜族自治县');
INSERT INTO `area` VALUES ('2991', '309', '江城哈尼族彝族自治县');
INSERT INTO `area` VALUES ('2992', '309', '孟连傣族拉祜族佤族自治县');
INSERT INTO `area` VALUES ('2993', '309', '澜沧拉祜族自治县');
INSERT INTO `area` VALUES ('2994', '309', '西盟佤族自治县');
INSERT INTO `area` VALUES ('2995', '310', '市辖区');
INSERT INTO `area` VALUES ('2996', '310', '临翔区');
INSERT INTO `area` VALUES ('2997', '310', '凤庆县');
INSERT INTO `area` VALUES ('2998', '310', '云县');
INSERT INTO `area` VALUES ('2999', '310', '永德县');
INSERT INTO `area` VALUES ('3000', '310', '镇康县');
INSERT INTO `area` VALUES ('3001', '310', '双江拉祜族佤族布朗族傣族自治县');
INSERT INTO `area` VALUES ('3002', '310', '耿马傣族佤族自治县');
INSERT INTO `area` VALUES ('3003', '310', '沧源佤族自治县');
INSERT INTO `area` VALUES ('3004', '311', '楚雄市');
INSERT INTO `area` VALUES ('3005', '311', '双柏县');
INSERT INTO `area` VALUES ('3006', '311', '牟定县');
INSERT INTO `area` VALUES ('3007', '311', '南华县');
INSERT INTO `area` VALUES ('3008', '311', '姚安县');
INSERT INTO `area` VALUES ('3009', '311', '大姚县');
INSERT INTO `area` VALUES ('3010', '311', '永仁县');
INSERT INTO `area` VALUES ('3011', '311', '元谋县');
INSERT INTO `area` VALUES ('3012', '311', '武定县');
INSERT INTO `area` VALUES ('3013', '311', '禄丰县');
INSERT INTO `area` VALUES ('3014', '312', '个旧市');
INSERT INTO `area` VALUES ('3015', '312', '开远市');
INSERT INTO `area` VALUES ('3016', '312', '蒙自市');
INSERT INTO `area` VALUES ('3017', '312', '屏边苗族自治县');
INSERT INTO `area` VALUES ('3018', '312', '建水县');
INSERT INTO `area` VALUES ('3019', '312', '石屏县');
INSERT INTO `area` VALUES ('3020', '312', '弥勒县');
INSERT INTO `area` VALUES ('3021', '312', '泸西县');
INSERT INTO `area` VALUES ('3022', '312', '元阳县');
INSERT INTO `area` VALUES ('3023', '312', '红河县');
INSERT INTO `area` VALUES ('3024', '312', '金平苗族瑶族傣族自治县');
INSERT INTO `area` VALUES ('3025', '312', '绿春县');
INSERT INTO `area` VALUES ('3026', '312', '河口瑶族自治县');
INSERT INTO `area` VALUES ('3027', '313', '文山县');
INSERT INTO `area` VALUES ('3028', '313', '砚山县');
INSERT INTO `area` VALUES ('3029', '313', '西畴县');
INSERT INTO `area` VALUES ('3030', '313', '麻栗坡县');
INSERT INTO `area` VALUES ('3031', '313', '马关县');
INSERT INTO `area` VALUES ('3032', '313', '丘北县');
INSERT INTO `area` VALUES ('3033', '313', '广南县');
INSERT INTO `area` VALUES ('3034', '313', '富宁县');
INSERT INTO `area` VALUES ('3035', '314', '景洪市');
INSERT INTO `area` VALUES ('3036', '314', '勐海县');
INSERT INTO `area` VALUES ('3037', '314', '勐腊县');
INSERT INTO `area` VALUES ('3038', '315', '大理市');
INSERT INTO `area` VALUES ('3039', '315', '漾濞彝族自治县');
INSERT INTO `area` VALUES ('3040', '315', '祥云县');
INSERT INTO `area` VALUES ('3041', '315', '宾川县');
INSERT INTO `area` VALUES ('3042', '315', '弥渡县');
INSERT INTO `area` VALUES ('3043', '315', '南涧彝族自治县');
INSERT INTO `area` VALUES ('3044', '315', '巍山彝族回族自治县');
INSERT INTO `area` VALUES ('3045', '315', '永平县');
INSERT INTO `area` VALUES ('3046', '315', '云龙县');
INSERT INTO `area` VALUES ('3047', '315', '洱源县');
INSERT INTO `area` VALUES ('3048', '315', '剑川县');
INSERT INTO `area` VALUES ('3049', '315', '鹤庆县');
INSERT INTO `area` VALUES ('3050', '316', '瑞丽市');
INSERT INTO `area` VALUES ('3051', '316', '芒市');
INSERT INTO `area` VALUES ('3052', '316', '梁河县');
INSERT INTO `area` VALUES ('3053', '316', '盈江县');
INSERT INTO `area` VALUES ('3054', '316', '陇川县');
INSERT INTO `area` VALUES ('3055', '317', '泸水县');
INSERT INTO `area` VALUES ('3056', '317', '福贡县');
INSERT INTO `area` VALUES ('3057', '317', '贡山独龙族怒族自治县');
INSERT INTO `area` VALUES ('3058', '317', '兰坪白族普米族自治县');
INSERT INTO `area` VALUES ('3059', '318', '香格里拉县');
INSERT INTO `area` VALUES ('3060', '318', '德钦县');
INSERT INTO `area` VALUES ('3061', '318', '维西傈僳族自治县');
INSERT INTO `area` VALUES ('3062', '319', '市辖区');
INSERT INTO `area` VALUES ('3063', '319', '城关区');
INSERT INTO `area` VALUES ('3064', '319', '林周县');
INSERT INTO `area` VALUES ('3065', '319', '当雄县');
INSERT INTO `area` VALUES ('3066', '319', '尼木县');
INSERT INTO `area` VALUES ('3067', '319', '曲水县');
INSERT INTO `area` VALUES ('3068', '319', '堆龙德庆县');
INSERT INTO `area` VALUES ('3069', '319', '达孜县');
INSERT INTO `area` VALUES ('3070', '319', '墨竹工卡县');
INSERT INTO `area` VALUES ('3071', '320', '昌都县');
INSERT INTO `area` VALUES ('3072', '320', '江达县');
INSERT INTO `area` VALUES ('3073', '320', '贡觉县');
INSERT INTO `area` VALUES ('3074', '320', '类乌齐县');
INSERT INTO `area` VALUES ('3075', '320', '丁青县');
INSERT INTO `area` VALUES ('3076', '320', '察雅县');
INSERT INTO `area` VALUES ('3077', '320', '八宿县');
INSERT INTO `area` VALUES ('3078', '320', '左贡县');
INSERT INTO `area` VALUES ('3079', '320', '芒康县');
INSERT INTO `area` VALUES ('3080', '320', '洛隆县');
INSERT INTO `area` VALUES ('3081', '320', '边坝县');
INSERT INTO `area` VALUES ('3082', '321', '乃东县');
INSERT INTO `area` VALUES ('3083', '321', '扎囊县');
INSERT INTO `area` VALUES ('3084', '321', '贡嘎县');
INSERT INTO `area` VALUES ('3085', '321', '桑日县');
INSERT INTO `area` VALUES ('3086', '321', '琼结县');
INSERT INTO `area` VALUES ('3087', '321', '曲松县');
INSERT INTO `area` VALUES ('3088', '321', '措美县');
INSERT INTO `area` VALUES ('3089', '321', '洛扎县');
INSERT INTO `area` VALUES ('3090', '321', '加查县');
INSERT INTO `area` VALUES ('3091', '321', '隆子县');
INSERT INTO `area` VALUES ('3092', '321', '错那县');
INSERT INTO `area` VALUES ('3093', '321', '浪卡子县');
INSERT INTO `area` VALUES ('3094', '322', '日喀则市');
INSERT INTO `area` VALUES ('3095', '322', '南木林县');
INSERT INTO `area` VALUES ('3096', '322', '江孜县');
INSERT INTO `area` VALUES ('3097', '322', '定日县');
INSERT INTO `area` VALUES ('3098', '322', '萨迦县');
INSERT INTO `area` VALUES ('3099', '322', '拉孜县');
INSERT INTO `area` VALUES ('3100', '322', '昂仁县');
INSERT INTO `area` VALUES ('3101', '322', '谢通门县');
INSERT INTO `area` VALUES ('3102', '322', '白朗县');
INSERT INTO `area` VALUES ('3103', '322', '仁布县');
INSERT INTO `area` VALUES ('3104', '322', '康马县');
INSERT INTO `area` VALUES ('3105', '322', '定结县');
INSERT INTO `area` VALUES ('3106', '322', '仲巴县');
INSERT INTO `area` VALUES ('3107', '322', '亚东县');
INSERT INTO `area` VALUES ('3108', '322', '吉隆县');
INSERT INTO `area` VALUES ('3109', '322', '聂拉木县');
INSERT INTO `area` VALUES ('3110', '322', '萨嘎县');
INSERT INTO `area` VALUES ('3111', '322', '岗巴县');
INSERT INTO `area` VALUES ('3112', '323', '那曲县');
INSERT INTO `area` VALUES ('3113', '323', '嘉黎县');
INSERT INTO `area` VALUES ('3114', '323', '比如县');
INSERT INTO `area` VALUES ('3115', '323', '聂荣县');
INSERT INTO `area` VALUES ('3116', '323', '安多县');
INSERT INTO `area` VALUES ('3117', '323', '申扎县');
INSERT INTO `area` VALUES ('3118', '323', '索县');
INSERT INTO `area` VALUES ('3119', '323', '班戈县');
INSERT INTO `area` VALUES ('3120', '323', '巴青县');
INSERT INTO `area` VALUES ('3121', '323', '尼玛县');
INSERT INTO `area` VALUES ('3122', '324', '普兰县');
INSERT INTO `area` VALUES ('3123', '324', '札达县');
INSERT INTO `area` VALUES ('3124', '324', '噶尔县');
INSERT INTO `area` VALUES ('3125', '324', '日土县');
INSERT INTO `area` VALUES ('3126', '324', '革吉县');
INSERT INTO `area` VALUES ('3127', '324', '改则县');
INSERT INTO `area` VALUES ('3128', '324', '措勤县');
INSERT INTO `area` VALUES ('3129', '325', '林芝县');
INSERT INTO `area` VALUES ('3130', '325', '工布江达县');
INSERT INTO `area` VALUES ('3131', '325', '米林县');
INSERT INTO `area` VALUES ('3132', '325', '墨脱县');
INSERT INTO `area` VALUES ('3133', '325', '波密县');
INSERT INTO `area` VALUES ('3134', '325', '察隅县');
INSERT INTO `area` VALUES ('3135', '325', '朗县');
INSERT INTO `area` VALUES ('3136', '326', '市辖区');
INSERT INTO `area` VALUES ('3137', '326', '新城区');
INSERT INTO `area` VALUES ('3138', '326', '碑林区');
INSERT INTO `area` VALUES ('3139', '326', '莲湖区');
INSERT INTO `area` VALUES ('3140', '326', '灞桥区');
INSERT INTO `area` VALUES ('3141', '326', '未央区');
INSERT INTO `area` VALUES ('3142', '326', '雁塔区');
INSERT INTO `area` VALUES ('3143', '326', '阎良区');
INSERT INTO `area` VALUES ('3144', '326', '临潼区');
INSERT INTO `area` VALUES ('3145', '326', '长安区');
INSERT INTO `area` VALUES ('3146', '326', '蓝田县');
INSERT INTO `area` VALUES ('3147', '326', '周至县');
INSERT INTO `area` VALUES ('3148', '326', '户县');
INSERT INTO `area` VALUES ('3149', '326', '高陵县');
INSERT INTO `area` VALUES ('3150', '327', '市辖区');
INSERT INTO `area` VALUES ('3151', '327', '王益区');
INSERT INTO `area` VALUES ('3152', '327', '印台区');
INSERT INTO `area` VALUES ('3153', '327', '耀州区');
INSERT INTO `area` VALUES ('3154', '327', '宜君县');
INSERT INTO `area` VALUES ('3155', '328', '市辖区');
INSERT INTO `area` VALUES ('3156', '328', '渭滨区');
INSERT INTO `area` VALUES ('3157', '328', '金台区');
INSERT INTO `area` VALUES ('3158', '328', '陈仓区');
INSERT INTO `area` VALUES ('3159', '328', '凤翔县');
INSERT INTO `area` VALUES ('3160', '328', '岐山县');
INSERT INTO `area` VALUES ('3161', '328', '扶风县');
INSERT INTO `area` VALUES ('3162', '328', '眉县');
INSERT INTO `area` VALUES ('3163', '328', '陇县');
INSERT INTO `area` VALUES ('3164', '328', '千阳县');
INSERT INTO `area` VALUES ('3165', '328', '麟游县');
INSERT INTO `area` VALUES ('3166', '328', '凤县');
INSERT INTO `area` VALUES ('3167', '328', '太白县');
INSERT INTO `area` VALUES ('3168', '329', '市辖区');
INSERT INTO `area` VALUES ('3169', '329', '秦都区');
INSERT INTO `area` VALUES ('3170', '329', '杨陵区');
INSERT INTO `area` VALUES ('3171', '329', '渭城区');
INSERT INTO `area` VALUES ('3172', '329', '三原县');
INSERT INTO `area` VALUES ('3173', '329', '泾阳县');
INSERT INTO `area` VALUES ('3174', '329', '乾县');
INSERT INTO `area` VALUES ('3175', '329', '礼泉县');
INSERT INTO `area` VALUES ('3176', '329', '永寿县');
INSERT INTO `area` VALUES ('3177', '329', '彬县');
INSERT INTO `area` VALUES ('3178', '329', '长武县');
INSERT INTO `area` VALUES ('3179', '329', '旬邑县');
INSERT INTO `area` VALUES ('3180', '329', '淳化县');
INSERT INTO `area` VALUES ('3181', '329', '武功县');
INSERT INTO `area` VALUES ('3182', '329', '兴平市');
INSERT INTO `area` VALUES ('3183', '330', '市辖区');
INSERT INTO `area` VALUES ('3184', '330', '临渭区');
INSERT INTO `area` VALUES ('3185', '330', '华县');
INSERT INTO `area` VALUES ('3186', '330', '潼关县');
INSERT INTO `area` VALUES ('3187', '330', '大荔县');
INSERT INTO `area` VALUES ('3188', '330', '合阳县');
INSERT INTO `area` VALUES ('3189', '330', '澄城县');
INSERT INTO `area` VALUES ('3190', '330', '蒲城县');
INSERT INTO `area` VALUES ('3191', '330', '白水县');
INSERT INTO `area` VALUES ('3192', '330', '富平县');
INSERT INTO `area` VALUES ('3193', '330', '韩城市');
INSERT INTO `area` VALUES ('3194', '330', '华阴市');
INSERT INTO `area` VALUES ('3195', '331', '市辖区');
INSERT INTO `area` VALUES ('3196', '331', '宝塔区');
INSERT INTO `area` VALUES ('3197', '331', '延长县');
INSERT INTO `area` VALUES ('3198', '331', '延川县');
INSERT INTO `area` VALUES ('3199', '331', '子长县');
INSERT INTO `area` VALUES ('3200', '331', '安塞县');
INSERT INTO `area` VALUES ('3201', '331', '志丹县');
INSERT INTO `area` VALUES ('3202', '331', '吴起县');
INSERT INTO `area` VALUES ('3203', '331', '甘泉县');
INSERT INTO `area` VALUES ('3204', '331', '富县');
INSERT INTO `area` VALUES ('3205', '331', '洛川县');
INSERT INTO `area` VALUES ('3206', '331', '宜川县');
INSERT INTO `area` VALUES ('3207', '331', '黄龙县');
INSERT INTO `area` VALUES ('3208', '331', '黄陵县');
INSERT INTO `area` VALUES ('3209', '332', '市辖区');
INSERT INTO `area` VALUES ('3210', '332', '汉台区');
INSERT INTO `area` VALUES ('3211', '332', '南郑县');
INSERT INTO `area` VALUES ('3212', '332', '城固县');
INSERT INTO `area` VALUES ('3213', '332', '洋县');
INSERT INTO `area` VALUES ('3214', '332', '西乡县');
INSERT INTO `area` VALUES ('3215', '332', '勉县');
INSERT INTO `area` VALUES ('3216', '332', '宁强县');
INSERT INTO `area` VALUES ('3217', '332', '略阳县');
INSERT INTO `area` VALUES ('3218', '332', '镇巴县');
INSERT INTO `area` VALUES ('3219', '332', '留坝县');
INSERT INTO `area` VALUES ('3220', '332', '佛坪县');
INSERT INTO `area` VALUES ('3221', '333', '市辖区');
INSERT INTO `area` VALUES ('3222', '333', '榆阳区');
INSERT INTO `area` VALUES ('3223', '333', '神木县');
INSERT INTO `area` VALUES ('3224', '333', '府谷县');
INSERT INTO `area` VALUES ('3225', '333', '横山县');
INSERT INTO `area` VALUES ('3226', '333', '靖边县');
INSERT INTO `area` VALUES ('3227', '333', '定边县');
INSERT INTO `area` VALUES ('3228', '333', '绥德县');
INSERT INTO `area` VALUES ('3229', '333', '米脂县');
INSERT INTO `area` VALUES ('3230', '333', '佳县');
INSERT INTO `area` VALUES ('3231', '333', '吴堡县');
INSERT INTO `area` VALUES ('3232', '333', '清涧县');
INSERT INTO `area` VALUES ('3233', '333', '子洲县');
INSERT INTO `area` VALUES ('3234', '334', '市辖区');
INSERT INTO `area` VALUES ('3235', '334', '汉滨区');
INSERT INTO `area` VALUES ('3236', '334', '汉阴县');
INSERT INTO `area` VALUES ('3237', '334', '石泉县');
INSERT INTO `area` VALUES ('3238', '334', '宁陕县');
INSERT INTO `area` VALUES ('3239', '334', '紫阳县');
INSERT INTO `area` VALUES ('3240', '334', '岚皋县');
INSERT INTO `area` VALUES ('3241', '334', '平利县');
INSERT INTO `area` VALUES ('3242', '334', '镇坪县');
INSERT INTO `area` VALUES ('3243', '334', '旬阳县');
INSERT INTO `area` VALUES ('3244', '334', '白河县');
INSERT INTO `area` VALUES ('3245', '335', '市辖区');
INSERT INTO `area` VALUES ('3246', '335', '商州区');
INSERT INTO `area` VALUES ('3247', '335', '洛南县');
INSERT INTO `area` VALUES ('3248', '335', '丹凤县');
INSERT INTO `area` VALUES ('3249', '335', '商南县');
INSERT INTO `area` VALUES ('3250', '335', '山阳县');
INSERT INTO `area` VALUES ('3251', '335', '镇安县');
INSERT INTO `area` VALUES ('3252', '335', '柞水县');
INSERT INTO `area` VALUES ('3253', '336', '市辖区');
INSERT INTO `area` VALUES ('3254', '336', '城关区');
INSERT INTO `area` VALUES ('3255', '336', '七里河区');
INSERT INTO `area` VALUES ('3256', '336', '西固区');
INSERT INTO `area` VALUES ('3257', '336', '安宁区');
INSERT INTO `area` VALUES ('3258', '336', '红古区');
INSERT INTO `area` VALUES ('3259', '336', '永登县');
INSERT INTO `area` VALUES ('3260', '336', '皋兰县');
INSERT INTO `area` VALUES ('3261', '336', '榆中县');
INSERT INTO `area` VALUES ('3262', '337', '市辖区');
INSERT INTO `area` VALUES ('3263', '338', '市辖区');
INSERT INTO `area` VALUES ('3264', '338', '金川区');
INSERT INTO `area` VALUES ('3265', '338', '永昌县');
INSERT INTO `area` VALUES ('3266', '339', '市辖区');
INSERT INTO `area` VALUES ('3267', '339', '白银区');
INSERT INTO `area` VALUES ('3268', '339', '平川区');
INSERT INTO `area` VALUES ('3269', '339', '靖远县');
INSERT INTO `area` VALUES ('3270', '339', '会宁县');
INSERT INTO `area` VALUES ('3271', '339', '景泰县');
INSERT INTO `area` VALUES ('3272', '340', '市辖区');
INSERT INTO `area` VALUES ('3274', '340', '秦州区');
INSERT INTO `area` VALUES ('3275', '340', '清水县');
INSERT INTO `area` VALUES ('3276', '340', '秦安县');
INSERT INTO `area` VALUES ('3277', '340', '甘谷县');
INSERT INTO `area` VALUES ('3278', '340', '武山县');
INSERT INTO `area` VALUES ('3279', '340', '张家川回族自治县');
INSERT INTO `area` VALUES ('3280', '341', '市辖区');
INSERT INTO `area` VALUES ('3281', '341', '凉州区');
INSERT INTO `area` VALUES ('3282', '341', '民勤县');
INSERT INTO `area` VALUES ('3283', '341', '古浪县');
INSERT INTO `area` VALUES ('3284', '341', '天祝藏族自治县');
INSERT INTO `area` VALUES ('3285', '342', '市辖区');
INSERT INTO `area` VALUES ('3286', '342', '甘州区');
INSERT INTO `area` VALUES ('3287', '342', '肃南裕固族自治县');
INSERT INTO `area` VALUES ('3288', '342', '民乐县');
INSERT INTO `area` VALUES ('3289', '342', '临泽县');
INSERT INTO `area` VALUES ('3290', '342', '高台县');
INSERT INTO `area` VALUES ('3291', '342', '山丹县');
INSERT INTO `area` VALUES ('3292', '343', '市辖区');
INSERT INTO `area` VALUES ('3293', '343', '崆峒区');
INSERT INTO `area` VALUES ('3294', '343', '泾川县');
INSERT INTO `area` VALUES ('3295', '343', '灵台县');
INSERT INTO `area` VALUES ('3296', '343', '崇信县');
INSERT INTO `area` VALUES ('3297', '343', '华亭县');
INSERT INTO `area` VALUES ('3298', '343', '庄浪县');
INSERT INTO `area` VALUES ('3299', '343', '静宁县');
INSERT INTO `area` VALUES ('3300', '344', '市辖区');
INSERT INTO `area` VALUES ('3301', '344', '肃州区');
INSERT INTO `area` VALUES ('3302', '344', '金塔县');
INSERT INTO `area` VALUES ('3304', '344', '肃北蒙古族自治县');
INSERT INTO `area` VALUES ('3305', '344', '阿克塞哈萨克族自治县');
INSERT INTO `area` VALUES ('3306', '344', '玉门市');
INSERT INTO `area` VALUES ('3307', '344', '敦煌市');
INSERT INTO `area` VALUES ('3308', '345', '市辖区');
INSERT INTO `area` VALUES ('3309', '345', '西峰区');
INSERT INTO `area` VALUES ('3310', '345', '庆城县');
INSERT INTO `area` VALUES ('3311', '345', '环县');
INSERT INTO `area` VALUES ('3312', '345', '华池县');
INSERT INTO `area` VALUES ('3313', '345', '合水县');
INSERT INTO `area` VALUES ('3314', '345', '正宁县');
INSERT INTO `area` VALUES ('3315', '345', '宁县');
INSERT INTO `area` VALUES ('3316', '345', '镇原县');
INSERT INTO `area` VALUES ('3317', '346', '市辖区');
INSERT INTO `area` VALUES ('3318', '346', '安定区');
INSERT INTO `area` VALUES ('3319', '346', '通渭县');
INSERT INTO `area` VALUES ('3320', '346', '陇西县');
INSERT INTO `area` VALUES ('3321', '346', '渭源县');
INSERT INTO `area` VALUES ('3322', '346', '临洮县');
INSERT INTO `area` VALUES ('3323', '346', '漳县');
INSERT INTO `area` VALUES ('3324', '346', '岷县');
INSERT INTO `area` VALUES ('3325', '347', '市辖区');
INSERT INTO `area` VALUES ('3326', '347', '武都区');
INSERT INTO `area` VALUES ('3327', '347', '成县');
INSERT INTO `area` VALUES ('3328', '347', '文县');
INSERT INTO `area` VALUES ('3329', '347', '宕昌县');
INSERT INTO `area` VALUES ('3330', '347', '康县');
INSERT INTO `area` VALUES ('3331', '347', '西和县');
INSERT INTO `area` VALUES ('3332', '347', '礼县');
INSERT INTO `area` VALUES ('3333', '347', '徽县');
INSERT INTO `area` VALUES ('3334', '347', '两当县');
INSERT INTO `area` VALUES ('3335', '348', '临夏市');
INSERT INTO `area` VALUES ('3336', '348', '临夏县');
INSERT INTO `area` VALUES ('3337', '348', '康乐县');
INSERT INTO `area` VALUES ('3338', '348', '永靖县');
INSERT INTO `area` VALUES ('3339', '348', '广河县');
INSERT INTO `area` VALUES ('3340', '348', '和政县');
INSERT INTO `area` VALUES ('3341', '348', '东乡族自治县');
INSERT INTO `area` VALUES ('3342', '348', '积石山保安族东乡族撒拉族自治县');
INSERT INTO `area` VALUES ('3343', '349', '合作市');
INSERT INTO `area` VALUES ('3344', '349', '临潭县');
INSERT INTO `area` VALUES ('3345', '349', '卓尼县');
INSERT INTO `area` VALUES ('3346', '349', '舟曲县');
INSERT INTO `area` VALUES ('3347', '349', '迭部县');
INSERT INTO `area` VALUES ('3348', '349', '玛曲县');
INSERT INTO `area` VALUES ('3349', '349', '碌曲县');
INSERT INTO `area` VALUES ('3350', '349', '夏河县');
INSERT INTO `area` VALUES ('3351', '350', '市辖区');
INSERT INTO `area` VALUES ('3352', '350', '城东区');
INSERT INTO `area` VALUES ('3353', '350', '城中区');
INSERT INTO `area` VALUES ('3354', '350', '城西区');
INSERT INTO `area` VALUES ('3355', '350', '城北区');
INSERT INTO `area` VALUES ('3356', '350', '大通回族土族自治县');
INSERT INTO `area` VALUES ('3357', '350', '湟中县');
INSERT INTO `area` VALUES ('3358', '350', '湟源县');
INSERT INTO `area` VALUES ('3359', '351', '平安县');
INSERT INTO `area` VALUES ('3360', '351', '民和回族土族自治县');
INSERT INTO `area` VALUES ('3361', '351', '乐都县');
INSERT INTO `area` VALUES ('3362', '351', '互助土族自治县');
INSERT INTO `area` VALUES ('3363', '351', '化隆回族自治县');
INSERT INTO `area` VALUES ('3364', '351', '循化撒拉族自治县');
INSERT INTO `area` VALUES ('3365', '352', '门源回族自治县');
INSERT INTO `area` VALUES ('3366', '352', '祁连县');
INSERT INTO `area` VALUES ('3367', '352', '海晏县');
INSERT INTO `area` VALUES ('3368', '352', '刚察县');
INSERT INTO `area` VALUES ('3369', '353', '同仁县');
INSERT INTO `area` VALUES ('3370', '353', '尖扎县');
INSERT INTO `area` VALUES ('3371', '353', '泽库县');
INSERT INTO `area` VALUES ('3372', '353', '河南蒙古族自治县');
INSERT INTO `area` VALUES ('3373', '354', '共和县');
INSERT INTO `area` VALUES ('3374', '354', '同德县');
INSERT INTO `area` VALUES ('3375', '354', '贵德县');
INSERT INTO `area` VALUES ('3376', '354', '兴海县');
INSERT INTO `area` VALUES ('3377', '354', '贵南县');
INSERT INTO `area` VALUES ('3378', '355', '玛沁县');
INSERT INTO `area` VALUES ('3379', '355', '班玛县');
INSERT INTO `area` VALUES ('3380', '355', '甘德县');
INSERT INTO `area` VALUES ('3381', '355', '达日县');
INSERT INTO `area` VALUES ('3382', '355', '久治县');
INSERT INTO `area` VALUES ('3383', '355', '玛多县');
INSERT INTO `area` VALUES ('3384', '356', '玉树县');
INSERT INTO `area` VALUES ('3385', '356', '杂多县');
INSERT INTO `area` VALUES ('3386', '356', '称多县');
INSERT INTO `area` VALUES ('3387', '356', '治多县');
INSERT INTO `area` VALUES ('3388', '356', '囊谦县');
INSERT INTO `area` VALUES ('3389', '356', '曲麻莱县');
INSERT INTO `area` VALUES ('3390', '357', '格尔木市');
INSERT INTO `area` VALUES ('3391', '357', '德令哈市');
INSERT INTO `area` VALUES ('3392', '357', '乌兰县');
INSERT INTO `area` VALUES ('3393', '357', '都兰县');
INSERT INTO `area` VALUES ('3394', '357', '天峻县');
INSERT INTO `area` VALUES ('3395', '358', '市辖区');
INSERT INTO `area` VALUES ('3396', '358', '兴庆区');
INSERT INTO `area` VALUES ('3397', '358', '西夏区');
INSERT INTO `area` VALUES ('3398', '358', '金凤区');
INSERT INTO `area` VALUES ('3399', '358', '永宁县');
INSERT INTO `area` VALUES ('3400', '358', '贺兰县');
INSERT INTO `area` VALUES ('3401', '358', '灵武市');
INSERT INTO `area` VALUES ('3402', '359', '市辖区');
INSERT INTO `area` VALUES ('3403', '359', '大武口区');
INSERT INTO `area` VALUES ('3404', '359', '惠农区');
INSERT INTO `area` VALUES ('3405', '359', '平罗县');
INSERT INTO `area` VALUES ('3406', '360', '市辖区');
INSERT INTO `area` VALUES ('3407', '360', '利通区');
INSERT INTO `area` VALUES ('3408', '360', '盐池县');
INSERT INTO `area` VALUES ('3409', '360', '同心县');
INSERT INTO `area` VALUES ('3410', '360', '青铜峡市');
INSERT INTO `area` VALUES ('3411', '361', '市辖区');
INSERT INTO `area` VALUES ('3412', '361', '原州区');
INSERT INTO `area` VALUES ('3413', '361', '西吉县');
INSERT INTO `area` VALUES ('3414', '361', '隆德县');
INSERT INTO `area` VALUES ('3415', '361', '泾源县');
INSERT INTO `area` VALUES ('3416', '361', '彭阳县');
INSERT INTO `area` VALUES ('3417', '362', '市辖区');
INSERT INTO `area` VALUES ('3418', '362', '沙坡头区');
INSERT INTO `area` VALUES ('3419', '362', '中宁县');
INSERT INTO `area` VALUES ('3420', '362', '海原县');
INSERT INTO `area` VALUES ('3421', '363', '市辖区');
INSERT INTO `area` VALUES ('3422', '363', '天山区');
INSERT INTO `area` VALUES ('3423', '363', '沙依巴克区');
INSERT INTO `area` VALUES ('3424', '363', '新市区');
INSERT INTO `area` VALUES ('3425', '363', '水磨沟区');
INSERT INTO `area` VALUES ('3426', '363', '头屯河区');
INSERT INTO `area` VALUES ('3427', '363', '达坂城区');
INSERT INTO `area` VALUES ('3428', '363', '米东区');
INSERT INTO `area` VALUES ('3429', '363', '乌鲁木齐县');
INSERT INTO `area` VALUES ('3430', '364', '市辖区');
INSERT INTO `area` VALUES ('3431', '364', '独山子区');
INSERT INTO `area` VALUES ('3432', '364', '克拉玛依区');
INSERT INTO `area` VALUES ('3433', '364', '白碱滩区');
INSERT INTO `area` VALUES ('3434', '364', '乌尔禾区');
INSERT INTO `area` VALUES ('3435', '365', '吐鲁番市');
INSERT INTO `area` VALUES ('3436', '365', '鄯善县');
INSERT INTO `area` VALUES ('3437', '365', '托克逊县');
INSERT INTO `area` VALUES ('3438', '366', '哈密市');
INSERT INTO `area` VALUES ('3439', '366', '巴里坤哈萨克自治县');
INSERT INTO `area` VALUES ('3440', '366', '伊吾县');
INSERT INTO `area` VALUES ('3441', '367', '昌吉市');
INSERT INTO `area` VALUES ('3442', '367', '阜康市');
INSERT INTO `area` VALUES ('3444', '367', '呼图壁县');
INSERT INTO `area` VALUES ('3445', '367', '玛纳斯县');
INSERT INTO `area` VALUES ('3446', '367', '奇台县');
INSERT INTO `area` VALUES ('3447', '367', '吉木萨尔县');
INSERT INTO `area` VALUES ('3448', '367', '木垒哈萨克自治县');
INSERT INTO `area` VALUES ('3449', '368', '博乐市');
INSERT INTO `area` VALUES ('3450', '368', '精河县');
INSERT INTO `area` VALUES ('3451', '368', '温泉县');
INSERT INTO `area` VALUES ('3452', '369', '库尔勒市');
INSERT INTO `area` VALUES ('3453', '369', '轮台县');
INSERT INTO `area` VALUES ('3454', '369', '尉犁县');
INSERT INTO `area` VALUES ('3455', '369', '若羌县');
INSERT INTO `area` VALUES ('3456', '369', '且末县');
INSERT INTO `area` VALUES ('3457', '369', '焉耆回族自治县');
INSERT INTO `area` VALUES ('3458', '369', '和静县');
INSERT INTO `area` VALUES ('3459', '369', '和硕县');
INSERT INTO `area` VALUES ('3460', '369', '博湖县');
INSERT INTO `area` VALUES ('3461', '370', '阿克苏市');
INSERT INTO `area` VALUES ('3462', '370', '温宿县');
INSERT INTO `area` VALUES ('3463', '370', '库车县');
INSERT INTO `area` VALUES ('3464', '370', '沙雅县');
INSERT INTO `area` VALUES ('3465', '370', '新和县');
INSERT INTO `area` VALUES ('3466', '370', '拜城县');
INSERT INTO `area` VALUES ('3467', '370', '乌什县');
INSERT INTO `area` VALUES ('3468', '370', '阿瓦提县');
INSERT INTO `area` VALUES ('3469', '370', '柯坪县');
INSERT INTO `area` VALUES ('3470', '371', '阿图什市');
INSERT INTO `area` VALUES ('3471', '371', '阿克陶县');
INSERT INTO `area` VALUES ('3472', '371', '阿合奇县');
INSERT INTO `area` VALUES ('3473', '371', '乌恰县');
INSERT INTO `area` VALUES ('3474', '372', '喀什市');
INSERT INTO `area` VALUES ('3475', '372', '疏附县');
INSERT INTO `area` VALUES ('3476', '372', '疏勒县');
INSERT INTO `area` VALUES ('3477', '372', '英吉沙县');
INSERT INTO `area` VALUES ('3478', '372', '泽普县');
INSERT INTO `area` VALUES ('3479', '372', '莎车县');
INSERT INTO `area` VALUES ('3480', '372', '叶城县');
INSERT INTO `area` VALUES ('3481', '372', '麦盖提县');
INSERT INTO `area` VALUES ('3482', '372', '岳普湖县');
INSERT INTO `area` VALUES ('3483', '372', '伽师县');
INSERT INTO `area` VALUES ('3484', '372', '巴楚县');
INSERT INTO `area` VALUES ('3485', '372', '塔什库尔干塔吉克自治县');
INSERT INTO `area` VALUES ('3486', '373', '和田市');
INSERT INTO `area` VALUES ('3487', '373', '和田县');
INSERT INTO `area` VALUES ('3488', '373', '墨玉县');
INSERT INTO `area` VALUES ('3489', '373', '皮山县');
INSERT INTO `area` VALUES ('3490', '373', '洛浦县');
INSERT INTO `area` VALUES ('3491', '373', '策勒县');
INSERT INTO `area` VALUES ('3492', '373', '于田县');
INSERT INTO `area` VALUES ('3493', '373', '民丰县');
INSERT INTO `area` VALUES ('3494', '374', '伊宁市');
INSERT INTO `area` VALUES ('3495', '374', '奎屯市');
INSERT INTO `area` VALUES ('3496', '374', '伊宁县');
INSERT INTO `area` VALUES ('3497', '374', '察布查尔锡伯自治县');
INSERT INTO `area` VALUES ('3498', '374', '霍城县');
INSERT INTO `area` VALUES ('3499', '374', '巩留县');
INSERT INTO `area` VALUES ('3500', '374', '新源县');
INSERT INTO `area` VALUES ('3501', '374', '昭苏县');
INSERT INTO `area` VALUES ('3502', '374', '特克斯县');
INSERT INTO `area` VALUES ('3503', '374', '尼勒克县');
INSERT INTO `area` VALUES ('3504', '375', '塔城市');
INSERT INTO `area` VALUES ('3505', '375', '乌苏市');
INSERT INTO `area` VALUES ('3506', '375', '额敏县');
INSERT INTO `area` VALUES ('3507', '375', '沙湾县');
INSERT INTO `area` VALUES ('3508', '375', '托里县');
INSERT INTO `area` VALUES ('3509', '375', '裕民县');
INSERT INTO `area` VALUES ('3510', '375', '和布克赛尔蒙古自治县');
INSERT INTO `area` VALUES ('3511', '376', '阿勒泰市');
INSERT INTO `area` VALUES ('3512', '376', '布尔津县');
INSERT INTO `area` VALUES ('3513', '376', '富蕴县');
INSERT INTO `area` VALUES ('3514', '376', '福海县');
INSERT INTO `area` VALUES ('3515', '376', '哈巴河县');
INSERT INTO `area` VALUES ('3516', '376', '青河县');
INSERT INTO `area` VALUES ('3517', '376', '吉木乃县');
INSERT INTO `area` VALUES ('3518', '377', '石河子市');
INSERT INTO `area` VALUES ('3519', '377', '阿拉尔市');
INSERT INTO `area` VALUES ('3520', '377', '图木舒克市');
INSERT INTO `area` VALUES ('3521', '377', '五家渠市');
INSERT INTO `area` VALUES ('4000', '340', '麦积区');
INSERT INTO `area` VALUES ('4001', '270', '江津区');
INSERT INTO `area` VALUES ('4002', '270', '合川区');
INSERT INTO `area` VALUES ('4003', '270', '永川区');
INSERT INTO `area` VALUES ('4004', '270', '南川区');
INSERT INTO `area` VALUES ('4006', '134', '芜湖县');
INSERT INTO `area` VALUES ('4100', '106', '加格达奇区');
INSERT INTO `area` VALUES ('4101', '106', '松岭区');
INSERT INTO `area` VALUES ('4102', '106', '新林区');
INSERT INTO `area` VALUES ('4103', '106', '呼中区');
INSERT INTO `area` VALUES ('4200', '125', '南湖区');
INSERT INTO `area` VALUES ('4300', '162', '共青城市');
INSERT INTO `area` VALUES ('4400', '360', '红寺堡区');
INSERT INTO `area` VALUES ('4500', '344', '瓜州县');
INSERT INTO `area` VALUES ('4600', '215', '随县');
INSERT INTO `area` VALUES ('4700', '228', '零陵区');
INSERT INTO `area` VALUES ('4800', '263', '平桂管理区');
INSERT INTO `area` VALUES ('4900', '279', '利州区');
INSERT INTO `area` VALUES ('5000', '286', '华蓥市');

-- ----------------------------
-- Table structure for `caipiandianyuangong`
-- ----------------------------
DROP TABLE IF EXISTS `caipiandianyuangong`;
CREATE TABLE `caipiandianyuangong` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Cpzid` int(20) DEFAULT NULL COMMENT '彩票店编号',
  `Shoujihao` varchar(20) DEFAULT NULL COMMENT '手机号',
  `Mima` varchar(20) DEFAULT NULL COMMENT '密码',
  `Zhuangtai` int(1) DEFAULT NULL COMMENT '状态',
  `Chuangjianshijian` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `Sjid` int(20) DEFAULT NULL COMMENT '手机编号',
  `image` varchar(20) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `caipiandianyuangong_fk1` (`Cpzid`),
  KEY `caipiandianyuangong_fk2` (`Sjid`),
  CONSTRAINT `caipiandianyuangong_ibfk_1` FOREIGN KEY (`Sjid`) REFERENCES `shoujiduanxiaoxi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiandianyuangong
-- ----------------------------

-- ----------------------------
-- Table structure for `caipiaobiao`
-- ----------------------------
DROP TABLE IF EXISTS `caipiaobiao`;
CREATE TABLE `caipiaobiao` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '二级类型名',
  `Id_leixing` int(20) DEFAULT NULL COMMENT '一级类型',
  `status` int(3) DEFAULT NULL COMMENT '状态1禁用2启用',
  PRIMARY KEY (`id`),
  KEY `caipiaobiao_fk1` (`Id_leixing`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiaobiao
-- ----------------------------

-- ----------------------------
-- Table structure for `caipiaobiao_desc`
-- ----------------------------
DROP TABLE IF EXISTS `caipiaobiao_desc`;
CREATE TABLE `caipiaobiao_desc` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `parent_type` int(3) DEFAULT NULL COMMENT '彩票类型',
  `Price` double(20,0) DEFAULT NULL COMMENT '赔率',
  `Begintime` timestamp NULL DEFAULT NULL COMMENT '上架时间',
  `Endtime` timestamp NULL DEFAULT NULL COMMENT '下架时间',
  `Status` int(1) DEFAULT NULL COMMENT '彩票状态',
  `Kaijiangtime` timestamp NULL DEFAULT NULL COMMENT '开奖时间',
  `Jiangchi` double(11,0) DEFAULT NULL COMMENT '奖池',
  PRIMARY KEY (`id`),
  KEY `caipiaobiao_fk1` (`parent_type`),
  CONSTRAINT `caipiaobiao_desc_ibfk_1` FOREIGN KEY (`parent_type`) REFERENCES `caipiaobiao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiaobiao_desc
-- ----------------------------

-- ----------------------------
-- Table structure for `caipiaodian`
-- ----------------------------
DROP TABLE IF EXISTS `caipiaodian`;
CREATE TABLE `caipiaodian` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(11) DEFAULT NULL COMMENT '彩票站名字',
  `Isticai` int(1) DEFAULT NULL COMMENT '是否体彩',
  `Isfucai` int(1) DEFAULT NULL COMMENT '是否福彩',
  `Phone` varchar(20) DEFAULT NULL COMMENT '彩票站电话号码',
  `password` varchar(11) DEFAULT NULL COMMENT '密码',
  `Imgid` varchar(50) DEFAULT NULL COMMENT '头像',
  `Ketixian` double(20,0) DEFAULT NULL COMMENT '可提现金额',
  `Dongjie` double(20,0) DEFAULT NULL COMMENT '冻结金额',
  `Yitixian` double(20,3) DEFAULT NULL COMMENT '已提现',
  `Area` int(11) DEFAULT NULL COMMENT '区表id',
  `Address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `Jingdu` double(10,6) DEFAULT NULL COMMENT '经度',
  `Weidu` double(10,6) DEFAULT NULL COMMENT '纬度',
  `Begingtime` timestamp NULL DEFAULT NULL COMMENT '开始营业时间',
  `Endtime` timestamp NULL DEFAULT NULL COMMENT '结束营业时间',
  `Time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `Status` int(1) DEFAULT NULL COMMENT '彩票站状态\r\n0未审核\r\n1审核通过\r\n2审核未通过',
  PRIMARY KEY (`id`),
  KEY `caipiaodian_fk1` (`Area`),
  CONSTRAINT `caipiaodian_fk1` FOREIGN KEY (`Area`) REFERENCES `area` (`arId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiaodian
-- ----------------------------
INSERT INTO `caipiaodian` VALUES ('1', null, '0', '0', '15674133317', '123', null, null, null, null, '378', '湖南工大', null, null, null, null, '2018-06-17 20:12:17', null);

-- ----------------------------
-- Table structure for `caipiaodianshenqing`
-- ----------------------------
DROP TABLE IF EXISTS `caipiaodianshenqing`;
CREATE TABLE `caipiaodianshenqing` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `shoujihao` varchar(20) DEFAULT NULL COMMENT '手机号',
  `mima` varchar(20) DEFAULT NULL COMMENT '密码',
  `dianming` varchar(100) DEFAULT NULL COMMENT '店名',
  `qu` int(20) DEFAULT NULL COMMENT '区',
  `Xiangxidizhi` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `jingdu` double(20,6) DEFAULT NULL COMMENT '经度',
  `weidu` double(20,6) DEFAULT NULL COMMENT '纬度',
  `Yinyezhizhao` varchar(20) DEFAULT NULL COMMENT '营业执照编号',
  `Yinyezhizhaomingzi` varchar(20) DEFAULT NULL COMMENT '营业执照名字',
  `Zhenshixingming` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `Shenfenzhengbianhao` int(200) DEFAULT NULL COMMENT '身份证编号',
  `Zhenmian` varchar(20) DEFAULT NULL COMMENT '身份证正面',
  `fanmian` varchar(20) DEFAULT NULL COMMENT '身份证反面',
  `Bank` varchar(20) DEFAULT NULL COMMENT '开户银行',
  `xingming` varchar(100) DEFAULT NULL COMMENT '开户人',
  `Zhanghao` varchar(100) DEFAULT NULL COMMENT '账号',
  `isticai` tinyint(1) DEFAULT NULL COMMENT '1.	是否体彩',
  `Isfucai` tinyint(1) DEFAULT NULL COMMENT '是否福彩',
  `zhuangtai` int(1) DEFAULT NULL COMMENT '状态\r\n0未审核\r\n1已审核\r\n2已拒绝',
  `Jujueliyou` varchar(200) DEFAULT NULL COMMENT '拒绝理由',
  PRIMARY KEY (`id`),
  KEY `caipiaodianshenqing_fk1` (`qu`),
  CONSTRAINT `caipiaodianshenqing_fk1` FOREIGN KEY (`qu`) REFERENCES `area` (`arId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiaodianshenqing
-- ----------------------------
INSERT INTO `caipiaodianshenqing` VALUES ('1', '15674133317', '123', '马爷开的店', '378', '湖南工大', null, null, '123.jpg', '马日升', '马日升', '430321', '123.jpg', '123.jpg', '建设', '马日升', '*', '0', '0', '1', null);

-- ----------------------------
-- Table structure for `caipiao_leixing`
-- ----------------------------
DROP TABLE IF EXISTS `caipiao_leixing`;
CREATE TABLE `caipiao_leixing` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Mingcheng` varchar(50) NOT NULL COMMENT '名称',
  `Status` int(1) DEFAULT NULL COMMENT '状态\r\n1禁用\r\n2启用',
  PRIMARY KEY (`id`,`Mingcheng`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of caipiao_leixing
-- ----------------------------
INSERT INTO `caipiao_leixing` VALUES ('1', '六合彩', '0');
INSERT INTO `caipiao_leixing` VALUES ('3', '马爷', '1');
INSERT INTO `caipiao_leixing` VALUES ('4', '马爷1', '0');
INSERT INTO `caipiao_leixing` VALUES ('5', '1', '1');
INSERT INTO `caipiao_leixing` VALUES ('6', '2', '1');
INSERT INTO `caipiao_leixing` VALUES ('7', '3', '1');
INSERT INTO `caipiao_leixing` VALUES ('8', '4', '1');
INSERT INTO `caipiao_leixing` VALUES ('9', '5', '1');
INSERT INTO `caipiao_leixing` VALUES ('10', '唐', '1');

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `ctId` int(11) NOT NULL AUTO_INCREMENT COMMENT '市ID',
  `prId` int(11) NOT NULL COMMENT '省份ID',
  `ctName` varchar(32) NOT NULL COMMENT '市名称',
  `ctYunfei` double(12,2) DEFAULT NULL COMMENT '通用费用',
  `cityYunfei` double(15,3) DEFAULT NULL COMMENT '地区运费',
  PRIMARY KEY (`ctId`),
  KEY `prId` (`prId`),
  CONSTRAINT `city_fk` FOREIGN KEY (`prId`) REFERENCES `provice` (`prId`)
) ENGINE=InnoDB AUTO_INCREMENT=378 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 9216 kB; (`prId`) REFER `shuiguoshop/provice`(`';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('33', '2', '市辖区', '8.00', '10.000');
INSERT INTO `city` VALUES ('34', '2', '县', '8.00', '12.000');
INSERT INTO `city` VALUES ('35', '3', '市辖区', '8.00', null);
INSERT INTO `city` VALUES ('36', '3', '县', '8.00', null);
INSERT INTO `city` VALUES ('37', '4', '石家庄市', '8.00', null);
INSERT INTO `city` VALUES ('38', '4', '唐山市', '8.00', null);
INSERT INTO `city` VALUES ('39', '4', '秦皇岛市', '8.00', null);
INSERT INTO `city` VALUES ('40', '4', '邯郸市', '8.00', null);
INSERT INTO `city` VALUES ('41', '4', '邢台市', '8.00', null);
INSERT INTO `city` VALUES ('42', '4', '保定市', '8.00', null);
INSERT INTO `city` VALUES ('43', '4', '张家口市', '8.00', null);
INSERT INTO `city` VALUES ('44', '4', '承德市', '8.00', null);
INSERT INTO `city` VALUES ('45', '4', '沧州市', '8.00', null);
INSERT INTO `city` VALUES ('46', '4', '廊坊市', '8.00', null);
INSERT INTO `city` VALUES ('47', '4', '衡水市', '8.00', null);
INSERT INTO `city` VALUES ('48', '5', '太原市', '8.00', null);
INSERT INTO `city` VALUES ('49', '5', '大同市', '8.00', null);
INSERT INTO `city` VALUES ('50', '5', '阳泉市', '8.00', null);
INSERT INTO `city` VALUES ('51', '5', '长治市', '8.00', null);
INSERT INTO `city` VALUES ('52', '5', '晋城市', '8.00', null);
INSERT INTO `city` VALUES ('53', '5', '朔州市', '8.00', null);
INSERT INTO `city` VALUES ('54', '5', '晋中市', '8.00', null);
INSERT INTO `city` VALUES ('55', '5', '运城市', '8.00', null);
INSERT INTO `city` VALUES ('56', '5', '忻州市', '8.00', null);
INSERT INTO `city` VALUES ('57', '5', '临汾市', '8.00', null);
INSERT INTO `city` VALUES ('58', '5', '吕梁市', '8.00', null);
INSERT INTO `city` VALUES ('59', '6', '呼和浩特市', '8.00', null);
INSERT INTO `city` VALUES ('60', '6', '包头市', '8.00', null);
INSERT INTO `city` VALUES ('61', '6', '乌海市', '8.00', null);
INSERT INTO `city` VALUES ('62', '6', '赤峰市', '8.00', null);
INSERT INTO `city` VALUES ('63', '6', '通辽市', '8.00', null);
INSERT INTO `city` VALUES ('64', '6', '鄂尔多斯市', '8.00', null);
INSERT INTO `city` VALUES ('65', '6', '呼伦贝尔市', '8.00', null);
INSERT INTO `city` VALUES ('66', '6', '巴彦淖尔市', '8.00', null);
INSERT INTO `city` VALUES ('67', '6', '乌兰察布市', '8.00', null);
INSERT INTO `city` VALUES ('68', '6', '兴安盟', '8.00', null);
INSERT INTO `city` VALUES ('69', '6', '锡林郭勒盟', '8.00', null);
INSERT INTO `city` VALUES ('70', '6', '阿拉善盟', '8.00', null);
INSERT INTO `city` VALUES ('71', '7', '沈阳市', '8.00', null);
INSERT INTO `city` VALUES ('72', '7', '大连市', '8.00', null);
INSERT INTO `city` VALUES ('73', '7', '鞍山市', '8.00', null);
INSERT INTO `city` VALUES ('74', '7', '抚顺市', '8.00', null);
INSERT INTO `city` VALUES ('75', '7', '本溪市', '8.00', null);
INSERT INTO `city` VALUES ('76', '7', '丹东市', '8.00', null);
INSERT INTO `city` VALUES ('77', '7', '锦州市', '8.00', null);
INSERT INTO `city` VALUES ('78', '7', '营口市', '8.00', null);
INSERT INTO `city` VALUES ('79', '7', '阜新市', '8.00', null);
INSERT INTO `city` VALUES ('80', '7', '辽阳市', '8.00', null);
INSERT INTO `city` VALUES ('81', '7', '盘锦市', '8.00', null);
INSERT INTO `city` VALUES ('82', '7', '铁岭市', '8.00', null);
INSERT INTO `city` VALUES ('83', '7', '朝阳市', '8.00', null);
INSERT INTO `city` VALUES ('84', '7', '葫芦岛市', '8.00', null);
INSERT INTO `city` VALUES ('85', '8', '长春市', '8.00', null);
INSERT INTO `city` VALUES ('86', '8', '吉林市', '8.00', null);
INSERT INTO `city` VALUES ('87', '8', '四平市', '8.00', null);
INSERT INTO `city` VALUES ('88', '8', '辽源市', '8.00', null);
INSERT INTO `city` VALUES ('89', '8', '通化市', '8.00', null);
INSERT INTO `city` VALUES ('90', '8', '白山市', '8.00', null);
INSERT INTO `city` VALUES ('91', '8', '松原市', '8.00', null);
INSERT INTO `city` VALUES ('92', '8', '白城市', '8.00', null);
INSERT INTO `city` VALUES ('93', '8', '延边朝鲜族自治州', '8.00', null);
INSERT INTO `city` VALUES ('94', '9', '哈尔滨市', '8.00', null);
INSERT INTO `city` VALUES ('95', '9', '齐齐哈尔市', '8.00', null);
INSERT INTO `city` VALUES ('96', '9', '鸡西市', '8.00', null);
INSERT INTO `city` VALUES ('97', '9', '鹤岗市', '8.00', null);
INSERT INTO `city` VALUES ('98', '9', '双鸭山市', '8.00', null);
INSERT INTO `city` VALUES ('99', '9', '大庆市', '8.00', null);
INSERT INTO `city` VALUES ('100', '9', '伊春市', '8.00', null);
INSERT INTO `city` VALUES ('101', '9', '佳木斯市', '8.00', null);
INSERT INTO `city` VALUES ('102', '9', '七台河市', '8.00', null);
INSERT INTO `city` VALUES ('103', '9', '牡丹江市', '8.00', null);
INSERT INTO `city` VALUES ('104', '9', '黑河市', '8.00', null);
INSERT INTO `city` VALUES ('105', '9', '绥化市', '8.00', null);
INSERT INTO `city` VALUES ('106', '9', '大兴安岭地区', '8.00', null);
INSERT INTO `city` VALUES ('107', '10', '市辖区', '8.00', null);
INSERT INTO `city` VALUES ('108', '10', '县', '8.00', null);
INSERT INTO `city` VALUES ('109', '11', '南京市', '8.00', null);
INSERT INTO `city` VALUES ('110', '11', '无锡市', '8.00', null);
INSERT INTO `city` VALUES ('111', '11', '徐州市', '8.00', null);
INSERT INTO `city` VALUES ('112', '11', '常州市', '8.00', null);
INSERT INTO `city` VALUES ('113', '11', '苏州市', '8.00', null);
INSERT INTO `city` VALUES ('114', '11', '南通市', '8.00', null);
INSERT INTO `city` VALUES ('115', '11', '连云港市', '8.00', null);
INSERT INTO `city` VALUES ('116', '11', '淮安市', '8.00', null);
INSERT INTO `city` VALUES ('117', '11', '盐城市', '8.00', null);
INSERT INTO `city` VALUES ('118', '11', '扬州市', '8.00', null);
INSERT INTO `city` VALUES ('119', '11', '镇江市', '8.00', null);
INSERT INTO `city` VALUES ('120', '11', '泰州市', '8.00', null);
INSERT INTO `city` VALUES ('121', '11', '宿迁市', '8.00', null);
INSERT INTO `city` VALUES ('122', '12', '杭州市', '8.00', null);
INSERT INTO `city` VALUES ('123', '12', '宁波市', '8.00', null);
INSERT INTO `city` VALUES ('124', '12', '温州市', '8.00', null);
INSERT INTO `city` VALUES ('125', '12', '嘉兴市', '8.00', null);
INSERT INTO `city` VALUES ('126', '12', '湖州市', '8.00', null);
INSERT INTO `city` VALUES ('127', '12', '绍兴市', '8.00', null);
INSERT INTO `city` VALUES ('128', '12', '金华市', '8.00', null);
INSERT INTO `city` VALUES ('129', '12', '衢州市', '8.00', null);
INSERT INTO `city` VALUES ('130', '12', '舟山市', '8.00', null);
INSERT INTO `city` VALUES ('131', '12', '台州市', '8.00', null);
INSERT INTO `city` VALUES ('132', '12', '丽水市', '8.00', null);
INSERT INTO `city` VALUES ('133', '13', '合肥市', '8.00', null);
INSERT INTO `city` VALUES ('134', '13', '芜湖市', '8.00', null);
INSERT INTO `city` VALUES ('135', '13', '蚌埠市', '8.00', null);
INSERT INTO `city` VALUES ('136', '13', '淮南市', '8.00', null);
INSERT INTO `city` VALUES ('137', '13', '马鞍山市', '8.00', null);
INSERT INTO `city` VALUES ('138', '13', '淮北市', '8.00', null);
INSERT INTO `city` VALUES ('139', '13', '铜陵市', '8.00', null);
INSERT INTO `city` VALUES ('140', '13', '安庆市', '8.00', null);
INSERT INTO `city` VALUES ('141', '13', '黄山市', '8.00', null);
INSERT INTO `city` VALUES ('142', '13', '滁州市', '8.00', null);
INSERT INTO `city` VALUES ('143', '13', '阜阳市', '8.00', null);
INSERT INTO `city` VALUES ('144', '13', '宿州市', '8.00', null);
INSERT INTO `city` VALUES ('145', '13', '巢湖市', '8.00', null);
INSERT INTO `city` VALUES ('146', '13', '六安市', '8.00', null);
INSERT INTO `city` VALUES ('147', '13', '亳州市', '8.00', null);
INSERT INTO `city` VALUES ('148', '13', '池州市', '8.00', null);
INSERT INTO `city` VALUES ('149', '13', '宣城市', '8.00', null);
INSERT INTO `city` VALUES ('150', '14', '福州市', '8.00', null);
INSERT INTO `city` VALUES ('151', '14', '厦门市', '8.00', null);
INSERT INTO `city` VALUES ('152', '14', '莆田市', '8.00', null);
INSERT INTO `city` VALUES ('153', '14', '三明市', '8.00', null);
INSERT INTO `city` VALUES ('154', '14', '泉州市', '8.00', null);
INSERT INTO `city` VALUES ('155', '14', '漳州市', '8.00', null);
INSERT INTO `city` VALUES ('156', '14', '南平市', '8.00', null);
INSERT INTO `city` VALUES ('157', '14', '龙岩市', '8.00', null);
INSERT INTO `city` VALUES ('158', '14', '宁德市', '8.00', null);
INSERT INTO `city` VALUES ('159', '15', '南昌市', '8.00', null);
INSERT INTO `city` VALUES ('160', '15', '景德镇市', '8.00', null);
INSERT INTO `city` VALUES ('161', '15', '萍乡市', '8.00', null);
INSERT INTO `city` VALUES ('162', '15', '九江市', '8.00', null);
INSERT INTO `city` VALUES ('163', '15', '新余市', '8.00', null);
INSERT INTO `city` VALUES ('164', '15', '鹰潭市', '8.00', null);
INSERT INTO `city` VALUES ('165', '15', '赣州市', '8.00', null);
INSERT INTO `city` VALUES ('166', '15', '吉安市', '8.00', null);
INSERT INTO `city` VALUES ('167', '15', '宜春市', '8.00', null);
INSERT INTO `city` VALUES ('168', '15', '抚州市', '8.00', null);
INSERT INTO `city` VALUES ('169', '15', '上饶市', '8.00', null);
INSERT INTO `city` VALUES ('170', '16', '济南市', '8.00', null);
INSERT INTO `city` VALUES ('171', '16', '青岛市', '8.00', null);
INSERT INTO `city` VALUES ('172', '16', '淄博市', '8.00', null);
INSERT INTO `city` VALUES ('173', '16', '枣庄市', '8.00', null);
INSERT INTO `city` VALUES ('174', '16', '东营市', '8.00', null);
INSERT INTO `city` VALUES ('175', '16', '烟台市', '8.00', null);
INSERT INTO `city` VALUES ('176', '16', '潍坊市', '8.00', null);
INSERT INTO `city` VALUES ('177', '16', '济宁市', '8.00', null);
INSERT INTO `city` VALUES ('178', '16', '泰安市', '8.00', null);
INSERT INTO `city` VALUES ('179', '16', '威海市', '8.00', null);
INSERT INTO `city` VALUES ('180', '16', '日照市', '8.00', null);
INSERT INTO `city` VALUES ('181', '16', '莱芜市', '8.00', null);
INSERT INTO `city` VALUES ('182', '16', '临沂市', '8.00', null);
INSERT INTO `city` VALUES ('183', '16', '德州市', '8.00', null);
INSERT INTO `city` VALUES ('184', '16', '聊城市', '8.00', null);
INSERT INTO `city` VALUES ('185', '16', '滨州市', '8.00', null);
INSERT INTO `city` VALUES ('186', '16', '菏泽市', '8.00', null);
INSERT INTO `city` VALUES ('187', '17', '郑州市', '8.00', null);
INSERT INTO `city` VALUES ('188', '17', '开封市', '8.00', null);
INSERT INTO `city` VALUES ('189', '17', '洛阳市', '8.00', null);
INSERT INTO `city` VALUES ('190', '17', '平顶山市', '8.00', null);
INSERT INTO `city` VALUES ('191', '17', '安阳市', '8.00', null);
INSERT INTO `city` VALUES ('192', '17', '鹤壁市', '8.00', null);
INSERT INTO `city` VALUES ('193', '17', '新乡市', '8.00', null);
INSERT INTO `city` VALUES ('194', '17', '焦作市', '8.00', null);
INSERT INTO `city` VALUES ('195', '17', '濮阳市', '8.00', null);
INSERT INTO `city` VALUES ('196', '17', '许昌市', '8.00', null);
INSERT INTO `city` VALUES ('197', '17', '漯河市', '8.00', null);
INSERT INTO `city` VALUES ('198', '17', '三门峡市', '8.00', null);
INSERT INTO `city` VALUES ('199', '17', '南阳市', '8.00', null);
INSERT INTO `city` VALUES ('200', '17', '商丘市', '8.00', null);
INSERT INTO `city` VALUES ('201', '17', '信阳市', '8.00', null);
INSERT INTO `city` VALUES ('202', '17', '周口市', '8.00', null);
INSERT INTO `city` VALUES ('203', '17', '驻马店市', '8.00', null);
INSERT INTO `city` VALUES ('204', '18', '武汉市', '8.00', null);
INSERT INTO `city` VALUES ('205', '18', '黄石市', '8.00', null);
INSERT INTO `city` VALUES ('206', '18', '十堰市', '8.00', null);
INSERT INTO `city` VALUES ('207', '18', '宜昌市', '8.00', null);
INSERT INTO `city` VALUES ('208', '18', '襄樊市', '8.00', null);
INSERT INTO `city` VALUES ('209', '18', '鄂州市', '8.00', null);
INSERT INTO `city` VALUES ('210', '18', '荆门市', '8.00', null);
INSERT INTO `city` VALUES ('211', '18', '孝感市', '8.00', null);
INSERT INTO `city` VALUES ('212', '18', '荆州市', '8.00', null);
INSERT INTO `city` VALUES ('213', '18', '黄冈市', '8.00', null);
INSERT INTO `city` VALUES ('214', '18', '咸宁市', '8.00', null);
INSERT INTO `city` VALUES ('215', '18', '随州市', '8.00', null);
INSERT INTO `city` VALUES ('216', '18', '恩施土家族苗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('217', '18', '省直辖县级行政区划', '8.00', null);
INSERT INTO `city` VALUES ('218', '19', '长沙市', '8.00', '12.000');
INSERT INTO `city` VALUES ('219', '19', '株洲市', '8.00', '8.000');
INSERT INTO `city` VALUES ('220', '19', '湘潭市', '8.00', '15.000');
INSERT INTO `city` VALUES ('221', '19', '衡阳市', '8.00', null);
INSERT INTO `city` VALUES ('222', '19', '邵阳市', '8.00', null);
INSERT INTO `city` VALUES ('223', '19', '岳阳市', '8.00', null);
INSERT INTO `city` VALUES ('224', '19', '常德市', '8.00', null);
INSERT INTO `city` VALUES ('225', '19', '张家界市', '8.00', null);
INSERT INTO `city` VALUES ('226', '19', '益阳市', '8.00', null);
INSERT INTO `city` VALUES ('227', '19', '郴州市', '8.00', null);
INSERT INTO `city` VALUES ('228', '19', '永州市', '8.00', null);
INSERT INTO `city` VALUES ('229', '19', '怀化市', '8.00', null);
INSERT INTO `city` VALUES ('230', '19', '娄底市', '8.00', null);
INSERT INTO `city` VALUES ('231', '19', '湘西土家族苗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('232', '20', '广州市', '8.00', null);
INSERT INTO `city` VALUES ('233', '20', '韶关市', '8.00', null);
INSERT INTO `city` VALUES ('234', '20', '深圳市', '8.00', null);
INSERT INTO `city` VALUES ('235', '20', '珠海市', '8.00', null);
INSERT INTO `city` VALUES ('236', '20', '汕头市', '8.00', null);
INSERT INTO `city` VALUES ('237', '20', '佛山市', '8.00', null);
INSERT INTO `city` VALUES ('238', '20', '江门市', '8.00', null);
INSERT INTO `city` VALUES ('239', '20', '湛江市', '8.00', null);
INSERT INTO `city` VALUES ('240', '20', '茂名市', '8.00', null);
INSERT INTO `city` VALUES ('241', '20', '肇庆市', '8.00', null);
INSERT INTO `city` VALUES ('242', '20', '惠州市', '8.00', null);
INSERT INTO `city` VALUES ('243', '20', '梅州市', '8.00', null);
INSERT INTO `city` VALUES ('244', '20', '汕尾市', '8.00', null);
INSERT INTO `city` VALUES ('245', '20', '河源市', '8.00', null);
INSERT INTO `city` VALUES ('246', '20', '阳江市', '8.00', null);
INSERT INTO `city` VALUES ('247', '20', '清远市', '8.00', null);
INSERT INTO `city` VALUES ('248', '20', '东莞市', '8.00', null);
INSERT INTO `city` VALUES ('249', '20', '中山市', '8.00', null);
INSERT INTO `city` VALUES ('250', '20', '潮州市', '8.00', null);
INSERT INTO `city` VALUES ('251', '20', '揭阳市', '8.00', null);
INSERT INTO `city` VALUES ('252', '20', '云浮市', '8.00', null);
INSERT INTO `city` VALUES ('253', '21', '南宁市', '8.00', null);
INSERT INTO `city` VALUES ('254', '21', '柳州市', '8.00', null);
INSERT INTO `city` VALUES ('255', '21', '桂林市', '8.00', null);
INSERT INTO `city` VALUES ('256', '21', '梧州市', '8.00', null);
INSERT INTO `city` VALUES ('257', '21', '北海市', '8.00', null);
INSERT INTO `city` VALUES ('258', '21', '防城港市', '8.00', null);
INSERT INTO `city` VALUES ('259', '21', '钦州市', '8.00', null);
INSERT INTO `city` VALUES ('260', '21', '贵港市', '8.00', null);
INSERT INTO `city` VALUES ('261', '21', '玉林市', '8.00', null);
INSERT INTO `city` VALUES ('262', '21', '百色市', '8.00', null);
INSERT INTO `city` VALUES ('263', '21', '贺州市', '8.00', null);
INSERT INTO `city` VALUES ('264', '21', '河池市', '8.00', null);
INSERT INTO `city` VALUES ('265', '21', '来宾市', '8.00', null);
INSERT INTO `city` VALUES ('266', '21', '崇左市', '8.00', null);
INSERT INTO `city` VALUES ('267', '22', '海口市', '8.00', null);
INSERT INTO `city` VALUES ('268', '22', '三亚市', '8.00', null);
INSERT INTO `city` VALUES ('269', '22', '省直辖县级行政区划', '8.00', null);
INSERT INTO `city` VALUES ('270', '23', '市辖区', '8.00', null);
INSERT INTO `city` VALUES ('271', '23', '县', '8.00', null);
INSERT INTO `city` VALUES ('273', '24', '成都市', '8.00', null);
INSERT INTO `city` VALUES ('274', '24', '自贡市', '8.00', null);
INSERT INTO `city` VALUES ('275', '24', '攀枝花市', '8.00', null);
INSERT INTO `city` VALUES ('276', '24', '泸州市', '8.00', null);
INSERT INTO `city` VALUES ('277', '24', '德阳市', '8.00', null);
INSERT INTO `city` VALUES ('278', '24', '绵阳市', '8.00', null);
INSERT INTO `city` VALUES ('279', '24', '广元市', '8.00', null);
INSERT INTO `city` VALUES ('280', '24', '遂宁市', '8.00', null);
INSERT INTO `city` VALUES ('281', '24', '内江市', '8.00', null);
INSERT INTO `city` VALUES ('282', '24', '乐山市', '8.00', null);
INSERT INTO `city` VALUES ('283', '24', '南充市', '8.00', null);
INSERT INTO `city` VALUES ('284', '24', '眉山市', '8.00', null);
INSERT INTO `city` VALUES ('285', '24', '宜宾市', '8.00', null);
INSERT INTO `city` VALUES ('286', '24', '广安市', '8.00', null);
INSERT INTO `city` VALUES ('287', '24', '达州市', '8.00', null);
INSERT INTO `city` VALUES ('288', '24', '雅安市', '8.00', null);
INSERT INTO `city` VALUES ('289', '24', '巴中市', '8.00', null);
INSERT INTO `city` VALUES ('290', '24', '资阳市', '8.00', null);
INSERT INTO `city` VALUES ('291', '24', '阿坝藏族羌族自治州', '8.00', null);
INSERT INTO `city` VALUES ('292', '24', '甘孜藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('293', '24', '凉山彝族自治州', '8.00', null);
INSERT INTO `city` VALUES ('294', '25', '贵阳市', '8.00', null);
INSERT INTO `city` VALUES ('295', '25', '六盘水市', '8.00', null);
INSERT INTO `city` VALUES ('296', '25', '遵义市', '8.00', null);
INSERT INTO `city` VALUES ('297', '25', '安顺市', '8.00', null);
INSERT INTO `city` VALUES ('298', '25', '铜仁地区', '8.00', null);
INSERT INTO `city` VALUES ('299', '25', '黔西南布依族苗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('300', '25', '毕节地区', '8.00', null);
INSERT INTO `city` VALUES ('301', '25', '黔东南苗族侗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('302', '25', '黔南布依族苗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('303', '26', '昆明市', '8.00', null);
INSERT INTO `city` VALUES ('304', '26', '曲靖市', '8.00', null);
INSERT INTO `city` VALUES ('305', '26', '玉溪市', '8.00', null);
INSERT INTO `city` VALUES ('306', '26', '保山市', '8.00', null);
INSERT INTO `city` VALUES ('307', '26', '昭通市', '8.00', null);
INSERT INTO `city` VALUES ('308', '26', '丽江市', '8.00', null);
INSERT INTO `city` VALUES ('309', '26', '普洱市', '8.00', null);
INSERT INTO `city` VALUES ('310', '26', '临沧市', '8.00', null);
INSERT INTO `city` VALUES ('311', '26', '楚雄彝族自治州', '8.00', null);
INSERT INTO `city` VALUES ('312', '26', '红河哈尼族彝族自治州', '8.00', null);
INSERT INTO `city` VALUES ('313', '26', '文山壮族苗族自治州', '8.00', null);
INSERT INTO `city` VALUES ('314', '26', '西双版纳傣族自治州', '8.00', null);
INSERT INTO `city` VALUES ('315', '26', '大理白族自治州', '8.00', null);
INSERT INTO `city` VALUES ('316', '26', '德宏傣族景颇族自治州', '8.00', null);
INSERT INTO `city` VALUES ('317', '26', '怒江傈僳族自治州', '8.00', null);
INSERT INTO `city` VALUES ('318', '26', '迪庆藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('319', '27', '拉萨市', '8.00', null);
INSERT INTO `city` VALUES ('320', '27', '昌都地区', '8.00', null);
INSERT INTO `city` VALUES ('321', '27', '山南地区', '8.00', null);
INSERT INTO `city` VALUES ('322', '27', '日喀则地区', '8.00', null);
INSERT INTO `city` VALUES ('323', '27', '那曲地区', '8.00', null);
INSERT INTO `city` VALUES ('324', '27', '阿里地区', '8.00', null);
INSERT INTO `city` VALUES ('325', '27', '林芝地区', '8.00', null);
INSERT INTO `city` VALUES ('326', '28', '西安市', '8.00', null);
INSERT INTO `city` VALUES ('327', '28', '铜川市', '8.00', null);
INSERT INTO `city` VALUES ('328', '28', '宝鸡市', '8.00', null);
INSERT INTO `city` VALUES ('329', '28', '咸阳市', '8.00', null);
INSERT INTO `city` VALUES ('330', '28', '渭南市', '8.00', null);
INSERT INTO `city` VALUES ('331', '28', '延安市', '8.00', null);
INSERT INTO `city` VALUES ('332', '28', '汉中市', '8.00', null);
INSERT INTO `city` VALUES ('333', '28', '榆林市', '8.00', null);
INSERT INTO `city` VALUES ('334', '28', '安康市', '8.00', null);
INSERT INTO `city` VALUES ('335', '28', '商洛市', '8.00', null);
INSERT INTO `city` VALUES ('336', '29', '兰州市', '8.00', null);
INSERT INTO `city` VALUES ('337', '29', '嘉峪关市', '8.00', null);
INSERT INTO `city` VALUES ('338', '29', '金昌市', '8.00', null);
INSERT INTO `city` VALUES ('339', '29', '白银市', '8.00', null);
INSERT INTO `city` VALUES ('340', '29', '天水市', '8.00', null);
INSERT INTO `city` VALUES ('341', '29', '武威市', '8.00', null);
INSERT INTO `city` VALUES ('342', '29', '张掖市', '8.00', null);
INSERT INTO `city` VALUES ('343', '29', '平凉市', '8.00', null);
INSERT INTO `city` VALUES ('344', '29', '酒泉市', '8.00', null);
INSERT INTO `city` VALUES ('345', '29', '庆阳市', '8.00', null);
INSERT INTO `city` VALUES ('346', '29', '定西市', '8.00', null);
INSERT INTO `city` VALUES ('347', '29', '陇南市', '8.00', null);
INSERT INTO `city` VALUES ('348', '29', '临夏回族自治州', '8.00', null);
INSERT INTO `city` VALUES ('349', '29', '甘南藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('350', '30', '西宁市', '8.00', null);
INSERT INTO `city` VALUES ('351', '30', '海东地区', '8.00', null);
INSERT INTO `city` VALUES ('352', '30', '海北藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('353', '30', '黄南藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('354', '30', '海南藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('355', '30', '果洛藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('356', '30', '玉树藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('357', '30', '海西蒙古族藏族自治州', '8.00', null);
INSERT INTO `city` VALUES ('358', '31', '银川市', '8.00', null);
INSERT INTO `city` VALUES ('359', '31', '石嘴山市', '8.00', null);
INSERT INTO `city` VALUES ('360', '31', '吴忠市', '8.00', null);
INSERT INTO `city` VALUES ('361', '31', '固原市', '8.00', null);
INSERT INTO `city` VALUES ('362', '31', '中卫市', '8.00', null);
INSERT INTO `city` VALUES ('363', '32', '乌鲁木齐市', '8.00', null);
INSERT INTO `city` VALUES ('364', '32', '克拉玛依市', '8.00', null);
INSERT INTO `city` VALUES ('365', '32', '吐鲁番地区', '8.00', null);
INSERT INTO `city` VALUES ('366', '32', '哈密地区', '8.00', null);
INSERT INTO `city` VALUES ('367', '32', '昌吉回族自治州', '8.00', null);
INSERT INTO `city` VALUES ('368', '32', '博尔塔拉蒙古自治州', '8.00', null);
INSERT INTO `city` VALUES ('369', '32', '巴音郭楞蒙古自治州', '8.00', null);
INSERT INTO `city` VALUES ('370', '32', '阿克苏地区', '8.00', null);
INSERT INTO `city` VALUES ('371', '32', '克孜勒苏柯尔克孜自治州', '8.00', null);
INSERT INTO `city` VALUES ('372', '32', '喀什地区', '8.00', null);
INSERT INTO `city` VALUES ('373', '32', '和田地区', '8.00', null);
INSERT INTO `city` VALUES ('374', '32', '伊犁哈萨克自治州', '8.00', null);
INSERT INTO `city` VALUES ('375', '32', '塔城地区', '8.00', null);
INSERT INTO `city` VALUES ('376', '32', '阿勒泰地区', '8.00', null);
INSERT INTO `city` VALUES ('377', '32', '自治区直辖县级行政区划', '8.00', null);

-- ----------------------------
-- Table structure for `cpzchongzhijilu`
-- ----------------------------
DROP TABLE IF EXISTS `cpzchongzhijilu`;
CREATE TABLE `cpzchongzhijilu` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '充值流水',
  `Cpzid` int(11) DEFAULT NULL COMMENT '彩票站编号',
  `Money` double(11,0) DEFAULT NULL COMMENT '充值金额',
  `Status` int(1) DEFAULT NULL COMMENT '状态\r\n0失败\r\n1成功',
  `Time` timestamp NULL DEFAULT NULL COMMENT '充值时间',
  `Type` int(1) DEFAULT NULL COMMENT '充值类型\r\n1微信\r\n2支付宝\r\n3银行卡',
  `Did` varchar(40) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`),
  KEY `cpzchongzhijilu_fk1` (`Cpzid`),
  KEY `cpzchongzhijilu_fk2` (`Did`),
  CONSTRAINT `cpzchongzhijilu_fk2` FOREIGN KEY (`Did`) REFERENCES `dingdan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cpzchongzhijilu
-- ----------------------------

-- ----------------------------
-- Table structure for `cpztixian`
-- ----------------------------
DROP TABLE IF EXISTS `cpztixian`;
CREATE TABLE `cpztixian` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '提现编号',
  `Cpzid` int(20) DEFAULT NULL COMMENT '彩票站编号',
  `Money` double(11,0) DEFAULT NULL COMMENT '提现金额',
  `Status` int(1) DEFAULT NULL COMMENT '状态',
  `Time` timestamp NULL DEFAULT NULL COMMENT '提现时间',
  `Endtime` timestamp NULL DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`),
  KEY `cpztixian_fk1` (`Cpzid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cpztixian
-- ----------------------------

-- ----------------------------
-- Table structure for `dingdan`
-- ----------------------------
DROP TABLE IF EXISTS `dingdan`;
CREATE TABLE `dingdan` (
  `id` varchar(40) NOT NULL COMMENT '订单编号',
  `Usersid` int(20) DEFAULT NULL COMMENT '用户编号',
  `Cpzid` int(20) DEFAULT NULL COMMENT '接单彩票站编号',
  `Cpzid1` int(20) DEFAULT NULL COMMENT '接单彩票站编号',
  `Cpzid2` int(20) DEFAULT NULL COMMENT '接单彩票站编号',
  `Cpzid3` int(20) DEFAULT NULL COMMENT '接单彩票站编号',
  `Cpzid4` int(20) DEFAULT NULL COMMENT '接单彩票站编号',
  `Cpzid5` int(20) DEFAULT NULL COMMENT '实际中标的彩票站编号',
  `Cpid` int(11) DEFAULT NULL COMMENT '彩票编号',
  `Num` int(20) DEFAULT NULL COMMENT '注数',
  `Begintime` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `Endtime` timestamp NULL DEFAULT NULL COMMENT '完成时间',
  `Time` timestamp NULL DEFAULT NULL COMMENT '订单持续时间',
  `Money` double(11,0) DEFAULT NULL COMMENT '下单金额',
  `Status` int(1) DEFAULT NULL COMMENT '订单状态，-1已取消订单，0已下单未付款，1已付款，2商家已接单',
  PRIMARY KEY (`id`),
  KEY `dingdan_fk1` (`Usersid`),
  KEY `dingdan_fk2` (`Cpzid`),
  KEY `dingdan_fk3` (`Cpzid1`),
  KEY `dingdan_fk4` (`Cpzid2`),
  KEY `dingdan_fk5` (`Cpzid3`),
  KEY `dingdan_fk6` (`Cpzid4`),
  KEY `dingdan_fk7` (`Cpzid5`),
  KEY `dingdan_fk8` (`Cpid`),
  CONSTRAINT `dingdan_ibfk_1` FOREIGN KEY (`Usersid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dingdan
-- ----------------------------

-- ----------------------------
-- Table structure for `dingdanxiangqing`
-- ----------------------------
DROP TABLE IF EXISTS `dingdanxiangqing`;
CREATE TABLE `dingdanxiangqing` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `caipiaoStyle` int(3) DEFAULT NULL,
  `dingdanId` varchar(40) DEFAULT NULL COMMENT '订单表编号',
  `Hongqiu1` varchar(2) DEFAULT NULL COMMENT '红球1',
  `Hongqiu2` varchar(2) DEFAULT NULL COMMENT '红球2',
  `Hongqiu3` varchar(2) DEFAULT NULL COMMENT '红球3',
  `Hongqiu4` varchar(2) DEFAULT NULL COMMENT '红球4',
  `Hongqiu5` varchar(2) DEFAULT NULL COMMENT '红球5',
  `Hongqiu6` varchar(2) DEFAULT NULL COMMENT '红球6',
  `Lanqiu` varchar(2) DEFAULT NULL COMMENT '蓝球',
  `Zhushu` int(20) DEFAULT NULL COMMENT '注数',
  `Beishu` int(20) DEFAULT NULL COMMENT '倍数',
  `Is_zhongjiang` int(1) DEFAULT NULL COMMENT '是否中奖',
  `zhongjiangjine` double(20,0) DEFAULT NULL COMMENT '中奖金额',
  `Is_lingjiang` int(1) DEFAULT NULL COMMENT '是否领奖',
  `Pay_money` double(20,0) DEFAULT NULL COMMENT '购买金额',
  PRIMARY KEY (`id`),
  KEY `dingdanxiangqing_fk1` (`dingdanId`),
  KEY `caipiaoStyle` (`caipiaoStyle`),
  CONSTRAINT `dingdanxiangqing_fk1` FOREIGN KEY (`dingdanId`) REFERENCES `dingdan` (`id`),
  CONSTRAINT `dingdanxiangqing_ibfk_1` FOREIGN KEY (`caipiaoStyle`) REFERENCES `caipiaobiao_desc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dingdanxiangqing
-- ----------------------------

-- ----------------------------
-- Table structure for `provice`
-- ----------------------------
DROP TABLE IF EXISTS `provice`;
CREATE TABLE `provice` (
  `prId` int(11) NOT NULL AUTO_INCREMENT COMMENT '省份ID',
  `prName` varchar(32) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`prId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='InnoDB free: 9216 kB; InnoDB free: 9216 kB; InnoDB free: 921';

-- ----------------------------
-- Records of provice
-- ----------------------------
INSERT INTO `provice` VALUES ('2', '北京市');
INSERT INTO `provice` VALUES ('3', '天津市');
INSERT INTO `provice` VALUES ('4', '河北省');
INSERT INTO `provice` VALUES ('5', '山西省');
INSERT INTO `provice` VALUES ('6', '内蒙古自治区');
INSERT INTO `provice` VALUES ('7', '辽宁省');
INSERT INTO `provice` VALUES ('8', '吉林省');
INSERT INTO `provice` VALUES ('9', '黑龙江省');
INSERT INTO `provice` VALUES ('10', '上海市');
INSERT INTO `provice` VALUES ('11', '江苏省');
INSERT INTO `provice` VALUES ('12', '浙江省');
INSERT INTO `provice` VALUES ('13', '安徽省');
INSERT INTO `provice` VALUES ('14', '福建省');
INSERT INTO `provice` VALUES ('15', '江西省');
INSERT INTO `provice` VALUES ('16', '山东省');
INSERT INTO `provice` VALUES ('17', '河南省');
INSERT INTO `provice` VALUES ('18', '湖北省');
INSERT INTO `provice` VALUES ('19', '湖南省');
INSERT INTO `provice` VALUES ('20', '广东省');
INSERT INTO `provice` VALUES ('21', '广西壮族自治区');
INSERT INTO `provice` VALUES ('22', '海南省');
INSERT INTO `provice` VALUES ('23', '重庆市');
INSERT INTO `provice` VALUES ('24', '四川省');
INSERT INTO `provice` VALUES ('25', '贵州省');
INSERT INTO `provice` VALUES ('26', '云南省');
INSERT INTO `provice` VALUES ('27', '西藏自治区');
INSERT INTO `provice` VALUES ('28', '陕西省');
INSERT INTO `provice` VALUES ('29', '甘肃省');
INSERT INTO `provice` VALUES ('30', '青海省');
INSERT INTO `provice` VALUES ('31', '宁夏回族自治区');
INSERT INTO `provice` VALUES ('32', '新疆维吾尔自治区');

-- ----------------------------
-- Table structure for `shoujiduanxiaoxi`
-- ----------------------------
DROP TABLE IF EXISTS `shoujiduanxiaoxi`;
CREATE TABLE `shoujiduanxiaoxi` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `message` varchar(200) DEFAULT NULL COMMENT '消息',
  `time` timestamp NULL DEFAULT NULL COMMENT '消息发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of shoujiduanxiaoxi
-- ----------------------------
INSERT INTO `shoujiduanxiaoxi` VALUES ('1', '15599888899', '1848', '2018-07-11 16:25:55');
INSERT INTO `shoujiduanxiaoxi` VALUES ('2', '15555980230', '8276', '2018-07-08 16:29:16');
INSERT INTO `shoujiduanxiaoxi` VALUES ('3', '15555980230', '5935', '2018-07-08 16:36:56');

-- ----------------------------
-- Table structure for `shuangseqiuqishu`
-- ----------------------------
DROP TABLE IF EXISTS `shuangseqiuqishu`;
CREATE TABLE `shuangseqiuqishu` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `Qishu` varchar(20) DEFAULT NULL COMMENT '期数',
  `Hongqiu1` varchar(2) DEFAULT NULL COMMENT '红球1',
  `Hongqiu2` varchar(2) DEFAULT NULL COMMENT '红球2',
  `Hongqiu3` varchar(2) DEFAULT NULL COMMENT '红球3',
  `Hongqiu4` varchar(2) DEFAULT NULL COMMENT '红球4',
  `Hongqiu5` varchar(2) DEFAULT NULL COMMENT '红球5',
  `Hongqiu6` varchar(2) DEFAULT NULL COMMENT '红球6',
  `lanqiu` varchar(2) DEFAULT NULL COMMENT '蓝球',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of shuangseqiuqishu
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(11) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `touxiang` varchar(50) DEFAULT NULL COMMENT '头像',
  `jifen` double(20,0) DEFAULT NULL COMMENT '可用积分',
  `dongji` double(20,0) DEFAULT NULL COMMENT '冻结积分',
  `yitixian` double(20,0) DEFAULT NULL COMMENT '已提现金额',
  `dengji` int(1) DEFAULT NULL COMMENT '用户等级',
  `time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `bank` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `xingming` varchar(10) DEFAULT NULL COMMENT '开户人',
  `zhanghao` varchar(100) DEFAULT NULL COMMENT '账号',
  `tuijiandianpu` int(20) DEFAULT NULL COMMENT '推荐店铺',
  `shoucangdianpu` int(20) DEFAULT NULL COMMENT '收藏店铺',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'nico', '15555980230', 'E3CF096A7F6C51B3DDA4F904D8944B5E', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `userschongzhijilu`
-- ----------------------------
DROP TABLE IF EXISTS `userschongzhijilu`;
CREATE TABLE `userschongzhijilu` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '充值流水',
  `Usersid` int(11) DEFAULT NULL COMMENT '用户编号',
  `Money` double(11,0) DEFAULT NULL COMMENT '充值金额',
  `Status` int(1) DEFAULT NULL COMMENT '状态',
  `time` timestamp NULL DEFAULT NULL COMMENT '充值时间',
  `Type` int(1) DEFAULT NULL COMMENT '充值类型\r\n1微信\r\n2支付宝\r\n3银行卡',
  `Did` varchar(40) DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`),
  KEY `userschongzhijilu_fk1` (`Usersid`),
  KEY `userschongzhijilu_fk2` (`Did`),
  CONSTRAINT `userschongzhijilu_fk2` FOREIGN KEY (`Did`) REFERENCES `dingdan` (`id`),
  CONSTRAINT `userschongzhijilu_ibfk_1` FOREIGN KEY (`Usersid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of userschongzhijilu
-- ----------------------------

-- ----------------------------
-- Table structure for `userstixian`
-- ----------------------------
DROP TABLE IF EXISTS `userstixian`;
CREATE TABLE `userstixian` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '提现编号',
  `Usersid` int(20) DEFAULT NULL COMMENT '用户编号',
  `Money` double(20,0) DEFAULT NULL COMMENT '提现金额',
  `Status` int(1) DEFAULT NULL COMMENT '状态',
  `Time` timestamp NULL DEFAULT NULL COMMENT '提现时间',
  `Endtime` timestamp NULL DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`),
  KEY `userstixian_fk1` (`Usersid`),
  CONSTRAINT `userstixian_ibfk_1` FOREIGN KEY (`Usersid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of userstixian
-- ----------------------------
