package org.thinking.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author thinking-ppp 2021/8/4
 */
public class Leetcode1 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target-nums[i])) {
        result = new int[]{i, map.get(target-nums[i])};
      }

      map.put(nums[i], i);
    }

    return result;
  }

}
