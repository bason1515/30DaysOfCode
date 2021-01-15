import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        ArrayList<List<Long>> result = new ArrayList<>();
        LongStream.rangeClosed(m, n).boxed()
                .map(SumSquaredDivisors::getNumSumPair)
                .filter(pair -> isDivisorSumASquare(pair.get(1)))
                .forEach(result::add);
        return result.toString();
    }

    private static boolean isDivisorSumASquare(long l) {
        return sqrt(l) % 1 == 0;
    }

    private static List<Long> getNumSumPair(long l) {
        ArrayList<Long> divisors = findDivisors(l);
        long sum = divisors.stream()
                .mapToLong(n -> (long) pow(n, 2))
                .sum();
        return Arrays.asList(l,sum);
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
