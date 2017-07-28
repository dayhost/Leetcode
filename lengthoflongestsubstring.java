package Interview;

import java.util.HashMap;

public class lengthoflongestsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("ababa");
	}

	
	public static int lengthOfLongestSubstring(String s) {
        int cur=0;
        int length = 0;
        int pre = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        while(cur<s.length()){
            if(map.containsKey(s.charAt(cur))){
                pre = Math.max(pre,map.get(s.charAt(cur))+1);
            }
            map.put(s.charAt(cur),cur);
            length = Math.max(length,cur-pre+1);
            cur++;
        }
        return length;
    }
}
