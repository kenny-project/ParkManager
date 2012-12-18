package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kenny.park.ParkPlances;
import com.kenny.park.ParkingBoy;
import com.kenny.park.bean.Car;

public class test
{
	// 停车测试
	@Test
	// case 1
	public void ParkingBoy_case1()
	{
		// case 1
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());
		boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		manager.Clear();
	}

	@Test
	public void ParkingBoy_case3()
	{
		// case 3
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());
		for (int i = 0; i < manager.getMaxCount(); i++)
		{
			boy.PushCar(i, new Car());
		}
		Assert.assertTrue(manager.bFull());
		int result = boy.PushCar(5000, new Car());
		Assert.assertEquals(0, result);
	}
	// 存取车比较是否为同一辆车
	// case 2
	@Test
	public void ParkingBoy_case2()
	{
		// case 2
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());
		int result = boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertNotNull(obj);
		Assert.assertEquals(manager.getMaxCount(), manager.Display());
	}
	// 存取车比较是否为同一辆车
	// case 4//一个空停车场取车
	@Test
	public void ParkingBoy_case4()
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());

		manager.Clear();
		Car obj = manager.PopCar(1);
		Assert.assertNull(obj);// 空
	}

	// case 5//一个有效停车凭证取车 取出原来的车
	@Test
	public void ParkingBoy_case5()
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());

		manager.Clear();
		Car car = new Car();
		int result = boy.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertEquals(car, obj);
	}
	// case 6 无效停车证。取不出车
	@Test
	public void ParkingBoy_case6()
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());
		manager.Clear();
		Car obj = manager.PopCar(100);
		Assert.assertNull(obj);
	}
	// case 7有效停车证，取两次，第一次成功，第二次失败
	@Test
	public void ParkingBoy_case7()
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		ParkingBoy boy = new ParkingBoy();
		boy.setParkList(manager.getParkList());
		manager.Clear();
		int result = boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertNotNull(obj);
		obj = manager.PopCar(1);
		Assert.assertNull(obj);

	}
}
