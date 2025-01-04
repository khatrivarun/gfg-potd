/*
 * Problem Link: https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1
 * Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices
 * such that arr[i] + arr[j] + arr[k] = target and i < j < k.
 *
 * Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
 * Output: 4
 *
 * Input: arr[] = [-2, 0, 1, 1, 5], target = 1
 * Output: 0
 */

public class Solution {

  public int countTriplets(int[] arr, int target) {

    int count = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      int leftPointer = i + 1;
      int rightPointer = arr.length - 1;

      // Idea here is to iterate in n^2
      // complexity and find which 3
      // elements satify the condition
      while (leftPointer < rightPointer) {

        int sum = arr[i] + arr[leftPointer] + arr[rightPointer];

        if (sum == target) {
          // In case we find the 3 numbers
          // check for duplicates cuz we gotta
          // include them in the result as well
          int leftElement = arr[leftPointer], leftCount = 0;
          int rightElement = arr[rightPointer], rightCount = 0;

          while (leftPointer <= rightPointer && arr[leftPointer] == leftElement) {
            leftCount += 1;
            leftPointer += 1;
          }

          while (leftPointer <= rightPointer && arr[rightPointer] == rightElement) {
            rightCount += 1;
            rightPointer -= 1;
          }

          // if same elements
          if (leftElement == rightElement)
            count += (leftCount * (leftCount - 1)) / 2;
          // if different elements
          else
            count += leftCount * rightCount;
        }

        // if sum is greater than target
        // decrement right pointer
        else if (sum > target) {
          rightPointer -= 1;
        }

        // if sum is smaller than target
        // increment left pointer
        else {
          leftPointer += 1;
        }

      }

    }

    return count;

  }

  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] arr1 = { -3, -1, -1, 0, 1, 2 };
    System.out.println(solution.countTriplets(arr1, -2));

    int[] arr2 = { -2, 0, 1, 1, 5 };
    System.out.println(solution.countTriplets(arr2, 1));

  }

}
