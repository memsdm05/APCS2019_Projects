package Other.Shitposts;

public class Check4 {
    public static Boolean check3(int num) {
        return num==1;
    }

    public static Boolean check4(int num) {
        int iter = 0;
        int c = num;
        c = 34 * c % 234;
        c = 43 * c % 23;
        c += 2;
        while (c > 1) {
            if (c%2==0) {
                c = c/2;
            }
            else {
                c = (3 * c) + 1;
            }
            iter++;
        }
        boolean[] bool = new boolean[iter];
        c = num;
        c = 34 * c % 234;
        c = 43 * c % 23;
        c += 2;
        iter = 0;
        while (c > 1) {
            if (c%2==0) {
                c = c/2;
            }
            else {
                c = (3 * c) + 1;
            }
            bool[iter] = (c%2==0);
            iter++;
        }
        iter = 0;
        int sum = 0;
        while (iter < bool.length) {
            if (bool[iter]) {
                sum = sum + iter;
            }
            else {
                sum = sum + -iter;
            }
            iter++;
        }
        if (sum*bool.length*num==1088) {
            return true;
        }
        else {
            return false;
        }
    }



    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(check4(i));
        }
    }
}
