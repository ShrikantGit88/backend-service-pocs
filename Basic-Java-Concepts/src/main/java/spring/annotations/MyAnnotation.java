package spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //applicable on the elements types mentioned
@Retention(RetentionPolicy.RUNTIME) //used at runtime
@interface MyAnnotation {
    int myValue() default 0;

    String myName() default "Shri";
}