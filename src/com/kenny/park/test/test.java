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
		//case 1
		ParkManager manager=new ParkManager();
		int result=	manager.PushCar(1, new Object());

		Assert.assertEquals(99, manager.Display());
		manager.Clear();
		
		//case 3
		for(int i=0;i<ParkManager.MaxCount;i++)
		{
			manager.PushCar(i, new Object());
		}
		Assert.assertTrue(manager.bFull());
		result=manager.PushCar(5000,new Object());
		Assert.assertEquals(0, result);
	}
	//取车
	@Test
	public void Pop()
	{
		//case 2
		ParkManager manager=new ParkManager();
		int result=	manager.PushCar(1, new Object());
		Assert.assertEquals(ParkManager.MaxCount-1, manager.Display());
		Object obj=manager.PopCar(1);
		Assert.assertNotNull(obj);		
		Assert.assertEquals(ParkManager.MaxCount, manager.Display());
		
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
