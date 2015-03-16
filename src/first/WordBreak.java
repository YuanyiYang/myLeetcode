package first;

import java.util.*;

public class WordBreak {
  public static List<String> wordBreak(String s, Set<String> dict) {
    List<String> results = new ArrayList<String>();
    int length = s.length();
    Map<Integer, List<List<Integer>>> temp = new HashMap<Integer, List<List<Integer>>>();
    List<List<Integer>> initial = new ArrayList<List<Integer>>();
    initial.add(new ArrayList<Integer>());
    temp.put(length, initial);
    boolean[] dp = new boolean[length + 1];
    for (int i = 0; i < length; i++) {
      dp[i] = false;
    }
    dp[length] = true;
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j <= length; j++) {
        if (dp[j] && dict.contains(s.substring(i, j))) {
          dp[i]=true;
          List<List<Integer>> curResult = temp.get(j);
          List<List<Integer>> newResult = new ArrayList<List<Integer>>();
          for (List<Integer> l : curResult) {
            List<Integer> n = new ArrayList<Integer>(l);
            n.add(0,i);
            newResult.add(n);
          }
          List<List<Integer>> cur;
          if(temp.containsKey(i)){
            cur = temp.get(i);
          }else{
            cur = new ArrayList<List<Integer>>();
          }
          cur.addAll(newResult);
          temp.put(i, cur);
        }
      }
    }
    if (!dp[0])
      return new ArrayList<String>();
    List<List<Integer>> t = temp.get(0);
    //System.out.println(t.size());
    for (List<Integer> l : t) {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<l.size();i++){
        if(i==l.size()-1){
          sb.append(s.substring(l.get(i)));
        }else{
          sb.append(s.substring(l.get(i), l.get(i+1))).append(" ");
        }
      }
      results.add(sb.toString());
    }
    for(String sbbb : results){
      System.out.println(sbbb);
    }
    return results;
  }
  
  public static List<String> getAllResults(String s, Set<String> dict){
    List<String> results = new ArrayList<String>();
    if(s==null||s.length()==0){
      return results;
    }
    StringBuilder sb = new StringBuilder();
    dfs(s,dict,results,sb,0);
    return results;
  }
  
  private static void dfs(String s, Set<String> dict, List<String> results, StringBuilder cur, int index){
    if(index>=s.length()-1){
      results.add(cur.toString());
      return;
    }
    for(int i=index+1;i<=s.length();i++){
      if(dict.contains(s.substring(index,i))){
        int len = cur.length();
        if(len!=0){
          cur.append(" ");
        }
        cur.append(s.substring(index, i));
        dfs(s,dict,results,cur,i);
        cur.delete(len, cur.length());
      }
    }
  }
  
  public static void main(String[] args) {
      String s = "catsanddog";
      Set<String> dict = new HashSet<String>();
      dict.add("cat");
      dict.add("cats");
      dict.add("and");
      dict.add("sand");
      dict.add("dog");
      //wordBreak(s, dict);
      for(String st:getAllResults(s, dict)){
        System.out.println(st);
      }
  }
}
