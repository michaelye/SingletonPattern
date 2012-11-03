package com.michael.singletonpattern;


/**
 * 同步确保不会因为可能由于多个线程同时访问到
 * if(uniqueInstance == null)
 * 而造成，可能生成不止一个实例的情况
 * synchronized关键字是用来迫使每个线程在进入这个方法之前，需要等其它线程先离开该方法
 * 也就是说确保了不会有两个线程同时进入这个方法，这样就杜绝了可能产生多个实例的可能
 * 
 * 但是这样做会降低性能。同步一个方法可能会造成持续执行效率下降100倍，所以不能把这个方法用在频繁运行的地方
 * 如果你确保程序可以接受这个问题，那就没什么关系。
 * 
 * 与普通的单例模式相比就多了一个synchronized而已
 * */
public class SingletonSynchronized {

	private static SingletonSynchronized uniqueInstance;
	
	private SingletonSynchronized(){}
	
	public static synchronized SingletonSynchronized getInstance()
	{
		if(uniqueInstance == null)
		{
			uniqueInstance = new SingletonSynchronized();
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
