package Interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Interview.TreeNode;

public class findMaxSumInBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static int findMaxSum(TreeNode root){
		if(root==null){
			return 0;
		}
		int max = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		HashMap<TreeNode,Integer> sumMap = new HashMap<>();
		queue.offer(root);
		sumMap.put(root, root.val);
		while(!queue.isEmpty()){
			TreeNode tmpNode = queue.poll();
			max = Math.max(max, sumMap.get(tmpNode));
			if(tmpNode.left!=null){
				queue.offer(tmpNode.left);
				sumMap.put(tmpNode.left,sumMap.get(tmpNode)+tmpNode.left.val);
			}
			if(tmpNode.right!=null){
				queue.offer(tmpNode.right);
				sumMap.put(tmpNode.right,sumMap.get(tmpNode)+tmpNode.right.val);
			}
		}
		return max;
	}

} 