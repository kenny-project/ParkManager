package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kenny.park.ParkManager;
import com.kenny.park.bean.CarBean;

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
		
		//case 4//一个空停车场取车
		manager.Clear();
		obj=manager.PopCar(1);
		Assert.assertNull(obj);//空
		
		//case 5//一个有效停车凭证取车 取出原来的车
		manager.Clear();
		CarBean car= new CarBean();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(ParkManager.MaxCount-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertEquals(car,obj);		

		//case 6 无效停车证。取不出车
		manager.Clear();
		obj=manager.PopCar(100);
		Assert.assertNull(obj);		
		
		//case 7有效停车证，取两次，第一次成功，第二次失败
		manager.Clear();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(ParkManager.MaxCount-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertNotNull(obj);	
		obj=manager.PopCar(1);
		Assert.assertNull(obj);
		
		
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
