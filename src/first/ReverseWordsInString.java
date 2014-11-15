package first;

public class ReverseWordsInString {

  public static String reverseWords(String s) {
    if (s == null)
      return s;
    s = clearSpaceInString(s);
    String[] tempArray = s.split(" ");
    int begin = 0;
    int end = tempArray.length - 1;
    while (begin < end) {
      String temp = tempArray[begin];
      tempArray[begin] = tempArray[end];
      tempArray[end] = temp;
      begin++;
      end--;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tempArray.length; i++) {
      sb.append(tempArray[i]);
      if (i != tempArray.length - 1) {
        sb.append(" ");
      }
    }
    return new String(sb);
  }

  private static String clearSpaceInString(String s) {
    if (s == null)
      return null;
    return s.trim().replaceAll(" +", " ");
    /*
     * This is a solution with Java Regex.
     */
  }

  private static String clearSpaceWithChar(String s) {
    s = s.trim();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (s.charAt(i - 1) == ' ') {
          count++;
        }
      }
    }
    int charLen = s.length() - count;
    char[] temp = new char[charLen];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        temp[j++] = s.charAt(i);
      } else {
        if (s.charAt(i - 1) != ' ') {
          temp[j++] = s.charAt(i);
        }
      }
    }
    return new String(temp);
  }
  
  public static String oneScan(String s){
    if(s==null) return null;
    StringBuilder result = new StringBuilder();
    int end = s.length();
    for(int i=s.length()-1;i>=0;i--){
      if(s.charAt(i)==' '){
        end = i;
        continue;
      }
      if(i==0||s.charAt(i-1)==' '){
        if(result.length()!=0){
          result.append(' ');
        }
        result.append(s.substring(i, end));
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String test = "     a    b   ";
    System.out.println(ReverseWordsInString.reverseWords(test));
  }
}
