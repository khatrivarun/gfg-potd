/*
 * Problem Link: You are given an integer target and an array arr[]. You have to
 * find number of pairs in arr[] which sums up to target. It is given that the
 * elements of the arr[] are in sorted order.
 * Note: pairs should have elements of distinct indexes.
 *
 * Examples:
 * Input: arr[] = [-1, 1, 5, 5, 7], target = 6
 * Output: 3
 *
 * Input: arr[] = [1, 1, 1, 1], target = 2
 * Output: 6
 *
 * Input: arr[] = [-1, 10, 10, 12, 15], target = 125
 * Output: 0
 */

public class Solution {

  int countPairs(int arr[], int target) {
    int result = 0;

    int lowPointer = 0, highPointer = arr.length - 1;

    // Already done at some point
    while (lowPointer < highPointer) {

      int sum = arr[lowPointer] + arr[highPointer];

      if (sum < target) {
        lowPointer += 1;
      } else if (sum > target) {
        highPointer -= 1;
      } else {
        int flagOne = arr[lowPointer], flagTwo = arr[highPointer];
        int countOne = 0, countTwo = 0;

        while (lowPointer <= highPointer && arr[lowPointer] == flagOne) {
          countOne += 1;
          lowPointer += 1;
        }

        while (lowPointer <= highPointer && arr[highPointer] == flagTwo) {
          countTwo += 1;
          highPointer -= 1;
        }

        if (flagOne == flagTwo) {
          result += (countOne * (countOne - 1)) / 2;
        } else {
          result += countOne * countTwo;
        }
      }

    }

    return result;
  }

}
