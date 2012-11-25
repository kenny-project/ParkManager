package com.kenny.park;

import java.util.HashMap;

import com.kenny.park.bean.Car;

public class ParkManager {
	private int MaxCount = 100;
	private HashMap<Integer, Car> map = new HashMap<Integer, Car>();

	public void Init() {
		map.clear();
	}

	public void Clear() {
		map.clear();
	}
	public int getMaxCount()
	{
		return MaxCount;
	}
	public void setMaxCount(int maxCount) {
		MaxCount = maxCount;
	}

	// 停车
	// id:存车ID object：car
	public int PushCar(int id, Car car) {

		if (!bFull()) {
			if (!map.containsKey(id)) {
				map.put(id, car);
				return 1;
			}
		}
		return 0;
	}

	// 取车
	// id:存车ID
	public Car PopCar(int id) {
		if (map.containsKey(id)) {
			return map.remove(id);
		}
		return null;
	}

	// 显示空位数
	public int Display() {
		return MaxCount - map.size();
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
