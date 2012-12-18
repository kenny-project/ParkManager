package com.kenny.park;

import java.util.HashMap;

import com.kenny.park.bean.Car;

///停车场
public class ParkPlance
{
	private int MaxCount = 100;
	private int id;// 停车场ID

	private HashMap<Integer, Car> map = new HashMap<Integer, Car>();
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public void Init()
	{
		map.clear();
	}

	public void Clear()
	{
		map.clear();
	}
	public int getMaxCount()
	{
		return MaxCount;
	}
	public void setMaxCount(int maxCount)
	{
		MaxCount = maxCount;
	}

	// 停车
	// id:存车ID object：car
	public int PushCar(int id, Car car)
	{
		if (!bFull())
		{
			if (!map.containsKey(id))
			{
				map.put(id, car);
				return 1;
			}
		}
		return 0;
	}

	// 取车
	// id:存车ID
	public Car PopCar(int id)
	{
		if (map.containsKey(id)) { return map.remove(id); }
		return null;
	}

	// 显示空位数
	public int Display()
	{
		return MaxCount - map.size();
	}

	// 车库是否已满
	public boolean bFull()
	{
		if (MaxCount <= map.size())
		{

			return true;
		}
		else
		{
			return false;
		}
	}

	// 是否为空
	public boolean bEmpty()
	{
		if (0 == map.size())
		{

			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * 获取空置率
	 * 
	 * @return
	 */
	public int getVacancy()
	{
		return (map.size() * 100) / (MaxCount * 100);
	}
	public String getChart()
	{
		String chart = "停车场编号：" + id + "\n车位数：" + MaxCount + "\n空位数："
				+ Display();
		return chart;

	}
}
