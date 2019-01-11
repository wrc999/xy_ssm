package service.talk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.ReplyTalk;
import entity.Talk;
import entity.collect;
import entity.praise;
import mapper.talkDao;

@Service
@Transactional
public class talkServiceImpl implements talkService {
	@Autowired
	private talkDao td;

	@Override
	public ArrayList<Talk> talkFind(Talk talk) throws Exception {
		return td.talkSelect(talk);
	}

	@Override
	public void talkAdd(Talk talk) throws SQLException {
		// TODO Auto-generated method stub
		td.talkAdd(talk);
	}

	@Override
	public void talkDel(Talk talk) throws Exception {
		// TODO Auto-generated method stub
		td.talkDelete(talk);
	}

	@Override
	public List<ReplyTalk> replyFind() throws Exception {
		// TODO Auto-generated method stub
		return td.replySelect();
	}

	@Override
	public List<praise> praiseFind() throws Exception {
		// TODO Auto-generated method stub
		return td.praiseSelect();
	}

	@Override
	public void praiseAdd(praise praise) {
		// TODO Auto-generated method stub
		td.praiseInsert(praise);
	}

	@Override
	public void talkCollect_add(collect collect) throws Exception {
		// TODO Auto-generated method stub
		td.talkCollect_add(collect);
	}

	@Override
	public void talkCollect_delete(collect collect) throws SQLException {
		// TODO Auto-generated method stub
		td.talkCollect_delete(collect);
	}

	@Override
	public ArrayList<collect> talkCollect_find(collect collect) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return td.talkCollect_find(collect);
	}

	@Override
	public void replyAdd(ReplyTalk reply) throws Exception {
		// TODO Auto-generated method stub
		td.replyTalkAdd(reply);
	}

}
