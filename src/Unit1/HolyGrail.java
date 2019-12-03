package Unit1;

import java.util.Scanner;

/**
 * HolyGrail is a simple chatbot application
 * @version Wendsday 9/4/2019
 * @author 22browner
 *  */

public class HolyGrail {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these\n" +
                           "questions three, ere the other side he see.");
        System.out.print("Question 1: What is your name? ");
        String name = input.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = input.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = input.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a\nking, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");
    }
}
