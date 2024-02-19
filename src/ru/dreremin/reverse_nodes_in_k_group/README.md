# Description of problem

Given the head of a linked list, reverse the nodes of the list k at a time, <br>
and return the modified list.<br>
k is a positive integer and is less than or equal to the length of the linked <br>
list. If the number of nodes is not a multiple of k then left-out nodes, in <br>
the end, should remain as it is.<br>
You may not alter the values in the list's nodes, only nodes themselves may be <br> changed.

### Example 1:
![test](images/reverse_ex1.jpeg)
> <b>Input:</b> head = [1,2,3,4,5], k = 3<br>
<b>Output:</b> [2,1,4,3,5]

### Example2:
![test](images/reverse_ex2.jpeg)
> <b>Input:</b> head = [1,2,3,4,5], k = 3<br>
<b>Output:</b> [3,2,1,4,5]

### Constaints
- The number of nodes in the list is n;
- 1 <= k <= n <= 5000;
- 0 <= Node.val <= 1000.

<b>Follow-up:</b> Can you solve the problem in O(1) extra memory space?

# Description of solution

### Intuition
In order to change the direction of links in a singly linked list in one pass, <br>
it is necessary to iterate through its nodes sequentially, and at each<br>
iteration the pointers should be redirected as follows:<br>
- the "next" pointer of the current node must be redirected through one node;
- the "next" pointer of the next node must be directed to the first node of <br>
the list.

### Approach
According to the condition of the problem, it is necessary to change the <br>
direction of links only for each k nodes. Therefore, you should create a <br>
function that will perform the actions described in the “intuition” section <br>
only on a section of the list, and then pass parameters for working with the <br>
next section using a recursive call. Before performing link redirection on a <br>
section of the list, this function must iterate through the k nodes to see if <br>
they exist. If there are not enough nodes, then link redirection should not be <br>
performed. To maintain the integrity of the list, it is necessary, after <br>
completing the redirection of links in the section of the list, to redirect <br>
the “next” pointer of the node preceding the list section to the new first <br>
node of the list section. The function must return the head node of the list <br>
section.

### Complexity:
- Time complexity: O(n);

- Space complexity: O(1).