package additional_question;

import java.util.ArrayList;
import java.util.List;

public class WindowSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		input.add(6);
		input.add(7);
		input.add(8);
		input.add(9);
		List<Integer> result = GetSum(input,3);
		System.out.println();
		
	}
	
	public static List<Integer> GetSum(List<Integer> A, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if(A.size()<=0||A==null||k<=0){
			return result;
		}
		int count = 0;
		for(int i=0; i<A.size(); i++){
			if(count>=k-1){
				int tmpSum = 0;
				for(int j = count; j>count-k; j--){
					tmpSum = tmpSum+A.get(j).intValue();
				}
				result.add(tmpSum);
			}
			count++;
		}
		return result;
	}

}
