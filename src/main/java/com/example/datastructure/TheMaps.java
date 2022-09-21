package com.example.datastructure;

import java.util.HashMap;
import java.util.Map;

public class TheMaps {
    public static void main(String[] args) {
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
    record Person(String name){}
}
