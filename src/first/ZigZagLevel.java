package first;

import java.util.*;

public class ZigZagLevel {
  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    if (root == null)
      return results;
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    boolean left = false;
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> result = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode n = q.poll();
        result.add(n.val);
        if (left) {
          if (n.right != null) {
            q.add(0, n.right);
          }
          if (n.left != null) {
            q.add(0, n.left);
          }
        } else {
          if (n.left != null) {
            q.add(0, n.left);
          }
          if (n.right != null) {
            q.add(0, n.right);
          }

        }
      }
      results.add(result);
      left = !left;
    }
    return results;
  }
  
  public static void main(String[] args) {
    
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = null;
    root.right.left = null;
    root.right.right = new TreeNode(5);
    for(List<Integer> r : ZigZagLevel.zigzagLevelOrder(root)){
      for(Integer i : r){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
