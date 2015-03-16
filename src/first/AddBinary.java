package first;

/*
 *  For example,
 *  a = "11"
 *  b = "1"
 *  Return "100".
 *  One Pass.
 */
public class AddBinary {

  public String revised(String a, String b) {
    if (a == null || b == null)
      return a == null ? b : a;
    if (a.length() == 0 || b.length() == 0)
      return a.length() == 0 ? b : a;
    int al = a.length() - 1;
    int bl = b.length() - 1;
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while (al >= 0 || bl >= 0 || carry > 0) {
      int ai = 0;
      int bi = 0;
      if (al >= 0) {
        ai = a.charAt(al) - '0';
        al--;
      }
      if (bl >= 0) {
        bi = b.charAt(bl) - '0';
        bl--;
      }
      int v = carry + ai + bi;
      sb.insert(0, v % 2); // 注意这里第一个参数是index
      carry = v / 2;
    }
    return sb.toString();
  }
}
