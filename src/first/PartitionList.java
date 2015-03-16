package first;

public class PartitionList {
  public static ListNode partition(ListNode head, int x) {
    if (head == null)
      return head;
    ListNode left = new ListNode(0);
    ListNode right = new ListNode(0);
    ListNode leftDummy = left;
    ListNode rightDummy = right;
    while (head != null) {
      ListNode next = head.next;
      head.next = null;
      if (head.val < x) {
        left.next = head;
        left = left.next;
      } else {
        right.next = head;
        right = right.next;
      }
      head = next;
    }
    if (leftDummy.next == null) {
      return rightDummy.next;
    } else {
      left.next = rightDummy.next;
      return leftDummy.next;
    }
  }
  
  public static void main(String[] args) {
    ListNode n = new ListNode(1);
    ListNode m = new ListNode(1);
    n.next = m;
    ListNode x = partition(n, 0);
    while(x!=null){
      System.out.println(x.val);
      x = x.next;
    }
  }
}
