package first;

public class AddBinary {

  public String addBinary(String a, String b) {
    if (a == null || b == null) {
      return a == null ? b : a;
    }
    if (a.length() == 0 || b.length() == 0) {
      return a.length() == 0 ? b : a;
    }
    StringBuilder resultBuilder = new StringBuilder();
    int resultLength = Math.max(a.length(), b.length()) + 1;
    int[] result = new int[resultLength];
    int[] strA = new int[a.length()];
    int[] strB = new int[b.length()];
    reverseString(a, strA);
    reverseString(b, strB);
    int carry = 0;
    for (int i = 0; i < result.length; i++) {
      if (i < strA.length) {
        result[i] += strA[i];
      }
      if (i < strB.length) {
        result[i] += strB[i];
      }
      result[i] += carry;
      if (result[i] >= 2) {
        carry = 1;
      } else {
        carry = 0;
      }
      result[i] %= 2;
      if (i == result.length - 1 && result[i] == 0)
        break;
      resultBuilder.append(result[i]);
    }
    return resultBuilder.reverse().toString();
  }

  private void reverseString(String str, int[] result) {
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      result[result.length - 1 - i] = ch - '0';
    }
  }
}
