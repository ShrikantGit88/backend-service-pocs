package core;

interface Addable {
    int multiply(int a, int b);
}
public class Java8Lambda {
    public static void main(String... args){
        //lambda expression used to implement functional interface
        Addable addableRef = (a, b) -> a * b;
        System.out.println(addableRef.multiply(10, 20));
    }
}

