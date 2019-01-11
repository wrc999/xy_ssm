package service.talk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ReplyTalk;
import entity.Talk;
import entity.collect;
import entity.praise;

public interface talkService {
	
	  public ArrayList<Talk> talkFind(Talk talk) throws Exception;//用户查询分享
	  public void talkAdd(Talk talk) throws SQLException;//添加分享
	  public void talkDel(Talk talk) throws Exception;//删除分享
	  
	  public void replyAdd(ReplyTalk reply) throws Exception;//添加回复
	  public List<ReplyTalk> replyFind() throws Exception;//查询回复
	  public List<praise> praiseFind() throws Exception;//查询点赞
	  public void praiseAdd(praise praise) throws Exception;//添加点赞
	  
	  
	  public void talkCollect_add(collect collect) throws Exception;//添加收藏
	  public void talkCollect_delete(collect collect) throws Exception;//删除收藏
	  public ArrayList<collect> talkCollect_find(collect collect) throws Exception;//查询收藏
}
