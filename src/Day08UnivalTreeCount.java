
public class Day08UnivalTreeCount {
	
	public class TreeNode {
		
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}

	private int count = 0;
	
    public int countUnivalSubtrees(TreeNode root) {
    	
        if (root == null) {
            return 0;
        }
        count = 0;
        isUni(root);
        return count;
    }
    
    private boolean isUni(TreeNode node) {
    	
        if (node == null) {
            return true;
        }
        boolean left = isUni(node.left);
        boolean right = isUni(node.right);
        if (left == true && right == true) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            count ++;
            return true;
        }
        return false;

    }
}
