package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public interface IParkingBoy
{
	public void setParkList(List<ParkPlance> mParkList);
	public int PushCar(int id, Car car);
	public String Chart();
}
