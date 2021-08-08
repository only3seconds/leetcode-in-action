package org.thinking.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 找到小镇的法官
 *
 * @author thinking-ppp 2021/8/8
 */
public class Leetcode997 {

  /**
   * 方法一：使用HashMap
   */
  public int findJudge(int n, int[][] trust) {
    if (trust == null || trust.length == 0) {
      if (n == 1) {
        return 1;
      } else {
        return -1;
      }

    }
    Map<Integer, HashSet<Integer>> map = new HashMap<>();

    for (int i = 0; i < trust.length; i++) {
      if (map.containsKey(trust[i][0])) {
        map.get(trust[i][0]).add(trust[i][1]);
      } else {
        HashSet<Integer> set = new HashSet<>();
        set.add(trust[i][1]);
        map.put(trust[i][0], set);
      }
    }

    int maybeJudge = 0;
    for (int i = 1; i <= n; i++) {
      if (!map.containsKey(i)) {
        maybeJudge = i;
      }
    }

    for (HashSet<Integer> set : map.values()) {
      if (!set.contains(maybeJudge)) {
        return -1;
      }
    }

    return maybeJudge;
  }

  /**
   * 方法二：投票思想，使用两个一纬数组
   * @param n
   * @param trust
   * @return
   */
  public int findJudge2(int n, int[][] trust) {
    // 投出去的票数
    int[] vote1 = new int[n + 1];
    // 收获票数
    int[] vote2 = new int[n + 1];

    for (int i = 0; i < trust.length; i++) {
      vote1[trust[i][0]]++;
      vote2[trust[i][1]]++;
    }

    for (int i = 1; i <= n; i++) {
      if (vote1[i] == 0 && vote2[i] == n - 1) {
        return i;
      }
    }

    return -1;
  }

}
