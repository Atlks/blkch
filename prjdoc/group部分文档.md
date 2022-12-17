group部分文档


net api svr port number
http://localhost:5000/GetCurrentTime
http://localhost:5000/friendGroup/list


<!-- TOC -->

- [friendGroup/list](#friendgrouplist)
- [addgrp](#addgrp)
- [add user to group](#add-user-to-group)
- [rename](#rename)
- [del grp](#del-grp)

<!-- /TOC -->
 
 ## friendGroup/list
[19:19:22] http 网络请求数据： https://znbajwu.com/friendGroup/list?access_token=7a617dd3fd7640c5880964f37ecf4998&salt=1669893561652&secret=6OEro2qkYU7hKg1iziiUug%3d%3d
[19:19:22] http time(233ms)��������Ӧ���ݣ� {"currentTime":1669893562267,"data":[{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064db","groupName":"家人","userId":10000415,"userIdList":[]},{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064dd","groupName":"同事","userId":10000415,"userIdList":[]}],"resultCode":1,"version":"1.0.1"}


## addgrp
[19:19:31] http 网络请求数据： https://znbajwu.com/friendGroup/add?access_token=7a617dd3fd7640c5880964f37ecf4998&groupName=%ef%bd%87%ef%bd%92%ef%bd%90%ef%bc%91&salt=1669893571254&secret=xxUYkprmli7vMVATZqRR%2bA%3d%3d
[19:19:33] 主窗失去焦点
[19:19:33] http time(2160ms)��������Ӧ���ݣ� {"currentTime":1669893573798,"data":{"createTime":1669893573,"groupId":"63888dc5c728a97158d2f81b","groupName":"ｇｒｐ１","userId":10000415,"userIdList":[]},"resultCode":1,"version":"1.0.1"}
[19:19:33] http 网络请求数据： https://znbajwu.com/friendGroup/list?access_token=7a617dd3fd7640c5880964f37ecf4998&salt=1669893573424&secret=zwo35MweLm63vCSvMBhljQ%3d%3d
[19:19:33] DecoderImPacket  10
[19:19:33] http 网络请求数据： https://znbajwu.com/org/company/getByUserId?access_token=7a617dd3fd7640c5880964f37ecf4998&userId=10000415&salt=1669893573449&secret=UT8WNNgfLpe9QLmEQ%2f4Krg%3d%3d
[19:19:33] 收到Socket: {"messageHead":{"from":"10005/Server","to":"10000415","messageId":"0df8abe444a0455ea864b8471a5f2b99","chatType":1,"offline":false},"fromUserId":"10000415","fromUserName":"yy","toUserId":"10000415","toUserName":"yy","timeSend":1669893573796,"type":800,"content":"","objectId":"sync_label","fileName":"","isEncrypt":false,"deleteTime":0,"isReadDel":false,"fileSize":0,"fileTime":0,"location_x":0.0,"location_y":0.0,"encryptType":0}
[19:19:33] ProcessDeviceSyncMessage  0df8abe444a0455ea864b8471a5f2b99
[19:19:33] �������޸��˱�ǩ
[19:19:34] http time(231ms)��������Ӧ���ݣ� {"currentTime":1669893574038,"data":[{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064db","groupName":"家人","userId":10000415,"userIdList":[]},{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064dd","groupName":"同事","userId":10000415,"userIdList":[]},{"createTime":1669893573,"groupId":"63888dc5c728a97158d2f81b","groupName":"ｇｒｐ１","userId":10000415,"userIdList":[]}],"resultCode":1,"version":"1.0.1"}
[19:19:34] http time(231ms)��������Ӧ���ݣ� {"currentTime":1669893574063,"resultCode":1,

## add user to group
[19:19:39] http 网络请求数据： https://znbajwu.com/friendGroup/updateGroupUserList?access_token=7a617dd3fd7640c5880964f37ecf4998&groupId=63888dc5c728a97158d2f81b&userIdListStr=10000032%2c10000033&salt=1669893579434&secret=Y9ryiOppTWHcQpRvSI4m1w%3d%3d
[19:19:40] DecoderImPacket  10
[19:19:40] 收到Socket: {"messageHead":{"from":"10005/Server","to":"10000415","messageId":"0bc1e7c672b74a94b712f27f51514ea7","chatType":1,"offline":false},"fromUserId":"10000415","fromUserName":"yy","toUserId":"10000415","toUserName":"yy","timeSend":1669893580056,"type":800,"content":"","objectId":"sync_label","fileName":"","isEncrypt":false,"deleteTime":0,"isReadDel":false,"fileSize":0,"fileTime":0,"location_x":0.0,"location_y":0.0,"encryptType":0}
[19:19:40] ProcessDeviceSyncMessage  0bc1e7c672b74a94b712f27f51514ea7
[19:19:40] �������޸��˱�ǩ
[19:19:40] http time(239ms)��������Ӧ���ݣ� {"currentTime":1669893580055,"resultCode":1,"version":"1.0.1"}
[19:19:40] http 网络请求数据： https://znbajwu.com/friendGroup/list?access_token=7a617dd3fd7640c5880964f37ecf4998&salt=1669893579681&secret=45g1Ldk0N8Y84l%2fdYLlxkg%3d%3d
[19:19:40] http time(234ms)��������Ӧ���ݣ� {"currentTime":1669893580295,"data":[{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064db","groupName":"家人","userId":10000415,"userIdList":[]},{"createTime":1669462730,"groupId":"6381facaacb0c4637f1064dd","groupName":"同事","userId":10000415,"userIdList":[]},{"createTime":1669893573,"groupId":"63888dc5c728a97158d2f81b","groupName":"ｇｒｐ１","userId":10000415,"userIdList":[10000032,10000033]}],"resultCode":1,"version":"1.0.1"}
[19:19:41] 主窗获取焦点
[19:19:42] 主窗失去焦点


## rename 

:26:49] 主窗获取焦点
[19:26:49] http 网络请求数据： https://znbajwu.com/friendGroup/update?access_token=7a617dd3fd7640c5880964f37ecf4998&groupId=63888f6fc728a97158d2f81e&groupName=%ef%bd%87%ef%bc%92%ef%bc%92%ef%bc%93%ef%bc%93&salt=1669894008743&secret=rPczPv7YtA%2fXYdHlRkDMPA%3d%3d
[19:26:49] http time(235ms)��������Ӧ���ݣ� {"currentTime":1669894009365,"resultCode":1,"version":"1.0.1"}
[19:26:49] DecoderImPacket  10

## del grp

[19:26:50] 主窗失去焦点
[19:28:48] 主窗获取焦点
[19:28:51] http 网络请求数据： https://znbajwu.com/friendGroup/delete?access_token=7a617dd3fd7640c5880964f37ecf4998&groupId=63888f6fc728a97158d2f81e&salt=1669894131375&secret=EdHsZshZUVN5v11Rw8Budw%3d%3d
[19:28:52] http time(542ms)��������Ӧ���ݣ� {"currentTime":1669894132299,"resultCode":1,"version":"1.0.1"}
[19:28:52] DecoderImPacket  10