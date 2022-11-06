import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        //binarySearch
        int[] arr = {50,10,20,30,40,50,60,70,80,90};
        int index = binarySearch(arr, 20);
        System.out.println(index);
;
    }

    private static int binarySearch(int[] s, int target){
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        int L = s.length;
        int left = 0;
        int right = s.length -1;
        while (left < right){
            int mid = left + (left + right)/2;
            if(s[mid] < target){
                left = mid+1;
            } else if(s[mid] > target){
                right = mid-1;
            }else{return mid;}
        }
        return -1;
    }
