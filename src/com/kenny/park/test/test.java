package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;

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
		int result=	manager.PushCar(1, new Object());

		Assert.assertEquals(99, manager.Display());
		
//		for(int i=0;i<ParkManager.MaxCarCount;i++)
//		{
//			int result=	manager.PushCar(i, new Object());
//		}
	}
	//取车
	@Test
	public void Pop()
	{
//		ParkManager manager=new ParkManager();
//		for(int i=0;i<manager.Display();i++)
//		{
//			Object obj=manager.Pop(i);
//			Assert.assertNotNull(obj);
//		}
	}
	//显示空位数
	@Test
	public void Display()
	{
		
	}
}
