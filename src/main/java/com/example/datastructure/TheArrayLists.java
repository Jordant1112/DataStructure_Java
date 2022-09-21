package com.example.datastructure;

import java.util.ArrayList;
import java.util.List;

public class TheArrayLists {
    public static void main(String[] args) {
        List<String> colors = new ArrayList();
        colors.add("blue");
        colors.add("purple");

        colors.add("red");
        System.out.println(colors.size());
        System.out.println(colors.contains("red"));
        System.out.println(colors);

        for (String color: colors){
            System.out.println(color);
        }
    }
}
