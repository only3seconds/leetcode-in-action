package org.thinking.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author thinking-ppp 2021/8/3
 */
public class Leetcode1604 {

  public static void main(String[] args) {
    String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
    String[] keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
    String[] keyName1 = {"b", "b", "b", "b", "b", "b"};
    String[] keyTime1 = {"22:57", "23:40", "03:43", "21:55", "20:38", "00:19"};

    System.out.println("19:30".compareTo("19:51"));
    System.out.println(alertNames(keyName1, keyTime1));
  }

  public static List<String> alertNames(String[] keyName, String[] keyTime) {
    // 1. 统计每个keyName 的刷卡时间数组
    Map<String, ArrayList<Integer>> nameTimeMap = new HashMap<>();
    ArrayList<Integer> keyTimeList = null;
    for (int i = 0; i < keyName.length; i++) {
      if (!nameTimeMap.containsKey(keyName[i])) {
        keyTimeList = new ArrayList<>();
      }
      String[] times = keyTime[i].split(":");

      keyTimeList.add(Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
      nameTimeMap.put(keyName[i], keyTimeList);
    }

    // 2. 排序，判断是否存在1小时内刷卡次数超过3次的现象
    List<String> resut = new ArrayList<>();
    Set<Entry<String, ArrayList<Integer>>> entrySet = nameTimeMap.entrySet();
    for (Map.Entry<String, ArrayList<Integer>> entry : entrySet) {
      Collections.sort(entry.getValue());
      if (over3Times(entry.getValue())) {
        resut.add(entry.getKey());
      }
    }

    // 3. 返回排序后的结果
    Collections.sort(resut);
    return resut;
  }

  private static boolean over3Times(ArrayList<Integer> keyTimeList) {
    Integer[] assist = new Integer[keyTimeList.size()];

    for (int i = 1; i < keyTimeList.size(); i++) {
      assist[i] = keyTimeList.get(i) - keyTimeList.get(i - 1);
    }

    int validLeft = 1;
    for (int j = 2; j < assist.length; j++) {
      if (assist[validLeft] + assist[j] <= 60) {
        return true;
      }
      validLeft++;
    }
    return false;
  }

}
