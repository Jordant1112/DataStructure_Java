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

        int[] arr2 = {3, 2, 1, 0, 40, 50, 60, 7, 8, 90};
        int[] shellArray = shellSearch(arr2);
        System.out.println(Arrays.toString(shellArray));

        int[] quickArray = quickSort(arr2, 0, arr2.length -1);
        System.out.println(Arrays.toString(quickArray));
        System.out.println(Arrays.toString(arr2));
        int[] mergeArray = mergeSort(arr2,0, 3 ,arr2.length-1);
        System.out.println(Arrays.toString(mergeArray));

        int[] bucketArray = bucketSort(arr2);

    }

    private static int[] bucketSort(int[] arr) {
        int[][] tmp = new int[10][arr.length];
        int max = getMax(arr);
        int len = String.valueOf(max).length();
        int[] counts = new int[10];
        for (int i = 0, n = 1; i < len; i++, n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int value = arr[j]/n%10;
                tmp[value][counts[value]++] = arr[j];
            }
            int index = 0;
            for (int k = 0; k < counts.length; k++) {
                if(counts[k] != 0){
                    for (int h = 0; h < counts[k]; h++) {
                        arr[index] = tmp[k][h];
                        index++;
                    }
                }
                counts[k] = 0; //clear the counts from previous round
            }
        }

    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private static int[] mergeSort(int[] array, int start, int center, int end){
        int[] s = array;
        int[] tmp = new int[end - start + 1];
        //定义右边数组的起始索引
        int i = start;
        //定义左边数组起始索引
        int j = center + 1;
        //定义临时数组起始索引
        int index = 0;
        while(i <= center && j <= end){
            if(array[i] < array[j]){
                tmp[index] = array[i];
                i++;
            }else{
                tmp[index] = array[j];
                j++;
            }
            index++;
        }
        //处理剩余元素
        while(i <= center){
            tmp[index] = array[i];
            i++;
            index++;
        }
        while(j <= end){
            tmp[index] = array[j];
            j++;
            index++;
        }
        return tmp;
    }


    private static int[] quickSort(int[] array, int start, int end){
        int[] s = array;
        if(start < end) {
            int index = getIndex(s, start, end);
            quickSort(s, start, index-1);
            quickSort(s, index+1, end);
        }
        return s;
    }
    private static int getIndex(int [] arr, int start, int end){
        int i = start;
        int j = end;
        int x = arr[i];
        while (i < j) {
            while(i<j && arr[j] >= x){
                j--;
            }
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            while(i<j && arr[i] < x){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
                j--;
            }
            arr[i] = x;
        }
        return i;
    }


    private static int[] shellSearch(int[] array){
        //optimization of insertSearch
        //key point is how to select the increment value while searching
        /*
        int increment = s.length / 2;
        while(increment > 0){
            for (int i = increment; i < s.length; i++) {
                for (int j = i; j > increment-1; j -=increment) {
                    if(s[j] < s[j-increment]){
                        int tmp = s[j];
                        s[j] = s[j-increment];
                        s[j-increment] = tmp;
                    }
                }
            }
            increment /=2;
        }

         */
        // knuth series is a better increment choice
        int[] s = array;
        int increment = 1;
        while(increment <= s.length /3){
            increment = increment *3 +1;
        }
        for(int h = increment; h > 0; h = (h-1)/3) {
            for (int i = increment; i < s.length; i++) {
                for (int j = i; j > h - 1; j -= h) {
                    if (s[j] < s[j - h]) {
                        int tmp = s[j];
                        s[j] = s[j - h];
                        s[j - h] = tmp;
                    }
                }
            }
        }
        return s;
    }


    private static int[] insertSearch(int[] array){
        int[] s = array;
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

    private static int[] selectSearch(int[] array){
        int L = array.length;
        int[] s = array;
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
