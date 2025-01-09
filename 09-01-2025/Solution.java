/*
 * Problem Link: https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * Given an array arr[] containing only non-negative integers, your task is to find a
 * continuous subarray (a contiguous sequence of elements) whose sum equals a specified
 * value target. You need to return the 1-based indices of the leftmost and rightmost
 * elements of this subarray. You need to find the first subarray whose sum is equal
 * to the target.
 *
 * Note: If no such array is possible then, return [-1].
 *
 * Examples:
 * Input: arr[] = [1, 2, 3, 7, 5], target = 12
 * Output: [2, 4]
 *
 * Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
 * Output: [1, 5]
 *
 * Input: arr[] = [5, 3, 4], target = 2
 * Output: [-1]
 */

import java.util.ArrayList;

public class Solution {

  static ArrayList<Integer> subarraySum(int[] arr, int target) {

    int startPointer = 0;
    int sum = 0;

    // i acts as the right pointer in this case
    // and we keep on increasing the right pointer
    // until we reach the end while also calculating
    // the sum as well
    //
    // if sum is greater than target
    // than manipulate startPointer
    // to bring sum <= target
    for (int i = 0; i < arr.length; i++) {

      sum += arr[i];

      if (sum > target) {

        while (sum > target && startPointer < i) {

          sum -= arr[startPointer];
          startPointer += 1;

        }

      }

      if (sum == target) {

        ArrayList<Integer> resultList = new ArrayList<>();

        resultList.add(startPointer += 1);
        resultList.add(i + 1);

        return resultList;

      }

    }

    ArrayList<Integer> defaultList = new ArrayList<>();
    defaultList.add(-1);

    return defaultList;

  }

}
