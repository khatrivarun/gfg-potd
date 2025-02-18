// Problem Link: https://www.geeksforgeeks.org/problems/k-closest-points-to-origin--172242/1
// Given an array of points where each point is represented as points[i] = [xi, yi] on the
// X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
// Examples:
// Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
// Output: [[-2, 2], [0, 1]]
//
// Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
// Output: [[0, 0]]

import java.util.Arrays;

public class Solution {

  // Sort it out and return the array
  public int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, (pointOne, pointTwo) -> (pointOne[0] * pointOne[0] + pointOne[1] * pointOne[1])
        - (pointTwo[0] * pointTwo[0] + pointTwo[1] * pointTwo[1]));

    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++)
      result[i] = points[i];

    return result;
  }

}
