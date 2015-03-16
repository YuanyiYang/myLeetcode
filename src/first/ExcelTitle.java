package first;

/*
 * int manipulation
 */
public class ExcelTitle {

  public static String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      char x;
      if (n % 26 == 0) {
        x = con(26);
        n--;
      } else {
        x = con(n % 26);
      }
      sb.append(x);
      n = n / 26;
    }
    return sb.reverse().toString();
  }

  public static char con(int i) {
    return (char) ('A' - 1 + i);
  }
  
  public static void main(String[] args) {
    System.out.println(convertToTitle(28));
  }
}
