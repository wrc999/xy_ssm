package service.user;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.suggest;
import entity.userInfo;
import mapper.userDao;

@Service
@Transactional
public class userServiceImpl implements userService{
	@Autowired
	private userDao ud;

	@Override
	public userInfo userGet(userInfo user) {
		// TODO Auto-generated method stub
		return ud.userGet(user);
	}

	@Override
	public void userAdd(userInfo user) throws SQLException {
		// TODO Auto-generated method stub
		ud.userAdd(user);
	}

	@Override
	public void userDel(userInfo user) throws SQLException {
		// TODO Auto-generated method stub
		ud.userDelete(user);
	}

	@Override
	public userInfo userUpdate(userInfo user) throws SQLException {
		// TODO Auto-generated method stub
		ud.userUpdate(user);
		return ud.userGet(user);
	}

	@Override
	public void UserPassWord_edit(userInfo user) throws SQLException {
		// TODO Auto-generated method stub
		ud.userPassWord_edit(user);
	}

	@Override
	public void userSuggestAdd(suggest suggest) throws SQLException {
		// TODO Auto-generated method stub
		ud.userSuggestAdd(suggest);
	}

	@Override
	public ArrayList<userInfo> userAdminGet(userInfo user) {
		// TODO Auto-generated method stub
		return ud.userAdminGet(user);
	}

}
