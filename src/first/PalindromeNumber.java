package first;

public class PalindromeNumber {

  public static boolean isPalindrome(int x) {

    if (x < 0)
      return false;
    int div = 1;
    while (x / div >= 10) {
      div *= 10;
    }
    while (x > 0) {
      int least = x % 10;
      int highest = x / div;
      if (least != highest) {
        return false;
      }
      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(100000001));
    System.out.println(Integer.MAX_VALUE == Math.abs(Integer.MIN_VALUE + 1));
    System.out.println(Integer.MIN_VALUE);
    long num = 9000000001l;
    System.out.println((int)num);
  }
}
