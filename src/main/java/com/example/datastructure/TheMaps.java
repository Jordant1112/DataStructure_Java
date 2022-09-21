package com.example.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TheMaps {
    public static void main(String[] args) {

        Map<Person, Diamond> map = new HashMap<>();
        map.put(new Person("Tom"), new Diamond("Africa Diamond"));
        System.out.println(new Person("Tom").hashCode());
        System.out.println(new Person("Tom").hashCode());
        System.out.println(map.get(new Person("Tom")));
        //Note: need to override hashCode in the Person Class
        //Otherwise, the hashcode is different
    }

    private static void maps() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("Tom"));
        map.put(2, new Person("charlie"));
        map.put(3, new Person("Buffet"));
        map.put(3, new Person("Warren"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1));
        System.out.println(map.containsKey(4));
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
    }

    static class Person{
        String name;
        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
    record Diamond(String name){}
}
