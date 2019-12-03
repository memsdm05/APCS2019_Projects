package Other;

public class StringStuff {
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = new String("Hello World");
        String s3 = new String(s1);
        String s4 = s1;

        System.out.println(s1 + "\t" + Integer.toHexString(System.identityHashCode(s1)));
        System.out.println(s2 + "\t" + Integer.toHexString(System.identityHashCode(s2)));
        System.out.println(s3 + "\t" + Integer.toHexString(System.identityHashCode(s3)));
        System.out.println(s4 + "\t" + Integer.toHexString(System.identityHashCode(s4)));

        System.out.println((s1 == s2)? "s1 == s2" : "s1 != s2");
        System.out.println((s1 == s4)? "s1 == s4" : "s1 != s4");
        System.out.println((s2 == s3)? "s2 == s3" : "s2 != s3");

        s4 += "your mom!";
        System.out.println(s4 + "\t" + Integer.toHexString(System.identityHashCode(s4)));
    }
}
