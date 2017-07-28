
public class BSTMiniSumPath {

	public int Solution(TreeNode root) {
		if(root==null){
			return -1;
		}else if(root.left!=null&&root.right==null){
			return Solution(root.left)+root.val;
		}else if(root.right!=null&&root.left==null){
			return Solution(root.right)+root.val;
		}
		return Math.max(Solution(root.left), Solution(root.right));
	}
}

class TreeNode{
	public TreeNode left;
	public TreeNode right;
	public int val;
}