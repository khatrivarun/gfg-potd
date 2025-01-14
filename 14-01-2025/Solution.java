/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
 * Given an array of integers arr[], the task is to find the first equilibrium
 * point in the array.
 * The equilibrium point in an array is an index (0-based indexing) such that
 * the sum of all elements before that index is the same as the sum of elements
 * after it. Return -1 if no such point exists.
 *
 * Examples:
 * Input: arr[] = [1, 2, 0, 3]
 * Output: 2
 *
 * Input: arr[] = [1, 1, 1, 1]
 * Output: -1
 *
 * Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
 * Output: 3
 */

public class Solution {

  public static int findEquilibrium(int arr[]) {
    int firstHalfSum = 0, secondHalfSum = 0, result = -1;

    // Idea is to first calculate the sum for second half
    // if there was no first half being considered at all.
    for (int i : arr) {
      secondHalfSum += i;
    }

    // Then we adjust both the sums to play with the
    // condition, like adding first half elements to
    // the first half sum and removing those elements
    // and current loop element.
    //
    // if the condition does not match, we add back
    // current element to the second half sum for next
    // iteration to consider it.
    for (int i = 1; i < arr.length; i++) {
      firstHalfSum += arr[i - 1];
      secondHalfSum -= (arr[i - 1] + arr[i]);

      if (firstHalfSum == secondHalfSum) {
        result = i;
        break;
      } else {
        secondHalfSum += arr[i];
      }
    }

    return result;
  }

}
