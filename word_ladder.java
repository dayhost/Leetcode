package Interview;
import java.util.HashSet;
import java.util.List;

public class word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int length = 1;//initial length
        HashSet<String> visitedSet = new HashSet<String>();
        HashSet<String> beginSet = new HashSet<String>();
        HashSet<String> endSet = new HashSet<String>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!endSet.isEmpty()&&!beginSet.isEmpty()){
            if (beginSet.size() > endSet.size()) {
			    HashSet<String> set = beginSet;
			    beginSet = endSet;
			    endSet = set;
            }
            HashSet<String> tmp = new HashSet<String>();
            for(String tmpString : beginSet){
                char[] tmpChars = tmpString.toCharArray();
                for(int i=0; i<tmpChars.length; i++){
                    for(char c='a'; c<='z'; c++){
                        char old = tmpChars[i];
                        tmpChars[i] = c;
                        String charValue = String.valueOf(tmpChars);
                        if(endSet.contains(charValue)){
                            return length+1;
                        }
                        
                        if(!visitedSet.contains(charValue)&&wordList.contains(charValue)){
                            visitedSet.add(charValue);
                            tmp.add(charValue);
                        }
                        tmpChars[i] = old;
                    }
                }
            }
            beginSet = tmp;
            length++;
        }
        return 0;
    }
}