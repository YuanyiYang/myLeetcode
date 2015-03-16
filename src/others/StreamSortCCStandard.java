package others;

public class StreamSortCCStandard {

  public static StreamSNode root = null;

  public static void track(int x) {
    if (root == null) {
      root = new StreamSNode(x);
    } else {
      root.insert(x);
    }
  }

  public static int getRankOfNumber(int x) {
    if (root == null) {
      return -1;
    }
    return root.getRank(x);
  }

  public static class StreamSNode {
    int val;
    int left_size;
    StreamSNode left, right;

    StreamSNode(int val) {
      this.val = val;
    }

    public void insert(int x) {
      if (x <= val) {
        if (left == null) {
          this.left = new StreamSNode(x);
        } else {
          this.left.insert(x);
        }
        left_size++;
      } else {
        if (this.right != null) {
          this.right.insert(x);
        } else {
          this.right = new StreamSNode(x);
        }
      }
    }

    public int getRank(int x) {
      if (x == val) {
        return this.left_size;
      } else if (x < val) {
        if (this.left == null) {
          return left_size;
        } else {
          return this.left.getRank(x);
        }
      } else {
        // x > val
        int right_size = 0;
        if (this.right == null) {
          right_size = 0;
        } else {
          right_size = this.right.getRank(x);
        }
        return 1 + left_size + right_size;
      }
    }
  }

  public static void main(String[] args) {
    StreamSortCCStandard s = new StreamSortCCStandard();
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
