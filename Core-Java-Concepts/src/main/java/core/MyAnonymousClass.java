package core;

import model.Animal;

public class MyAnonymousClass {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        //'anonymous subclass' which has only one object i.e. this class definition will be applied to only 'myAnimal' object
        Animal myAnimal = new Animal(){
            @Override
            public void makeSound() {
                System.out.println("grewwwwwolwowlll");
            }
        };
        myAnimal.makeSound();

        // anonymous class to extend an interface
        Runnable runnableRef = new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        runnableRef.run();
    }
}
