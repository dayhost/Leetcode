package Interview;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	    int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class conBinaryTree {

	public static void main(String[] args){
		TreeNode result = deserialize("[1,2,3]");
		System.out.println();
	}
	public static TreeNode deserialize(String data) {

        String[] nodes = data.substring(1, data.length()-2).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = null;
        try{
            head = new TreeNode(Integer.parseInt(nodes[0]));
        }catch(Exception e){
            return null;
        }
        queue.offer(head);
        for(int i=1; i<nodes.length; i++){
            if(!nodes[i].equals("Null")){
                try{
                    int val = Integer.parseInt(nodes[i]);
                    TreeNode tmpNode = new TreeNode(val);
                    queue.offer(tmpNode);
                    if(queue.peek().left==null){
                        queue.peek().left=tmpNode;
                    }else if(queue.peek().right==null){
                        queue.peek().right=tmpNode;
                        queue.poll();
                    }
                }catch(Exception e){
                    continue;
                }
            }
        }
        return head;
    }
}
