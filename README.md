# leetcode-in-action
LeetCode代码仓库

## 项目包结构

项目中每个子项目都是一个算法集合。

## 规范 

每个LeetCode题目都以LeetcodeXXX取名。

子项目的包名称和算法集合有关。比如org.thinking.array包，该包根据题目的难易程度分为: easy、medium和hard

项目注释分为四个维度：Title、题目、思路和类似题型

##### 示例

```java
/**
 * Title: Jump Game II
 * <p>
 * 题目: 给一串非负数的数组nums，数组nums中的每个元素代表基于当前位置能跳的最远距离。假定给定的数组nums总是能到最后一个节点。
 * <p>
 * 请输出最少的跳数
 * <p>
 * 思路: 该题思路与Jump Game类似。假设你当前位于0下标的数组位置，最远能跳nums[0]的距离，那么第一跳只能跳到nums[0]的位置。
 * <p>
 * 第二跳应该只能在[0, nums[0]]的候选点中找最远的，假设找到第二跳最好在A点(0<A<=nums[0]），能跳到最远点在nums[A]位置。
 * <p>
 * 第三跳应该在[A, nums[A]]之间的位置找最远点。依次类推，每次找一个候选点，就是一跳。
 * <p>
 * 类似题型: Jump Game
 *
 * @author thinking_ppp 2021/7/6
 */
public class Leetcode45 {

  public int jump(int[] nums) {
    int result = 0;
    return result;
  }

  public static void main(String[] args) {
    // Output 2
//    int[] nums = {2, 3, 1, 1, 4};
    // Output 2
    int[] nums = {2, 3, 0, 1, 4};
    Leetcode45 leetcode45 = new Leetcode45();
    ConsoleOutput.printf(leetcode45.jump(nums));
  }
}
```
