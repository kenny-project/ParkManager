package com.kenny.park;

import java.util.HashMap;

public class ParkManager {
	public static final int MaxCount = 100;
	private HashMap<Integer, Object> map = new HashMap<Integer, Object>();

	public void Init() {
		map.clear();
	}

	// ͣ��
	// id:�泵ID object��car
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

	// ȡ��
	// id:�泵ID
	public Object PopCar(int id) {
		if (map.containsKey(id)) 
		{
			Object obj=map.get(id);
			map.remove(id);
			return obj;
		}
		return null;
	}

	// ��ʾ��λ��
	public int Display() {
		return MaxCount-map.size();
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
