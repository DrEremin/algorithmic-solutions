# Description of problem

Given a string containing just the characters '(' and ')', return the length <br>
of the longest valid (well-formed) parentheses substring.

### Example 1:

> <b>Input:</b> s = "(()"<br>
<b>Output:</b> 2<br>
<b>Explanation:</b> The longest valid parentheses substring is "()".

### Example 2:

> <b>Input:</b> s = ")()())"<br>
<b>Output:</b> 4<br>
<b>Explanation:</b> The longest valid parentheses substring is "()()".

### Example 3:

> <b>Input:</b> s = ""<br>
<b>Output:</b> 0

### Constraints:

- 0 <= s.length <= 3 * 10<sup>4</sup>
- s[i] is '(', or ')'.

### Difficulty: hard

# Description of solution

### Intuition

It is necessary to put the indexes of the supposed problem areas of the string on<br> the stack, and then take them out and select the maximum from the differences <br>
between these indexes.

### Approach

1. Add a surrogate character ')' to the beginning of the string;
2. Loop through the characters of the string: push indexes of unpaired brackets to <br>
the stack or pop indexes corresponding to pairs from the stack;
3. Pop the indexes of unpaired brackets from the stack and select the maximum from <br>
the differences of these indexes.

### Complexity:

- Time complexity: O(n);
- Space complexity: O(n).