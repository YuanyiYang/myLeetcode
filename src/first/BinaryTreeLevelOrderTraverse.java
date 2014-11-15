package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraverse {

  // Binary Tree Level Order Traverse 2
  // BFS: add value in each level at the front of the list
  // same as populating rigth pointer question
  
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null)
      return result;
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    list.add(root);
    while (!list.isEmpty()) {
      int size = list.size();
      List<Integer> levelResult = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode node = list.poll();
        if (node.left != null) {
          list.add(node.left);
        }
        if (node.right != null) {
          list.add(node.right);
        }
        levelResult.add(node.val);
      }
      result.addFirst(levelResult);
    }
    return result;
  }
}
