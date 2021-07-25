package org.thinking.linked.list.medium;

/**
 * @author thinking-ppp 2021/7/25
 */
public class Leetcode92 {

  public class ListNode {

    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode visualHead = new ListNode();
      visualHead.next = head;
      ListNode preLeft = visualHead;
      ListNode rightNode = visualHead;
      while (left-- > 1) {
        preLeft = preLeft.next;
      }

      while (right-- > 0) {
        rightNode = rightNode.next;
      }

      ListNode leftNode = preLeft.next;
      preLeft.next = rightNode.next;
      rightNode.next = null;
      ListNode post;
      while (leftNode != null) {
        post = leftNode.next;
        leftNode.next = preLeft.next;
        preLeft.next = leftNode;
        leftNode = post;
      }

      return visualHead.next;

    }

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
