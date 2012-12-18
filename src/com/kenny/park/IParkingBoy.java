package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public interface IParkingBoy
{
	
	public int PushCar(List<ParkPlance> mParkList, int id, Car car);
	public String Chart();
}
