package com.michael.singletonpattern;

/**
 * 普通的单例模式
 * 
 * */
public class SingletonCommon {

	private static SingletonCommon uniqueInstance;
	
	private SingletonCommon(){}
	
	public static SingletonCommon getInstance()
	{
		if(uniqueInstance == null)
		{
			uniqueInstance = new SingletonCommon();
		}
		return uniqueInstance;
	}
	
	//下面你还可以添加其他的有用的方法
	
	/**
	 * 获取单例信息,如果内存地址一样就说明，是同一个对象
	 * 
	 * */
	public String getSingletonInfo()
	{
		return uniqueInstance.toString();
	}
}
