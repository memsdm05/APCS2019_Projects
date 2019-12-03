package Other.Chapters;

public class Cents {
    public static void printPermutations(int cents) {
        int q, d, n, p;
        for(q = 0; q*25 <= cents; q++) {
            for(d = 0; q*25+d*10 <= cents; d++) {
                for(n = 0; q*25+d*10+n*5 <= cents; n++) {
                    p = cents - (q*25+d*10+n*5);
                    System.out.printf("%d cents = %d quarters + %d dimes + %d nickels + %d pennies\n", cents, q,d,n,p);
                }
            }
        }
    }

    public static void main(String[] args) {
        printPermutations(123);
    }
}
