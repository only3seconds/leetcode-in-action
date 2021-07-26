package org.thinking.design.medium;

/**
 * 对于循环队列，关键点是：如何区分队列空和队列满？为了区分，多引入一个空间不用于存储数据。
 * @author thinking-ppp 2021/7/25
 */
public class Leetcode622 {

  // 循环队列长度
  private int len;
  private int[] array;
  private int front;
  private int rear;

  public Leetcode622(int k) {
    this.len = k + 1;
    this.array = new int[len];
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    array[rear] = value;
    rear = (rear + 1) % len;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    front = (front + 1) % len;
    return true;

  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return array[front];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return array[(rear - 1 + len) % len];
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public boolean isFull() {
    return (rear + 1) % len == front;
  }

}
