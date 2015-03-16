package first;

/*
 * Recursive time out
 * Two-dimenstion DP
 */
public class DistinctSubsequences {

  public static int numDistinct(String s, String t) {
    if (t.length() == 0)
      return 1;
    if (s.length() == 0)
      return 0;
    if (s.length() == 1 && t.length() == 1) {
      if (s.charAt(0) == t.charAt(0)) {
        return 1;
      } else {
        return 0;
      }
    }
    if (s.charAt(0) == t.charAt(0)) {
      return numDistinct(s.substring(1), t.substring(1))
          + numDistinct(s.substring(1), t);
    } else {
      return numDistinct(s.substring(1), t);
    }
  }

  public static int dp(String S, String T) {
    if (S == null || T == null || S.length() == 0 || T.length() == 0)
      return 0;
    int[][] dp = new int[S.length() + 1][T.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 1; // pay attention to the initialization
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[S.length()][T.length()];
  }

  public static void main(String[] args) {
    String s = "rabbbit";
    String t = "rabbit";
    String a = "ccc";
    String b = "c";
    System.out.println(dp(a, b));
    System.out.println(dp(s, t));
  }
}
