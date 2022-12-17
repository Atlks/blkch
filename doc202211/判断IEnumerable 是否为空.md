判断IEnumerable 是否为空


      IEnumerable o = new FriendTagDao().QueryMemInGrpRzt(uid, groupId);
                bool v = o.GetEnumerator().MoveNext();
                if (v==false)
                    new FriendTagDao().AddMemToGrp(uid, groupId);
                else
                            new FriendTagDao().DelMemFromGrp(uid, groupId);