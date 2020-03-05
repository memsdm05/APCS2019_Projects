package Other;

import java.util.Arrays;
public class Sorts {

    public static void selectionSort(int[] nums) {
        for (int out = 0; out < nums.length; out++) {
            int min = nums[out];
            int index = out;
            for (int in = out+1; in < nums.length; in++) {
                if (nums[in] < min) {
                    min = nums[in];
                    index = in;
                }
            }
            int temp = min;
            nums[index] = nums[out];
            nums[out] = temp;
        }
    }

    public static void sort(int arr[])
    {
        int n = 5;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i-1;
            int temp = nums[j];
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 5, 8, 2, 0, 1, 9, 4, 3};
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = randHelper(-10, 100);
//        }
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
