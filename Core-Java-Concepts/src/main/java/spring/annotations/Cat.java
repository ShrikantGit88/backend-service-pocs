package spring.annotations;

@MyAnnotation(myName = "SHRIKANT")
public class Cat {

    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("meow!!!!");
    }

    @ImportantString
    String name;

    public Cat(String name) {
        this.name = name;
    }
}
