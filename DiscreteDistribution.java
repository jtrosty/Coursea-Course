/* *****************************************************************************
 *  Name:              Jonathan Trost
 *  Coursera User ID:  Computer Science: Programming With A Purpose
 *  Last modified:     11 April 2020
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int[] sumArray;
        sumArray = new int[args.length];
        int m = Integer.parseInt(args[0]);

        for (int i = 0; i < sumArray.length; i++) {
            if (i == 0) {
                sumArray[i] = 0;
            }
            else {
                sumArray[i] = (sumArray[i - 1] + Integer.parseInt(args[i]));
            }
        }

        /*
        for (int k = 0; k < sumArray.length; k++) {
            System.out.println(sumArray[k]);
        }

         */
        // int timer = 0;


        for (int j = 0; j < m; j++) {
            double r = (Math.random() * ((sumArray[sumArray.length - 1]) - sumArray[0]))
                    + sumArray[0];
            int hi = sumArray.length - 1;
            int lo = 0;
            boolean intervalFound = false;

            while (!intervalFound) {
                int checker = ((hi - lo) / 2) + lo;

                /*
                timer++;
                if (timer == 5) {
                    intervalFound = true;
                }
                */

                // System.out.println(
                //      "checker is " + checker + " r is " + r + " hi is " + hi + " lo is " + lo);

                if (r < sumArray[checker]) {
                    hi = checker;
                }
                else if (r > sumArray[checker + 1]) {
                    lo = checker;
                }
                else {
                    System.out.print((checker + 1) + "  ");
                    intervalFound = true;
                }
            }
        }
    }
}
