package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.acollect;
import entity.activity;
import entity.activityjoins;
import service.activity.activityService;
import util.DateUtil;

@Controller
@RequestMapping("activity")
public class activitys {

	@Autowired
	private activityService as;
	
	//添加活动收藏
	@RequestMapping("collectAdd")
	public @ResponseBody String collectAdd(acollect acollect) throws Exception {
		acollect.setAcollecttime(DateUtil.getCurrentTime());
		as.collectAdd(acollect);
		return "1";
	}
	//获得用户收藏活动
	@RequestMapping("collectGet")
	public @ResponseBody List<activity> collectGet(Integer use_id) {
		return as.collectGet(use_id);
	}
	//活动报名
	@RequestMapping("joinsAdd")
	public @ResponseBody String joinsAdd(activityjoins ajoins) {
		as.joinsAdd(ajoins);
		return "1";
	}
	//添加活动
	@RequestMapping("add")
	public @ResponseBody String add(activity activity) {
		as.add(activity);
		return "1";
	}
	//删除活动
	@RequestMapping("delete")
	public @ResponseBody String delete(activity activity) {
		as.delete(activity);
		return "1";
	}
	//查询收藏
	@RequestMapping("get")
	public @ResponseBody List<activity> get(Integer use_id) {
		return as.get(use_id);
	}
	//后台查询收藏
	public @ResponseBody Map<String, Serializable> adminGet(Integer use_id,String limit,String page){
		int pageSize = 10;
		if(limit != null && !limit.equals("")){
			pageSize = Integer.parseInt(limit);
		}
		int page1 = 1;
		if(page != null && !page.equals("")){
			page1 = Integer.parseInt(page);
		}
		ArrayList<activity> activityList = (ArrayList<activity>) as.get(use_id);
		int total = activityList.size();
		ArrayList<activity> activityList1 = new ArrayList<activity>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("count", total);
		resultMap.put("msg", "");
		resultMap.put("code", 0);
		if(page != null && page.length() > 0 && limit!=null && limit.length()>0){
			for(int i = (page1-1)*pageSize ; i< page1*pageSize && i< total;i++){
				activityList1.add(activityList.get(i));
			}
			resultMap.put("data", activityList1);
			return resultMap;
		}else{
			resultMap.put("data", activityList);
			return resultMap;
		}
	}
}
