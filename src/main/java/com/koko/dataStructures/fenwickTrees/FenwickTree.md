## Use case  of BinaryIndexedTree or Fenwick

1. Let us consider the following problem to understand Binary Indexed Tree. 
2. We have an array arr[0 . . . n-1]. We would like to 
   1. Compute the sum of the first i elements.
   2. Modify the value of a specified element of the array arr[i] = x where 0 <= i <= n-1.
3. Simple solution is to create an extra array and store the sum of the first i-th elements at the i-th index in this new array. 
4. The sum of a given range can now be calculated in O(1) time, but the update operation takes O(n) time now.
5. This works well if there are a large number of query operations but a very few number of update operations.

6. **Could we perform both the query and update operations in O(log n) time?**
   1. One efficient solution is to use **Segment Tree** that performs both operations in O(Logn) time.
   2. An alternative solution is **Binary Indexed Tree**, which also achieves O(Logn) time complexity for both operations. 
   3. Compared with Segment Tree, Binary Indexed Tree requires less space and is easier to implement.
    
## Structure

1. **Representation**
   1. Binary Indexed Tree is represented as an array. Let the array be BITree[]. 
   2. Each node of the Binary Indexed Tree stores the sum of some elements of the input array. 
   3. The size of the Binary Indexed Tree is equal to the size of the input array, denoted as n.
   4. We initialize all the values in BITree[] as 0. 
   5. BITree[0] is a dummy node.
   5. Then we call update() for all the indexes,
   6. And then It contains **Prefix sum** for indexes.
    
2. **How does Binary Indexed Tree work?**
   1. The idea is based on the fact that all positive integers can be represented as the sum of powers of 2. 
   2. For example 19 can be represented as 16 + 2 + 1. 
   3. Every node of the BITree stores the sum of n elements where n is a power of 2. 
   4. For example, the sum of the first 12 elements can be obtained by the sum of the last 4 elements (from 9 to 12) 
   5. plus the sum of 8 elements (from 1 to 8). 
   6. The number of set bits in the binary representation of a number n is O(Logn). 
   7. Therefore, we traverse at-most O(Logn) nodes in both getSum() and update() operations. 
   8. The time complexity of the construction is O(nLogn) as it calls update() for all n elements.
      
5. **Update operation**
    1. We start with the position where value is being updated.
    2. To get next index:
        1. 2's complement
        2. Bitwise and with original number.
        3. Add to original number
        4. **i = i + (i & (-i))**
    3. Like this we get next indexes till we reach the end of array.
    4. And sum at these indexes get modified by adding the update.
    
6. **Sum till index**
    1. Every index stores value from i,j
    2. Now, how to calculate sum of 0,i.
    3. Sum from 1-13 -> 1-8 + 9-12 + 13
    4. Divide in powers of 2.
        1. 2's complement
        2. Bitwise and with original number.
        3. Subtract from original number
        4. **i = i - (i & (-i))**

3. **Can we extend the Binary Indexed Tree to computing the sum of a range in O(Logn) time?**
    1. Yes. rangeSum(l, r) = getSum(r) – getSum(l-1).
    
    
6. **What is binary lifting?**
    1. In binary lifting, a value is increased (or lifted) by powers of 2,
    2. starting with the highest possible power of 2, 2^⌊ log(N)⌋, down to the lowest power, 2^0. 
    3. **How binary lifting is used?**
       1. We are trying to find pos, which is the position of lower bound of v in prefix sums array,
       2. where v is the value we are searching for.
       3. So, we initialize pos = 0 and set each bit of pos, from most significant bit to least significant bit.
       4. Whenever a bit is set to 1, the value of pos increases (or lifts).
       5. While increasing or lifting pos, we make sure that prefix sum till pos should be less than v,
       6. for which we maintain the prefix sum and update it whenever we increase or lift pos.