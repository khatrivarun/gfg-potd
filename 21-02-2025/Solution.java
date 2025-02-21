// Problem Link:
// https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
// Given a string s, composed of different combinations of '(' , ')', '{', '}',
// '[', ']', verify the validity of the arrangement.
// An input string is valid if:
//
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
//
// Examples:
// Input: s = "[{()}]"
// Output: true
//
// Input: s = "[()()]{}"
// Output: true
//
// Input: s = "([]"
// Output: False
//
// Input: s = "([{]})"
// Output: False

import java.util.Stack;

public class Solution {

  // Pretty standard problem using stacks
  static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);

      if (character == '{' || character == '(' || character == '[') {
        stack.push(character);
      } else {
        if (stack.isEmpty())
          return false;
        Character poppedBracket = stack.pop();

        if (poppedBracket == '(') {
          if (character != ')') {
            return false;
          }
        } else if (poppedBracket == '[') {
          if (character != ']') {
            return false;
          }
        } else {
          if (character != '}') {
            return false;
          }
        }
      }
    }

    return stack.isEmpty();
  }
}
