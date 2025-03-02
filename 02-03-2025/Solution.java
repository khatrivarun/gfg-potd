// Problem Link:
// https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
// Given an array arr[] of integers and an integer k, your task is to find the
// maximum value for each contiguous subarray of size k. The output should be an
// array of maximum values corresponding to each contiguous subarray.
//
// Examples:
// Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
// Output: [3, 3, 4, 5, 5, 5, 6]
//
// Input: arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
// Output: [10, 10, 10, 15, 15, 90, 90]
//
// Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
// Output: [5, 1, 3, 4, 2, 6]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {

  public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
    ArrayList<Integer> result = new ArrayList<>();
    Deque<Integer> indexDoubleEndedQueue = new ArrayDeque<>();

    for (int i = 0; i < arr.length; i++) {
      // Step 1: Removing all indices which are not to be included
      // in the subarray while calculating the max of the window
      while (!indexDoubleEndedQueue.isEmpty() && indexDoubleEndedQueue.peekFirst() <= i - k)
        indexDoubleEndedQueue.pollFirst();

      // Step 2: Removing all indices at last which are smaller
      // than the current arr[i]
      while (!indexDoubleEndedQueue.isEmpty() && arr[i] >= arr[indexDoubleEndedQueue.peekLast()])
        indexDoubleEndedQueue.pollLast();

      // Step 3: Adding arr[i] to the deque
      indexDoubleEndedQueue.offerLast(i);

      // Step 4: if its a valid window
      // fetch the max which will be on top
      if (i >= k - 1)
        result.add(indexDoubleEndedQueue.peekFirst());
    }

    return result;
  }

}
