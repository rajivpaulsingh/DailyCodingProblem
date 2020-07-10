
/**
 
Input:
                 10
              /      \
             5       20
           /  \
          3   8
             /
            7
Output:
    Preorder = 10,5,3,null,null,8,7,null,null,null,20,null,null,
*/

public class Day03SerilaizeBST {
	
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

	public static void main(String[] args) {
		
		Day03SerilaizeBST test = new Day03SerilaizeBST();

	}
	
	public static String serialize(TreeNode root) {
		
		if(root == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		while(root != null) {
			sb.append(root.val);
			sb.append(", ");
			
			sb.append(serialize(root.left));
			sb.append(serialize(root.right));
		}
		
		return sb.toString();
	}

}
