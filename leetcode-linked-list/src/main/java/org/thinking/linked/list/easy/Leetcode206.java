package org.thinking.linked.list.easy;

/**
 * @author thinking-ppp 2021/7/20
 *
 * 反转链表
 */
public class Leetcode206 {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head;
    ListNode p = head.next;
    ListNode post = p.next;

    newHead.next = null;
    while (post != null) {
      p.next = newHead;
      newHead = p;
      p = post;
      post = p.next;
    }
    p.next = newHead;
    newHead = p;


    return newHead;
  }

  public class ListNode {

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




