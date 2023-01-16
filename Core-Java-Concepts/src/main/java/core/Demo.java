package core;

import java.io.IOException;
import java.io.InputStream;

public class Demo extends InputStream implements Cloneable{
    int num;

    public Demo() {
    }

    @Override
    public int read() throws IOException {
        return 25;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Demo(int num) {
        this.num = num;
    }

    public void saySomething() {
        System.out.println("Hello...."+this.num);
    }
}
