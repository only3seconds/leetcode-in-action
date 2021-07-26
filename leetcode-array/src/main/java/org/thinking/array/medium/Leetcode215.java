package org.thinking.array.medium;

import java.util.Arrays;

/**
 * @author thinking-ppp 2021/7/26
 */
public class Leetcode215 {

  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0;
    for (; i < nums.length - k; i++) {
      ;
    }
    return nums[i];

  }

}
