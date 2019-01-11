package mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ReplyTalk;
import entity.Talk;
import entity.collect;
import entity.praise;

public interface talkDao {
	
	  public ArrayList<Talk> talkSelect(Talk talk) throws SQLException, ClassNotFoundException;//分享查询
	  public void talkAdd(Talk talk) throws SQLException;//添加
	  public void talkDelete(Talk talk) throws SQLException;//删除
	  
	  public void replyTalkAdd(ReplyTalk reply);//添加回复
	  public List<ReplyTalk> replySelect() throws SQLException, ClassNotFoundException;//查询回复
	  
	  public List<praise> praiseSelect() throws SQLException;	//查询点赞
	  public void praiseInsert(praise praise);//添加点赞
	  
	  
	  public void talkCollect_add(collect collect) throws SQLException;//添加收藏
	  public void talkCollect_delete(collect collect) throws SQLException;//删除收藏
	  public ArrayList<collect> talkCollect_find(collect collect) throws SQLException, ClassNotFoundException;//查询收藏
	
}
