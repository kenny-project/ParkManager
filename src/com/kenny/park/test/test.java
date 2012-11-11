package com.kenny.park.test;

import org.junit.Test;

import com.kenny.park.ParkManager;

public class test 
{

	@Test
	public void Init()
	{
		
	}
	//停车测试
	@Test
	public void Push()
	{
		ParkManager manager=new ParkManager();
		for(int i=0;i<ParkManager.MaxCarCount;i++)
		{
			manager.PushCar(i, new Object());
		}
	}
	//取车
	@Test
	public void Pop()
	{
		
	}
	//显示空位数
	@Test
	public void Display()
	{
		
	}
}
