package com.example.datastructure;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

