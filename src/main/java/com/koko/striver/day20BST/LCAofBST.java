package com.koko.striver.day20BST;



public class LCAofBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        /**             8
         *            /  \
         *          5     9
         *        /  \
         *       4    6
         *             \
         *              7
         */
        System.out.println(lca(root, 4, 7).data);
    }

    /**
     * Time Complexity: O(H). where H is the height of the tree.
     * Auxiliary Space: O(H), If recursive stack space is ignored, the space complexity of the above solution is constant.
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    private static TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) return null;

        // now its turn to check which side n1 and n2 will land
        if (n1 < root.data && n2 < root.data) {
            return lca(root.left, n1, n2);
        } else if (n1 > root.data && n2 > root.data) {
            return lca(root.right, n1, n2);
        }

        // agar ek bhi shi nhi hua then root hi hoga lca. its looks easy code
        return root;
    }
}
