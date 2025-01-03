/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
 * Given an array of integers arr[] and a number k, count the number of subarrays
 * having XOR of their elements as k.
 *
 * Examples:
 * Input: arr[] = [4, 2, 2, 6, 4], k = 6
 * Output: 4
 *
 * Input: arr[] = [5, 6, 7, 8, 9], k = 5
 * Output: 2
 */

import java.util.HashMap;

public class Solution {

  public long subarrayXor(int arr[], int k) {
    long subarraysCount = 0;
    int cumulativeXor = 0;
    HashMap<Integer, Integer> xorCountHistory = new HashMap<>();

    // Honestly, its completely same as previous
    // day's solution but instead of cumulative sums
    // we are dealing with cumulative XORs
    //
    // So guessed it as the same algorithm.
    for (int i = 0; i < arr.length; i++) {
      cumulativeXor ^= arr[i];

      if (cumulativeXor == k)
        subarraysCount += 1;

      if (xorCountHistory.containsKey(cumulativeXor ^ k))
        subarraysCount += xorCountHistory.get(cumulativeXor ^ k);

      xorCountHistory.put(cumulativeXor, xorCountHistory.getOrDefault(cumulativeXor, 0) + 1);
    }

    return subarraysCount;
  }

  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] arr1 = { 4, 2, 2, 6, 4 };
    System.out.println(solution.subarrayXor(arr1, 6));

    int[] arr2 = { 5, 6, 7, 8, 9 };
    System.out.println(solution.subarrayXor(arr2, 5));
  }

}
