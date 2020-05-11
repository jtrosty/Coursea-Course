/* *****************************************************************************
 *  Name:              Jonathan Trost
 *  Coursera User ID:  Computer Science: Programming With A Purpose
 *  Last modified:     11 April 2020
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] thueArray = new boolean[n * n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                thueArray[i] = false;
            }
            else if (0 == i % 2) {
                thueArray[i] = thueArray[i / 2];
            }
            else {
                thueArray[i] = !thueArray[i - 1];
            }
        }

        for (int j = 0; j < n * n; j++) {
            if ((j % n) == 0 && j != 0) {
                System.out.println();
            }

            if (thueArray[j % n] == thueArray[j / n]) {
                System.out.print("+  ");
            }
            else {
                System.out.print("-  ");
            }
        }

    }
}
