package org.example;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        MyHashTable<MyTestingClass , Student> table =  new MyHashTable<MyTestingClass , Student>();
        for(int i = 0;i < 10000;i++){
            table.put(new MyTestingClass(ranStr(5)), new Student(ranStr(6),ranStr(7)));
        }
        for(int i = 0;i < table.getM();i++){
            System.out.println(table.countElements(i));
        }
        BST<Integer, String> bst = new BST<>();

        bst.put(5, "asd");
        bst.put(3, "asdfg");
        bst.put(7, "as");
        bst.put(2, "qwe");
        bst.put(4, "qwerty");
        bst.put(6, "cvbh");

        System.out.println(bst.get(4));
        System.out.println(bst.get(6));

        bst.delete(7);


        for (Integer key : bst) {
            System.out.println(key + " " + bst.get(key));
        }

    }
    public static String ranStr(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < length ; i++) {
            result.append(chars.charAt(random.nextInt(chars.length())));
        }
        return result.toString();
    }
}