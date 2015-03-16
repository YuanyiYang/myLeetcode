package first;

public class EditDistance {

  public static int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) {
      return 0;
    } else if (word1 == null || word2 == null) {
      return word1 == null ? word2.length() : word1.length();
    } else {
      int len1 = word1.length();
      int len2 = word2.length();
      int[][] dp = new int[len2 + 1][len1 + 1];
      dp[0][0] = 0;
      for (int j = 1; j < len2 + 1; j++) {
        dp[j][0] = j;
      }
      for (int i = 1; i < len1 + 1; i++) {
        dp[0][i] = i;
      }
      for (int i = 1; i < len1 + 1; i++) {
        for (int j = 1; j < len2 + 1; j++) {
          char a = word1.charAt(i - 1);
          char b = word2.charAt(j - 1);
          int cost = Math.min(dp[j][i-1], dp[j - 1][i]) + 1;
          if (a == b) {
            cost = Math.min(cost, dp[j - 1][i - 1]);
          } else {
            cost = Math.min(cost, dp[j - 1][i - 1] + 1);
          }
          dp[j][i] = cost;
        }
      }
      return dp[len2][len1];
    }
  }
  
  public static void main(String[] args) {
    System.out.println(minDistance("a", "ab"));
  }
}
