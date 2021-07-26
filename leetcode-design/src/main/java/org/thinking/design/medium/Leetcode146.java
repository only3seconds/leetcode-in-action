package org.thinking.design.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * LRU 缓存机制
 *
 * @author thinking-ppp 2021/7/26
 */
public class Leetcode146 {

  private int capacity;
  private Map<Integer, Integer> map = new HashMap<>();
  private Map<Integer, Long> timeMap = new LinkedHashMap<>();
  private long time = 0;

  public Leetcode146(int capacity) {
    this.capacity = capacity;

  }

  public int get(int key) {
    if (map.containsKey(key)) {
      timeMap.remove(key);
      timeMap.put(key, time);
      time++;
      return map.get(key);
    } else {
      return -1;
    }

    //return map.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.put(key, value);
      timeMap.remove(key);
      timeMap.put(key, time);
      time++;
    } else {
      if (map.size() >= capacity) {
        int minKey = timeMap.entrySet().iterator().next().getKey();
        map.remove(minKey);
        timeMap.remove(minKey);
      }
      map.put(key, value);
      timeMap.put(key, time);
      time++;
    }

  }

//  private int lruKey(Map<Integer, Long> map) {
//    long min = Long.MAX_VALUE;
//    int minkey = -1;
//    Set<Entry<Integer, Long>> entrySet = map.entrySet();
//    for (Entry<Integer, Long> entry : entrySet) {
//      if (entry.getValue() < min) {
//        min = entry.getValue();
//        minkey = entry.getKey();
//      }
//    }
//
//    return minkey;
//  }
}


