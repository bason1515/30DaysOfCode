import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScreenLock {

    private static int desiredLength;
    private static int patternsAmount;
    private static final Map<Character, char[]> MOVES;
    private static final Map<Character, Map<Character, Character>> CROSS_MOVES;
    static {
        Map<Character, char[]> moves = new HashMap<>();
        moves.put('A', new char[] {'B', 'E', 'D', 'F', 'H'});   // 5
        moves.put('B', new char[] {'A', 'D', 'E', 'F', 'C', 'G', 'I'}); // 7
        moves.put('C', new char[] {'B', 'E', 'F', 'D', 'H'});   // 5
        moves.put('D', new char[] {'A', 'B', 'E', 'H', 'G', 'C', 'I'}); // 7
        moves.put('E', new char[] {'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I'});    // 8
        moves.put('F', new char[] {'C', 'B', 'E', 'H', 'I', 'A', 'G'}); // 7
        moves.put('G', new char[] {'D', 'E', 'H', 'B', 'F'});   // 5
        moves.put('H', new char[] {'G', 'D', 'E', 'F', 'I', 'A', 'C'}); // 7
        moves.put('I', new char[] {'H', 'E', 'F', 'D', 'B'});   // 5
        MOVES = Collections.unmodifiableMap(moves);

        Map<Character, Map<Character, Character>> cMoves = new HashMap<>();
        cMoves.put('B', Stream.of(
                new AbstractMap.SimpleImmutableEntry<>('A', 'C'),
                new AbstractMap.SimpleImmutableEntry<>('C', 'A')
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        cMoves.put('D', Stream.of(
                new AbstractMap.SimpleImmutableEntry<>('A', 'G'),
                new AbstractMap.SimpleImmutableEntry<>('G', 'A')
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        cMoves.put('F', Stream.of(
                new AbstractMap.SimpleImmutableEntry<>('C', 'I'),
                new AbstractMap.SimpleImmutableEntry<>('I', 'C')
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        cMoves.put('H', Stream.of(
                new AbstractMap.SimpleImmutableEntry<>('G', 'I'),
                new AbstractMap.SimpleImmutableEntry<>('I', 'G')
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        cMoves.put('E', Stream.of(
                new AbstractMap.SimpleImmutableEntry<>('B', 'H'),
                new AbstractMap.SimpleImmutableEntry<>('H', 'B'),
                new AbstractMap.SimpleImmutableEntry<>('D', 'F'),
                new AbstractMap.SimpleImmutableEntry<>('F', 'D'),
                new AbstractMap.SimpleImmutableEntry<>('A', 'I'),
                new AbstractMap.SimpleImmutableEntry<>('I', 'A'),
                new AbstractMap.SimpleImmutableEntry<>('G', 'C'),
                new AbstractMap.SimpleImmutableEntry<>('C', 'G')
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        CROSS_MOVES = Collections.unmodifiableMap(cMoves);
    }

    public int calculateCombinations(char startPosition, int patternLength) {
        init(patternLength);
        visitNextFrom(startPosition, new ArrayList<>(), 0);
        return patternsAmount;
    }

    private void init(int patternLength) {
        desiredLength = patternLength;
        patternsAmount = 0;
    }

    private void visitNextFrom(char pos, List<Character> visited, int currentLength) {
        currentLength++;
        visited.add(pos);
        if (currentLength == desiredLength) {
            patternsAmount++;
            return;
        }
        for (char move : MOVES.get(pos)) {
            if (!visited.contains(move)) {
                visitNextFrom(move, new ArrayList<>(visited), currentLength);
            } else if (CROSS_MOVES.containsKey(move)) {
                Character crossTo = CROSS_MOVES.get(move).get(pos);
                if (crossTo != null && !visited.contains(crossTo)) {
                    visitNextFrom(crossTo, new ArrayList<>(visited), currentLength);
                }
            }
        }
    }
}