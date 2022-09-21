package com.example.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TheStacksandQueues {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        Queue<Person> supermarketqueue = new LinkedList<>();
        supermarketqueue.add(new Person("Alex",21));

        supermarketqueue.add(new Person("Maria",41));

        supermarketqueue.add(new Person("Ali",24));
        System.out.println(supermarketqueue.peek());
        System.out.println(supermarketqueue.poll());
        System.out.println(supermarketqueue.size());
        System.out.println(supermarketqueue.peek());

    }
    static record Person(String name, int age){

    }
}
