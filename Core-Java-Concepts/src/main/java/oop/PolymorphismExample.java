package oop;

import model.Animal;
import model.Dog;
import model.Food;

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat(new Food());

        Dog dog = new Dog(2, "Danny");
        dog.eat(new Food());//method overriding
        dog.eat(3); // method overloading
    }
}
