package com.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239_SlidingWindowMaximum {

  /**
   * 239. 滑动窗口最大值 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
   *
   * <p>返回滑动窗口中的最大值。
   *
   * <p>进阶：
   *
   * <p>你能在线性时间复杂度内解决此题吗？
   *
   * <p>示例:
   *
   * <p>输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
   *
   * <p>滑动窗口的位置 最大值
   *
   * <p>--------------- -----
   *
   * <p>[1 3 -1] -3 5 3 6 7 =3
   *
   * <p>1 [3 -1 -3] 5 3 6 7 =3
   *
   * <p>1 3 [-1 -3 5] 3 6 7 =5
   *
   * <p>1 3 -1 [-3 5 3] 6 7 =5
   *
   * <p>1 3 -1 -3 [5 3 6] 7 =6
   *
   * <p>1 3 -1 -3 5 [3 6 7] =7
   *
   * <p>time:O(n) space:O(n)
   *
   * @param nums
   * @param k
   * @return
   */
  public static int[] slidingWindowMaximum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length + 1 - k];
    for (int i = 0; i < nums.length; i++) {
      if (!deque.isEmpty() && deque.peekFirst() == i - k) {
        deque.poll();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.offerLast(i);
      if ((i + 1) >= k) {
        res[i + 1 - k] = nums[deque.peek()];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println(Arrays.toString(slidingWindowMaximum(nums, k)));
  }
}
