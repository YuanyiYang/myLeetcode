package first;

import java.util.*;

public class CombinationSum2 {
  public static List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    if (num == null || num.length == 0)
      return results;
    List<Integer> result = new ArrayList<Integer>();
    Arrays.sort(num);
    boolean[] visited = new boolean[num.length];
    helper(results, result, target, 0, num, visited);
    return results;
  }

  public static void helper(List<List<Integer>> results, List<Integer> result,
      int target, int index, int[] num, boolean[] visited) {
    if (target == 0) {
      results.add(new ArrayList<Integer>(result));
      return;
    }
    if (index == num.length)
      return;
    for (int i = index; i < num.length; i++) {
      if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) {
        continue;
      } else {
        int cur = num[i];
        if (cur > target)
          return;
        result.add(cur);
        visited[i] = true;
        helper(results, result, target - cur, i + 1, num, visited);
        visited[i] = false;
        result.remove(result.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] re = { 1 };
    System.out.println(combinationSum2(re, 1));
  }
}
