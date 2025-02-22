// Problem Link:
// https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
// Given a string s consisting of opening and closing parenthesis '(' and ')'.
// Find the length of the longest valid parenthesis substring.
//
// A parenthesis string is valid if:
// For every opening parenthesis, there is a closing parenthesis.
// The closing parenthesis must be after its opening parenthesis.
//
// Examples:
// Input: s = "((()"
// Output: 2
//
// Input: s = ")()())"
// Output: 4
//
// Input: s = "())()"
// Output: 2

import java.util.Stack;

public class Solution {

  static int maxLength(String s) {
    int maximumLength = 0;

    Stack<Integer> indices = new Stack<>();
    indices.add(-1);

    // Same approach when we match
    // brackets but when the bracket
    // closes, we check for maximum length
    // of the backets
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        indices.add(i);
      else {
        indices.pop();

        if (indices.isEmpty())
          indices.add(i);
        else
          maximumLength = Math.max(maximumLength, i - indices.peek());
      }
    }

    return maximumLength;
  }

}
