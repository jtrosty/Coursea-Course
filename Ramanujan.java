/* *****************************************************************************
 *  Name:              Jonathan Trost
 *  Coursera User ID:  Computer Science:
 *  Last modified:     5 May 2020
 **************************************************************************** */

public class Ramanujan {

    private static boolean isWholeNumber(double error, double n) {
        return (error > Math.abs(n - Math.ceil(n)) || error > Math.abs(n - Math.floor(n)));
    }

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        double error = 0.00000000001;
        double maxNum = Math.cbrt(n);
        boolean firstSet = false;
        double a = 1;
        double b = 1;
        double c = 1;
        double d = 1;


        for (int i = 1; i < maxNum; i++) {
            double aCubed = i * i * i;
            double resultB = Math.cbrt(n - aCubed);

            // StdOut.print(" results B " + resultB);

            if (isWholeNumber(error, resultB) && !firstSet) {
                a = i;
                b = Math.ceil(resultB);
                // System.out.println(" a is " + a + " b is " + b);
                firstSet = true;
            }
            else if (isWholeNumber(error, resultB) && firstSet) {
                c = i;
                d = Math.ceil(resultB);
                // System.out.println(" c is " + c + " d is " + d);
                break;
            }
        }

        if (Math.abs((a + b) - (c + d)) < 1) return false;
        a = (a * a * a);
        b = (b * b * b);
        c = (c * c * c);
        d = (d * d * d);

        if (error > ((a + b) - (c + d)) && firstSet) return true;
        return false;
    }
    // java-introcs Ramanujan 9223278330318728221

    // 1729 = 1 + 12 = 9 + 10
    // 4104, 16, 2, 15, 9
    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
