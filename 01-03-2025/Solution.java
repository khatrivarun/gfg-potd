// Problem Link: https://www.geeksforgeeks.org/problems/decode-the-string2444/1
// Given an encoded string s, the task is to decode it. The encoding rule is :
// k[encodedString], where the encodedString inside the square brackets is being
// repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
// Input: s = "1[b]"
// Output: "b"
//
// Input: s = "3[b2[ca]]"
// Output: "bcacabcacabcaca"

import java.util.Stack;

public class Solution {

  static String decodeString(String s) {
    Stack<Character> characterStack = new Stack<>();
    Stack<Integer> repetitionStack = new Stack<>();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);

      // Check 1: If the character is digit
      // chances are, it could be a multiple
      // digit number so build the number here
      if (Character.isDigit(character)) {
        int number = 0;

        while (Character.isDigit(s.charAt(i))) {
          number *= 10;
          number += Integer.parseInt(s.substring(i, i + 1));
          i += 1;
        }

        i -= 1;
        repetitionStack.push(number);
      }

      // Check 2: If the character is
      // a closing bracket, build the
      // string here and push it back
      // to stack
      else if (character == ']') {
        String temporaryString = "";

        // Till we find the opening bracket
        // pop and recover back the substring
        while (characterStack.peek() != '[')
          temporaryString = characterStack.pop() + temporaryString;
        characterStack.pop();

        // Then we pop the number stack to fetch
        // the repetition. Use that repetition to
        // repeat the string and put it in a builder
        StringBuilder interimString = new StringBuilder();
        int repetition = repetitionStack.pop();
        for (int j = 0; j < repetition; j++)
          interimString.append(temporaryString);

        // Now we have the decoded substring ready
        // push it back to character stack so it
        // will be picked up when we encounter
        // an outer closing bracket
        for (int j = 0; j < interimString.length(); j++)
          characterStack.push(interimString.charAt(j));
      }

      // Else just push it all
      // on the character stack
      else
        characterStack.push(character);
    }

    // In the stack we have the final
    // decoded string, form it as a proper
    // string, reverse it and return it
    while (!characterStack.isEmpty()) {
      result.append(characterStack.pop());
    }
    result = result.reverse();

    return result.toString();
  }

}
