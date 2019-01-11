package mapper;

import java.util.ArrayList;

import entity.view;

public interface viewDao {

	public void add(view v);
	public void delete(view v);
	public ArrayList<view> get(view v);
}
