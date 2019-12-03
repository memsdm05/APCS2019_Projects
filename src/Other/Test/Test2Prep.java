package Other.Test;

import java.text.DecimalFormat;

public class Test2Prep {

    private int plusMinus(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (i%2==0)? -i : i;
        }
        return sum;
    }

    public static int minutesUntilLunch(String time) {
        String[] t = time.split(":");
        int min = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
        return 765 - min;
    }

    public static String reverse(String str) {
        String newStr = "";
        for (int i = str.length()-1; i >= 0; i--) {
            newStr += str.substring(i, i+1);
        }
        return newStr;
    }



    public static void main(String[] args) {
        Test2Prep app = new Test2Prep();
        System.out.println(app.plusMinus(3));

        int n = 2, b = 3;
        double x = 2.5, y;
        System.out.println((x * n + n / b) / 2);

        String s1 = "123", s2 = "324";

        System.out.println((s1 + s2) + Integer.parseInt(s1) + Integer.parseInt(s2) + s2);

        System.out.println(new DecimalFormat("#.##").format(45.3452));

        System.out.println(minutesUntilLunch("11:52"));

        System.out.println(reverse("hello"));
    }
}
