package core;

import java.io.IOException;
import java.io.ObjectInputStream;

public class CreateObjectExample {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //Note: We can create object only when access modifier of a constructor is private.
        //How to create objects in java
        //way 1
        Demo demo1 = new Demo(10);
        demo1.saySomething();

        //way 2
        try {
            Demo demo2 = (Demo) Class.forName("core.Demo").newInstance(); //pass fully qualified name to forName method
            demo2.saySomething();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //How to clone or get object from existing one
        //way 1
        Demo demoClone1 = (Demo) demo1.clone();
        demoClone1.saySomething();

        //way 2
//        ObjectInputStream objectInputStream = new ObjectInputStream(demo1);
//        Demo demoObject = (Demo) objectInputStream.readObject();
//        demoObject.saySomething();
    }
}
