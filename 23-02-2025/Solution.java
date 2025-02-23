// Problem Link:
// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
// Given an array arr[ ] of integers, the task is to find the next greater
// element for each element of the array in order of their appearance in the
// array. Next greater element of an element in the array is the nearest element
// on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater
// element for current element is -1. For example, next greater of the last
// element is always -1.
//
// Examples:
// Input: arr[] = [1, 3, 2, 4]
// Output: [3, 4, 4, -1]
//
// Input: arr[] = [6, 8, 0, 1, 3]
// Output: [8, -1, 1, 3, -1]
//
// Input: arr[] = [10, 20, 30, 50]
// Output: [20, 30, 50, -1]
//
// Input: arr[] = [50, 40, 30, 10]
// Output: [-1, -1, -1, -1]

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

  public ArrayList<Integer> nextLargerElement(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++)
      result.add(-1);

    for (int i = arr.length - 1; i >= 0; i--) {

      // Step 1: Pop all the elements which are smaller
      // than arr[i] so we can reach the next greater
      // element in order of appearance.
      //
      // Since we are going in reverse mode, order of
      // appereance is maintained.
      while (!stack.isEmpty() && stack.peek() <= arr[i])
        stack.pop();

      // If the stack is not empty
      // that is the next greater
      // element
      if (!stack.isEmpty())
        result.set(i, stack.peek());

      // Push arr[i] as we
      // visit the elements
      stack.push(arr[i]);

    }

    return result;
  }

}
