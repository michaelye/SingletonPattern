package com.michael.singletonpattern;


/**
 * 双重检查加锁 double-checked locking
 * 
 * SingletonSynchronized方法效率不高，因为每次访问都需要同步。
 * 我们可以利用双重检查加锁，首先检查是否已经创建了实例，如果还没有创建，才进行同步
 * 这样一来就只有第一次会同步。这样就可以提高效率。
 * 
 * 需要使用volatile关键字,这个关键字确保当uniqueInstance变量被初始化成SingletonDoubleLocking实例时，
 * 多个线程正确地处理uniqueInstance变量。
 * 
 * 需要注意的是：双重检查加锁不适用于1.4及更早版本的Java
 * 
 * */
public class SingletonDoubleLocking {

	private volatile static SingletonDoubleLocking uniqueInstance;
	
	private SingletonDoubleLocking(){}
	
	public static SingletonDoubleLocking getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized (SingletonDoubleLocking.class) 
			{
				if(uniqueInstance == null)
				{
					uniqueInstance = new SingletonDoubleLocking();
				}
			}
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
