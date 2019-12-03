package Other.Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

public class RobotShit
{
    public static void main(String[] args) throws IOException,
            AWTException, InterruptedException
    {

        // Create an instance of Robot class
        Robot robot = new Robot();

        // Press keys using robot. A gap of
        // of 500 mili seconds is added after
        // every key press
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_SPACE);
        System.out.println(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_S);
    }
}