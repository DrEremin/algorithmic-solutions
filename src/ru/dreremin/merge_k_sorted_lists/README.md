# Description of problem

You are given an array of k linked-lists lists, each linked-list is sorted in <br>
ascending order.<br>
Merge all the linked-lists into one sorted linked-list and return it.

## Example 1:

>  <b>Input:</b> lists = [[1,4,5],[1,3,4],[2,6]]<br>
<b>Output:</b> [1,1,2,3,4,4,5,6]<br>
<b>Explanation:</b> The linked-lists are:<br>
[<br>
&nbsp; 1->4->5,<br>
&nbsp; 1->3->4,<br>
&nbsp; 2->6<br>
]<br>
merging them into one sorted list:<br>
1->1->2->3->4->4->5->6<br>

## Example 2:

> <b>Input:</b> lists = []<br>
<b>Output:</b> []<br>

## Example 3:

> <b>Input:</b> lists = [[]]<br>
<b>Output:</b> []<br>

## Constraints:

- k == lists.length;
- 0 <= k <= 10<sup>4</sup>;
- 0 <= lists[i].length <= 500;
- -10<sup>4</sup> <= lists[i,j] <= 10<sup>4</sup>;
- lists[i] is sorted in ascending order;
- the sum of lists[i].length will not exceed 10<sup>4</sup>.

## Difficulty: hard

# Description of solution

## Intuition
Create a function that takes two sorted lists and returns the list obtained <br>
using normal merge sort. This way you can iterate through all the elements of <br>
the array, merging the new list with the next one.<br>

## Approach
Let the sizes of the lists in the array be the same. <br>
Then n - size of the list, m - number of lists in the array.<br>
If merge lists sequentially by array elements (from the first to the last),<br>
the number of list elements that need to be traversed during merging will be <br>
equal to (m<sup>2</sup> - m) * n / 2 - this quadratic, and maybe cubic (n == m)<br> efficiency. Therefore, it is necessary to sequentially split the array into two<br>
subarrays until 2 or 1 element remains in the subarrays, and after that, merge<br> 
the lists of these subarrays. In this case, the time efficiency will be <br>
log<sub>2</sub>(m) * n * m / 2 - which in the worst case will correspond to <br>
log<sub>2</sub>(m) * m<sup>2</sup> if n == m.<br>
The array splitting algorithm is recursive. During the partitioning process, <br>
no new arrays are created.<br>
During the process of merging lists, no new nodes are created, only pointers <br>
are redirected to the next node. Therefore, the memory efficiency is O(1).

## Complexity

- Time complexity: O(log(m) * m * n);
- Space complexity: O(1).
