package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.ReplyTalk;
import entity.Talk;
import entity.collect;
import entity.praise;
import service.talk.talkService;
import util.DateUtil;

@Controller
@RequestMapping("talk")
public class talk {

	@Autowired
	public talkService ts;
	
	@RequestMapping("add")
	public @ResponseBody String add(Talk talk) throws Exception {
		talk.setTalktime(DateUtil.getCurrentTime());
		ts.talkAdd(talk);
		return "1";
	}
	
	@RequestMapping("praiseAdd")
	public @ResponseBody String praiseAdd(praise praise) throws Exception {
		ts.praiseAdd(praise);
		return "1";
	}
	
	@RequestMapping("replyAdd")
	public @ResponseBody String replyTalkAdd(ReplyTalk replyTalk) throws Exception {
		replyTalk.setReplytime(DateUtil.getCurrentTime());
		ts.replyAdd(replyTalk);
		return "1";
	}
	
	@RequestMapping("collectAdd")
	public @ResponseBody String collectAdd(collect collect) throws Exception {
		collect.setTalktime(DateUtil.getCurrentTime());
		ts.talkCollect_add(collect);
		return "1";
	}
	
	@RequestMapping("delete")
	public @ResponseBody String delete(Talk talk) throws Exception {
		ts.talkDel(talk);
		return "1";
	}
	
	@RequestMapping("collectDelete")
	public @ResponseBody String collectDelete(collect collect) throws Exception {
		ts.talkCollect_delete(collect);
		return "1";
	}
	
	@RequestMapping("collectGet")
	public @ResponseBody ArrayList<collect> get(collect collect) throws Exception {
		ArrayList<collect> talkList = ts.talkCollect_find(collect);
		ArrayList<praise> praiseList = (ArrayList<praise>) ts.praiseFind();
		ArrayList<ReplyTalk> ReplyList = (ArrayList<ReplyTalk>) ts.replyFind();
		for(int i=0;i<talkList.size();i++) {
			ArrayList<ReplyTalk> reply = new ArrayList<ReplyTalk>();
			for(int j=0;j<ReplyList.size();j++) {
				if(talkList.get(i).getTalk_id()==ReplyList.get(j).getTalk_id()) {
					reply.add(ReplyList.get(j));
				}
				talkList.get(i).setReplyTalkList(reply);
			}
		}
		//添加点赞集合
		for(int i=0;i<talkList.size();i++) {
			ArrayList<praise> praise = new ArrayList<praise>();
			for(int j=0;j<praiseList.size();j++) {
				if(talkList.get(i).getTalk_id()==praiseList.get(j).getTalk_id()) {
					praise.add(praiseList.get(j));
				}
				talkList.get(i).setPraiseList(praise);
			}
		}
		return talkList;
}
	@RequestMapping("get")
	public @ResponseBody ArrayList<Talk> get(Talk talk) throws Exception {
		ArrayList<Talk> talkList = ts.talkFind(talk);
		ArrayList<praise> praiseList = (ArrayList<praise>) ts.praiseFind();
  		ArrayList<ReplyTalk> ReplyList = (ArrayList<ReplyTalk>) ts.replyFind();
  		for(int i=0;i<talkList.size();i++) {
  			ArrayList<ReplyTalk> reply = new ArrayList<ReplyTalk>();
  			for(int j=0;j<ReplyList.size();j++) {
  				if(talkList.get(i).getTalk_id()==ReplyList.get(j).getTalk_id()) {
  					reply.add(ReplyList.get(j));
  				}
  				talkList.get(i).setReplyTalkList(reply);
  			}
  		}
  		//添加点赞集合
  		for(int i=0;i<talkList.size();i++) {
  			ArrayList<praise> praise = new ArrayList<praise>();
  			for(int j=0;j<praiseList.size();j++) {
  				if(talkList.get(i).getTalk_id()==praiseList.get(j).getTalk_id()) {
  					praise.add(praiseList.get(j));
  				}
  				talkList.get(i).setPraiseList(praise);
  			}
  		}
		return talkList;
	}
}
