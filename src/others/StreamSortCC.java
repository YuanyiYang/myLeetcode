package others;

/*
 * CC chapter 11 last question
 * Ideas is kind of same with Trie; how to build trie; move the method to the node
 * See StreamSortCCStandard
 */
public class StreamSortCC {

  public static class StreamNode {
    int val;
    int lessThan;
    int equalTo;
    StreamNode left;
    StreamNode right;

    StreamNode(int val) {
      this.val = val;
    }
  }

  public StreamNode root = null;

  public void track(int x) {
    if (root == null) {
      root = new StreamNode(x);
    } else {
      StreamNode runner = root;
      StreamNode parent = root;
      while (runner != null) {
        if (runner.val == x) {
          runner.equalTo++;
          updateTree(runner.right);
          break;
        } else if (runner.val < x) {
          parent = runner;
          runner = runner.right;
        } else {
          parent = runner;
          runner.lessThan++;
          updateTree(runner.right);
          runner = runner.left;
        }
      }
      if (runner == null) {
        StreamNode newNode = new StreamNode(x);
        if (parent.val > x) {
          parent.left = newNode;
          newNode.lessThan = parent.lessThan - 1;
        } else {
          parent.right = newNode;
          newNode.lessThan = 1 + parent.lessThan + parent.equalTo;
        }
      }
    }
  }

  public int getRankOfNumber(int x) {
    if (root == null)
      return -1;
    StreamNode runner = root;
    StreamNode parent = root;
    while (runner != null) {
      if (runner.val == x) {
        return runner.lessThan + runner.equalTo;
      } else if (runner.val > x) {
        parent = runner;
        runner = runner.left;
      } else {
        parent = runner;
        runner = runner.right;
      }
    }
    // return -1;
    if (parent.val < x) {
      return parent.lessThan + parent.equalTo + 1;
    } else {
      return parent.lessThan;
    }
  }

  public void updateTree(StreamNode node) {
    if (node == null)
      return;
    node.lessThan++;
    updateTree(node.left);
    updateTree(node.right);
  }

  public static void main(String[] args) {
    StreamSortCC s = new StreamSortCC();
    s.track(5);
    s.track(1);
    s.track(4);
    s.track(5);
    s.track(9);
    s.track(7);
    s.track(13);
    s.track(3);
    s.track(4);
    System.out.println(s.getRankOfNumber(1));
    System.out.println(s.getRankOfNumber(3));
    System.out.println(s.getRankOfNumber(4));
    System.out.println(s.getRankOfNumber(5));
    System.out.println(s.getRankOfNumber(9));
    System.out.println(s.getRankOfNumber(7));
    System.out.println(s.getRankOfNumber(13));
    System.out.println(s.getRankOfNumber(10));
    System.out.println(s.getRankOfNumber(15));

  }
}
