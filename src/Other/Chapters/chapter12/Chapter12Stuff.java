package Other.Chapters.chapter12;


public class Chapter12Stuff {
    public static void main(String[] args) {
        Diploma diploma1 = new Diploma("Olly Meister", "Womens Study");
        System.out.println(diploma1);
        System.out.println();

        Diploma diploma2 = new DiplomaWithHonors("Emilcel", "Bitcoin Investment");
        System.out.println(diploma2);
        System.out.println();

        Haiku poem1 = new Haiku();
        Limerick poem2 = new Limerick();

        poem1.printRhythm();
        System.out.println();
        poem2.printRhythm();
    }
}
