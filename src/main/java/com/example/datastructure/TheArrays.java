package com.example.datastructure;

import java.util.Arrays;

public class TheArrays {
    public static void main(String[] args) {
        //Arrays and 2d Arrays
        String[] colors = new String[5];
        colors[0] = "purple";
        colors[1] = "blue";
        colors[2] = "red";
        colors[3] = "orange";
        colors[4] = "yellow";
        System.out.println(Arrays.toString(colors));

        int[] numbers = new int[2];
        numbers[0] = 100;
        numbers[1] = 200;
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < colors.length; i++){
            System.out.println(colors[i]);
        }
        for (String color: colors){
            System.out.println(color);
        }
        Arrays.stream(colors).forEach(System.out::println);


        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0;j<3;j++){
                board[i][j] = '-';
            }
        }
        System.out.println(Arrays.deepToString(board));

        int[][] TwoDArrays = new int[2][3];
        TwoDArrays[0][0] = 1;
        System.out.println(Arrays.deepToString(TwoDArrays));
        System.out.println(TwoDArrays[0][1]);



    }
}
