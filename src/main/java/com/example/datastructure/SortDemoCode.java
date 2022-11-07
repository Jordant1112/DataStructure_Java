package com.example.datastructure;

import java.util.Arrays;

public class SortDemoCode {
    public static void main(String[] args) {
        //binarySearch
        int[] arr = {50, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int index = binarySearch(arr, 20);
        System.out.println(index);
        int[] bubbleArray = bubbleSearch(arr);
        System.out.println(Arrays.toString(bubbleArray));
    }

    private static int[] bubbleSearch(int[] s) {
        int L = s.length;
        for (int i = 0; i < s.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < s.length - 1 - i; j++) {
                if (s[i] > s[j]) {
                    int tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
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
