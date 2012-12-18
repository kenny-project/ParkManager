package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public class SmartParkingBoy implements IParkingBoy
{
	protected int nType=ParkPlances.nSmartParkingBoy;
	
	public int PushCar(List<ParkPlance> mParkList, int id, Car car)
	{
		int maxDisplay = 0;
		ParkPlance temp = null;
		for (ParkPlance park : mParkList)
		{
			if (maxDisplay < park.Display())
			{
				temp = park;
			}
		}
		if (temp != null) { return temp.PushCar(id, car); }
		return 0;
	}
}
