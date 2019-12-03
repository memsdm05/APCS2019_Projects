package Other;

public class NumberBumper {

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static int swapOnesAndTens(int num) {
        int ones = num%10;
        num /= 10;
        int tens = num%10;
        num /= 10;


        return num*100 + ones*10 + tens;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int stuff = randHelper(1, 1000);
            System.out.println(stuff + " = " + swapOnesAndTens(stuff));
        }

    }
}
