package com.kenny.park;

import java.util.List;

import com.kenny.park.bean.Car;

public class ParkingBoy implements IParkingBoy
{
	protected int nType=ParkPlances.nParkingBoy;
	protected List<ParkPlance> mParkList;
	public void setParkList(List<ParkPlance> mParkList)
	{
		this.mParkList = mParkList;
	}
	public int PushCar( int id, Car car)
	{
		this.mParkList=mParkList;
		for (ParkPlance park : mParkList)
		{
			if (!park.bFull()) { return park.PushCar(id, car); }
		}
		return 0;
	}
	public String Chart()
	{
		String result="ͣ���б��:"+nType;
		int TotalVacancy =0;
		int TotalAllSpace=0;
		for (ParkPlance park : mParkList)
		{
			result+=park.getChart()+"\n";
			TotalVacancy+=park.Display();
			TotalAllSpace+=park.getMaxCount();
		}
		result+="Total��λ��:"+TotalAllSpace+"\nTotal��λ����"+TotalVacancy+"\n";
		return result;
	}
}
