public class TreeTraversals {

	public static void preOrder(BinaryTreeNode node) { // complete this method
		System.out.print(node.value + " ");
		if(node.left != null) {
			preOrder(node.left);
		}
		if(node.right!= null) {
			preOrder(node.right);
		}
	}

	public static void inOrder(BinaryTreeNode node) { // complete this method
		if(node.left != null) {
			inOrder(node.left);
		}	
			System.out.print(node.value + " ");
		
		if(node.right!=null) {
			inOrder(node.right);
			
		}
	}

	public static void postOrder(BinaryTreeNode node) { // complete this method
		if(node.left != null) {
			postOrder(node.left);
		}
		if(node.right != null) {
			postOrder(node.right);
		}
		System.out.print(node.value + " ");
	}
}