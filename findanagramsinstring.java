package Interview;

import java.util.ArrayList;
import java.util.List;

public class findanagramsinstring {
	
	public static void main(String[] args){
		findAnagrams("cbaebabacd","abc");
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[256];
        for(char c: p.toCharArray()){
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        while(right<s.length()){
            if(hash[s.charAt(right)]>=1){
                count--;
            }
            hash[s.charAt(right)]--;
            right++;
            if(count==0){
                result.add(left);
            }
            if(right-left==p.length()){
                if(hash[s.charAt(left)]>=0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}
