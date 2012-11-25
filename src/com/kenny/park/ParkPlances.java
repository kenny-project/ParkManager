package com.kenny.park;

import java.util.ArrayList;
import java.util.List;

import com.kenny.park.bean.Car;

public class ParkPlances 
{
	List<ParkManager> mParkList=new ArrayList<ParkManager>();
	int maxCount=0;
	public void Init() 
	{
		ParkManager park1=new ParkManager();
		park1.setMaxCount(10);
		ParkManager park2=new ParkManager();
		park2.setMaxCount(10);
		mParkList.add(park1);
		mParkList.add(park2);
		for (ParkManager park : mParkList) {
			maxCount+=park.getMaxCount();
		}		
	}
	public int getMaxCount()
	{
		return maxCount;
	}
	public void Clear() 
	{
		for (ParkManager park : mParkList) {
			park.Clear();
		}
	}
	// ͣ��
	// id:�泵ID object��car type: 1:������С�� 2��ɵ��С��
	public int PushCar(int type,int id, Car car) 
	{
		if(type==1)
		{
			int maxDisplay=0;
			ParkManager temp=null;
		for (ParkManager park : mParkList) 
		{
			if (maxDisplay<park.Display()) 
			{
				temp=park;
			}
		}
		if(temp!=null)
		{
		return temp.PushCar(id, car);
		}
		
		}
		else
		{
			for (ParkManager park : mParkList) 
			{
				if (!park.bFull()) 
				{
					return park.PushCar(id, car);
				}
			}			
		}
		return 0;
	}
	// ȡ��
	// id:�泵ID
	public Car PopCar(int id) 
	{
		for (ParkManager park : mParkList) 
		{
			Car car=park.PopCar(id);
			if (null!=car) 
			{
				return car;
			}
		}
		return null;
	}
	// ��ʾ��λ��
	public int Display() 
	{
		int count=0;
		for (ParkManager park : mParkList) 
		{
			count+=park.Display();
		}
		return count;
	}
	public boolean bFull() 
	{
		for (ParkManager park : mParkList) 
		{
			if(!park.bFull())
			{
				return false;
			}
		}
		return true;
	}
	// �Ƿ�Ϊ��
	public boolean bEmpty() {
		for (ParkManager park : mParkList) 
		{
			if(park.bEmpty())
			{
				return false;
			}
		}
		return true;
	}
}

