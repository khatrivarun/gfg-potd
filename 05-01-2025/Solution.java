/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-less-than-target/1
 * Given an array arr[] and an integer target. You have to find the number of pairs in the array
 * whose sum is strictly less than the target.
 *
 * Examples:
 * Input: arr[] = [7, 2, 5, 3], target = 8
 * Output: 2
 *
 * Input: arr[] = [5, 2, 3, 2, 4, 1], target = 5
 * Output: 4
 *
 * Input: arr[] = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
 * Output: 6
 */

import java.util.Arrays;

public class Solution {

  int countPairs(int arr[], int target) {

    int result = 0;

    Arrays.sort(arr);
    int leftPointer = 0, rightPointer = arr.length - 1;

    // Same logic as other sum pairs
    // except we dont care about if the sum
    // matches, we only care about less than
    // and greater than target conditions
    while (leftPointer < rightPointer) {
      int sum = arr[leftPointer] + arr[rightPointer];

      if (sum < target) {
        result += rightPointer - leftPointer;
        leftPointer += 1;
      } else {
        rightPointer -= 1;
      }
    }

    return result;

  }

}
