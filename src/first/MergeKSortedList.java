package first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

  // to maintain the heap, it is O(logK);
  // in total it needs to be maintained nk times
  // so the total complexity is O(nkLogK)
  public ListNode heapSolution(List<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;
    int k = lists.size();
    // use a queue to represent the heap and define its own comparator
    Queue<ListNode> minHeap = new PriorityQueue<ListNode>(k,
        new Comparator<ListNode>() {
          @Override
          public int compare(ListNode o1, ListNode o2) {
            if (o1 == null)
              return 1;
            else if (o2 == null)
              return -1;
            else
              return o1.val - o2.val;
          }
        });
    for (ListNode root : lists) {
      if (root != null) {
        minHeap.add(root);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (minHeap.size() != 0) {
      ListNode root = minHeap.poll();
      cur.next = root;
      cur = root;
      if (root.next != null) {
        minHeap.add(root.next);
      }
    }
    return dummy.next;
  }

  public ListNode mergeSortSolution(List<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;
    if (lists.size() <= 2)
      return mergeTwoSortedList(lists);
    List<ListNode> left = new ArrayList<ListNode>();
    List<ListNode> right = new ArrayList<ListNode>();
    int i = 0;
    for (; i < lists.size() / 2; i++) {
      left.add(lists.get(i));
    }
    for (; i < lists.size(); i++) {
      right.add(lists.get(i));
    }
    return mergeTwoSortedList(mergeSortSolution(left), mergeSortSolution(right));
  }

  private ListNode mergeTwoSortedList(ListNode node1, ListNode node2) {
    ListNode dummy = new ListNode(0);
    ListNode runner = dummy;
    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        runner.next = node1;
        node1 = node1.next;
      } else {
        runner.next = node2;
        node2 = node2.next;
      }
      runner = runner.next;
    }
    if (node1 == null) {
      runner.next = node2;
    }
    if (node2 == null) {
      runner.next = node1;
    }
    return dummy.next;
  }

  private ListNode mergeTwoSortedList(List<ListNode> lists) {
    ListNode node1;
    ListNode node2;
    if (lists.size() == 1) {
      node1 = lists.get(0);
      node2 = null;
    } else if (lists.size() == 2) {
      node1 = lists.get(0);
      node2 = lists.get(1);
    } else {
      return null;
    }
    return mergeTwoSortedList(node1, node2);
  }
}
