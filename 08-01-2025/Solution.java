/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1
 * Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle.
 *
 * A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.
 *
 * Examples:
 * Input: arr[] = [4, 6, 3, 7]
 * Output: 3
 *
 * Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
 * Output: 6
 *
 * Input: arr[] = [1, 2, 3]
 * Output: 0
 */

import java.util.Arrays;

public class Solution {

  static int countTriangles(int arr[]) {
    int count = 0;

    Arrays.sort(arr);

    // 2 pointer approach as always
    for (int i = 2; i < arr.length; i++) {
      int leftPointer = 0, rightPointer = i - 1;

      while (leftPointer < rightPointer) {

        // check for sum
        int sum = arr[leftPointer] + arr[rightPointer];

        if (sum > arr[i]) {

          // if sum is greater than arr[i]
          // all elements in between
          // leftPointer and rightPointer
          // are eligible to form triangles
          count += rightPointer - leftPointer;

          // decrease rightPointer
          // and check again
          rightPointer -= 1;

        } else {
          leftPointer += 1;
        }

      }
    }

    return count;
  }

}
