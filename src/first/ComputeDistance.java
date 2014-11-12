package first;

public class ComputeDistance {

  // edit distance with one swap operation whose cost is 1
  // replacement operation is 1.5
  // insert and deletion with 1
  
  private static double insert = 1.0;
  private static double delete = 1.0;
  private static double replacement = 1.5;
  private static double swap = 1.0;
  private static int swapCount = 0;
  
  private static void compute(String a, String b) {
    swapCount = 0;
    if(a==null||b==null) return ;
    if(a.length()==0||b.length()==0) return;
    double[][] dp = new double[b.length()+1][a.length()+1];
    for ( int i = 0; i<dp[0].length; i++ ) {
      dp[0][i] = i;
    }
    for ( int j = 0; j<dp.length; j++ ) {
      dp[j][0] = j;
    }
    for(int i=1;i<dp[0].length;i++){
      for(int j=1;j<dp.length;j++){
        double replaceCost = (a.charAt(i-1) == b.charAt(j-1)) ? 0 : replacement;
        double ins = dp[j-1][i] + insert;
        double del = dp[j][i-1] + delete;
        double rep = dp[j-1][i-1] + replaceCost;
        double cur = min(ins, del, rep);
        if(i>=2&&j>=2&&swapCount==0){
          if(a.charAt(i-2)==b.charAt(j-1) && a.charAt(i-2)==b.charAt(j-1)){
            double swapCost = dp[j-2][i-2] + swap;
            if(swapCost<cur){
              cur = swapCost;
              swapCount++;
            }
          }
        }
        dp[j][i] = cur;
      }
    }
    System.out.println(dp[b.length()][a.length()]);
  }
  
  private static double min (double a, double b, double c) {
    double local = Math.min(a, b);
    return Math.min(local, c);
  }
  
  public static void main(String[] args) {
    //compute("porsche", "procese");
    compute("failing", "sailn");
    compute("google", "gogol");
  }
}
