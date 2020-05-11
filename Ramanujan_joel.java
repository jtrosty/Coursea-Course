//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Ramanujan {
  public Ramanujan() {
  }

  private static boolean isWholeNumber(double error, double n) {
    return error > Math.abs(n - Math.ceil(n)) || error > Math.abs(n - Math.floor(n));
  }

  public static boolean isRamanujan(long n) {
    double error = 1.0E-11D;
    double maxNum = Math.cbrt((double)n);
    boolean firstSet = false;
    double a = 1.0D;
    double b = 1.0D;
    double c = 1.0D;
    double d = 1.0D;

    for(int i = 1; (double)i < maxNum; ++i) {
      double aCubed = (double)(i * i * i);
      double resultB = Math.cbrt((double)n - aCubed);
      if (isWholeNumber(error, resultB) && !firstSet) {
        a = (double)i;
        b = Math.ceil(resultB);
        firstSet = true;
      } else if (isWholeNumber(error, resultB) && firstSet) {
        c = (double)i;
        d = Math.ceil(resultB);
        break;
      }
    }

    if (Math.abs(a + b - (c + d)) < 1.0D) {
      return false;
    } else {
      a = a * a * a;
      b = b * b * b;
      c = c * c * c;
      d = d * d * d;
      return error > a + b - (c + d) && firstSet;
    }
  }

  public static void main(String[] args) {
    long n = Long.parseLong(args[0]);
    System.out.println(isRamanujan(n));
  }
}
