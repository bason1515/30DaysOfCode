import java.util.ArrayList;
import java.util.stream.LongStream;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        StringBuilder sb = new StringBuilder("[");
        LongStream.rangeClosed(m, n).boxed()
                .map(SumSquaredDivisors::getNumSumPair)
                .filter(pair -> isDivisorSumASquare(pair[1]))
                .forEach(pair -> sb.append(String.format("[%d, %d], ", pair[0], pair[1])));
        return sb.delete(sb.length()-2, sb.length())
                .append("]")
                .toString();
    }

    private static boolean isDivisorSumASquare(long l) {
        return sqrt(l) % 1 == 0;
    }

    private static long[] getNumSumPair(long l) {
        ArrayList<Long> divisors = findDivisors(l);
        long sum = divisors.stream()
                .mapToLong(n -> (long) pow(n, 2))
                .sum();
        return new long[] {l, sum};
    }

    private static ArrayList<Long> findDivisors(long l) {
        ArrayList<Long> divisors = new ArrayList<>();
        for (long i = 1; i <= sqrt(l); i++) {
            if(l % i == 0) {
                divisors.add(i);
                if(i != l/i) divisors.add(l/i);
            }
        }
        return divisors;
    }
}
