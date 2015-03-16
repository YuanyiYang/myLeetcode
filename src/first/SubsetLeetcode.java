package first;

import java.util.*;

public class SubsetLeetcode {

  // Given a set of distinct integers, S, return all possible subsets
  // Use iterative way is more intutive
  public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    results.add(new ArrayList<Integer>()); // empty set
    for (int i = 0; i < S.length; i++) {
      List<List<Integer>> new_results = new ArrayList<List<Integer>>(results);
      // if we don't create a new list here, in the code below we are trying to
      // insert the list into the results, of which we hold an iterator
      // this will cause a fail-fast exception
      for (List<Integer> temp_result : results) {
        List<Integer> temp = new ArrayList<Integer>(temp_result);
        temp.add(S[i]);
        new_results.add(temp);
      }
      results = new_results;
    }
    return results;
  }

  // Given a collection of integers that might contain duplicates, S, return all
  // possible subsets.
  // Still, we are trying the iterative way. How to remove the duplicates?
  // If a[i]!=a[i-1] then we add all results of a[i-1] and that with a[i]
  // If a[i] == a[i-1] then we have to add a[i] to the previous iteration where
  // we add a[i-1]
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<List<Integer>> pre = new ArrayList<List<Integer>>();
    results.add(new ArrayList<Integer>());
    for (int i = 0; i < num.length; i++) {
      List<List<Integer>> new_results = new ArrayList<List<Integer>>(results);
      if (i != 0 && num[i] == num[i - 1]) {
        for (List<Integer> result : pre) {
          result.add(num[i]);
          new_results.add(new ArrayList<Integer>(result));
        }
      } else {
        pre.clear();
        for (List<Integer> temp_result : results) {
          List<Integer> temp = new ArrayList<Integer>(temp_result);
          temp.add(num[i]);
          pre.add(new ArrayList<Integer>(temp));
          new_results.add(temp);
        }
      }
      results = new_results;
    }
    return results;
  }
}
