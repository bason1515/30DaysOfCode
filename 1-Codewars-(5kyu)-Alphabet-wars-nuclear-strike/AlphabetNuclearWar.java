import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabetNuclearWar {

    public static String alphabetWar(String battlefield) {
        if (!battlefield.contains("#")) return clearBattlefield(battlefield);
        Pattern pattern = Pattern.compile("(#+)|(\\[.*?\\])");
        Matcher matcher = pattern.matcher(battlefield);
        List<String> bf = new ArrayList<>();
        String tmp = "";
        while(matcher.find()) {
            for (int i = 0; i < matcher.groupCount()-1; i++) {
                String s = matcher.group(i);
                if (s.contains("[") && !tmp.equals("")) {
                    bf.add(tmp);
                    tmp = "";
                    bf.add(s);
                } else if (s.contains("#")) {
                    tmp += s;
                } else {
                    bf.add(s);
                }
            }
        }
        bf.add(tmp);
        destroyShelters(bf);
        return clearBattlefield(bf.toString());
    }

    private static void destroyShelters(List<String> bf) {
        for (int i = 0; i < bf.size(); i++) {
            String s = bf.get(i);
            if (s.contains("#"))
                continue;
            if (calcDmg(bf, i) > 1)
                bf.set(i, "");
        }
    }

    private static int calcDmg(List<String> bf, int i) {
        int dmg = 0;
        if (i > 0 && bf.get(i-1).contains("#"))
            dmg += bf.get(i-1).length();
        if (i < bf.size()-1 && bf.get(i+1).contains("#"))
            dmg += bf.get(i+1).length();
        return dmg;
    }

    private static String clearBattlefield(String s) {
        return s.replaceAll("[^a-z]", "");
    }

}
