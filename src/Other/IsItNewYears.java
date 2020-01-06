package Other;

public class IsItNewYears {

    public static void main(String[] args) {
        if (System.currentTimeMillis()/1000 > 1577854800) {
            System.out.println("HAPPY NEW YEARS!!");
        }
        else {
            System.out.println("not yet bucko");
        }
    }
}
