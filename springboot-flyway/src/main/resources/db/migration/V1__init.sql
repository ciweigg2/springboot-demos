SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for iot_version_group
-- ----------------------------
DROP TABLE IF EXISTS `iot_version_group`;
CREATE TABLE `iot_version_group` (
                                     `VG_ID` int(2) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
                                     `VG_NAME` varchar(20) DEFAULT NULL COMMENT '版本分组名称',
                                     `VG_FLAG` varchar(30) DEFAULT NULL COMMENT '版本分组标识',
                                     `VG_CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '版本分组创建时间',
                                     `VG_STATUS` int(1) DEFAULT '1' COMMENT '版本分组状态，1：正常，0：冻结，-1：已删除',
                                     `VG_MARK` varchar(200) DEFAULT NULL COMMENT '备注信息',
                                     PRIMARY KEY (`VG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='版本分组信息表';

SET FOREIGN_KEY_CHECKS = 1;
