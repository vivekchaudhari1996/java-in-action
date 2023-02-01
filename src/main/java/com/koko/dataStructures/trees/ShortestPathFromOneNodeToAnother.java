package com.koko.dataStructures.trees;

public class ShortestPathFromOneNodeToAnother {

    // ###DFS
    // ###BinaryTreeDFS



    // Q:
    // Find the shortest path starting from node s and ending at node t.
    // Generate step-by-step directions of such path as a string consisting of only the
    // uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
    // Return the step-by-step directions of the shortest path from node s to node t.



    // Example:
    // Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
    //Output: "UURL"
    //Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.



    // Solution:

    // Idea:
    /*
    Build directions for both start and destination from the root.
Say we get "LLRRL" and "LRR".
Remove common prefix path.
We remove "L", and now start direction is "LRRL", and destination - "RR"
Replace all steps in the start direction to "U" and add destination direction.
The result is "UUUU" + "RR".

Here, we build path in the reverse order to avoid creating new strings.
     */


    // TC:O(n)

    private boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val)
            return true;
        if (n.left != null && find(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && find(n.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        int i = 0, max_i = Math.min(d.length(), s.length());
        while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            ++i;
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }

    public static class TreeNode {
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



}
