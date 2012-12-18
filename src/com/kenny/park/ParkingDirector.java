package com.kenny.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kenny.park.bean.Car;

public class ParkingDirector 
{
	protected int nType=ParkPlances.nParkingDirector;
	List<IParkingBoy> mParkList = new ArrayList<IParkingBoy>();
	List<ParkPlance> mParkPlanceList;
	private ParkPlance mParkPlance=null;
	public void AddParkingBoy(IParkingBoy mParkingBoy)
	{
		mParkList.add(mParkingBoy);
	}
	public void SetParkPlance(ParkPlance parkPlance)
	{
		mParkPlance=parkPlance;
	}
	public void setParkList(List<ParkPlance> mParkList)
	{
		this.mParkPlanceList=mParkList;
	}
	public String Chart()
	{
		String result="";
		for (ParkPlance mParkPlance : mParkPlanceList)
		{
			result+=mParkPlance.getChart()+"\n";
		}
		for (IParkingBoy boy : mParkList)
		{
			result+=boy.Chart();
		}
		return result;
	}
}
