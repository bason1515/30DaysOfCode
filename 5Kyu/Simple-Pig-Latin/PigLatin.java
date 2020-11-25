public class PigLatin {
    public static String pigIt(String str) {
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            String firstLetter = s[i].substring(0,1);
            if (s[i].matches("^[a-zA-z]+$")) {
                s[i] = s[i].substring(1) + firstLetter + "ay";
            }
        }
        return String.join(" ", s);
    }
}