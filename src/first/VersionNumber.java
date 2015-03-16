package first;
import java.util.*;
public class VersionNumber {
  public static  int compareVersion(String version1, String version2) {
    if (version1 == null || version2 == null) {
      return version1 == null ? -1 : 1;
    }
    List<Integer> v1 = new ArrayList<Integer>(), v2 = new ArrayList<Integer>();
    int r1 = 0, r2 = 0;
    for (int i = 0; i < version1.length(); i++) {
      char ch = version1.charAt(i);
      if (ch != '.') {
        r1 = 10 * r1 + ch - '0';
      } else {
        v1.add(r1);
        r1 = 0;
      }
    }
    v1.add(r1);
    for (int i = 0; i < version2.length(); i++) {
      char ch = version2.charAt(i);
      if (ch != '.') {
        r2 = 10 * r2 + ch - '0';
      } else {
        v2.add(r2);
        r2 = 0;
      }
    }
    v2.add(r2);
    int len = Math.min(v1.size(), v2.size());
    for (int i = 0; i < len; i++) {
      if (v1.get(i) < v2.get(i)) {
        return -1;
      } else if (v1.get(i) > v2.get(i)) {
        return 1;
      }
    }
    if (v1.size() == v2.size())
      return 0;
    else
      return v1.size() > v2.size() ? 1 : -1;
  }
  
  public static void main(String[] args) {
    System.out.println(compareVersion("1.0", "0."));
    char s = 'a';
    System.out.println(s+"");
    int x = -2147447412;
    System.out.println(0-x);
  }
}
