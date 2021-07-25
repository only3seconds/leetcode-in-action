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
   * 3. 通过新建虚拟头节点统一操作
   */
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode newHead = head;
    ListNode p = head.next;
    ListNode post; // 不要在这里急着给post赋值

    newHead.next = null;
    while (p != null) {
      post = p.next; // 先保存下一个节点
      p.next = newHead;
      newHead = p;
      p = post;
    }

    return newHead;
  }

  /**
   * 增加虚拟头节点
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode visualHead = new ListNode();
    visualHead.next = null;
    ListNode p = head;
    ListNode post;
    while (p != null) {
      post = p.next;
      p.next = visualHead.next;
      visualHead.next = p;
      p = post;
    }

    return visualHead.next;
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




