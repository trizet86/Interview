package com.company.Task3;

public class Main {
    public static void main(String[] args) {
        VectorList<Integer> vectorList = new VectorList<>();
        vectorList.insertLast(1);
        vectorList.insertLast(2);
        vectorList.insertLast(3);
        vectorList.insertLast(4);
        for (Integer item : vectorList) {
            System.out.println(item);
        }

        System.out.println();

        vectorList.insertFirst(10);
        vectorList.insertFirst(20);
        vectorList.insertFirst(30);
        vectorList.insertFirst(40);
        for (Integer item : vectorList) {
            System.out.println(item);
        }
    }
}
