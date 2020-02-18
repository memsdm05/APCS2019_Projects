package Other.Chapters;

public class Chap13Stuff {
    public Chap13Stuff() {
    }

    public String process(String str) {
        int n = str.length();
        if (n >= 2) {
            int n2 = n/2;
            str = process(str.substring(n2)) + process(str.substring(0, n2));
        }
        return str;
    }

    public int power3(int n) {
        if (n==0)
            return 1;
        else {
            int p = power3(n/2);
            p *= p;
            System.out.println("#");

            if (n % 2 == 1) {
                p *= 3;
                System.out.println("#");
            }

            return p;
        }
    }


    public static void main(String[] args) {
        Chap13Stuff app = new Chap13Stuff();
        System.out.println(app.process("HAVE") + " " + app.process("FUN"));
        System.out.println(app.power3(15));
    }
}
