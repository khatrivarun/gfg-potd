/*
 * Problem link:
 * https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
 *
 * Given an array arr[] of non-negative integers, where each element arr[i]
 * represents the height of the vertical lines, find the maximum amount of water
 * that can be contained between any two lines, together with the x-axis.
 * Note: In the case of a single vertical line it will not be able to hold
 * water.
 *
 * Examples:
 * Input: arr[] = [1, 5, 4, 3]
 * Output: 6
 *
 * Input: arr[] = [3, 1, 2, 4, 5]
 * Output: 12
 *
 * Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
 * Output: 25
 */

public class Solution {

  public int maxWater(int arr[]) {

    int maxWater = Integer.MIN_VALUE;
    int left = 0, right = arr.length - 1;

    // Slight variation of water collection
    // we will just keep on calculating max
    // on each step and move left and right
    // the same way
    while (left < right) {

      maxWater = Math.max(maxWater, (right - left) * Math.min(arr[left], arr[right]));

      if (arr[left] < arr[right])
        left += 1;
      else
        right -= 1;

    }

    return maxWater == Integer.MIN_VALUE ? 0 : maxWater;

  }

}
