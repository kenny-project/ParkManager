package com.kenny.park.test;

import junit.framework.Assert;

import org.junit.Test;

import com.kenny.park.ParkManager;
import com.kenny.park.ParkPlances;
import com.kenny.park.bean.Car;

public class test 
{
	//ͣ������
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
	//ȡ��
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
		
		//case 4//һ����ͣ����ȡ��
		manager.Clear();
		obj=manager.PopCar(1);
		Assert.assertNull(obj);//��
		
		//case 5//һ����Чͣ��ƾ֤ȡ�� ȡ��ԭ���ĳ�
		manager.Clear();
		Car car= new Car();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertEquals(car,obj);		

		//case 6 ��Чͣ��֤��ȡ������
		manager.Clear();
		obj=manager.PopCar(100);
		Assert.assertNull(obj);		
		
		//case 7��Чͣ��֤��ȡ���Σ���һ�γɹ����ڶ���ʧ��
		manager.Clear();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(manager.getMaxCount()-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertNotNull(obj);	
		obj=manager.PopCar(1);
		Assert.assertNull(obj);
		
	}
}
