package com.kenny.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kenny.park.bean.Car;

public class ParkPlances
{
	public static int nParkingBoy=0;//停车仔
	public static int nSmartParkingBoy=1;//聪明停车仔
	public static int nSuperParkingBoy=2;//Super 停车仔
	public static int nParkingManager=3;//停车场经理
	List<ParkPlance> mParkList = new ArrayList<ParkPlance>();
	int maxCount = 0;
	public void Init()
	{
		ParkPlance park1 = new ParkPlance();
		park1.setMaxCount(10);
		ParkPlance park2 = new ParkPlance();
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
	// 停车
	// id:存车ID object：car type: 1:聪明的小弟 2：傻的小弟 3: super boy
	// 4:Parking Manager
	public int PushCar(int type, int id, Car car) throws Exception
	{
		if (type == nParkingManager)
		{// Parking Manager
			type = new Random().nextInt(nParkingManager+1);
			if (type == nParkingManager)
			{
				PushCar(id, car);
			}
			else
			{
				return PushCar(type, id, car);
			}
		}
		if (type == nSuperParkingBoy)
		{// 停在空置率最高的那个停车场
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
		}
		else if (type == nSmartParkingBoy)
		{// 空位最高的车痊
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

		}
		else if(type==nParkingBoy)
		{
			PushCar(id, car);
		}
		else
		{
			throw new Exception("未找到相应的停车仔");
		}
		return 0;
	}
	public int PushCar(int id, Car car)
	{
		for (ParkPlance park : mParkList)
		{
			if (!park.bFull()) { return park.PushCar(id, car); }
		}
		return 0;
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
