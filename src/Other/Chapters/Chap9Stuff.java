package Other.Chapters;

import java.util.Arrays;

public class Chap9Stuff {
    public void reverse(int[] intArray) {
        if(intArray.length > 1) {
            int temp = intArray[0];
            intArray[0] = intArray[intArray.length-1];
            intArray[intArray.length-1] = temp;
        }
    }

    public static boolean allSame(int[] nums) {
        return nums[0] == nums[nums.length-1];
    }

    public static char getRandomRPS() {
        char[] rps = {'r', 'r', 'r', 'p', 'p', 'p', 'p', 'p', 's', 's', 's', 's', 's', 's'};
        return rps[(int)(Math.random()*(rps.length-1))];
    }

    public static int s(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public static int[] fibonacci(int n) {
        int[] fib = new int[n+1];
        int t1 = 0, t2 = 1;
        for (int i = 0; i <= n; i++) {
            fib[i] = t1;
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return fib;
    }

    public static double greatestMatrix(double[][] matrix) {
        double sum = -1;
        for (double[] rows : matrix) {
            for (double col : rows)
                sum = (col > sum)? col : sum;
        }
        return (sum<0)? 0 : sum;
    }

    public static boolean onDiag(int[][] matrix, int i, int j) {
        return i == j || i + j== matrix[0].length - 1;
    }

    public static int[] sumOfRows(int[][] t) {
        int[] sumRows = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            sumRows[i] = s(t[i]);
        }
        return sumRows;
    }

    public boolean isMedian (double[] sample, double m) {
        Arrays.sort(sample);
        if (sample.length%2==1)
            return m == sample[(sample.length-1)/2];
        else
            return m == (sample[(sample.length-1)/2] + sample[(sample.length)/2]) / 2;
    }

    public static void main(String[] args) {
        Chap9Stuff app = new Chap9Stuff();

        System.out.println(Arrays.toString(fibonacci(0)));
        double[][] m = {{-1,-2,-3}, {-4,-5,-6}, {-7,-8,-9}};
        System.out.println(greatestMatrix(m));
//        System.out.println(Arrays.toString(sumOfRows(m)));

        double[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(app.isMedian(a, 3.5));
    }
}
