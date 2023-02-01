package com.koko.problems.array1D.unsorted;

public class HouseRobber3 {

    // Question:
    // The thief has found himself a new place for his thievery again.
    // There is only one entrance to this area, called root.
    //
    // Besides the root, each house has one and only one parent house.
    // After a tour, the smart thief realized that all houses in this place form a binary tree.
    // It will automatically contact the police if two directly-linked houses were broken into on the same night.
    //
    // Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.


    // Example:
    /*
    Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     */


    // Solution:
    // Recursive approach using withRob and withoutRob as per conditions.
    // Post Order traversal.


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public int rob(TreeNode root) {
        pair res = HouseRobber_( root );
        return Math.max( res.withrob, res.withoutrob );
    }

    public static class pair{
        int withrob = 0;
        int withoutrob = 0;
    }

    public static pair HouseRobber_(TreeNode root) {
        if( root == null ) return new pair();

        pair left = HouseRobber_( root.left );
        pair right = HouseRobber_( root.right );

        pair ans = new pair();

        // when including curr node's value, then we cant add neighbouring children's value to ans
        ans.withrob = left.withoutrob + root.val + right.withoutrob;

        // when not including curr node's val, we can either include or
        // not include children's val to ans,  whatever gives the bigger value is added
        ans.withoutrob = Math.max( left.withrob, left.withoutrob ) +
                Math.max( right.withrob, right.withoutrob );

        return ans;
    }
}
