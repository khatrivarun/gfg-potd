// Problem Link:
// https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
// You are given a histogram represented by an array arr, where each element of
// the array denotes the height of the bars in the histogram. All bars have the
// same width of 1 unit.
//
// Your task is to find the largest rectangular area possible in the given
// histogram, where the rectangle can be formed using a number of contiguous
// bars.
//
// Examples:
// Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
// Output: 100
//
// Input: arr[] = [3, 5, 1, 7, 5, 9]
// Output: 15
//
// Input: arr[] = [3]
// Output: 3

import java.util.Stack;

public class Solution {

  public static int getMaxArea(int arr[]) {
    int maxArea = 0, top, current;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      // if the current element is smaller than the
      // stack peek, we pop the stack and calculate
      // the max area of histogram possible.
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        top = stack.pop();
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;

        maxArea = Math.max(maxArea, arr[top] * width);
      }

      stack.push(i);
    }

    // Left over indices
    // in the stack
    while (!stack.isEmpty()) {
      top = stack.pop();
      current = arr[top] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
      maxArea = Math.max(maxArea, current);
    }

    return maxArea;
  }

}
