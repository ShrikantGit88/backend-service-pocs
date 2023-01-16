package core;

class Car_Outer {
    int x = 10;
    static int y = 20;

    public void startCar() {
        System.out.println("Inside startCar method");
        Car_Outer.Engine_inner enInner = new Car_Outer.Engine_inner();
        enInner.startEngine();
    }
    class Engine_inner {
        int z = 30;
        //static int abc = ""; //static declaration is not supported in inner class as its only associated with
        //an object of outer class
        public void startEngine() {
            System.out.println("Inside Inner class startEngine method"+z);
        }
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        Car_Outer car = new Car_Outer();
        car.startCar();

        Car_Outer.Engine_inner in = new Car_Outer().new Engine_inner();
        in.startEngine();
    }
}
