///*
// * Suppose an arithmetic expression is given as a binary tree. 
// * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
// * 
// * Given the root to such a tree, write a function to evaluate it.
// * 
// * For example, given the following tree:
//
//    *
//   / \
//  +    +
// / \  / \
//3  2  4  5
//
// * You should return 45, as it is (3 + 2) * (4 + 5).
// */
//
//
//public class Day50ExpressionTree {
//	
//	class Node { 
//		  
//	    char value; 
//	    Node left, right; 
//	  
//	    Node(char item) { 
//	        value = item; 
//	        left = right = null; 
//	    } 
//	} 
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public float evaluate() {
//        return evaluate(root);
//    }
//
//    private float evaluate(Node_EX _node) {
//        if (_node.left == null || _node.right == null)
//            return Float.parseFloat(_node.key);
//        String op = _node.key;
//        if (op == "+") {
//            return evaluate(_node.left) + evaluate(_node.right);
//        } else if (op == "-") {
//            return evaluate(_node.left) - evaluate(_node.right);
//        } else if (op == "*") {
//            return evaluate(_node.left) * evaluate(_node.right);
//        } else {
//            return evaluate(_node.left) / evaluate(_node.right);
//        }
//    }
//}
