package org.thinking.array.easy;

import java.util.Arrays;

/**
 * 多数元素
 * @author thinking-ppp 2021/8/8
 */
public class Leetcode169 {

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];

  }

}
