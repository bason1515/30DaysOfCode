public class Line {

    public static String WhoIsNext(String[] names, int n) {
        int multiply = 1;
        for (; multiply * names.length < n; multiply *= 2) {
            n -= multiply * names.length;
        }
        int i = 0;
        while(n > multiply) {
            n -= multiply;
            i++;
        }
        return names[i];
    }
}