import java.util.ArrayList;
import java.util.List;

public class Snail {

    private static int x,y; // Current position
    private static int l,r,d,u; // Visited sides
    private static int[][] arr;
    private static List<Integer> snail;

    public static int[] snail(int[][] array) {
        init(array);
        int arrLength = arr.length * arr[0].length;
        while(snail.size() != arrLength) {
            traverseRight();
            traverseDown();
            traverseLeft();
            traverseUp();
        }
        return snail.stream().mapToInt(i -> i).toArray();
    }

    private static void init(int[][] array) {
        x = 0;
        y = 0;
        l = 0;
        r = 0;
        d = 0;
        u = 0;
        arr = array;
        snail = new ArrayList<>();
    }

    private static void traverseRight() {
        for (; x < arr[0].length-r; x++) {
            snail.add(arr[y][x]);
        }
        x--;
        u++;
        y++;
    }

    private static void traverseDown() {
        for (; y < arr[0].length-d; y++) {
            snail.add(arr[y][x]);
        }
        y--;
        r++;
        x--;
    }

    private static void traverseLeft() {
        for (; x >= l; x--) {
            snail.add(arr[y][x]);
        }
        x++;
        d++;
        y--;
    }

    private static void traverseUp() {
        for (; y >= u; y--) {
            snail.add(arr[y][x]);
        }
        y++;
        l++;
        x++;
    }
}