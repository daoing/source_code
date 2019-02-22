package fieldSet;

import java.lang.reflect.Field;

public class Set_test2 {
	
	public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        System.out.println(createFromClass("fieldSet.Bird2"));
    }

    public static Object createFromClass(String classStr) throws Exception{
        // 1. 取得Class对象
    	Class<?> clazz = Class.forName(classStr); 
    	// 2. 反射实例化对象
        Object object = clazz.newInstance();
        // 3. 获取所有的属性
        Field[] fields = clazz.getDeclaredFields();
       
        for(Field field: fields){
        	field.setAccessible(true); //允许访问 private 属性
        	
            String name = field.getName();
            if(name.equals("name")){
            	field.set(object, "飞鸟");
            }
            if(name.equals("age")){
            	field.set(object, 30);
            }
        }
        return object;
    }

}
