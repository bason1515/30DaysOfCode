import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
    private static int[][] sudoku;

    public static boolean check(int[][] sudokuSolution) {
        sudoku = sudokuSolution;
        return areBlocksValid() && areRowsValid() && areColumnsValid();
    }

    private static boolean areBlocksValid() {
        for (int i = 0; i < 9; i+=3)
            for (int j = 0; j < 9; j+=3)
                if (!isBlockValid(i, j))
                    return false;
        return true;
    }

    private static boolean isBlockValid(int i, int j) {
        Set<Integer> set = new HashSet<>();
        for (int y = i; y < i+3; y++)
            for (int x = j; x < j+3; x++)
                set.add(sudoku[y][x]);
        return set.size() == 9 && !set.contains(0);
    }

    private static boolean areRowsValid() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                set.add(sudoku[i][j]);
        return set.size() == 9 && !set.contains(0);
    }

    private static boolean areColumnsValid() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                set.add(sudoku[j][i]);
        return set.size() == 9 && !set.contains(0);
    }
}