public class Kata {

    public static long nextBiggerNumber(long n)
    {
        int[] bonds = findBonds(n);
        long result = swapNumbers(n, bonds);
        return result == n ? -1 : result;
    }

    private static int[] findBonds(long n) {
        char[] arr = Long.toString(n).toCharArray();
        int leftBond = arr.length-1;
        int rightBond = arr.length-1;
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i-1] < arr[i]) {
                leftBond = i-1;
                rightBond = findFirstLowestOnRight(arr, leftBond);
                break;
            }
        }
        return new int[] {leftBond, rightBond};
    }

    private static int findFirstLowestOnRight(char[] arr, int i) {
        int lowest = i+1;
        for (int j = i+1; j < arr.length; j++) {
            if (arr[i] >= arr[j])
                break;
            lowest = j;
        }
        return lowest;
    }

    private static int findLowestOnRight(char[] arr, int i) {
        int lowest = i;
        for (int j = i+1; j < arr.length; j++) {
            if (arr[lowest] >= arr[j])
                lowest = j;
        }
        return lowest;
    }

    private static long swapNumbers(long n, int[] bonds) {
        char[] arr = Long.toString(n).toCharArray();
        swapChars(arr, bonds[0], bonds[1]);
        for (int i = bonds[0]+1; i < arr.length-1; i++) {
            swapChars(arr, i, findLowestOnRight(arr, i));
        }
        return Long.parseLong(new String(arr));
    }

    private static void swapChars(char[] arr, int c1, int c2) {
        char tmp = arr[c1];
        arr[c1] = arr[c2];
        arr[c2] = tmp;
    }
}