CREATE TABLE IF NOT EXISTS `PRODUCT`(
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME` VARCHAR(16) NOT NULL,
    `PRICE` INT NOT NULL DEFAULT '0',
    `STOCK` INT NOT NULL DEFAULT '0',
    `TYPE` VARCHAR(10) NOT NULL,
    `DESCRIPTION` VARCHAR(100),
    `SID` INT NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `DELIVERMAN`(
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME` VARCHAR(10) NOT NULL,
    `UNAME` VARCHAR(16) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    `TELEPHONE` VARCHAR(11) NOT NULL,
    `GENDER` VARCHAR(2) NOT NULL,
    `VTYPE` VARCHAR(10) NOT NULL,
    `VID` INT NOT NULL,
    `VBRAND` VARCHAR(10) NOT NULL,
    `STATUS` INT NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `CUSTOMER`(
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `NAME` VARCHAR(10) NOT NULL,
    `UNAME` VARCHAR(16) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    `TELEPHONE` VARCHAR(11) NOT NULL,
    `GENDER` VARCHAR(1) NOT NULL,
    `BIRTHDAY` DATE NOT NULL,
    `ADDRESS` VARCHAR(100) NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `COMMENT`(
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `STARTID` INT NOT NULL DEFAULT '0',
    `ENDID` INT NOT NULL DEFAULT '0',
    `STARTNAME` VARCHAR(16) NOT NULL,
    `ENDNAME` VARCHAR(16) NOT NULL,
    `TIME` DATE NOT NULL,
    `CONTENT` VARCHAR(100) NOT NULL,
    `LIKES` INT NOT NULL,
    `COID` INT NOT NULL DEFAULT '0',
    `DISLIKES` INT NOT NULL,
    `STATUS` INT NOT NULL DEFAULT '1'
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ORDER`(
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CID` INT NOT NULL,
    `SID` INT NOT NULL,
    `GID` VARCHAR(100) NOT NULL,
    `GOODSNUM` VARCHAR(100) NOT NULL,
    `ENDTIME` DATE,
    `STARTTIME` DATE NOT NULL,
    `TOTAL` DECIMAL(2) NOT NULL,
    `STATUS` INT NOT NULL,
    `SNAME` VARCHAR(20) NOT NULL,
    `DISCOUNTNUM` VARCHAR(100),
    `DID` VARCHAR(100),
    `CNAME` VARCHAR(16) NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `CART`(
    `CID` INT NOT NULL,
    `GID` VARCHAR(100),
    `GOODSNUM` VARCHAR(100),
    `TOTAL` DECIMAL(2)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : software

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 17/07/2024 21:24:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
                           `id` int NOT NULL,
                           `password` varchar(6) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                           `balance` decimal(10, 0) NULL DEFAULT NULL,
                           `did` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                           `discountNum` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : software

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 17/07/2024 21:23:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
                          `id` int NOT NULL,
                          `password` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                          `uname` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : software

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 17/07/2024 21:24:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
                             `id` int NOT NULL,
                             `password` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                             `shopname` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                             `uname` varchar(16) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                             `address` varchar(32) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                             `telephone` varchar(11) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
                             `idCard` varchar(18) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : software

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 17/07/2024 21:24:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
                           `id` int NOT NULL,
                           `limit` int NULL DEFAULT NULL,
                           `discount` decimal(10, 2) NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
