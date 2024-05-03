package org.example;

public class MyTestingClass {
    private String key;

    public MyTestingClass(String id) {
        this.key = id;
    }

    @Override
    public int hashCode() {
        int h = 17;
        for(int i = 0; i< key.length(); i++) {
            h = h* 17 + key.charAt(i);
        }

        return h;

    }
}
