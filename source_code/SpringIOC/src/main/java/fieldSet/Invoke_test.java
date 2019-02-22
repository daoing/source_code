package fieldSet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Invoke_test {
	
	public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        System.out.println(createFromClass("fieldSet.Bird"));
    }

    public static Object createFromClass(String classStr) throws Exception{
        Class<?> clazz = Class.forName(classStr);
        Object object = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            String name = field.getName();
            String methodStr = "set"+name.toUpperCase().substring(0, 1)+name.substring(1);
            Method method = clazz.getMethod(methodStr,new Class[]{field.getType()});
            if(field.getType().getSimpleName().equals("String")){
                method.invoke(object, "飞鸟");
            }else if(field.getType().getSimpleName().equals("int")){
                method.invoke(object, 30);
            }
        }
        return object;
    }

}
