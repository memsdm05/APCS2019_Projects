package Other.Chapters;

import java.util.Scanner;

public class OneTwo {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.print("Enter a number 1-10 (or 0 to quit): ");
            switch (scan.nextInt()) {
                case(1):
                case(2):
                    System.out.println("Buckle your show");
                    break;
                case(3):
                case(4):
                    System.out.println("Shut the door");
                    break;
                case(5):
                case(6):
                    System.out.println("Pick up sticks");
                    break;
                case(7):
                case(8):
                    System.out.println("Lay them straight");
                    break;
                case(9):
                case(10):
                    System.out.println("A big fat hen");
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }


    }
}
