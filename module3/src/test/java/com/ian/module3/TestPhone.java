package com.ian.module3;

public class TestPhone {
    public static void main(String[] args) {
        Phone p1 = new Phone("apple", "128G", "6.1", "blue", 1099);
        Phone p2 = new Phone("samsung", "256G", "6.5", "black", 999);
        Phone p3 = new Phone("huawei", "256G", "6.3", "gold", 199);
        System.out.println(p1.color);
    }
}
