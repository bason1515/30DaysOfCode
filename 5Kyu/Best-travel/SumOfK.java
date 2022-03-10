import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfK {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        List<Integer> allDistances = findDistances(k, ls);
        return allDistances.stream()
            .filter(x -> x <= t)
            .max(Integer::compareTo)
            .orElse(null);
    }

    private static List<Integer> findDistances(int k, List<Integer> ls) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(list, new ArrayList<>(), ls, 0, k);
        return list.stream()
            .map(integers -> integers.stream()
                .reduce(0, Integer::sum))
            .collect(Collectors.toList());
    }

    private static void subsets(List<List<Integer>> list, ArrayList<Integer> result, List<Integer> ls, int start, int limit) {
        if (result.size() == limit) {
            list.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i < ls.size(); i++) {
            result.add(ls.get(i));
            subsets(list, result, ls, i + 1, limit);
            result.remove(result.size() - 1);
        }
    }
}