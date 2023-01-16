package core;

import model.Cat;

public class PersianCat extends Cat {
    public PersianCat(int age, String name) {
        super(age, name);
    }
//    private int age;
//    public String name;
//
//
//
//    public PersianCat(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }

    public void makeSound() {
        System.out.println("persian meoooooww !!");
        super.walk();
    }
//    void eat() {
//        System.out.println("....cat food");
//    }
}
