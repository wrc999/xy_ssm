package service.view;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.view;
import mapper.viewDao;

@Service
@Transactional
public class viewServiceImpl implements viewService {
	@Autowired
	private viewDao vd;

	@Override
	public void add(view v) {
		// TODO Auto-generated method stub
		vd.add(v);
	}

	@Override
	public void delete(view v) {
		// TODO Auto-generated method stub
		vd.delete(v);
	}

	@Override
	public ArrayList<view> get(view v) {
		// TODO Auto-generated method stub
		return vd.get(v);
	}

}
