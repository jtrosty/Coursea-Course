/* *****************************************************************************
 *  Name:              Jonathan Trost
 *  Coursera User ID:  Computer Science: Programming With A Purpose
 *  Last modified:     11 April 2020
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        // boolean[] birthdayEntered = new boolean[n];

        int[] count = new int[n + 1];
        double fraction = 0.0;

        // Run all the trials
        for (int i = 0; i < trials; i++) {
            boolean[] birthdayEntered = new boolean[n];
            boolean sameBirthday = false;
            int peopleEnteredCount = 0;

            while (!sameBirthday) {
                int birthday = (int) (Math.round(Math.random() * (n - 1)));
                // System.out.println("birthday " + birthday);
                peopleEnteredCount++;
                // System.out.println("people entered " + peopleEnteredCount);

                if (birthdayEntered[birthday]) {
                    count[peopleEnteredCount - 1]++;
                    sameBirthday = true;
                }
                else {
                    birthdayEntered[birthday] = true;
                }
            }
        }

        // System.out.println("1 " + count[0] + " 2 " + count[1]);


        for (int j = 0; j <= n; j++) {
            fraction = (fraction + ((count[j] * 1.0) / trials));
            System.out.print((j + 1) + "  " + count[j] + "  " + fraction);
            System.out.println();

            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
