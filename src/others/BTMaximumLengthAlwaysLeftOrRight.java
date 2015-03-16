package others;

import first.TreeNode;

/*
 * 给定一个Binary Tree，找到从任意一个节点开始一直往左或者一直往右的path的最长的length
 * stack overflow http://stackoverflow.com/questions/18299738/maximum-length-of-a-descending-path-in-a-tree-which-always-goes-leftright
 * 一种path是一直向左走,一种path是一直向右走,要求所有这些path中最长的，这种path可能开始于任何一个节点
 * 
 * 思路就是：对于这个节点，返回其descendants的最小值，这个值就是通过左右子节点最大的，并且跟从这个节点开始一直
 * 往左或者一直往右的path中，这三个数中找出最大的
 */
public class BTMaximumLengthAlwaysLeftOrRight {

  static int findLength(TreeNode root) {
    if(root==null) return 0;
    int result = 0;
    int left = findAllTheWayLeft(root);
    int right = findAllTheWayRight(root);
    int re = Math.max(findLength(root.left), findLength(root.right));
    result = Math.max(left,right);
    result = Math.max(result,re);
    return result;
  }
  
  static int findAllTheWayLeft(TreeNode root){
    if(root==null) return 0;
    int r = 0;
    while(root.left!=null){
      root = root.left;
      r++;
    }
    return r;
  }
  
  static int findAllTheWayRight(TreeNode root){
    if(root==null) return 0;
    int r = 0;
    while(root.right!=null){
      root = root.right;
      r++;
    }
    return r;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.left.left = new TreeNode(7);
    root.right.left.left.left = new TreeNode(8);
    root.right.left.left.left.left = new TreeNode(9);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(4);
    root.right.left.right = new TreeNode(6);
    System.out.println(findLength(root));
  }
}
