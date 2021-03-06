package org.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Andy Class API -
 */
public class ClassUtil {

	public static void main(String[] args) {
		String s = "hello";
		int a = 123;
//		printClassMessage(s);
		printConMessage(s);
	}

	/**
	 * 打印类的信息,包括类的函数,类的成员变量
	 * 
	 * @param obj
	 *            该对象所属类的信息
	 */
	public static void printClassMessage(Object obj) {
		// 获取类的信息,首先要获取类的类类型 ClassType
		Class c1 = obj.getClass(); // 传递的是哪个子类的对象 , c就是该子类的类类型
		// 获取类的名称
		System.out.println("类的名称是:" + c1.getName());
		/**
		 * Method类 ,方法对象 一个成员方法,就是一个Method 对象,
		 * getMethods()获取的是所有public的函数,包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己申明的方法,.不问访问权限
		 */
		Method[] ms = c1.getMethods();// c1.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			// 得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + "");
			// 得到方法的名称
			System.out.print(ms[i].getName() + "(");
			// 获取参数类型-->得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}

		/**
		 * 成员变量也是对象 java.lang.reflect.Field Field 封装了关于成员变量的操作
		 * getFields()获取的是所有的public的成员变量 getDeclaredFields()获取的是该类自己申明的成员变量的信息
		 */
		// Field[] fs = c1.getFields();
		Field[] fs = c1.getDeclaredFields();
		for (Field field : fs) {
			// 得到成员变量类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			// 得到成员变量的名称
			String fieldName = field.getName();
			System.out.println(typeName + "" + fieldName);
		}

	}

	/**
	 * 打印对的构造函数的信息
	 * 
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		Class c = obj.getClass();
		/**
		 * 构造函数也是对象
		 * java.lang.Constructor 中封装了构造函数的信息
		 * getConstructors()获取所有的public的构造函数
		 * getDeclaredConstructors()得到所有的构造函数
		 */
		Constructor[] cs = c.getConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");
			//获取构造函数的参数列表-> 得到参数列表的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
