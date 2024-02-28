package ru.dreremin.longest_valid_parentheses;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	
	public int longestValidParentheses(String s) {
        
		Deque<Integer> stack = new LinkedList<>();
		
		s = ")" + s;
		stack.push(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(stack.peek()) == ')') {
				stack.push(i);
			} else {
				stack.pop();
			}
		}
		
		int max = 0, prev = s.length(), cur;

		while (!stack.isEmpty()) {
			cur = stack.pop();
			max = Integer.max(prev - cur - 1, max);
			prev = cur;
		}
		return max;
    }
}
