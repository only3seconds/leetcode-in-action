package org.thinking.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 找到小镇的法官
 * @author thinking-ppp 2021/8/8
 */
public class Leetcode997 {

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


    for (HashSet<Integer> set: map.values()) {
      if (!set.contains(maybeJudge)) {
        return -1;
      }
    }

    return maybeJudge;
  }

}
