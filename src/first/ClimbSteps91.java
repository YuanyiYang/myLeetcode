package first;

public class ClimbSteps91 {

  public static int climb(int n){
    if(n==0) return 0;
    if(n==1) return 1;
    if(n==2) return 2;
    if(n==3) return 4;    
    return climb(n-1) + climb(n-2) + climb(n-3);
  }
  
  public static int dp(int n){
    if(n==0) return 0;
    if(n==1) return 1;
    if(n==2) return 2;
    if(n==3) return 4;  
    int p = 1;
    int q = 2;
    int r = 4;
    for(int i=4;i<=n;i++){
      int temp = p + q + r;
      p = q;
      q = r;
      r = temp;
    }
    return r;
  }
  
  public static int simpleAnswer(int n){
    if(n<0){
      return 0;
    }else if(n==0){
      return 1;
    }else {
      return simpleAnswer(n-1) + simpleAnswer(n-2) + simpleAnswer(n-3);
    }
  }
  
  public static void main(String[] args) {
    System.out.println(climb(20));
    System.out.println(dp(20));
    System.out.println(simpleAnswer(20));
  }
}
