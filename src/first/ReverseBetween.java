package first;

public class ReverseBetween {

	public class ListNode {
		int val; 
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        ListNode post = null;
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for(int i=m;i>1;i--){
            cur = cur.next;
            pre = pre.next;
        }
        ListNode startPoint = cur;
        for(int i=m;i<=n;i++){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            if(i!=n) cur = post; // Here we need cur points to node n 
        }
        startPoint.next.next = cur;
        startPoint.next = post;
        return dummy.next;
    }
}
