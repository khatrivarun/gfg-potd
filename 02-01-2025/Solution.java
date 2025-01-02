/*
 * Problem Link: https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
 * Given an unsorted array of integers, find the number of continuous subarrays
 * having sum exactly equal to a given number k.
 *
 * Examples
 * Input: arr = [10, 2, -2, -20, 10], k = -10
 * Output: 3
 *
 * Input: arr = [9, 4, 20, 3, 10, 5], k = 33
 * Output: 2
 *
 * Input: arr = [1, 3, 5], k = 0
 * Output: 0
 */

import java.util.HashMap;

public class Solution {

  public int countSubarrays(int arr[], int k) {
    int result = 0, consecutiveSum = 0;
    HashMap<Integer, Integer> sumsHistory = new HashMap<>();

    // This looks like a build up on the problem
    // to check existence of a subarray which sums
    // up to 0
    //
    // So the approach will be similar where we record
    // the consecutive sums in a hash map but along with
    // it, we will increment the number of times the
    // consecutive sum appears so we can keep track of
    // number of subarrays which amount to the same sum
    //
    // As for checking for the subarray, a small variation
    // we can put in here is that we will check for existence
    // for consecutive sum - k in the hashmap
    for (int i = 0; i < arr.length; i++) {
      consecutiveSum += arr[i];

      if (consecutiveSum == k)
        result += 1;

      if (sumsHistory.containsKey(consecutiveSum - k)) {
        result += sumsHistory.get(consecutiveSum - k);
      }

      sumsHistory.put(consecutiveSum, sumsHistory.getOrDefault(consecutiveSum, 0) + 1);
    }

    return result;
  }

}
