package com.kenny.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kenny.park.bean.Car;

public class ParkPlances
{
	public final static int nParkingBoy=0;//ͣ����
	public final  static int nSmartParkingBoy=1;//����ͣ����
	public final  static int nSuperParkingBoy=2;//Superͣ����
	public final  static int nParkingManager=3;//ͣ��������
	public final  static int nParkingDirector=4;//ͣ��������
	List<ParkPlance> mParkList = new ArrayList<ParkPlance>();
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
	/**
	 * 	type: 
	 * 1:������С��
	 * 2��ɵ��С�� 
	 * 3: super boy
	 * 4:Parking Manager
	 * @param type
	 * @return
	 */
	public String getChart(int type)
	{
		String result="";
		switch(type)
		{
			case nParkingManager:
				break;
			case nParkingDirector:
				break;
			case nSmartParkingBoy:
			case nSuperParkingBoy:
			case nParkingBoy:
				getParkingBoyChart(type);
				break;
		}
	}
	/**
	 * ����ָ��parkingBoy Chart��������
	 * @return
	 */
	private String getParkingBoyChart(int type)
	{
		String result="ͣ���б��:"+type;
		for (ParkPlance park : mParkList)
		{
			result+=park.getChart()+"\n";
		}
		return result;
	}
	// ͣ��
	// id:�泵ID object��car type: 1:������С�� 2��ɵ��С�� 3: super boy
	// 4:Parking Manager
	public int PushCar(int type, int id, Car car) throws Exception
	{
		if (type == nParkingManager)
		{// Parking Manager

		}
		{
			throw new Exception("δ�ҵ���Ӧ��ͣ����");
		}
		return 0;
	}
	// ȡ��
	// id:�泵ID
	public Car PopCar(int id)
	{
		for (ParkPlance park : mParkList)
		{
			Car car = park.PopCar(id);
			if (null != car) { return car; }
		}
		return null;
	}
	// ��ʾ��λ��
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
	// �Ƿ�Ϊ��
	public boolean bEmpty()
	{
		for (ParkPlance park : mParkList)
		{
			if (park.bEmpty()) { return false; }
		}
		return true;
	}
}
