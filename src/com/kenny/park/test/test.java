package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kenny.park.ParkManager;
import com.kenny.park.ParkPlances;
import com.kenny.park.bean.Car;

public class test 
{
	//停车测试
	@Test
	public void Push()
	{
		//case 1
		ParkPlances manager=new ParkPlances();
		manager.Init();
		int result=	manager.PushCar(1, new Car());

		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		manager.Clear();
		
		//case 3
		for(int i=0;i<manager.getMaxCount();i++)
		{
			manager.PushCar(i, new Car());
		}
		Assert.assertTrue(manager.bFull());
		result=manager.PushCar(5000,new Car());
		Assert.assertEquals(0, result);
		
		
		
	}
	//取车
	@Test
	public void Pop()
	{
		//case 2
		ParkPlances manager=new ParkPlances();
		manager.Init();
		int result=	manager.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		Car obj=manager.PopCar(1);
		Assert.assertNotNull(obj);		
		Assert.assertEquals(manager.getMaxCount(), manager.Display());
		
		//case 4//一个空停车场取车
		manager.Clear();
		obj=manager.PopCar(1);
		Assert.assertNull(obj);//空
		
		//case 5//一个有效停车凭证取车 取出原来的车
		manager.Clear();
		Car car= new Car();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertEquals(car,obj);		

		//case 6 无效停车证。取不出车
		manager.Clear();
		obj=manager.PopCar(100);
		Assert.assertNull(obj);		
		
		//case 7有效停车证，取两次，第一次成功，第二次失败
		manager.Clear();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertNotNull(obj);	
		obj=manager.PopCar(1);
		Assert.assertNull(obj);
		
	}
}
