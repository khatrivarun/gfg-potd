// Problem Link:
// https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
// The stock span problem is a financial problem where we have a series of daily
// price quotes for a stock and we need to calculate the span of stock price for
// all days. The span arr[i] of the stocks price on a given day i is defined as
// the maximum number of consecutive days just before the given day, for which
// the price of the stock on the given day is less than or equal to its price on
// the current day.
//
// Examples:
// Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
// Output: [1, 1, 1, 2, 1, 4, 6]
//
// Input: arr[] = [10, 4, 5, 90, 120, 80]
// Output: [1, 1, 2, 4, 5, 1]
//
// Input: arr[] = [11, 4, 5, 90, 120, 80]
// Output: [1, 1, 2, 4, 5, 1]

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

  public ArrayList<Integer> calculateSpan(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++)
      result.add(-1);

    for (int i = 0; i < arr.length; i++) {

      // Step 1, pop of all indices which are smaller than
      // the current element
      while (!stack.isEmpty() && arr[i] >= arr[stack.peek()])
        stack.pop();

      // If the stack is empty
      // use the current index
      // else use stack's peak
      if (stack.isEmpty())
        result.set(i, i + 1);
      else
        result.set(i, i - stack.peek());

      stack.push(i);
    }

    return result;
  }

}
