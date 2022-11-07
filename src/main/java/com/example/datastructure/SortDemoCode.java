package com.example.datastructure;

import java.util.Arrays;

public class SortDemoCode {
    public static void main(String[] args) {
        //binarySearch
        int[] arr = {50, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int index = binarySearch(arr, 20);
        System.out.println(index);
        int[] bubbleArray = bubbleSearch(arr);
        System.out.println("bubble Search is");
        System.out.println(Arrays.toString(bubbleArray));

        int[] selectArray = selectSearch(arr);
        System.out.println(Arrays.toString(selectArray));

        int[] arr1 = {3, 2, 1, 0, 40, 50, 60, 7, 8, 90};
        int[] insertArray = insertSearch(arr1);
        System.out.println(Arrays.toString(insertArray));
    }

    private static int[] insertSearch(int[] s){
        for (int i = 1; i < s.length; i++) {
            for (int j = i; j > 0; j--) {
                if(s[j] < s[j-1]){
                    int tmp = s[j];
                    s[j] = s[j-1];
                    s[j-1] = tmp;
                }
            }
        }
        return s;
    }

    private static int[] selectSearch(int[] s){
        int L = s.length;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i+1; j < s.length-1; j++) {
                if(s[i] > s[j]){
                    int tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                }
            }
        }
        return s;
    }


    private static int[] bubbleSearch(int[] s) {
        int L = s.length;
        for (int i = 0; i < s.length-1; i++) {
            boolean flag = false;
            for (int j = i+1; j < s.length - 1 - i; j++) {
                if (s[j] > s[j+1]) {
                    int tmp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tmp;
                    flag = true;
                }
                if (flag == false) break;
            }
        }
        return s;
    }


    private static int binarySearch(int[] s, int target) {
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        int L = s.length;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            int mid = left + (left + right) / 2;
            if (s[mid] < target) {
                left = mid + 1;
            } else if (s[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
