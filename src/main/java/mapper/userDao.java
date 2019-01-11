package mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.suggest;
import entity.userInfo;

public interface userDao {

	public userInfo userGet(userInfo user);//查询
	public void userAdd(userInfo user) throws SQLException;//添加
	public void userDelete(userInfo user) throws SQLException;//删除
	public void userUpdate(userInfo user) throws SQLException;//修改
	public void userPassWord_edit(userInfo user) throws SQLException;//修改密码
	public void userSuggestAdd(suggest suggest) throws SQLException;//意见反馈
	public ArrayList<userInfo> userAdminGet(userInfo user);
}
