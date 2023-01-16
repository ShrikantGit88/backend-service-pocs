package spring.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationExample {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("AnnotationExample >>");
        Cat myCat = new Cat("stella");
        //to check what annotation is applied on this class

        //class type annotation
        if(myCat.getClass().isAnnotationPresent(MyAnnotation.class)){
            Class c = myCat.getClass();
            System.out.println(" class name: "+c.getName());

            MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
            System.out.println("my name from annotation "+myAnnotation.myName());
        }
        //method type annotation
        for(Method method: myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){

                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for(int i =0; i < annotation.times(); i++){
                    method.invoke(myCat);
                }
            }
        }
        //field type annotation
        for(Field field: myCat.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ImportantString.class)){
                    //RunImmediately annotation = field.getAnnotation(ImportantString.class);
               Object obj = field.get(myCat);
               if(obj instanceof String){
                   System.out.println(((String) obj).toUpperCase());
               }
            }
        }

    }
}
