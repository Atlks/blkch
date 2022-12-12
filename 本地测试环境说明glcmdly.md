本地测试环境说明glcmdly.md

<!-- TOC -->

- [---------------jdk8，编译水平8](#---------------jdk8编译水平8)
- [db 存储使用mgdb和rds](#db-存储使用mgdb和rds)
- [db配置文件](#db配置文件)
- [--------maven版本 3.6.3](#--------maven版本-363)
- [--------------mongodb 版本。。。驱动适配的版本是？？最新版本mongdob版本太高了。。会错误。。。](#--------------mongodb-版本驱动适配的版本是最新版本mongdob版本太高了会错误)
- [去除密钥验证login](#去除密钥验证login)
- [add test admin](#add-test-admin)

<!-- /TOC -->
# ---------------jdk8，编译水平8



| Listen on         | 0.0.0.0:5226                                                       |
| Main Class        | com.shiku.imserver.IMServerStarter    

# db 存储使用mgdb和rds
# db配置文件
/imsvr/src/imserver.properties


问题解决

 - Unable to derive module descriptor 
loadkit.v1.0.0: Invalid module name: '0' is not a Java identifier

版本不对，jdk17兼容度有问题，切换到8即ok



# --------maven版本 3.6.3


Since Maven 3.8.1 http repositories are blocked
最近下载了最新版idea后，打开一个项目，在下载引用的包时出现了这个错误：“Since Maven 3.8.1 http repositories are blocked”

从Maven 3.8.1开始，不再支持http的包了。这也很理解，https会更加安全。

但我们现有的项目还是有很多包的下载地址协议头是http，所以还是老老实实退回的老版本吧

 

从Maven官网下载

在官网上版本号小于3.8.1的最新版本是3.6.3

https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/

# --------------mongodb 版本。。。驱动适配的版本是？？最新版本mongdob版本太高了。。会错误。。。


# 去除密钥验证login

application.javas 
	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		AuthorizationFilter filter = new AuthorizationFilter();
//		Map<String, String> initParameters = Maps.newHashMap();
//		initParameters.put("enable", "true");
//		List<String> urlPatterns = Arrays.asList("/*");
//
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		// registrationBean.setFilter(filter);
//
//		registrationBean.setInitParameters(initParameters);
//		registrationBean.setUrlPatterns(urlPatterns);
//		return registrationBean;
//	}

# add test admin



user mgdb store

coll::  imapi.user


role    imapi.userrole...

add test u and role

{
  "_id": 888,
  "userKey": "0a113ef6b61820daa5611c870ed8d5ee",
  "username": "888",
  "password": "21218cca77804d2ba1922c33e0151105",
  "userType": 1,
  "telephone": "86888",
  "areaCode": "86",
  "name": "888",
  "nickname": "888",
  "description": "888",
  "birthday": 888,
  "sex": 888,
  "loc": {
    "lng": 10,
    "lat": 10
  },
  "countryId": 0,
  "provinceId": 0,
  "cityId": 400300,
  "areaId": 0,
  "money": 0,
  "moneyTotal": 0,
  "level": 0,
  "vip": 0,
  "friendsCount": 0,
  "fansCount": 0,
  "attCount": 0,
  "createTime": {
    "$numberLong": "1670832659"
  },
  "modifyTime": {
    "$numberLong": "1670832659"
  },
  "idcard": "",
  "idcardUrl": "",
  "isAuth": 0,
  "status": 1,
  "onlinestate": 1,
  "settings": {
    "allowAtt": 1,
    "isVibration": 0,
    "isTyping": 0,
    "isUseGoogleMap": 0,
    "allowGreet": 1,
    "friendsVerify": 1,
    "openService": 0,
    "closeTelephoneFind": 1,
    "chatRecordTimeOut": -1,
    "chatSyncTimeLen": -2,
    "isEncrypt": 0,
    "multipleDevices": 1,
    "isKeepalive": 1,
    "phoneSearch": 1,
    "nameSearch": 1,
    "showLastLoginTime": -1,
    "showTelephone": -1,
    "friendFromList": "1,2,3,4,5",
    "authSwitch": 0
  }
}

add role
{
  "_id": {
    "$oid": "6396e213ab7fec63cc6f9370"
  },
  "userId": 888,
  "phone": "888",
  "role": 6,
  "status": 1,
  "createTime": {
    "$numberLong": "1670832659"
  },
  "lastLoginTime": {
    "$numberLong": "0"
  }
}