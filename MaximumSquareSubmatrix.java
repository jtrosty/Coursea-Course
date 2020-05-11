/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // This will compare the 3 array entries for the support array
    // and return the min value of them.
    private static int getMinvalue(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int size = a.length;
        int[][] b = new int[size][size];
        int maxArraySize = 0;

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (j == 0) b[i][0] = a[i][0];
                else if (a[i][j] == 1 && i == 0) {
                    b[i][j] = 1;
                }
                else if (a[i][j] == 1) {
                    // I get min value and add 1 at the end.
                    b[i][j] = getMinvalue(b[i - 1][j], b[i][j - 1], b[i - 1][j - 1]) + 1;
                    maxArraySize = Math.max(b[i][j], maxArraySize);
                }
                else {
                    b[i][j] = 0;
                }
            }
        }
        return maxArraySize;
    }

    // Reads an n-by-n matrix  of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(a));

    }
}
