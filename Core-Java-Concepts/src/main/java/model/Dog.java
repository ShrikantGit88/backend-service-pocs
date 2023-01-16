package model;

public class Dog extends Animal{
    private int age;
    public String name;
    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof !!");
    }

    @Override
    public void eat(Food df) {
        System.out.println("...dog galp galp");
    }

    public void eat(int numberOfTimes) {
        System.out.println("...dog galp galp "+numberOfTimes);
    }
    public void growl() { System.out.println(".. groooowwwweeel");}

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
