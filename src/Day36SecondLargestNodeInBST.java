/*
 * Given the root to a binary search tree, find the second largest node in the tree
 */

public class Day36SecondLargestNodeInBST {
	
	public class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;
	}
	
	public static TreeNode getSecondLargest(TreeNode node) { 
	    
	    // we are looking at the right-most element 
	    // (aka largest) and it has a left child
	    // so we want the largest element in its left child
	    if (node.right == null && node.left != null) {  
	        return getLargest(node.left);  
	    }  
	    
	    // we are looking at the parent of the largest element
	    // and the largest element has no children
	    // so this is the node we want
	    if (node.right != null &&  
	            node.right.left == null &&  
	            node.right.right == null) {  
	        return node;  
	    }  
	  
	    // recurse on the right child until we match
	    // one of the above cases
	    return getSecondLargest(node.right);  
	}
	
	public static TreeNode getLargest(TreeNode node) {
	    if (node.right != null) {
	        return getLargest(node.right);
	    }
	    return node;
	}

}
