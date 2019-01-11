package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.userInfo;
import entity.view;
import service.view.viewService;
import util.DateUtil;

@Controller
@RequestMapping("view")
public class views {

	@Autowired
	private viewService vs;
	
	@RequestMapping("add")
	public @ResponseBody String add(view v) throws Exception {
		v.setUploadTime(DateUtil.getCurrentTime());
		vs.add(v);
		return "1";
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(view v) {
		vs.delete(v);
		return "1";
	}
	
	@RequestMapping("get")
	public @ResponseBody ArrayList<view> get(view v) {
		return vs.get(v);
	}
	
	@RequestMapping("/adminGet")
	public @ResponseBody Map<String, Serializable> adminGet(view v,String limit,String page){
		int pageSize = 10;
		if(limit != null && !limit.equals("")){
			pageSize = Integer.parseInt(limit);
		}
		int page1 = 1;
		if(page != null && !page.equals("")){
			page1 = Integer.parseInt(page);
		}
		ArrayList<view> viewList = vs.get(v);
		int total = viewList.size();
		ArrayList<view> viewList1 = new ArrayList<view>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("count", total);
		resultMap.put("msg", "");
		resultMap.put("code", 0);
		if(page != null && page.length() > 0 && limit!=null && limit.length()>0){
			for(int i = (page1-1)*pageSize ; i< page1*pageSize && i< total;i++){
				viewList1.add(viewList.get(i));
			}
			resultMap.put("data", viewList1);
			return resultMap;
		}else{
			resultMap.put("data", viewList);
			return resultMap;
		}
	}
}
