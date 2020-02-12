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

    public static void main(String[] args) {
        Chap13Stuff app = new Chap13Stuff();
        System.out.println(app.process("HAVE") + " " + app.process("FUN"));
    }
}
