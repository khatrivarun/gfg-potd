// Problem Link:
// https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
// ou are given an array of strings arr that represents a valid arithmetic
// expression written in Reverse Polish Notation (Postfix Notation). Your task
// is to evaluate the expression and return an integer representing its value.
//
// Examples:
// Input: arr = ["2", "3", "1", "*", "+", "9", "-"]
// Output: -4
//
// Input: arr = ["100", "200", "+", "2", "/", "5", "*", "7", "+"]
// Output: 757

import java.util.Stack;

public class Solution {

  public int evaluate(String[] arr) {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      String operation = arr[i];

      if (operation.equals("+")) {
        Integer numberOne = stack.pop();
        Integer numberTwo = stack.pop();

        stack.push(numberOne + numberTwo);
      } else if (operation.equals("-")) {
        Integer numberOne = stack.pop();
        Integer numberTwo = stack.pop();

        stack.push(numberTwo - numberOne);
      } else if (operation.equals("/")) {
        Integer numberOne = stack.pop();
        Integer numberTwo = stack.pop();

        stack.push(numberTwo / numberOne);
      } else if (operation.equals("*")) {
        Integer numberOne = stack.pop();
        Integer numberTwo = stack.pop();

        stack.push(numberTwo * numberOne);
      } else {
        stack.push(Integer.parseInt(operation));
      }

    }

    return stack.pop();
  }

}
