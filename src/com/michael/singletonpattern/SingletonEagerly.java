package com.michael.singletonpattern;


/**
 * 急切创建实例
 * 
 * 这种做法依赖于虚拟机加载这个类的时候马上就创建唯一的单例。
 * 所以说就不存在有多个实例的问题了。
 * 
 * */
public class SingletonEagerly {

	private static SingletonEagerly uniqueInstance = new SingletonEagerly();//虚拟机加载这个类的时候，这个类就已经被创建
	
	private SingletonEagerly(){}
	
	public static SingletonEagerly getInstance()
	{
		return uniqueInstance;//不需要判断是否为null，直接返回就可以了
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
