package com.kenny.park.test;

import org.junit.Test;

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
		for(int i=0;i<ParkManager.MaxCarCount;i++)
		{
			manager.PushCar(i, new Object());
		}
	}
	//ȡ��
	@Test
	public void Pop()
	{
		
	}
	//��ʾ��λ��
	@Test
	public void Display()
	{
		
	}
}
