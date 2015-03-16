package first;
import java.util.*;
/*
 * 既然知道循环次数，for loop要比while loop好写一些
 * 用一个list来保存未使用的数，通过index来取数
 * 把kth 换成 数字的， k--
 */
public class GetPermutation {
  public static String getPermutation(int n, int k) {
    List<Integer> list = new ArrayList<Integer>();
    int fac = 1;
    for(int i=1;i<=n;i++){
      list.add(i);
      fac *= i;
    }
    k--;  // k-- 
    StringBuilder sb = new StringBuilder();
    for(int i=n;i>=1;i--){
      int bucket = fac / i;
      int index = k / bucket;
      int num = list.get(index);
      sb.append(num);
      list.remove(index);
      k %= bucket;
      fac = fac / i;
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(getPermutation(3, 4));
  }
}
