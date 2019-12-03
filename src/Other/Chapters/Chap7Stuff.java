package Other.Chapters;

import java.util.Scanner;

public class Chap7Stuff {
    private static void printCheckerboard(int n) {
        for (int y = 0; y < n; y++) {
            String xd = "";
            for (int x = 0; x < n; x++)
                xd += ((x+y)%2==0)? "#" : "o";
            System.out.println(xd);
        }
    }

    private static void lol(int m, int n) {
        int q = 0;
        while (m >= n) {
            q++;
            m -= n;
        }
        System.out.println(q);
        System.out.println(m);
    }

    private static void yoMama() {
        final int YEAR = 2014;
        final double START_POP = 123.8;
        final double GROWTH_RATE = 0.005;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter target population (in millions): ");
        double target = scan.nextDouble();
        double stuff = START_POP;
        int beans = YEAR;

        while (stuff < target) {
            beans++;
            stuff += (START_POP * GROWTH_RATE);
        }

        System.out.println(beans);
    }

    private static int kevin() {
        double growth = .1;
        double howMuchKevinKnows = 0;
        int months = 0;
        while (howMuchKevinKnows < .95) {
            howMuchKevinKnows += (1 - howMuchKevinKnows) * growth;
            months++;
        }
        return months;
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    private static void loopExample(int n, int b) {
        int p = 1;
        while (p <= n) {
            n = n - p;
            p = p * b;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        printCheckerboard(7);
        lol(6, 3);
        yoMama();
        System.out.println(sumDigits(123));
        loopExample(37, 2);
        System.out.println(kevin());
    }
}
