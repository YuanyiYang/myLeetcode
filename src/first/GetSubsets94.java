package first;

import java.util.*;


/*
 * From cc, see more on the leetcode version
 */
public class GetSubsets94 {

  public static List<List<Integer>> getSubsets(List<Integer> list) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<Integer> result = new ArrayList<Integer>();
    results.add(result); // empty subset
    helper(list, 0, results);
    return results;
  }

  public static void helper(List<Integer> list, int index,
      List<List<Integer>> results) {
    if(index==list.size()){
      return;
    }
    for(List<Integer> temp: new ArrayList<List<Integer>>(results)){   // 这里第一次写错了，因为没有new一个新的，所以直接加到原来的上面了，也就造成一个concurrent error
      List<Integer> contain = new ArrayList<Integer>(temp);
      contain.add(list.get(index));
      results.add(contain);
    }
    helper(list, index+1, results);
  }
  
  // second solution on CC
  
  public static void main(String[] args) {
    List<Integer> test = new ArrayList<>();
    test.add(0);
    test.add(1);
    test.add(2);
    test.add(3);
    System.out.println(getSubsets(test).size());
    for(List<Integer> i : getSubsets(test)){
      System.out.println(i);
    }
    //System.out.println(test);
    
    
  }
}
