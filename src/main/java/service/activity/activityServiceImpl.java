package service.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.activityDao;
import entity.acollect;
import entity.activity;
import entity.activityjoins;

@Service
@Transactional
public class activityServiceImpl implements activityService {
	@Autowired
	private activityDao ad;

	@Override
	public void add(activity activity) {
		// TODO Auto-generated method stub
		ad.add(activity);
	}

	@Override
	public void delete(activity activity) {
		// TODO Auto-generated method stub
		ad.delete(activity);
	}

	@Override
	public List<activity> get(Integer use_id) {
		// TODO Auto-generated method stub
		return ad.get(use_id);
	}

	@Override
	public void joinsAdd(activityjoins a) {
		// TODO Auto-generated method stub
		ad.joinsAdd(a);
	}

	@Override
	public void collectAdd(acollect a) {
		// TODO Auto-generated method stub
		ad.collectAdd(a);
	}

	@Override
	public List<activity> collectGet(Integer use_id) {
		// TODO Auto-generated method stub
		return ad.collectGet(use_id);
	}
	
}
