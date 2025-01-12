/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 *
 * Given an array arr[] with non-negative integers representing the height of
 * blocks. If the width of each block is 1, compute how much water can be
 * trapped between the blocks during the rainy season.
 *
 * Examples:
 * Input: arr[] = [3, 0, 1, 0, 4, 0 2]
 * Output: 10
 *
 * Input: arr[] = [3, 0, 2, 0, 4]
 * Output: 7
 *
 * Input: arr[] = [1, 2, 3, 4]
 * Output: 0
 *
 * Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
 * Output: 9
 */

public class Solution {

  public int maxWater(int arr[]) {

    int left = 1, right = arr.length - 2;
    int leftMax = arr[0], rightMax = arr[arr.length - 1];
    int result = 0;

    while (left <= right) {

      if (leftMax < rightMax) {

        result += Math.max(0, leftMax - arr[left]);
        leftMax = Math.max(leftMax, arr[left]);
        left += 1;

      } else {

        result += Math.max(0, rightMax - arr[right]);
        rightMax = Math.max(rightMax, arr[right]);
        right -= 1;

      }
    }

    return result;

  }

}
