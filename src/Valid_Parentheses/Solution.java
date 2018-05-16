package Valid_Parentheses;

import array.ArrayStack;
import array.Stack;

/**
 * Created by taoshiliu on 2018/5/13.
 * 括号匹配
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<Character>();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if(c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if(c == ')' && topChar != '(') {
                    return false;
                }
                if(c == ']' && topChar != '[') {
                    return false;
                }
                if(c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
