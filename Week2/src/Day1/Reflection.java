package Day1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
	public static void main(String args[]){
		Class<?> demo=null;
		Object object=null;
		try {
			demo=Class.forName("Day1.Person");
			object=demo.newInstance();
			//改变静态变量
			Field field=demo.getDeclaredField("name");
			field.setAccessible(true); //在类的外面获取此类的私有成员变量
			field.set(object, "vled");
			//调用方法
			Method method=demo.getMethod("getName");
			method.invoke(object);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
