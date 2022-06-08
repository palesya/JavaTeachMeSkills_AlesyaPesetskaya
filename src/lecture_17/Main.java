package lecture_17;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        MyService service = new MyService();
        Class<? extends MyService> aClass = service.getClass();
        System.out.println(aClass);

        Field[] fields = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        for(Method method:declaredMethods){
            if(method.getName().contains("print")){
                method.setAccessible(true);
                method.invoke(service);
            }
        }


    }
}
