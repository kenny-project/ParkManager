package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public class SuperParkingBoy extends ParkingBoy
{
	public SuperParkingBoy()
	{
		nType=ParkPlances.nSuperParkingBoy;
	}
	public int PushCar(List<ParkPlance> mParkList, int id, Car car)
	{
		int maxVacancy = 0;
		ParkPlance temp = null;
		for (ParkPlance park : mParkList)
		{
			if (maxVacancy < park.getVacancy())
			{
				temp = park;
			}
		}
		if (temp != null) { return temp.PushCar(id, car); }
		return 0;
	}
}
