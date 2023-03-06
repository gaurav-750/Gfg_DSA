package Arrays;


import java.util.Arrays;

public class Arrays_01 {
    public static void main(String[] args) {
//        int[] arr = {5,20,12,20,10};
        int[] arr = {10,20,20,30,30,30,30};


//        int ans = delete(arr, 12);
        System.out.println(largest(arr));
        System.out.println(findSecondLargest(arr));
        System.out.println(checkIfArrayIsSorted(arr));

        reverseAnArray(arr);
        System.out.println(Arrays.toString(arr));


        removeDupsFromArray(arr);

    }

    private static int removeDupsFromArray(int[] arr) {
        int cur = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]){
                continue;
            }
            cur++;
            arr[cur] = arr[i];
        }
        return cur+1;
    }

    private static void reverseAnArray(int[] arr) {
        int n = arr.length;
        int temp, j = n-1;
        for (int i = 0; i < (n/2); i++) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }

    private static boolean checkIfArrayIsSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }

    private static int findSecondLargest(int[] arr) {
        int max = arr[0], secondMax = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondMax){
                if (arr[i] > max){
                    secondMax = max;
                    max = arr[i];
                }else if (max != arr[i]){
                    secondMax = arr[i];
                }
            }
        }
        return secondMax;
    }

    private static int largest(int[] arr) {
        int max = -1, ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }

    private static int delete(int[] arr, int x) {
        int n = arr.length, i;
        for (i = 0; i < n; i++)
            if (arr[i] == x)
                break;
        if (i == n)
            return n;

        for (int j = i; j < n-1; j++)
            arr[j] = arr[j+1];
        return n-1;
    }
}
