package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * n,m 两个数，要求把n变成m，可以进行的操作是-1或者*2,即 n-1 or n*2,求把n变成m需要的最小次数
 * 1<=n.m<=10,000
 * 4,6 => 2; (4-1)*2
 * 10, 1 => 9
 */
public class Two_Buttons_NYU_ProgT {

  /*
   * 因为这里给定了n，m的范围，而且每次步骤的权重是1，所以可以想到用一个BFS，用一个array来记录步骤
   * 次数，当第一个n==m的时候，也就是得到最终结果的时候。由于n,m<=10000,所以需要一个长度是20000的数组
   * 来记录
   */

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String line = null;
    line = bf.readLine();
    String[] tokens = line.split(" ");
    int n = Integer.parseInt(tokens[0]);
    int m = Integer.parseInt(tokens[1]);
    int[] arr = new int[20000];
    LinkedList<Integer> l = new LinkedList<Integer>();
    if (n == m) {
      System.out.println(0);
    } else if (n > m) {
      System.out.println(n - m);
    } else {
      l.add(n);
      BFS(arr, m, l);
      System.out.println(arr[m]);
    }
  }

  public static void BFS(int[] arr, int m, LinkedList<Integer> l) {
    while (!l.isEmpty()) {
      int n = l.pollFirst();
      if (n == m) {
        return;
      }

      /*
       * 这里在插入节点之前判断，相对节省时间
       * 而且不用判断不等于0的情况，在那种情况的时候，节点肯定被访问过了
       */
      if (n > 0 && arr[n - 1] == 0) {
        arr[n - 1] = arr[n] + 1;
        l.add(n - 1);
      }

      if (2 * n < 20000 && arr[2 * n] == 0) {
        arr[2 * n] = arr[n] + 1;
        l.add(2 * n);
      }
    }
  }
}
