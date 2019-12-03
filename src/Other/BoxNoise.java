package Other;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Random;

public class BoxNoise extends JFrame{


    public static long SEED = (long)(3432); /* 420 */
    public static int PIXELS = 80;
    public static int SMOOTH_ITERATION = 10;

    public static int WATER_THRESHOLD = 87;
//    public static int BEACH_THRESHOLD = 81;
    public static int LAND_THRESHOLD = 110;
    public static int MOUNTAIN_THRESHOLD = 130;

    public static double NOISE_TO_ZERO = 0.58;
    public static double NOISE_TO_PEAK = 0.7;



    public BoxNoise() {
        super(String.format("Land %d", SEED));
        setBounds(100, 100, 800, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static double[][] getBox() {
        Random rand = new Random(SEED);
        double[][] box = new double[PIXELS][PIXELS];
        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[r].length; c++) {
                if (rand.nextDouble() < NOISE_TO_ZERO) {
                    if (rand.nextDouble() < NOISE_TO_PEAK) {
                        box[r][c] =  150 + rand.nextDouble() * 100;
                    }
                    else {
                        box[r][c] = rand.nextDouble() * 100;
                    }

                }
                else {
                    box[r][c] = 0.0;
                }
            }
        }
        return box;
        //System.out.println(input);
    }

    public static void gridPrint(double[][] box) {
        for(int r = 0; r < box.length; r++) {
            System.out.println();
            for (int c = 0; c < box[r].length; c++) {
                System.out.print((int) (box[r][c]));
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    public static double[][] blur(double[][] box, int iter) {
        for(int i = 0; i < iter; i++) {
            // go through each element
            for(int r = 0; r < box.length; r++) {
                for(int c = 0; c < box[r].length; c++) {
                    double boxSum = 0.0;
                    int items = 0;

                    // offsets for each pixel
                    for(int y = -1; y < 2; y++) {
                        for(int x = -1; x < 2; x++) {
                            try {
                                boxSum += box[r+y][c+x];
                                items ++;
                            }
                            catch(Exception e) {}

                        }
                    }

                    box[r][c] = boxSum / items;
                }
            }
        }

        return box;
    }

    //public static double[][] getBox()    { return box; }

    public void gridPaint(Graphics g, double[][] box) {
        Color col;
        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[r].length; c++) {

                int shit = (int)(box[r][c]);

                if (shit < WATER_THRESHOLD) {
                    col = new Color(0, 0, shit+100);
                }
                else if (shit < LAND_THRESHOLD) {
                    col = new Color(0, shit+50, 0);
                }
                else if (shit < MOUNTAIN_THRESHOLD) {
                    col = new Color(shit+10, 69, 19);
                }
                else {
                    col = Color.white;
                }

                g.setColor(col);
                g.fillRect(r*(800/PIXELS), c*(800/PIXELS), (800/PIXELS), (800/PIXELS));
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        double[][] box = BoxNoise.getBox();
        gridPrint(box);
        double[][] blurBox = BoxNoise.blur(box, SMOOTH_ITERATION);
        gridPrint(box);
        gridPaint(g, blurBox);

    }

    public static void main(String[] args) {
        //BoxNoise obj = new BoxNoise();
        new BoxNoise().setVisible(true);
    }

}
