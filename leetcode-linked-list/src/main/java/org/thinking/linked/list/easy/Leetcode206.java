package org.thinking.linked.list.easy;

/**
 * @author thinking-ppp 2021/7/20
 *
 * TODO:反转链表
 */
public class Leetcode206 {

  /**
   * 头插法
   * 1. 注意"节点引用"和"节点"的区别
   * 2. 注意链表的尾节点要置空
   * 3. 遍历链表时要注意结束条件，要考虑最后一个节点是否也处理了
   */
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




