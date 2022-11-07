package com.example.datastructure;

import java.util.*;
import java.util.regex.Pattern;

public class TheSets {
    public static void main(String[] args) {
        Set<Ball> balls = new HashSet<>();
        balls.add(new Ball("blue"));
        balls.add(new Ball("green"));
        balls.add(new Ball("green"));
        balls.add(new Ball("red"));
        balls.add(new Ball("yellow"));
        balls.forEach(System.out::println);
        System.out.println(balls.size());
    }
    // if use a class, need to override equals and hashcode for set
    static class Ball{

        String color;
        public Ball(String color) {
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Ball ball = (Ball) o;
            return Objects.equals(color, ball.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color);
        }

        @Override
        public String toString() {
            return "Ball{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }
    //record Ball(String color){} //if use record, no need to worry about the set(no override).
}
/*
public static classß Stack{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public void pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; //Eliminate obsolete reference
        return result;

    }
    public void ensureCapacity(){
        if (elements.length==size){
            elements = Arrays.copyOf(elements, 2*size +1);
        }
    }
}

 */