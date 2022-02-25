import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {

    public static String orderWeight(String strng) {
        String[] weights = strng.split("[^\\d]+");
        return Arrays.stream(weights)
            .sorted(Comparator.comparingInt(WeightSort::sumNumbers)
                .thenComparing(o -> o))
            .collect(Collectors.joining(" "));
    }

    private static int sumNumbers(String num) {
        return num.chars()
            .map(Character::getNumericValue)
            .sum();
    }
}