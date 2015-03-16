package first;

public class LongestCommonPrefix {

  public String iterativeWay(String[] strs) {
    if (strs == null || strs.length == 0)
      return "";
    StringBuilder result = new StringBuilder();
    int index = 0;
    while (true) {
      if (strs[0].length() <= index)
        break;
      char global = strs[0].charAt(index);
      for (int i = 1; i < strs.length; i++) {
        String current = strs[i];
        if (current.length() <= index || current.charAt(index) != global) {
          return result.toString();
        }
      }
      index++;
      result.append(global);
    }
    return result.toString();
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
      return "";
    int minL = Integer.MAX_VALUE;
    for (String str : strs) {
      minL = Math.min(minL, str.length());
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < minL; i++) {
      char cur = strs[0].charAt(i);
      for (String str : strs) {
        if (str.charAt(i) != cur) {
          return result.toString();
        }
      }
      result.append(cur);
    }
    return result.toString();
  }
}
