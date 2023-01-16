package exeption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandlingExample {
    public static void main(String[] args)  {
        //handling checked exceptions
       // readme1();
//        try {
//            readme2();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e); //catching checked exception and runtime exception
//        }

        //custom checked exception
        try {
            validateAge(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readme1() {
        File file = new File("abc");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static void readme2() throws FileNotFoundException {
        File file = new File("abc");
        FileInputStream fileInputStream = new FileInputStream(file);
    }

    public static void validateAge(int age) throws Exception {
        if(age < 0) {
            throw new AgeLessThanZeroException("Age can not be less than zero", new RuntimeException());
        } else if (age > 100) {
            throw new AgeGreaterThanHundredException("Age is more than 100");
        } else if (age == 0) {
            throw new AgeIsZeroException("Not born yet");
        }
    }
}