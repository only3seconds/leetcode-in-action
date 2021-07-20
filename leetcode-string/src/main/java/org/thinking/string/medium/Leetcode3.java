package org.thinking.string.medium;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author thinking-ppp 2021/7/20
 */
public class Leetcode3 {

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

}
