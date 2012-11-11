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
	//ͣ������
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
	//ȡ��
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
		
		//case 4//һ����ͣ����ȡ��
		manager.Clear();
		obj=manager.PopCar(1);
		Assert.assertNull(obj);//��
		
		//case 5//һ����Чͣ��ƾ֤ȡ�� ȡ��ԭ���ĳ�
		manager.Clear();
		CarBean car= new CarBean();
		result=	manager.PushCar(1, car);
		Assert.assertEquals(ParkManager.MaxCount-1, manager.Display());
		obj=manager.PopCar(1);
		Assert.assertEquals(car,obj);		

		//case 6 ��Чͣ��֤��ȡ������
		manager.Clear();
		obj=manager.PopCar(100);
		Assert.assertNull(obj);		
		
		//case 7��Чͣ��֤��ȡ���Σ���һ�γɹ����ڶ���ʧ��
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
	//��ʾ��λ��
	@Test
	public void Display()
	{
		
	}
}
