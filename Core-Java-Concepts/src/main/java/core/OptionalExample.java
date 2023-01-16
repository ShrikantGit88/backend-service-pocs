package core;

import model.Cat;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Cat> myCat = findByName("Stecy");

        //Right way
        Integer age = myCat.map(Cat::getAge)
                .orElse(0);
        System.out.println(">>> "+age);

        //wrong way
//        if(myCat.isPresent()) {
//            System.out.println(myCat.get().getAge());
//        } else {
//            System.out.println(0);
//        }
    }

    public static Optional<Cat> findByName(String name) {
        Cat cat = new Cat(3, name);
        return Optional.ofNullable(cat);
    }
}
