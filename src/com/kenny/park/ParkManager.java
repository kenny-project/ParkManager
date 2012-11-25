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

	// ͣ��
	// id:�泵ID object��car
	public int PushCar(int id, Car car) {

		if (!bFull()) {
			if (!map.containsKey(id)) {
				map.put(id, car);
				return 1;
			}
		}
		return 0;
	}

	// ȡ��
	// id:�泵ID
	public Car PopCar(int id) {
		if (map.containsKey(id)) {
			return map.remove(id);
		}
		return null;
	}

	// ��ʾ��λ��
	public int Display() {
		return MaxCount - map.size();
	}

	// �����Ƿ�����
	public boolean bFull() {
		if (MaxCount <= map.size()) {

			return true;
		} else {
			return false;
		}
	}

	// �Ƿ�Ϊ��
	public boolean bEmpty() {
		if (0 == map.size()) {

			return true;
		} else {
			return false;
		}
	}

}
