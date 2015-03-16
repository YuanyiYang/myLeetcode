package first;

import java.util.*;

/*
 * 这个题通过质数来生成hash值，还是有点意思的，就是说让每个字母代表一个质数，然后这个字符串的hash值就是这些质数的乘积
 * 另外的做法，就是一个helper function，同过Arrays来sort一个char数组，然后用这个sort好的string作为hashmap的key
 */
public class Anagrams {

  public static List<String> anagrams(String[] strs) {
    List<String> result = new ArrayList<String>();
    int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
        59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    for (String str : strs) {
      int hash = 1;
      for (int i = 0; i < str.length(); i++) {
        hash *= prime[str.charAt(i) - 'a'];
      }
      if (!map.containsKey(hash)) {
        List<String> list = new LinkedList<String>();
        list.add(str);
        map.put(hash, list);
      } else {
        List<String> list = map.get(hash);
        list.add(str);
      }
    }
    for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
      if (entry.getValue().size() > 1) {
        result.addAll(entry.getValue());
      }
    }
    return result;
  }
}
