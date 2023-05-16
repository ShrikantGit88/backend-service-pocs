package com.example.demo.springlearning;

public class Circle implements Shape {
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void draw() {
        System.out.println("Drawing ** circle ** with "+borderColor+" border");
    }
}
