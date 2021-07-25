package org.thinking.array.easy;

/**
 * 暴力解法会超时
 * 滑动窗口解法
 * 对于求和的题目，常常借助辅助数组，并且辅助数组比原数组多一位，首位赋值为0，方便统一计算。
 * @author thinking-ppp 2021/7/22
 */
public class Leetcode643 {

  public double findMaxAverage(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i <= nums.length - k; i++) {
      int tempSum = 0;
      for (int j = i; j < i + k; j++) {
        tempSum = tempSum + nums[j];
      }

      maxSum = Math.max(maxSum, tempSum);
    }

    return (double) maxSum / k;

  }

  public double findMaxAverage2(int[] nums, int k) {
    int maxSum = Integer.MIN_VALUE;
    int validLeft = 0;
    int[] sum = new int[nums.length + 1];
    sum[0] = 0;
    sum[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i+1] = sum[i] + nums[i];
    }

    for (int i = k; i < sum.length; i++) {
      int tempSum = sum[i] - sum[validLeft];
      maxSum = Math.max(maxSum, tempSum);
      validLeft++;
    }

    return (double) maxSum / k;

  }

}
