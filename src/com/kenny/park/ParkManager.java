package com.kenny.park;

import java.util.HashMap;

public class ParkManager {
	public static final int MaxCount = 100;
	private HashMap<Integer, Object> map = new HashMap<Integer, Object>();

	public void Init() {
		map.clear();
	}

	// 停车
	// id:存车ID object：car
	public int PushCar(int id, Object car) {

		if(!bFull())
		{
		if (!map.containsKey(id)) {
			map.put(id, car);
			return 1;
		}
		}
		return 0;
	}

	// 取车
	// id:存车ID
	public Object PopCar(int id) {
		if (map.containsKey(id)) 
		{
			Object obj=map.get(id);
			map.remove(id);
			return obj;
		}
		return null;
	}

	// 显示空位数
	public int Display() {
		return MaxCount-map.size();
	}

	// 车库是否已满
	public boolean bFull() {
		if (MaxCount <= map.size()) {

			return true;
		} else {
			return false;
		}
	}

	// 是否为空
	public boolean bEmpty() {
		if (0 == map.size()) {

			return true;
		} else {
			return false;
		}
	}

}
