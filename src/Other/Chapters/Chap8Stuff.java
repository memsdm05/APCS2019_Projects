package Other.Chapters;

public class Chap8Stuff {

    public String dateConv(String date) {
        String[] v = date.split("/");
        return ((v[1].length()==1)? "0" + v[1] : v[1]) + "-" + ((v[0].length()==1)? "0" + v[0] : v[0]) + "-" + v[2];
    }

    public String scroll(String s) {
        return s.substring(1) + s.charAt(0);
    }

    public String convertName(String s) {
        s = s.trim();
        return s.substring(s.indexOf(", ")+2) + " " + s.substring(0, s.indexOf(", "));
    }

    public String neg(String BooleanCochran) {
        return BooleanCochran.replace("0", "*").replace("1", "0").replace("*", "1");
    }

    public boolean frogMenFromMars(String s) {
        return s.replaceAll(s.substring(0,1), "").length() == 0;
    }

    public String cutOut(String s, String r) {
        return s.replaceFirst(r, "");
    }

    public boolean digital(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean star(String s) {return s.length() > 0 && s.endsWith("*");}
    public boolean twoStar(String s) {return s.length() > 1 && s.endsWith("**");}

    public static void main(String[] args) {
        Chap8Stuff app = new Chap8Stuff();
        // 000110101010110101010101
        // 111001010101001010101010
        System.out.println(app.neg("111001010101001010101010"));
        System.out.println(app.star("ijsdfouhs"));
        System.out.println(app.star("**"));
        System.out.println(app.dateConv("1/4/1234"));
        System.out.println(app.cutOut("Hi-ho, hi-ho", "-ho"));
        System.out.println(app.convertName("Browner, Ben"));
        System.out.println(app.frogMenFromMars("bbbbbbbbb"));
        System.out.println(app.digital("12342343"));
    }
}
