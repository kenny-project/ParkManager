package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public class SmartParkingBoy extends ParkingBoy
{
	public SmartParkingBoy()
	{
		nType=ParkPlances.nSmartParkingBoy;
	}
	public int PushCar(int id, Car car)
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
