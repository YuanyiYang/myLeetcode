package first;

public class RotateList {

  public ListNode rotateRight(ListNode head, int n) {
    if (n == 0)
      return head;
    if (head == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;
    while (n > 0) {
      if (fast == null) {
        fast = head;
      }
      fast = fast.next;
      n--;
    }
    if (fast == null)
      return head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode newHead = slow.next;
    slow.next = null;
    fast.next = head;
    return newHead;
  }
}
