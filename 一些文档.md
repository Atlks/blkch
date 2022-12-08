一些文档

grptag，右键菜单，添加好友菜单出来的好友选择器是ok的，
新建grptag出来的好友选择器是错误的


这个是正确的控件
   #region 标签右键菜单事件

        // 添加成员
        public void OnAddLableFriend(object sender, EventArgs e)
        {

            // 需要排除现有的数据
            List<RoomMember> excludes = mSelectItem.FriendLabel.GetRoomMemberList();

            FrmFriendSelect frm = new FrmFriendSelect();
            frm.LoadFriendsData(excludes);