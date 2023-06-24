package org.leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * #String #Stack
 *
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 *     Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 * https://www.youtube.com/watch?v=9kmUaXrjizQ
 * https://leetcode.com/problems/valid-parentheses/solutions/3398779/python-java-c-simple-solution-video-solution/?languageTags=java
 */
public class L20_ValidParenthesis {

    @Test
    public void validParenthesisTest() {
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("[)"));
        System.out.println(isValid("()[]{}"));
    }


    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }else{
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }
}
