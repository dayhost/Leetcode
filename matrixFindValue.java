package Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class matrixFindValue {

	public static void main(String[] args){
		findEqualValue(new int[][]{{1,2,3,4},{2,2,1,2},{2,3,1,4}},new int[]{0,1});
	}
	
	public static List<List<Integer>> findEqualValue(int[][] matrix, int[] position){
		List<List<Integer>> result = new ArrayList<>();
		if(matrix.length==0||matrix[0].length==0){
			return result;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(position);
		int target = matrix[position[0]][position[1]];
		while(!queue.isEmpty()){
			int[] tmpArray = queue.poll();
			if(matrix[tmpArray[0]][tmpArray[1]]==target){
				List<Integer> tmpList = new ArrayList<>();
				tmpList.add(tmpArray[0]);
				tmpList.add(tmpArray[1]);
				result.add(tmpList);
				matrix[tmpArray[0]][tmpArray[1]]=Integer.MIN_VALUE;
			}
			if(tmpArray[0]>0&&matrix[tmpArray[0]-1][tmpArray[1]]==target){
				queue.offer(new int[]{tmpArray[0]-1,tmpArray[1]});
			}
			if(tmpArray[1]>0&&matrix[tmpArray[0]][tmpArray[1]-1]==target){
				queue.offer(new int[]{tmpArray[0],tmpArray[1]-1});
			}
			if(tmpArray[0]<matrix.length-1&&matrix[tmpArray[0]+1][tmpArray[1]]==target){
				queue.offer(new int[]{tmpArray[0]+1,tmpArray[1]});
			}
			if(tmpArray[1]<matrix[0].length-1&&matrix[tmpArray[0]][tmpArray[1]+1]==target){
				queue.offer(new int[]{tmpArray[0],tmpArray[1]+1});
			}
		}
		return result;
	}
}
