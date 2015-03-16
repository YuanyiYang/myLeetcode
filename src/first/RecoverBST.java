package first;
import java.util.*;
public class RecoverBST {

  public static void recoverTree(TreeNode root) {
    int preValue = Integer.MIN_VALUE;
    int currentValue = Integer.MIN_VALUE;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode pre1 = null;
    TreeNode pre2 = null;
    TreeNode cur = root;
    TreeNode preNode = null;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      System.out.println(stack.size());
      //System.out.println(cur.val);
      currentValue = cur.val;
      if (currentValue < preValue) {
        if (pre1 == null) {
          pre1 = preNode;
          pre2 = cur;
        } else {
          pre2 = cur;
          break;
        }
      }
      preNode = cur;
      preValue = currentValue;
      cur = cur.right;
    }
    if (pre1 != null && pre2 != null) {
      int temp = pre1.val;
      pre1.val = pre2.val;
      pre2.val = temp;
    }

  }

  public static void inorder(TreeNode root){
    if(root==null) return;
    inorder(root.left);
    System.out.println("( " + root.val + " )");
    inorder(root.right);
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    inorder(root);
    recoverTree(root);
    inorder(root);
  }
}
