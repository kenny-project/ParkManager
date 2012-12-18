package com.kenny.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kenny.park.bean.Car;

public class ParkingManager implements IParkingBoy
{
	protected int nType=ParkPlances.nSuperParkingBoy;
	List<IParkingBoy> mParkList = new ArrayList<IParkingBoy>();
	private ParkPlance mParkPlance=null;
	public void AddParkingBoy(IParkingBoy mParkingBoy)
	{
		mParkList.add(mParkingBoy);
	}
	public void SetParkPlance(ParkPlance parkPlance)
	{
		mParkPlance=parkPlance;
	}
	public int PushCar(List<ParkPlance> mParkList, int id, Car car)
	{
		int index = new Random().nextInt(mParkList.size()+1);
		if(index==mParkList.size())
		{
			for (ParkPlance park : mParkList)
			{
				if (!park.bFull()) { return park.PushCar(id, car); }
			}
			return 0;
		}
		else
		{
			mParkList.get(index).PushCar(id, car);
		}
		return 0;
	}
	public String Chart()
	{
		String result="";
		if(mParkPlance!=null)
		result+=mParkPlance.getChart()+"\n";
		for (IParkingBoy boy : mParkList)
		{
			result+=boy.Chart();
		} 
		return result;
	}
}
