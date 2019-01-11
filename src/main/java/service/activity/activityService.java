package service.activity;

import java.util.List;

import entity.acollect;
import entity.activity;
import entity.activityjoins;

public interface activityService {
	
	public void add(activity activity);						//添加活动
	public void delete(activity activity);					//删除活动
	public List<activity> get(Integer use_id);					//查询活动
	public void joinsAdd(activityjoins a);					//添加报名者
	public void collectAdd(acollect a);						//添加活动收藏
	public List<activity> collectGet(Integer use_id);	//查询活动收藏
}
