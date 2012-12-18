package com.kenny.park;

import java.util.ArrayList;
import java.util.List;

import com.kenny.park.bean.Car;

public class ParkPlances
{
	public final static int nParkingBoy=0;//停车仔
	public final  static int nSmartParkingBoy=1;//聪明停车仔
	public final  static int nSuperParkingBoy=2;//Super停车仔
	public final  static int nParkingManager=3;//停车场经理
	public final  static int nParkingDirector=4;//停车场经理
	List<ParkPlance> mParkList = new ArrayList<ParkPlance>();
	public List<ParkPlance> getParkList()
	{
		return mParkList;
	}
	int maxCount = 0;
	public void Init()
	{
		ParkPlance park1 = new ParkPlance();
		park1.setId(1);
		park1.setMaxCount(10);
		ParkPlance park2 = new ParkPlance();
		park2.setId(2);
		park2.setMaxCount(10);
		mParkList.add(park1);
		mParkList.add(park2);
		for (ParkPlance park : mParkList)
		{
			maxCount += park.getMaxCount();
		}
	}
	public int getMaxCount()
	{
		return maxCount;
	}
	public void Clear()
	{
		for (ParkPlance park : mParkList)
		{
			park.Clear();
		}
	}
	// 取车
	// id:存车ID
	public Car PopCar(int id)
	{
		for (ParkPlance park : mParkList)
		{
			Car car = park.PopCar(id);
			if (null != car) { return car; }
		}
		return null;
	}
	// 显示空位数
	public int Display()
	{
		int count = 0;
		for (ParkPlance park : mParkList)
		{
			count += park.Display();
		}
		return count;
	}
	public boolean bFull()
	{
		for (ParkPlance park : mParkList)
		{
			if (!park.bFull()) { return false; }
		}
		return true;
	}
	// 是否为空
	public boolean bEmpty()
	{
		for (ParkPlance park : mParkList)
		{
			if (park.bEmpty()) { return false; }
		}
		return true;
	}
}
