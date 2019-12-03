package Other.Chapters;

public class Chap6Stuff {
    public double totalWages(double hours, double rate) {
        double wages;
        wages = (hours > 40) ? 40 * rate + 1.5 * (hours - 40) * rate: rate * hours;
        return wages;
    }

    public static void main(String[] args) {
    Chap6Stuff stuff = new Chap6Stuff();
    System.out.println(stuff.totalWages(45, 12.50));
    int avg = 24;
    char grade = ' ';

    if (avg < 60)
        grade = 'F';
    else if (avg < 70)
        grade = 'D';
    else if (avg < 80)
        grade = 'C';
    else if (avg < 90)
        grade = 'B';
    else
        grade = 'A';

    System.out.println(grade);
    }
}
