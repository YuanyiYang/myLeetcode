package first;

public class ReverseInteger {

  public int reverse(int x) {
    boolean negative = false;
    if (x == Integer.MIN_VALUE)
      return 0;
    if (x != Math.abs(x)) {
      negative = true;
      x = Math.abs(x);
    }
    int result = 0;
    while (x != 0) {
      if (result > Integer.MAX_VALUE / 10) {
        return 0;
      } else if (result == Integer.MAX_VALUE) {
        if (x % 10 > Integer.MAX_VALUE % 10) {
          return 0;
        }
      }
      result = result * 10 + x % 10;
      x = x / 10;
    }
    if (negative) {
      return 0 - result;
    }
    return result;
  }
}
