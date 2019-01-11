package service.user;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.suggest;
import entity.userInfo;

public interface userService {
		public userInfo userGet(userInfo user);//查询业务
		public void userAdd(userInfo user) throws SQLException;//添加业务
		public void userDel(userInfo user) throws SQLException;//删除业务
		public userInfo userUpdate(userInfo user) throws SQLException;//修改业务
		public void UserPassWord_edit(userInfo user) throws SQLException;//密码修改业务
		public void userSuggestAdd(suggest suggest) throws SQLException;//意见反馈业务
		public ArrayList<userInfo> userAdminGet(userInfo user);
}
