package spring;

public class AnnotationExample {
    public static void main(String[] args) {
        System.out.println("AnnotationExample >>");
        Sample sample = new Sample();
        Class c = sample.getClass();
        System.out.println(" class name: "+c.getName());

        MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
        System.out.println("my name from annotation "+myAnnotation.myName());
    }
}
