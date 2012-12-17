package com.kenny.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kenny.park.bean.Car;

public class ParkPlances
{
	public static int nParkingBoy=0;//ͣ����
	public static int nSmartParkingBoy=1;//����ͣ����
	public static int nSuperParkingBoy=2;//Super ͣ����
	public static int nParkingManager=3;//ͣ��������
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
	// ͣ��
	// id:�泵ID object��car type: 1:������С�� 2��ɵ��С�� 3: super boy
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
		{// ͣ�ڿ�������ߵ��Ǹ�ͣ����
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
		{// ��λ��ߵĳ�Ȭ
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
			throw new Exception("δ�ҵ���Ӧ��ͣ����");
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
