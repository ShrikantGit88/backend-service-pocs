package com.example.demo.springlearning;

public class Square implements Shape{
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Square with "+borderColor+" border");
    }
}
