package controller;


import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.suggest;
import entity.userInfo;
import service.user.userService;

@Controller
@RequestMapping("/user")
public class user {

	@Autowired
	private userService us;
	
	//添加用户
	@RequestMapping("/add")
	public @ResponseBody String add(userInfo user) throws SQLException{
		us.userAdd(user);
		return "1";
	}
	
	@RequestMapping("/suggestAdd")
	public @ResponseBody String add(suggest suggest) throws SQLException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String suggesttime = df.format(new Date());
		suggest.setSuggesttime(suggesttime);
		us.userSuggestAdd(suggest);
		return "1";
	}
	
	//删除用户接口
	@RequestMapping("/delete")
	public @ResponseBody String delete(userInfo user) throws SQLException{
		us.userDel(user);
		return "1";
	}
	
	//修改用户接口
	@RequestMapping("/edit")
	public @ResponseBody userInfo edit(userInfo user) throws SQLException{
		return us.userUpdate(user);
	}
	
	//查询用户接口
	@RequestMapping("/get")
	public @ResponseBody userInfo get(userInfo user){
		return us.userGet(user);
	}
	
	//后台查询用户接口
	@RequestMapping("/adminGet")
	public @ResponseBody Map<String, Serializable> adminGet(userInfo user,String limit,String page){
		int pageSize = 10;
		if(limit != null && !limit.equals("")){
			pageSize = Integer.parseInt(limit);
		}
		int page1 = 1;
		if(page != null && !page.equals("")){
			page1 = Integer.parseInt(page);
		}
		ArrayList<userInfo> userList = (ArrayList<userInfo>) us.userAdminGet(user);
		int total = userList.size();
		ArrayList<userInfo> userList1 = new ArrayList<userInfo>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("count", total);
		resultMap.put("msg", "");
		resultMap.put("code", 0);
		if(page != null && page.length() > 0 && limit!=null && limit.length()>0){
			for(int i = (page1-1)*pageSize ; i< page1*pageSize && i< total;i++){
				userList1.add(userList.get(i));
			}
			resultMap.put("data", userList1);
			return resultMap;
		}else{
			resultMap.put("data", userList);
			return resultMap;
		}
	}
}
