package core;

import java.io.*;

class Employee implements Serializable {

    private static final long serLONG = 0;

    transient public int salary; //non serializable property ...default value will be shown on deserialization
    public String name;
    static public String orgName = "Hitachi";

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setOrgName(String orgName) {
        Employee.orgName = orgName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Employee employee = new Employee(50000, "Ramesh");
        //Serialization
        try {
            FileOutputStream file = new FileOutputStream("myFile.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(employee);

            file.close();
            out.close();

            System.out.println("Object is serialized");

        } catch (IOException ioe) {
            System.out.println("ioe exception caught "+ioe);
            throw new RuntimeException(ioe);
        }

        Employee obj1 = null;
        //Deserialization
        try {
            FileInputStream file = new FileInputStream("myFile.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            obj1 = (Employee)in.readObject();

            System.out.println("Object is deserialized ");
            System.out.println(obj1.toString());

            file.close();
            in.close();

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("ioe exception caught "+e);
            throw new RuntimeException(e);
        }
    }
}
