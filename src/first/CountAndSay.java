package first;

public class CountAndSay {

  public static String countAndSay(int n) {
    String result = String.valueOf(1);
    n--;
    while (n > 0) {
      result = reduceString(result);
      n--;
    }
    return result;
  }

  private static String reduceString(String str) {
    StringBuilder result = new StringBuilder();
    int count = 0;
    char temp = str.charAt(0);
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == temp) {
        count++;
      } else {
        result.append(count);
        result.append(temp);
        temp = ch;
        count = 1;
      }
      if (i == str.length() - 1) {
        result.append(count);
        result.append(temp);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(countAndSay(5));
  }
}
