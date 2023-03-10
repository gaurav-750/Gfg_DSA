package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Arrays_01 {
    public static void main(String[] args) {
//        int[] arr = {5,20,12,20,10};
//        int[] arr = {10,20,20,30,30,30,30};
        int[] arr = {3,4,8,-9,20,6};


//        int ans = delete(arr, 12);
//        System.out.println(largest(arr));
//        System.out.println(findSecondLargest(arr));
//        System.out.println(checkIfArrayIsSorted(arr));
//
//        reverseAnArray(arr);
//        System.out.println(Arrays.toString(arr));
//
//
//        removeDupsFromArray(arr);

//        moveZeroesToEnd(arr);

//        leadersInArray(arr);

//        System.out.println(maxDifference(arr));

//        frequenciesInSortedArray(arr);

//        getTrappingRainWater(arr);

//        max1sInArray(arr);

//        maxSubArraySum(arr);

//        maxLengthEvenOddSubArray(arr);

//        System.out.println(majorityElement(arr));

//        todo Sliding Window
//        maxSumOfkElements(arr, 3);

//        System.out.println(subarrayWithGivenSum(arr, 3,  33));

//        nBonacciNumbers(4 ,10);

        System.out.println(prefixSum(arr));
    }

    private static boolean prefixSum(int[] arr) {
//        cal the total array sum:
        int totalSum = 0;
        for (int elem: arr)
            totalSum += elem;

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftSum == totalSum - arr[i]){
                return true;
            }
            leftSum += arr[i];
            totalSum -= arr[i];
        }
        return false;
    }

    private static void nBonacciNumbers(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(0);
        }
        list.add(1);
//        list => [0,0,1]

        int cur = 0, i = 1;
        for (int j = n; j < m; j++) {
            cur = cur + list.get(j-1);
            if (j-n-1 > 0){
                cur -= list.get(j-n-1);
            }

            list.add(cur);
            i++;
        }

        System.out.println(list);
    }

    private static boolean subarrayWithGivenSum(int[] arr, int k, int total) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }

        int i = 1, j = k;
        while (j < arr.length){
            cur = cur - arr[i-1] + arr[j];
            if (cur == total)
                return true;
            i++;j++;
        }
        return false;
    }

    private static int maxSumOfkElements(int[] arr, int k) {
        int cur = 0, max = -1;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }
        max = cur;

        int i = 1, j = k;
        while (j < arr.length){
            cur = cur - arr[i-1] + arr[j];
            max = Math.max(max, cur);
            i++;j++;
        }
        System.out.println("max = " + max);
        return max;
    }

    private static int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                if (val+1 > (arr.length/2))
                    return i;
                map.put(arr[i], val+1);
            }else {
                map.put(arr[i], 1);
            }
        }
        return -1;
    }

    private static int maxLengthEvenOddSubArray(int[] arr) {
        int count = 1, max = -1, cur, prev;
        for (int i = 1; i < arr.length; i++) {
            cur = arr[i]; prev = arr[i-1];
            if (cur%2==0 && prev%2!=0 ||
                    cur%2!=0 && prev%2==0)
                count += 1;
            else
                count = 1;

            max = Math.max(max, count);
        }
        System.out.println("max = " + max);
        return max;
    }

    private static int maxSubArraySum(int[] arr) {
        int cur = 0, max = arr[0];
        for (int elem : arr) {
            cur += elem;
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        System.out.println("max = " + max);
        return max;
    }

    private static int max1sInArray(int[] arr) {
        int ans = 0, i = 0;
        while (i < arr.length){
            int curAns = 0;
            if (arr[i] == 1) {
                while (i < arr.length && arr[i] == 1) {
                    curAns++;
                    i++;
                }
            }else {
                i++;
                continue;
            }

            ans = Math.max(ans, curAns);
            i++;
        }

        System.out.println("ans = " + ans);
        return ans;
    }

    private static int getTrappingRainWater(int[] arr) {
//        todo Approach
        /*
            For i = 1 -> (n-1),
                1. Get the lMax, rMax.
                2. Res += min(lMax, rMax) - arr[i]
         */
        int ans = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int lMax = -1, rMax = -1;

//            get the lMax
            for (int j = 0; j < i; j++) {
                lMax = Math.max(arr[j], lMax);
            }
//            get the rMax
            for (int j = i+1; j < arr.length; j++){
                rMax = Math.max(arr[j], rMax);
            }

            int sOutput = Math.min(lMax, rMax) - arr[i];
            if (sOutput >= 0)
                ans += sOutput;
        }

        System.out.println("ans = " + ans);
        return ans;
    }

    private static void frequenciesInSortedArray(int[] arr) {
        int freq, curElem, j;
        int i = 0;
        while (i < arr.length) {
            curElem = arr[i]; freq = 1;
            j = i+1;
            while (j < arr.length && arr[j] == curElem){
                freq++; j++;
            }
            System.out.println(curElem + ": " + freq);
            i = j;
        }
    }

    private static int maxDifference(int[] arr) {
        int ans = arr[1] - arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        return ans;
    }

    private static void leadersInArray(int[] arr) {
        int n = arr.length, maxTillNow = -1;
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] > maxTillNow){
                System.out.print(arr[i] + " ");
                maxTillNow = arr[i];
            }
        }

    }

    private static void moveZeroesToEnd(int[] arr) {
        int i = 0, j = 0, temp;
        while (j < arr.length){
            if (arr[j] != 0){
//            swap the elements at i and j
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
            j++;
        }

        System.out.println(Arrays.toString(arr));
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
