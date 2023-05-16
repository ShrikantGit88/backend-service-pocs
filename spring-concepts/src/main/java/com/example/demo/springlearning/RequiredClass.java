package com.example.demo.springlearning;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class RequiredClass {
    public RequiredClass() {
        System.out.println("Demo instantiation :"+ LocalTime.now());
    }
    public static void dosomething(){
        System.out.println("Doing something");

            int i = 1 / 0;
            System.out.println("after calc");

    }

    public void tryWithResources() throws Exception {
        try (Scanner scanner = new Scanner(new File("C:\\Shrikant\\My Repos\\Java-POCs\\spring-concepts\\testFile1.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {

     Runnable runnable = () -> System.out.println("Running thread1") ;
     Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread3 "+Thread.currentThread().getName());
                System.out.println("Is Alive? " + Thread.currentThread().isAlive());
            }
     };
    Thread thread1 = new Thread(() -> System.out.println("Running thread1 "+Thread.currentThread().getName()), "THREAD1");
    Thread thread2 = new Thread("THREAD2"){
        public void run() {
            System.out.println("Running thread2");
        }
    };
    Thread thread3 = new Thread(runnable3, "THREAD3");
    thread1.start();

    thread3.start();
    thread3.join(1000);
    thread2.start();
    }

}
