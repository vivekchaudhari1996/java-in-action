package com.koko.problems.array1D.unsorted;

public class MaxProductContiguousSubArr {

    // Question:
    // Given an integer array nums,
    // find a contiguous non-empty subarray within the array that has the largest product,
    // and return the product.

    // Example:
    /*
    Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */


    // Solution: Kadane's algo modified.
    // Our answer subarray can only be starting from index 0->right or from n-1->left.
    //* So, we'll be iterating twice to get our maximum answer once from the left and then from the right.
    //* The above analogy is a fact cuz if we take any mid subarray,
    //  it can only be -ve or +ve. Similarly, the left and right subarrays can also be -ve or +ve.
    // 1. So, starting from left, find the max product.
    // 2. Starting from right, find the max product.
    // 3. Max of both will be answer.


    // TC: O(N)
    // SC: O(1)

    public int maxProduct2(int[] nums) { // prefix and suffix

        int ans = Integer.MIN_VALUE, p = 1;
        for(int i=0; i<nums.length; i++){
            p *= nums[i];

            ans = Math.max(ans, p);
            if(p == 0) p = 1; // corner case
        }

        p = 1;
        for(int i=nums.length-1; i>=0; i--){
            p *= nums[i];

            ans = Math.max(ans, p);
            if(p == 0) p = 1;
        }

        return ans;
    }

    public int maxProduct(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int ans=nums[0];
        int max=1;
        int min=1;
        for(int n:nums)
        {
            int temp=n*max;
            max=Math.max(n,Math.max(temp,n*min));
            min=Math.min(n,Math.min(temp,n*min));
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
