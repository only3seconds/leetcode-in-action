package org.thinking.string.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 方法一：暴力解法
 * 方法二：滑动窗口
 *
 * @author thinking-ppp 2021/7/20
 */
public class Leetcode3 {

  /**
   * 暴力解法
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      HashSet<Character> set = new HashSet<>();
      set.add(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        if (set.contains(s.charAt(j))) {
          break;
        } else {
          set.add(s.charAt(j));
        }
      }
      max = Math.max(max, set.size());
    }

    return max;
  }

  /**
   *
   * 滑动窗口：通过左右指针保证窗口（可变/不变）始终满足要求
   * 1. 右指针依次向右边移动
   * 2. 当右指针移动到某个位置，导致窗口内的数据不满足要求时，移动左指针使得滑动窗口继续满足要求
   * 3. 可以借助常用的HashMap HashSet等数据结构来判断滑动窗口是否满足要求
   */
  public int lengthOfLongestSubstring2(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE; // 需要统计的指标
    int validLeft = -1; // 滑动窗口有效的左指针

    for (int i = 0; i < s.length(); i++) { // i其实就是滑动窗口的右指针
      // 发现有重复字符，滑动窗口不满足要求，移动左指针
      if (map.containsKey(s.charAt(i))) {
        // 注意：要取最大值（abba)
        validLeft = Math.max(validLeft, map.get(s.charAt(i)));
      }
      max = Math.max(max, i - validLeft);
      map.put(s.charAt(i), i);
    }
    return max;
  }

}
