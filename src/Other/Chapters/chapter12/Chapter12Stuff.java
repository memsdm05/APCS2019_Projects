package Other.Chapters.chapter12;


public class Chapter12Stuff {
    public static void main(String[] args) {
        Diploma diploma1 = new Diploma("Olly Meister", "Womens Study");
        System.out.println(diploma1);
        System.out.println();

        Diploma diploma2 = new DiplomaWithHonors("Ben", "being cool");
        System.out.println(diploma2);
        System.out.println();

        Poem poem1 = new Haiku();
        Poem poem2 = new Limerick();

        poem1.printRhythm();
        System.out.println();
        poem2.printRhythm();
    }
}
