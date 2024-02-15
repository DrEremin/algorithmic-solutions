# Description of problem

Given two sorted arrays nums1 and nums2 of size m and n respectively, return <br> the median of the two sorted arrays. <br>

The overall run time complexity should be O(log (m+n)). <br>

### Example 1:

> <b>Input:</b> nums1 = [1,3], nums2 = [2] <br> 
> <b>Output:</b> 2.00000<br> 
> <b>Explanation:</b> merged array = [1,2,3] and median is 2.<br>

### Example 2:

> <b>Input:</b> nums1 = [1,2], nums2 = [3,4]<br> 
> <b>Output:</b> 2.50000<br> 
> <b>Explanation:</b> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. <br>

### Constraints:

- nums1.length == m
- nums2.length == n
- 0 <= m <= 1000
- 0 <= n <= 1000
- 1 <= m + n <= 2000
- -10<sup>6</sup> <= nums1[i], nums2[i] <= 10<sup>6</sup>

### Difficulty: Hard

# Description of solution

### Intuition

First you need to calculate the number of elements up to and including the <br> 
required element based on the total size of both arrays.<br>
The main idea of the solution is to select an element of one of the arrays <br> 
at each step and calculate the number of elements to the left of the current <br> 
one (inclusively) and to the right of it (exclusively) in both arrays. <br> 
If there are fewer left elements than necessary, then all of them must be <br>
excluded from further search. If there are more left elements, then all right <br>
elements in both arrays are excluded from further search.

### Approach

The solution is based on a binary search algorithm, so its efficiency meets the<br> requirement of O(log(n+m)).<br>
To implement the task, an auxiliary method binarySearch() was developed, which <br>
returns the leftmost occurrence of a value in the target array if it is <br>
present, otherwise the (- insertion index) - 1. This method uses an iterative <br>
approach, allowing it not take up more memory on the thread's stack, since the <br>
main algorithm is running recursively.<br>
To take full advantage of binary search, a core method was developed that is <br>
an overloaded version of findMedianSortedArrays(). Both arrays and boundaries <br>
are passed into it, between which the search will be carried out (excluding <br>
boundaries).

### Algorithm:

- calculation of the total length of both arrays;
- calculating the numbers of the minimum and maximum required values (if the <br>
total length of both arrays is even, then there will be two required elements);
- selection of a producer array and a consumer array (the size of the producer <br>
array is greater than or equal to the size of the consumer array);
- selection of a pivot element in the producer array (average index between <br>
boundaries);
- getting for a pointer to the index of the leftmost occurrence of the pivot <br>
element in the consumer array, or the index of its insertion within the <br>
specified boundaries (excluding) in case of absence;
- counting the number of all elements in the producer array to the left of the <br>
pivot one (inclusive) and in the consumer array (excluding the element with <br>
the pointer). When calculating, all boundaries are ignored; counting occurs <br>
within the limits of the arrays sizes;
- estimation of the number of elements on the left:
  - if the number of left elements is less than the minimum specified, then <br>
  the left border is set along the reference element in the producer array and <br>
  to the left of the pointer in the consumer array (thus, these elements are<br>
  discarded), after that a recursive call;
  - if the number of left elements is greater than the specified maximum, then <br>
  the right border is set before the reference element in the producer array <br>
  and to the pointer in the consumer array (thus, right elements are <br>
  discarded), after that a recursive call;
  - if the number of left elements is equal to the specified minimum, then the <br>
  left border is set to the pivot element in the producer array and to the left<br>
  of the pointer in the consumer array, the attribute of the found minimum is <br>
  set to true, then the recursive call + pivot element / 2;
  - if the number of left elements is equal to the specified maximum, then the <br>
  right boundary is set to the reference element in the producer array and to <br>
  the pointer in the consumer array, the sign of the found maximum is set to <br>
  true, then the recursive call + pivot element / 2.

  If the total size of the arrays is odd, then the pivot element is simply <br>
  returned without further recursion.

### Algorithm:Complexity

- Time complexity: O(log(n+m));

- Space complexity: O(log(n+m)).
