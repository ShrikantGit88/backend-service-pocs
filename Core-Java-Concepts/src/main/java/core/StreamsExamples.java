package core;

import java.util.List;

public class StreamsExamples {

    public static void main(String[] args) {
        List<Integer> list = List.of(12,9,5,2,0,4,8);

        list.stream().forEach(StreamsExamples::printNumbers);
    }

    public static void printNumbers(int number){
        System.out.println(number);
    }
}
