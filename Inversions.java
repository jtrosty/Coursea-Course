/* *****************************************************************************
 *  Name:              Jon Trost
 *  Coursera User ID:  Computer Science
 *  Last modified:     4 May 2020
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int counter = 0;

        // worst solution
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] > a[j] && i < j) counter++;
            }
        }
        return counter;
    }

    // Method for swapping
    private static void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // Return a permuation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        long maxK = ((n * (n - 1)) / 2);
        int[] generatedInversions = new int[n];
        int countOfSwaps = 0;
        int length = (n - 1);
        long countK = k;

        //
        if (k >= maxK) {
            for (int i = 0; i < n; i++) {
                generatedInversions[i] = n - 1 - i;
            }
            return generatedInversions;
        }

        // Make array and initialize entries
        for (int i = 0; i < n; i++) {
            generatedInversions[i] = i;
        }
        if (k == 0) return generatedInversions;
        if (k == 2) {
            swap(0, 1, generatedInversions);
            swap(1, 2, generatedInversions);
            countK = countK - 2;
            return generatedInversions;
        }

        // Figure out how many big swaps have to happen and gets the remainder
        while (countK > ((2 * length) - 1)) {
            countOfSwaps++;
            countK = (countK + 1) - (2 * length);
            length = (length - 2);
            // StdOut.println("In while loop");
        }

        // Make all the big swaps
        for (int i = 0; i < countOfSwaps; i++) {
            swap(i, n - 1 - i, generatedInversions);
        }

        if (countK == 1) {
            swap(countOfSwaps, countOfSwaps + 1, generatedInversions);
            countK--;
            return generatedInversions;
        }

        // Do the last swap for the reminder of k
        int positionChange = (int) ((countK - 1) / 2) + 1;
        swap(countOfSwaps, countOfSwaps + positionChange, generatedInversions);

        if (countK % 2 == 0) {
            swap(countOfSwaps + positionChange, countOfSwaps + positionChange + 1,
                 generatedInversions);
        }

        return generatedInversions;

        /*
        // redundant code,
        if (k >= maxK) {
            for (int i = 0; i < n; i++) {
                generatedInversions[i] = n - 1 - i;
            }
            return generatedInversions;
        }
        // Start with a fully inversed array and bubble sort it to desired
        // level of inversions
        else if (k >= maxK / 2) {
            numOfInversions = maxK;
            for (int i = 0; i < n; i++) {
                generatedInversions[i] = n - 1 - i;
            }
            for (int j = 0; j < n; j++) {
                if (numOfInversions == k) break;
                for (int i = 1; i < n; i++) {
                    if (numOfInversions == k) break;
                    else if (generatedInversions[i - 1] > generatedInversions[i]) {
                        swap(i, i - 1, generatedInversions);
                        numOfInversions--;
                    }
                }
            }
        }
        // Start with a array from 0 to n-1, bubble sort it to desired
        // level of inversions
        else {
            numOfInversions = 0;

            for (int i = 0; i < n; i++) {
                generatedInversions[i] = i;
            }
            for (int j = 0; j < n; j++) {
                if (numOfInversions == k) break;
                for (int i = 1; i < n; i++) {
                    if (numOfInversions == k) break;
                    else if (generatedInversions[i - 1] < generatedInversions[i]) {
                        swap(i, i - 1, generatedInversions);
                        numOfInversions++;
                    }
                }
            }
        }
        return generatedInversions;
         */
    }


    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] inversedArray = generate(n, k);

        for (int i = 0; i < n; i++) {
            StdOut.print(inversedArray[i] + " ");
        }
        StdOut.println();
    }
}
