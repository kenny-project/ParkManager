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
	//ͣ������
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
	//ȡ��
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
	//��ʾ��λ��
	@Test
	public void Display()
	{
		
	}
}
