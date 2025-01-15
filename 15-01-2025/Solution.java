/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 * Given an array arr[] containing integers and an integer k, your task is to
 * find the length of the longest subarray where the sum of its elements is
 * equal to the given value k. If there is no subarray with sum equal to k,
 * return 0.
 *
 * Examples:
 * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
 * Output: 6
 *
 * Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
 * Output: 5
 *
 * Input: arr[] = [10, -10, 20, 30], k = 5
 * Output: 0
 */

import java.util.HashMap;

public class Solution {

  public int longestSubarray(int[] arr, int k) {
    int result = 0, cumulativeSum = 0;
    HashMap<Integer, Integer> cumulativeSums = new HashMap<>();
    cumulativeSums.put(0, -1);

    // just store indices with cumulative sums
    // and everything else stays the same
    for (int i = 0; i < arr.length; i++) {

      cumulativeSum += arr[i];

      if (cumulativeSums.containsKey(cumulativeSum - k))
        result = Math.max(result, i - cumulativeSums.get(cumulativeSum - k));

      cumulativeSums.putIfAbsent(cumulativeSum, i);

    }

    return result;
  }

}
