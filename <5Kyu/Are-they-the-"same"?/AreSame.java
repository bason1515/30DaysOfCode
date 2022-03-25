import java.util.stream.IntStream;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        int[] aSorted = IntStream.of(a)
            .map(i -> i * i)
            .sorted()
            .toArray();
        int[] bSorted = IntStream.of(b)
            .sorted()
            .toArray();
        for (int i = 0; i < a.length; i++) {
            if (aSorted[i] != bSorted[i])
                return false;
        }
        return true;
    }
}