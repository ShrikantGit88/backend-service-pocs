package casting;

import model.Animal;
import model.Cat;
import model.Dog;

public class CastingExample {
    public static void main(String[] args) {
        Animal animal = new Dog(2, "tommy");
        doAnimalStuff(animal);
        Dog dog = new Dog(2, "tommy");
        doAnimalStuff(dog);
        Cat cat = new Cat(4, "steccy");
        doAnimalStuff(cat);
    }

    public static void doAnimalStuff(Animal animal) {
       if(animal instanceof Dog) {
           Dog dog = (Dog) animal;
           dog.makeSound();
           dog.growl();
       } else if(animal instanceof Cat) {
           Cat cat = (Cat) animal;
           cat.makeSound();
           cat.sleep();
       }

    }
}
