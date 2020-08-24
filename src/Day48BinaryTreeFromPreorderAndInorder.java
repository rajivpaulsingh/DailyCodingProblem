/*
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g

 */



public class Day48BinaryTreeFromPreorderAndInorder {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper (0, 0, inorder.length - 1,  preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        //base condition
        if (preStart > preorder.length - 1 || inStart > inEnd) 
            return null;
        
        //get the root node with curr preorder element
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //get inIndex; finding preorder's element's index in inorder
        int inIndex = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i; 
            }
        }
        //(next, left of inIndex is the end for left subtree)
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //(prestart + length of left subtree + 1)
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}
