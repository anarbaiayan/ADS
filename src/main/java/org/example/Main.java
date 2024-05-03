package org.example;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        MyHashTable<MyTestingClass , Student> table =  new MyHashTable<MyTestingClass , Student>();
        for(int i = 0;i < 10000;i++){
            table.put(new MyTestingClass(ranStd(5)), new Student(ranStd(6),ranStd(7)));
        }
        for(int i = 0;i < table.getM();i++){
            System.out.println(table.countElements(i));
        }
    }
    public static String ranStd(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }
}