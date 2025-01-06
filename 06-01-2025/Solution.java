/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-
 * x1124/1
 * Given an array arr[] and a number target, find a pair of elements (a, b) in
 * arr[], where a<=b
 * whose sum is closest to target.
 *
 * Note: Return the pair in sorted order and if there are multiple such pairs
 * return the pair with
 * maximum absolute difference. If no such pair exists return an empty array.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> sumClosest(int[] arr, int target) {
    List<Integer> result = new ArrayList<>();
    int leftPointer = 0, rightPointer = arr.length - 1;
    int closestSumDifference = Integer.MAX_VALUE;

    Arrays.sort(arr);

    // same logic as pair sums go
    // but over here we also check
    // for closest absolute sum difference
    // to reach the answer
    while (leftPointer < rightPointer) {

      int sum = arr[leftPointer] + arr[rightPointer];
      int sumDifference = Math.abs(sum - target);

      if (sumDifference < closestSumDifference) {
        closestSumDifference = sumDifference;

        result.clear();
        result.add(0, arr[leftPointer]);
        result.add(1, arr[rightPointer]);
      }

      if (sum > target) {
        rightPointer -= 1;
      } else if (sum < target) {
        leftPointer += 1;
      } else {
        return result;
      }

    }

    return result;
  }

}
