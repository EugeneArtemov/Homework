package org.example;


/**
 * проверял функционал
 */
public class Main {
    public static void main(String[] args) {

        NewList<Integer> Ex = new NewArrayList<>();
        Ex.add(2);
        Ex.add(3, 5);
        Ex.add(7);
        Ex.add(8);
        Ex.add(9);
        //Ex.add(1, 0);
        System.out.println(Ex.get(2));
        Ex.remove(2);
        for (int i = 0; i < 50; i++)
            Ex.add(i);
        Ex.sort();

         NewList<Integer> Ex1 = new NewLinkedList<>();
        Ex1.add(2);

        Ex1.add(7);
        Ex1.add(8);
        Ex1.add(3, 1);
        Ex1.add(3);
        Ex1.add(10);
        Ex1.get(2);
        //Ex.add(1, 0);
        System.out.println(Ex1.get(2));

        Ex1.remove(10);

        //for (int i = 0; i < 50; i++)
          //  Ex1.add(i);

        Ex1.sort();
        System.out.println("hi");
    }
}