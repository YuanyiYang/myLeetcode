package first;

public class Pow {

  public static double pow(double x, int n) {
    if (n == 0)
      return 1;
    if (x == 0)
      return 0;
    boolean pos = true;
    if (n < 0) {
      pos = false;
      n = -n;
    }
    double result = 1;
    double base = x;
    while (n > 0) {
      if ((n & 1) == 1) {
        result *= base;
      }
      base = base * base;
      n = n >> 1;
    }
    return pos ? result : 1 / result;

  }
  
  public static void main(String[] args) {
    double x =  8.88023;
    int n = 3;
    System.out.println(pow(x, n));
    System.out.println(Math.sqrt(5));
  }
}
