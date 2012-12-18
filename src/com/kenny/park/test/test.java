package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kenny.park.IParkingBoy;
import com.kenny.park.ParkPlances;
import com.kenny.park.ParkingBoy;
import com.kenny.park.ParkingDirector;
import com.kenny.park.ParkingManager;
import com.kenny.park.SmartParkingBoy;
import com.kenny.park.SuperParkingBoy;
import com.kenny.park.bean.Car;

public class test
{
	@Test
	public void ParkingBoy_AutoPushOrPop()
	{
		ParkingBoy_PushOrPop(new ParkingBoy());
		ParkingBoy_PushOrPop(new SuperParkingBoy());
		ParkingBoy_PushOrPop(new SmartParkingBoy());
		ParkingBoy_PushOrPop(new ParkingManager());
	}
	@Test
	public void ParkingBoy_AutoChart()
	{
		new ParkingBoy().Chart();
		new SuperParkingBoy().Chart();
		new SmartParkingBoy().Chart();
		new ParkingManager().Chart();
		new ParkingDirector().Chart();
	}
	
	public void ParkingBoy_PushOrPop(IParkingBoy boy)
	{
		ParkingBoy_case1(boy);
		ParkingBoy_case2(boy);
		ParkingBoy_case3(boy);
		ParkingBoy_case4(boy);
		ParkingBoy_case5(boy);
		ParkingBoy_case6(boy);
		ParkingBoy_case7(boy);
	}
	// ͣ������
	public void ParkingBoy_case1(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		manager.Clear();
	}

	public void ParkingBoy_case3(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		for (int i = 0; i < manager.getMaxCount(); i++)
		{
			boy.PushCar(i, new Car());
		}
		Assert.assertTrue(manager.bFull());
		int result = boy.PushCar(5000, new Car());
		Assert.assertEquals(0, result);
	}
	// ��ȡ���Ƚ��Ƿ�Ϊͬһ����
	// case 2
	public void ParkingBoy_case2(IParkingBoy boy)
	{
		// case 2
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		int result = boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertNotNull(obj);
		Assert.assertEquals(manager.getMaxCount(), manager.Display());
	}
	// ��ȡ���Ƚ��Ƿ�Ϊͬһ����
	// case 4//һ����ͣ����ȡ��
	public void ParkingBoy_case4(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		manager.Clear();
		Car obj = manager.PopCar(1);
		Assert.assertNull(obj);// ��
	}

	// case 5//һ����Чͣ��ƾ֤ȡ�� ȡ��ԭ���ĳ�
	public void ParkingBoy_case5(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());

		manager.Clear();
		Car car = new Car();
		int result = boy.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertEquals(car, obj);
	}
	// case 6 ��Чͣ��֤��ȡ������
	public void ParkingBoy_case6(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		manager.Clear();
		Car obj = manager.PopCar(100);
		Assert.assertNull(obj);
	}
	// case 7��Чͣ��֤��ȡ���Σ���һ�γɹ����ڶ���ʧ��
	public void ParkingBoy_case7(IParkingBoy boy)
	{
		ParkPlances manager = new ParkPlances();
		manager.Init();
		boy.setParkPlanceList(manager.getParkList());
		manager.Clear();
		int result = boy.PushCar(1, new Car());
		Assert.assertEquals(manager.getMaxCount() - 1, manager.Display());
		Car obj = manager.PopCar(1);
		Assert.assertNotNull(obj);
		obj = manager.PopCar(1);
		Assert.assertNull(obj);
	}
}
