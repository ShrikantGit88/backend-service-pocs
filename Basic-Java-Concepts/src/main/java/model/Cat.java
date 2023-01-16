package model;

public class Cat extends Animal{
    private int age;
    public String name;
    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void makeSound() {
        System.out.println("meoooooww !!");
    }
    protected void walk() {
        System.out.println("....cat food");
    }

    public void sleep() {
        System.out.println("....cat sleep");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
